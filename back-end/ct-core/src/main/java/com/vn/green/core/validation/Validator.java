package com.vn.green.core.validation;

public interface Validator<T>
{
	public void validate(T t) throws ValidationException;
}
