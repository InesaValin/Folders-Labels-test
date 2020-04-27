package com.protonmail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver ldriver) {
		this.driver = ldriver;
	}

	@FindBy(id = "username")
	WebElement uname;
	@FindBy(name = "password")
	WebElement passw;
	@FindBy(id = "login_btn")
	WebElement loginButton;

	public void login(String myUserName, String myPassword) throws InterruptedException {
		uname.sendKeys(myUserName);
		passw.sendKeys(myPassword);

		Thread.sleep(3000);
		loginButton.click();
	}

}
