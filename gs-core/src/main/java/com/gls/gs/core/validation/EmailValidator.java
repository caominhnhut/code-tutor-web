package com.gls.gs.core.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class EmailValidator implements ConstraintValidator<ValidEmail, String>
{
	private static final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@(.+)$";

	@Override
	public void initialize(ValidEmail validEmail)
	{

	}

	@Override
	public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext)
	{
		return validateEmail(email);
	}

	private boolean validateEmail(String email)
	{
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
}
