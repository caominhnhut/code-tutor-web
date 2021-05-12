package com.vn.green.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vn.green.common.dto.CourseDTO;
import com.vn.green.common.enums.Status;
import com.vn.green.core.mapper.CourseMapper;
import com.vn.green.core.service.CourseService;
import com.vn.green.core.service.UserService;
import com.vn.green.document.DocumentService;
import com.vn.green.persistent.entity.CourseEntity;
import com.vn.green.persistent.entity.DocumentEntity;
import com.vn.green.persistent.repository.CourseRepository;
import com.vn.green.validation.SupportType;
import com.vn.green.validation.ValidationException;
import com.vn.green.validation.Validator;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private List<Validator<?>> validators;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private DocumentService documentService;

    @Override
    public Long createCourse(CourseDTO courseDTO, MultipartFile file) throws ValidationException {

        executeValidation(courseDTO);

        CourseEntity courseEntity = CourseMapper.INSTANCE.mapToEntity(courseDTO);

        courseEntity.setCreatedBy(userService.getLoggedUser().getName());

        courseEntity.setStatus(Status.CREATED);

        if (file != null) {
            DocumentEntity documentEntity = documentService.storeImage(file);
            courseEntity.setIconUri(documentEntity.getFileUri());
        }

        return courseRepository.create(courseEntity).getId();
    }

    private void executeValidation(CourseDTO courseDTO) throws ValidationException {

        for (Validator validator : validators) {
            if (validator.getSupportedTypes().contains(SupportType.COURSE)) {
                validator.validate(courseDTO);
            }
        }
    }
}
