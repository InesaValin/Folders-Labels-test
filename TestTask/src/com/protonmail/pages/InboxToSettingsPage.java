package com.protonmail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InboxToSettingsPage {

	WebDriver driver;

	public InboxToSettingsPage(WebDriver idriver) {
		this.driver = idriver;
	}

	@FindBy(xpath = "//*[@id=\"secured-inbox\"]/div[1]/div/dialog/div/footer/button[1]")
	WebElement closeButton;
	@FindBy(xpath = "//*[@id=\"tour-settings\"]")
	WebElement settingsButton;
	@FindBy(xpath = "/html/body/div[1]/div[2]/div/div/div[1]/nav/ul/li[11]/a/span/span")
	WebElement toFoldersLabels;

	public void goToSettings() throws InterruptedException {
		Thread.sleep(3000);
		closeButton.click();

		Thread.sleep(3000);
		settingsButton.click();

		Thread.sleep(3000);
		toFoldersLabels.click();
	}

}
