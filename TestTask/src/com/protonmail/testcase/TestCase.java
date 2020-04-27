package com.protonmail.testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.protonmail.pages.InboxToSettingsPage;
import com.protonmail.pages.LoginPage;
import com.protonmail.pages.SettingsPage;
import com.protonmail.utility.BrowserFactory;

public class TestCase {

	static WebDriver driver;

	@BeforeClass
	public static void browserOpenToSettings() throws InterruptedException {
		driver = BrowserFactory.startApplication(driver, "Chrome", "https://beta.protonmail.com");

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.login("protonmail_test_task", "ProtonMailTest123");

		InboxToSettingsPage inboxToSettingsPage = PageFactory.initElements(driver, InboxToSettingsPage.class);
		inboxToSettingsPage.goToSettings();
	}

	@Test(priority = 0)
	public void createFolderLabel() throws InterruptedException {
		SettingsPage settingsPage = PageFactory.initElements(driver, SettingsPage.class);
		settingsPage.createFolder("Important");
		settingsPage.createFolder("Regular");
		settingsPage.createLabel("First");
		settingsPage.createLabel("Second");
	}

	@Test(priority = 1)
	public void modifyFolderLabel() throws InterruptedException {
		SettingsPage settingsPage = PageFactory.initElements(driver, SettingsPage.class);
		settingsPage.modify("Changed", "1");
		settingsPage.modify("Also Changed", "2");
	}

	@Test(priority = 2)
	public void deleteFolderLabel() throws InterruptedException {
		SettingsPage settingsPage = PageFactory.initElements(driver, SettingsPage.class);
		settingsPage.delete("1");
	}

	@Test(priority = 3)
	public void changePlace() throws InterruptedException {
		SettingsPage settingsPage = PageFactory.initElements(driver, SettingsPage.class);
		settingsPage.changeOrder("3", "1");

	}

	@AfterClass
	public void BrowserClose() throws InterruptedException {
		BrowserFactory.quitBrowser(driver);
	}

}
