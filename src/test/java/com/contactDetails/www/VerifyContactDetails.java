package com.contactDetails.www;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import pageobjectmodel.ContactPageObjects;
import resources.BaseClass;

public class  VerifyContactDetails extends BaseClass
{	
	public void VerifyContactDetailsPage() throws IOException, InterruptedException, UnsupportedFlavorException
	{		
		System.out.println("In contact details page");
		Thread.sleep(2000);
		
		ContactPageObjects cpo=new ContactPageObjects(d);
				
		cpo.clickonContactDetails().click();
		Thread.sleep(2000);
		
		workemailValidaton(cpo);
		
		otheremailValidation(cpo);
		
		savebuttonValidation(cpo);
	}

	private void savebuttonValidation(ContactPageObjects cpo) throws InterruptedException {
		
		Thread.sleep(5000);
		cpo.clickonSave().submit();
		Assert.assertTrue(cpo.clickonSave().isEnabled());  
		System.out.println("Save button click....Passed");
		
		// Get the handle of the main window
		String mainWindowHandle = d.getWindowHandle();
		
		// Get all window handles
		Set<String> allWindowHandles = d.getWindowHandles();

		// Switch to the popup window
		for (String handle : allWindowHandles) {
		    if (!handle.equals(mainWindowHandle)) {
		        d.switchTo().window(handle);
		        break;
		    }
		}
		
		String savetxt=d.findElement(By.xpath("//html[1]//body[1]//div[1]//div[2]//div[1]")).getText();
		System.out.println(savetxt);
		
	}

	private void otheremailValidation(ContactPageObjects cpo) throws InterruptedException {
		
		Thread.sleep(5000);
		cpo.enterOtherEmail().click();
		Assert.assertTrue(cpo.enterOtherEmail().isEnabled());  
		System.out.println("Other email click....Passed");
				
		String str=cpo.enterOtherEmail().getAttribute("value");
				
		for(int i=0;i<=str.length();i++)
			{
				cpo.enterOtherEmail().sendKeys(Keys.chord(Keys.BACK_SPACE));
			}
		cpo.enterOtherEmail().sendKeys("xyz@gmail.com");		
		
		String expectworkemail = "xyz@gmail.com";				
			
		Assert.assertEquals(cpo.enterOtherEmail().getAttribute("value"), expectworkemail);
		System.out.println("Entering valid other emailid");
		
		
	}

	private void workemailValidaton(ContactPageObjects cpo) throws InterruptedException, UnsupportedFlavorException, IOException {
		
				
		Thread.sleep(5000);
		cpo.enterWorkEmail().click();
		Assert.assertTrue(cpo.enterWorkEmail().isEnabled());  
		System.out.println("Workemail click....Passed");
				
		String str=cpo.enterWorkEmail().getAttribute("value");
				
		for(int i=0;i<=str.length();i++)
			{
				cpo.enterWorkEmail().sendKeys(Keys.chord(Keys.BACK_SPACE));
			}
		cpo.enterWorkEmail().sendKeys("abc@gmail.com");		
		
		String expectworkemail = "abc@gmail.com";				
			
		Assert.assertEquals(cpo.enterWorkEmail().getAttribute("value"), expectworkemail);
		System.out.println("Entering valid work emailid");
		
		
	}
	
	public String assertValue() throws UnsupportedFlavorException, IOException, InterruptedException {
		Actions act = new Actions(d);
		// ctrl+a
		act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();

		// ctrl+c
		act.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
		Thread.sleep(2000);

		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

		return (String) clipboard.getData(DataFlavor.stringFlavor);

	}

	
}
