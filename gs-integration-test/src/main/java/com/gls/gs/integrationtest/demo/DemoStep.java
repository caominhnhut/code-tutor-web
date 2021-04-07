package com.gls.gs.integrationtest.demo;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.junit.Assert;

public class DemoStep
{
	private MyCalculation myCaculation;

	@Given("I have two numbers are $firstNumber and $secondNumber")
	public void requestSumOfNumbers(int firstNumber, int secondNumber)
	{
		myCaculation = new MyCalculation();
		myCaculation.setFirstNumber(firstNumber);
		myCaculation.setSecondNumber(secondNumber);

		int result = myCaculation.getFirstNumber() + myCaculation.getSecondNumber();
		myCaculation.setResult(result);
	}

	@Then("The result should be $result")
	public void validate(int result)
	{
		Assert.assertEquals(result, myCaculation.getResult());
	}
}
