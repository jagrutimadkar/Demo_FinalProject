package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {

	public static WebDriver d;
	
	public void driverInitalize() throws IOException, InterruptedException
	{
		FileInputStream source=new FileInputStream("E:\\SSquareIt Solution\\Java\\Feb24_TestNGFramework\\src\\main\\java\\resources\\data.properties");
		Properties prop = new Properties();
		prop.load(source);
		String browserName=prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			d=new ChromeDriver();
			d.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			d.manage().window().maximize();
			Thread.sleep(3000);	
			
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			d=new EdgeDriver();
			d.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			d.manage().window().maximize();
			Thread.sleep(3000);	
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			d=new FirefoxDriver();
			d.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			d.manage().window().maximize();
			Thread.sleep(3000);	
		}
		else
		{
			System.out.println("Please check u have correct browser.");
		}

	}

	
}
