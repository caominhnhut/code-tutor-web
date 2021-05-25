package com.vn.green.document.validation;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.vn.green.validation.SupportType;
import com.vn.green.validation.ValidationException;
import com.vn.green.validation.Validator;

@Service
public class DocumentModelValidator implements Validator<MultipartFile> {

    @Override
    public void validate(MultipartFile data) throws ValidationException {

        if (data == null) {
            throw new ValidationException("The file is not present");
        }

        String filename = StringUtils.cleanPath(data.getOriginalFilename());
        if (filename.contains("..")) {
            throw new ValidationException("The filename is incorrect format");
        }
    }

    @Override
    public SupportType getSupportedType() {

        return SupportType.DOCUMENT;
    }
}
