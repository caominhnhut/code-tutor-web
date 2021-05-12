package com.vn.green.validation;

import java.util.List;

public interface Validator<T> {

    void validate(T data) throws ValidationException;

    List<SupportType> getSupportedTypes();
}
