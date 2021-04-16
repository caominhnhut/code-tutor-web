package com.vn.green.core.validation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationModelValidator implements Validator<ValidationRequest>
{
	private final static Logger LOGGER = LoggerFactory.getLogger(AuthenticationModelValidator.class);

	@Override
	public void validate(ValidationRequest validationRequest) throws ValidationException
	{
		LOGGER.info("AuthenticationModelValidator is running");
	}
}
