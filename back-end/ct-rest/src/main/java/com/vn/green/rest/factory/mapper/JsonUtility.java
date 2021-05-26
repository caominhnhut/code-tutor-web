package com.vn.green.rest.factory.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vn.green.validation.ValidationException;

public class JsonUtility {

    private JsonUtility() {
        // Hide constructor
    }

    public static <T> T convertFromJson(String json, Class<T> clazz) throws ValidationException {

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            throw new ValidationException("The data of course is incorrect format");
        }
    }
}
