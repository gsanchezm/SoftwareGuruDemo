package com.softwareguru.config;

import org.openqa.selenium.By;

import com.softwareguru.utils.LocatorType;

public class Business extends Common{
	//Business functions
	//Adding Contact Information
	public void addContactInfo(String ... contact){
		typeInTextBox(LocatorType.Name, "firstName",contact[0]);
		typeInTextBox(LocatorType.Name, "lastName", contact[1]);
		typeInTextBox(LocatorType.Name, "phone", contact[2]);
		typeInTextBox(LocatorType.Id, "userName",contact[3]);
	}

	//Adding Mailing Information
	public void addMailingInfo(String ... mailing){
		typeInTextBox(LocatorType.Name, "address1", mailing[0]);
		typeInTextBox(LocatorType.Name, "city", mailing[1]);
		typeInTextBox(LocatorType.Name, "state", mailing[2]);
		typeInTextBox(LocatorType.Name, "postalCode", mailing[3]);
		selectFromDropDown(LocatorType.Name, "country", mailing[4]);
	}

	// method to submit user info
	public void submitUserInfo(String userName, String password){
		typeInTextBox(LocatorType.Id, "email", userName);
		typeInTextBox(LocatorType.Name, "password", password);
		typeInTextBox(LocatorType.Name, "confirmPassword", password);
		getDriver().findElement(By.name("confirmPassword")).submit();
	}
}
