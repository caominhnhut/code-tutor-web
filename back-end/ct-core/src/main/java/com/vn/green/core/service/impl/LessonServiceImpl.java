package com.vn.green.core.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.base.Strings;
import com.vn.green.common.dto.LessonDTO;
import com.vn.green.common.enums.Status;
import com.vn.green.common.utility.StringHelper;
import com.vn.green.core.mapper.LessonMapper;
import com.vn.green.core.service.LessonService;
import com.vn.green.core.service.UserService;
import com.vn.green.document.DocumentService;
import com.vn.green.persistent.entity.CourseEntity;
import com.vn.green.persistent.entity.DocumentEntity;
import com.vn.green.persistent.entity.LessonEntity;
import com.vn.green.persistent.repository.CourseRepository;
import com.vn.green.persistent.repository.LessonRepository;
import com.vn.green.validation.SupportType;
import com.vn.green.validation.ValidationException;
import com.vn.green.validation.ValidatorProvider;

@Service
public class LessonServiceImpl implements LessonService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LessonServiceImpl.class);

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private DocumentService documentService;

    @Autowired
    private ValidatorProvider validatorProvider;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Long createLesson(LessonDTO lessonDTO, long courseId, MultipartFile file) throws ValidationException {

        validatorProvider.executeValidation(lessonDTO, SupportType.LESSON);

        LessonEntity lessonEntity = LessonMapper.INSTANCE.mapToEntity(lessonDTO);

        lessonEntity.setCreatedBy(userService.getLoggedUser().getName());

        lessonEntity.setStatus(Status.CREATED);

        CourseEntity courseEntity = courseRepository.findOne(courseId);
        if (courseEntity == null) {
            throw new ValidationException(String.format("The course with id [%s] not found", courseId));
        }
        lessonEntity.setCourse(courseEntity);

        if (file != null) {
            DocumentEntity documentEntity = documentService.storeImage(file);
            lessonEntity.setIconUri(documentEntity.getFileUri());
        }

        return lessonRepository.create(lessonEntity).getId();
    }

    @Override
    public boolean updateLesson(LessonDTO lessonDTO, long courseId, MultipartFile file) throws ValidationException {

        validatorProvider.executeValidation(lessonDTO, SupportType.LESSON);

        Optional<LessonEntity> optionalLessonEntity = lessonRepository.findByLessonIdAndCourse(lessonDTO.getId(), courseId);
        if (!optionalLessonEntity.isPresent()) {
            throw new ValidationException(String.format("The course with id [%s] or lesson with id [%s] not found", courseId, lessonDTO.getId()));
        }

        LessonEntity lessonEntity = optionalLessonEntity.get();
        lessonEntity.setTitle(lessonDTO.getTitle());
        lessonEntity.setStatus(lessonDTO.getStatus());
        lessonEntity.setContent(lessonDTO.getContent());

        if (file == null) {
            // Don't need to update the icon;
            lessonRepository.update(lessonEntity);
            return true;
        }

        if (Strings.isNullOrEmpty(lessonEntity.getIconUri())) {
            // If the current lesson does not have icon, then create a new one
            DocumentEntity documentEntity = documentService.storeImage(file);
            lessonEntity.setIconUri(documentEntity.getFileUri());
        } else {
            // Replace the existing one
            String filename = StringHelper.extractFilename(lessonEntity.getIconUri());
            boolean updatedResult = documentService.updateImage(file, filename);

            if (!updatedResult) {
                LOGGER.error("Error while updating icon");
                return false;
            }
        }

        lessonRepository.update(lessonEntity);

        return true;
    }

    @Override
    public List<LessonDTO> getLessons(long courseId) {

        Optional<List<LessonEntity>> optionalLessonEntities = lessonRepository.findLessonsByCourse(courseId);

        if (!optionalLessonEntities.isPresent()) {
            return Collections.emptyList();
        }

        List<LessonEntity> lessonEntities = optionalLessonEntities.get();

        return lessonEntities.stream().map(LessonMapper.INSTANCE::mapFromEntity).collect(Collectors.toList());
    }

    @Override
    public LessonDTO getLesson(long courseId, long lessonId) {

        Optional<LessonEntity> optionalLessonEntity = lessonRepository.findByLessonIdAndCourse(lessonId, courseId);

        if (!optionalLessonEntity.isPresent()) {
            return null;
        }

        LessonEntity lessonEntity = optionalLessonEntity.get();
        return LessonMapper.INSTANCE.mapFromEntity(lessonEntity);
    }


}
