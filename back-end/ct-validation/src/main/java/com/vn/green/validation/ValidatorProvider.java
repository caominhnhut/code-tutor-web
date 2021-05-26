package com.vn.green.validation;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidatorProvider {

    @Autowired
    private List<Validator<?>> validatorList;

    private Map<SupportType, List<Validator<?>>> validators = new EnumMap<>(SupportType.class);

    @PostConstruct
    public void initialize() {

        for (Validator validator : validatorList) {
            SupportType supportType = validator.getSupportedType();
            if (!validators.containsKey(supportType)) {
                List<Validator<?>> subValidators = new ArrayList<>();
                subValidators.add(validator);
                validators.put(supportType, subValidators);
            } else {
                validators.get(supportType).add(validator);
            }
        }
    }

    public <T> void executeValidation(T t, SupportType supportType) throws ValidationException {

        List<Validator<?>> subValidators = validators.get(supportType);
        for (Validator validator : subValidators) {
            validator.validate(t);
        }
    }

    public Map<SupportType, List<Validator<?>>> getValidators() {

        return validators;
    }
}
