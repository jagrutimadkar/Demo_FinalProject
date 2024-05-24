package pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObjects {

	
	public WebDriver d;
	private By username=By.name("username");
	private By password=By.name("password");
	private By submitbtn=By.xpath("//button[@type='submit']");
	private By myinfotab=By.xpath("//span[text()='My Info']");
	public LoginPageObjects(WebDriver d2) 
	{
		// TODO Auto-generated constructor stub		
		this.d=d2;	
	}
	
	public WebElement enterUsername()
	{
		return d.findElement(username);
	}
	
	public WebElement enterPassword()
	{
		return d.findElement(password);
	}
	public WebElement submitbtn()
	{
		return d.findElement(submitbtn);
	}
	public WebElement myinfoclick()
	{
		return d.findElement(myinfotab);
	}
	

}
