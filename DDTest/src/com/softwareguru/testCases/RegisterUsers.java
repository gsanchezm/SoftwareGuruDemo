package com.softwareguru.testCases;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softwareguru.config.Business;
import com.softwareguru.utils.ExcelUtils;
import com.softwareguru.utils.LocatorType;

public class RegisterUsers extends Business{

	Object[][] testObjArray;
	String testCaseWorkBook = System.getProperty("user.dir") + "\\testData\\FlightRegisterData.xlsx";

	@DataProvider(name = "UserRegistration")
	public Object[][] userRegister(Method m) throws Exception{
		return (testObjArray = ExcelUtils.getTableArray(testCaseWorkBook, "RegisterUser"));
	}

	@BeforeTest
	public void setUp(){
		navigateTo();
	}

	@AfterTest
	public void tearDown(){
		getDriver().quit();
	}

	@BeforeMethod
	public void clickRegister(){
		clickOnLink(LocatorType.LinkText, "REGISTER");
	}

	@Test(dataProvider = "UserRegistration")
	public void contactInformation(String ... dataProvider){
		String[] contactInfo = new String[4];
		String[] mailInfo = new String[5];

		//Store data for mail info and contact info
		for(int i = 0; i < 9; i++){
			if(i>3){
				mailInfo[i-4] = dataProvider[i];
			}else{
				contactInfo[i] = dataProvider[i];
			}
		}

		//Adding Contact Information
		addContactInfo(contactInfo);

		//Adding Mailing Information
		addMailingInfo(mailInfo);

		//Adding User Information
		submitUserInfo(dataProvider[9], dataProvider[10]);

		//Verify user name is displayed
		Assert.assertTrue(getElementText().contains(dataProvider[9]));
	}
}
