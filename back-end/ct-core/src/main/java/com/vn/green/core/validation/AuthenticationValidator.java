package com.vn.green.core.validation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationValidator implements Validator<ValidationRequest>
{
	private final static Logger LOGGER = LoggerFactory.getLogger(AuthenticationValidator.class);

	@Override
	public void validate(ValidationRequest validationRequest) throws ValidationException
	{
		LOGGER.info("AuthenticationValidator is running");
	}
}
