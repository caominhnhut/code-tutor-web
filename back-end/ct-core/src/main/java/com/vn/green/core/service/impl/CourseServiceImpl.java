package com.vn.green.core.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.base.Strings;
import com.vn.green.common.dto.CourseDTO;
import com.vn.green.common.enums.Status;
import com.vn.green.common.utility.StringHelper;
import com.vn.green.core.mapper.CourseMapper;
import com.vn.green.core.service.CourseService;
import com.vn.green.core.service.UserService;
import com.vn.green.document.DocumentService;
import com.vn.green.persistent.entity.CourseEntity;
import com.vn.green.persistent.entity.DocumentEntity;
import com.vn.green.persistent.repository.CourseRepository;
import com.vn.green.validation.SupportType;
import com.vn.green.validation.ValidationException;
import com.vn.green.validation.ValidatorProvider;

@Service
public class CourseServiceImpl implements CourseService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CourseServiceImpl.class);

    @Autowired
    private ValidatorProvider validatorProvider;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private DocumentService documentService;

    @Override
    public Long createCourse(CourseDTO courseDTO, MultipartFile file) throws ValidationException {

        validatorProvider.executeValidation(courseDTO, SupportType.COURSE);

        CourseEntity courseEntity = CourseMapper.INSTANCE.mapToEntity(courseDTO);

        courseEntity.setCreatedBy(userService.getLoggedUser().getName());

        courseEntity.setStatus(Status.CREATED);

        if (file != null) {
            DocumentEntity documentEntity = documentService.storeImage(file);
            courseEntity.setIconUri(documentEntity.getFileUri());
        }

        return courseRepository.create(courseEntity).getId();
    }

    @Override
    public boolean updateCourse(CourseDTO courseDTO, MultipartFile file) throws ValidationException {

        validatorProvider.executeValidation(courseDTO, SupportType.COURSE);

        CourseEntity courseEntity = courseRepository.findOne(courseDTO.getId());

        courseEntity.setStatus(courseDTO.getStatus());
        courseEntity.setName(courseDTO.getName());
        courseEntity.setDescription(courseDTO.getDescription());
        courseEntity.setOrderId(courseDTO.getOrderId());

        if (file == null) {
            // Don't need to update the icon
            courseRepository.update(courseEntity);
            return true;
        }

        if (Strings.isNullOrEmpty(courseEntity.getIconUri())) {
            // If the current course dose not have icon, then create a new one
            DocumentEntity documentEntity = documentService.storeImage(file);
            courseEntity.setIconUri(documentEntity.getFileUri());
        } else {
            // replace the existing icon in disk
            String filename = StringHelper.extractFilename(courseEntity.getIconUri());
            boolean updatedResult = documentService.updateImage(file, filename);

            if (!updatedResult) {
                LOGGER.error("Error while updating icon");
                return false;
            }
        }

        courseRepository.update(courseEntity);
        return true;
    }

    @Override
    public List<CourseDTO> getCourses() {

        List<CourseEntity> courseEntities = courseRepository.findAll();

        return courseEntities.stream().map(CourseMapper.INSTANCE::mapFromEntity).collect(Collectors.toList());
    }
}
