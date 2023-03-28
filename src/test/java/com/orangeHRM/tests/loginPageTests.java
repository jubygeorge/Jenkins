package com.orangeHRM.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangeHRM.pages.HomePage;
import com.orangeHRM.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author jgeorge
 *
 */

public class loginPageTests {

	public WebDriver driver;
	HomePage homepage;
	LoginPage login;
	@BeforeMethod
		public void SetUp() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		login = new LoginPage(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@Test
	public void verifyLogo() {

		boolean flag = login.validateLogo();
		Assert.assertTrue(flag);

	}

	@Test
	public void verifyLogin() {

		homepage = login.login("Admin","admin123");
		String curURL = driver.getCurrentUrl();
		String expected = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		Assert.assertEquals(curURL, expected);

	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}
