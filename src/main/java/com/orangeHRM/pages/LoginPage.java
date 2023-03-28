package com.orangeHRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	
	By username = By.name("username");
	By password = By.name("password");
	By loginBtn = By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button");
	By logo     = By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[1]/img");
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public boolean validateLogo()
	{
	 driver.findElement(logo).isDisplayed();
	 return true;
	}
	public HomePage login(String uname,String pwd)
	{
		driver.findElement(username).sendKeys(uname);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginBtn).click();
		return new HomePage();
	}

}
