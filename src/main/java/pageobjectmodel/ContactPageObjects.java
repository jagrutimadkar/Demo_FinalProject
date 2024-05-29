package pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactPageObjects {

	public WebDriver d;
	
	private By ContactDetailstab=By.xpath("//a[text()='Contact Details']");
	//	private By workingemailfield=By.xpath("(//input[@class='oxd-input oxd-input--active'])[10]");
	private By workingemailfield=By.xpath("//div[3]//div[1]//div[1]//div[1]//div[2]//input[1]");
	private By otheremailfield=By.xpath("//div[3]//div[1]//div[2]//div[1]//div[2]//input[1]");
	private By savebtn=By.xpath("//button[normalize-space()='Save']");
	//private By popup=By.xpath("//html[1]/body[1]/div[1]/div[2]/div[1]");
	
	public ContactPageObjects(WebDriver d2)
	{
		this.d=d2;
	}
	
	public WebElement enterWorkEmail()
	{		
		return d.findElement(workingemailfield);
	}
	
	public WebElement clickonContactDetails()
	{
		return d.findElement(ContactDetailstab);
	}
	public WebElement enterOtherEmail()
	{
		return d.findElement(otheremailfield);
	}
	
	public WebElement clickonSave()
	{
		return (d.findElement(savebtn));
	}

}
