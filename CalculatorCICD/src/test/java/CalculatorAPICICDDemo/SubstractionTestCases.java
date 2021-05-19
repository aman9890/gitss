package CalculatorAPICICDDemo;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SubstractionTestCases {
	calculator obj;
	
	@BeforeClass
	public void init() {
		obj=new calculator();
	}
	
	@Test
	public void TestSubstractionWithPositiveNumbers() {
		int Result=obj.Substraction(5, 3);
		Assert.assertEquals(Result,2,"Substraction doesn't work with two positive numbers");
	}
	


}
