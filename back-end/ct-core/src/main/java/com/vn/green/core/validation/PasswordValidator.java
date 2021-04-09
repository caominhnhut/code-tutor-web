package com.vn.green.core.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<ValidPassword, String>
{
	private static final String PASSWORD_PATTERN = "^[a-zA-Z0-9]+$";

	@Override
	public void initialize(ValidPassword validPassword)
	{

	}

	@Override
	public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext)
	{
		return validatePassword(password);
	}

	private boolean validatePassword(String password)
	{
		Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
		Matcher matcher = pattern.matcher(password);
		return matcher.matches();
	}
}
