package CalculatorAPICICDDemo;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DivisionTestCases {
	calculator obj;
	int Result;
	
	@BeforeClass
	public void CreateObj(){
		System.out.println("I am in Before Class");
		obj=new calculator();
		
	}
	@BeforeMethod
	 public void Reinitialize() {
	
		System.out.println(" i am in Before Method");
		Result=0;
	 }
	
	@Test(priority=1)
	public void TestDivisionWithPositiveValues(){
		System.out.println("I am in first test cases");
		Result=obj.Division(100, 2);
		Assert.assertEquals(Result, 50,"Division is not working with positive values");
	}
	
	
	public void AferMethod() {
		System.out.println("I am in after Method");		
	}
	
	@Test(priority=2)
	public void TestDivisionWithNegativeValues(){
		System.out.println("I am in second test cases");
		Result=obj.Division(100, -2);
		Assert.assertEquals(Result, -50,"Division is not working with negative values");
	}
	
	@AfterClass
	public void ReleaseObj() {
		System.out.println("I am in After Class");
		obj=null;
	}
}
