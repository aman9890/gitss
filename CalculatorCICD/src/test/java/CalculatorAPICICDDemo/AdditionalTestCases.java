package CalculatorAPICICDDemo;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdditionalTestCases {
	calculator obj;
	int Result;
	
	@BeforeGroups("RegressionTest")
	public void InitGroups()
	{
		System.out.println("Im in Before Grooup"); 
 		obj=new calculator();
	}
	
	@BeforeClass
	public void Init(){
		System.out.println("I am in Before class");
		obj=new calculator();
	}
	
	@BeforeMethod
	public void ReinitialiseResultVar(){
		System.out.println("I am in Before Method");
		Result=0;
	}
	
	@Test(priority=2,groups= {"RegressionTest"})
	public void TestAdditionalWithPositiveNumbers(){
		System.out.println("I am in second test case");
		int Result=obj.Addition(10,20);
		Assert.assertEquals(Result, 30,"Addition doesn't work with positive numbers");
	}
	
	@Test(priority=3)
	public void TestAdditionalWithZeroNumbers(){
		System.out.println("I am in third test case");
		int Result=obj.Addition(0,0);
		Assert.assertEquals(Result, 0,"Addition doesnt work with zero numbers");
	}
	
	@Test(priority=1,groups={"RegressionTest"})
	public void TestAdditionalWithOnePositiveOneNegativeNumbers(){
		System.out.println("I am in first test case");		
		int Result=obj.Addition(0,0);
		Assert.assertEquals(Result, 0,"Addition doesnt work with 1 positive and 1 negative numbers");
	}
	
	@AfterClass
	public void Teardown() {
		obj=null;
		System.out.println("hello");
	}
	


}