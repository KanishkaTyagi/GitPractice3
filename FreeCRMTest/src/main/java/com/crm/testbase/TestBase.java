package com.crm.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.util.Utility;
import com.crm.util.WebEventListener;

public class TestBase {

	public static Properties prop;
	public static WebDriver driver;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	Utility utility;
	public TestBase(){

		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\crm\\config\\"
					+"config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void Initialization() {

		if(prop.getProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Users\\katyagi\\Desktop\\Selenium\\FreeCRMTest\\ChromeDriver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(prop.getProperty("browser").equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\Users\\katyagi\\Desktop\\Selenium\\geckodriver.exe\\");
			driver = new FirefoxDriver();
		}

		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(Utility.IMPLICIT_LOAD, TimeUnit.MINUTES);
		driver.manage().timeouts().pageLoadTimeout(Utility.PAGE_LOAD, TimeUnit.MINUTES);

		driver.get(prop.getProperty("url"));
        Actions action = new Actions(driver);
        a
	}
}
