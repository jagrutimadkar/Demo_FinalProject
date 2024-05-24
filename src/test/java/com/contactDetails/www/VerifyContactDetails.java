package com.contactDetails.www;

import java.io.IOException;

import org.openqa.selenium.Keys;
import pageobjectmodel.ContactPageObjects;
import resources.BaseClass;

public class  VerifyContactDetails extends BaseClass
{	
	public void VerifyContactDetailsPage() throws IOException, InterruptedException
	{		
		System.out.println("In contact details page");
		Thread.sleep(2000);
		
		ContactPageObjects cpo=new ContactPageObjects(d);
				
		cpo.clickonContactDetails().click();
		Thread.sleep(2000);
		
		cpo.enterWorkEmail().sendKeys(Keys.chord(Keys.BACK_SPACE),"abc@gmail.com");
		Thread.sleep(2000);
		cpo.enterOtherEmail().sendKeys("xyz@gmail.com");
		Thread.sleep(3000);
		cpo.clickonSave().submit();
	}
}
