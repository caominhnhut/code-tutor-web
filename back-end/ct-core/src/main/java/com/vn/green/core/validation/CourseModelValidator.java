package com.vn.green.core.validation;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.common.base.Strings;
import com.vn.green.common.dto.CourseDTO;
import com.vn.green.validation.SupportType;
import com.vn.green.validation.ValidationException;
import com.vn.green.validation.Validator;

@Service
public class CourseModelValidator implements Validator<CourseDTO> {

    @Override
    public void validate(CourseDTO courseDTO) throws ValidationException {

        if (Strings.isNullOrEmpty(courseDTO.getName())) {
            throw new ValidationException("Course name should not be empty");
        }

        if (Strings.isNullOrEmpty(courseDTO.getDescription())) {
            throw new ValidationException("Course description should not be empty");
        }
    }

    @Override
    public List<SupportType> getSupportedTypes() {

        return Collections.singletonList(SupportType.COURSE);
    }
}
