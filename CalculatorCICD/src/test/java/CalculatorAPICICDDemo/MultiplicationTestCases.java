package CalculatorAPICICDDemo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MultiplicationTestCases {
	int Result;
	calculator obj;
	
	@BeforeClass
	public void init() {
		obj=new calculator();	
	}

	@BeforeMethod
	public void ReinitialiseResultVar(){
			Result=0;
	}
	
	@Test(priority=1,dataProvider="ProvidePositiveIntegerValues")
	public void TestMultiplicationWithPositiveNumbers(int num1,int num2,int ExpectedResult){ // can write any name num1 or anything else
		Result=obj.Multiplication(num1,num2);
		Assert.assertEquals(Result, ExpectedResult,"Multiplication doesn't work with positive numbers");
	}
	
	@DataProvider
	public Object[][] ProvidePositiveIntegerValues() {
		Object [][] SetOfValues=new Object[3][3];
		
		//SET 1
		SetOfValues[0][0]=1;
		SetOfValues[0][1]=2;
		SetOfValues[0][2]=2;
		
		//SET 2
		SetOfValues[1][0]=10;
		SetOfValues[1][1]=20;
		SetOfValues[1][2]=200;
		
		//SET 3
		SetOfValues[2][0]=1000;
		SetOfValues[2][1]=2000;
		SetOfValues[2][2]=2000000;
		
		return SetOfValues;
	}		
		
	
	@BeforeSuite
	@Parameters({"RequestID"})
	public void CreateResultFolder(String name){    //RequestID
		System.out.println("I am in before suite");
		try {
			Files.createDirectory(Paths.get("./"+name));  //RequestID
			
		}catch(IOException e) {
			//TODO Auto-generated catch block
			System.out.println("Problem in creating a result directory");
		}		
	}
	@Parameters({"RequestID"})
	@AfterSuite
	
	public void CopyResultFile(String name ) {
		System.out.println("I am in after suite");
		try {
			Files.copy(Paths.get(".\\target\\surefire-reports\\emailable-report.html"),Paths.get("./"+name+"/Result.html"),StandardCopyOption.REPLACE_EXISTING);			
		}catch(IOException e) {
			System.out.println("Problem");
		}
		
		
	}
	
	

}
