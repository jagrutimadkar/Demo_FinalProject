package com.LoginPage.www;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.contactDetails.www.VerifyContactDetails;

import pageobjectmodel.LoginPageObjects;
import resources.BaseClass;

public class VerifyLogin extends BaseClass
{

	@Test(priority = 1)
	public void verifyLoginButton() throws IOException, InterruptedException, UnsupportedFlavorException
	{
		driverInitalize();
		
		
		//Thread.sleep(2000);
		
		LoginPageObjects lpo=new LoginPageObjects(d);
		
		//Thread.sleep(2000);
		
		lpo.enterUsername().sendKeys("Admin");
		lpo.enterPassword().sendKeys("admin123");
		lpo.submitbtn().click();
		
		Thread.sleep(5000);
		
		lpo.myinfoclick().click();

		Thread.sleep(1000);

		VerifyContactDetails vc=new VerifyContactDetails();
		vc.VerifyContactDetailsPage();		
	}
	

	
	@AfterClass
	public void closeDriver() throws InterruptedException
	{
		Thread.sleep(5000);
		d.quit();
	}

}
