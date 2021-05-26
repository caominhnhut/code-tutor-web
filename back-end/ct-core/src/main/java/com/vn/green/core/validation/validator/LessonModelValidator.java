package com.vn.green.core.validation.validator;

import org.springframework.stereotype.Service;

import com.google.common.base.Strings;
import com.vn.green.common.dto.LessonDTO;
import com.vn.green.validation.SupportType;
import com.vn.green.validation.ValidationException;
import com.vn.green.validation.Validator;

@Service
public class LessonModelValidator implements Validator<LessonDTO> {

    @Override
    public void validate(LessonDTO lessonDTO) throws ValidationException {

        if (Strings.isNullOrEmpty(lessonDTO.getTitle())) {
            throw new ValidationException("Title should not be empty");
        }
    }

    @Override
    public SupportType getSupportedType() {

        return SupportType.LESSON;
    }
}
