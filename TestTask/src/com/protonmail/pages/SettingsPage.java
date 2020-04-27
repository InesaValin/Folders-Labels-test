package com.protonmail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SettingsPage {

	WebDriver driver;

	public SettingsPage(WebDriver sdriver) {
		this.driver = sdriver;
	}

	@FindBy(xpath = "/html/body/div[1]/div[2]/div/div/div[2]/div/main/div/section/div[2]/button[1]")
	WebElement folderButton;
	@FindBy(id = "accountName")
	WebElement folderLabelName;
	@FindBy(xpath = "/html/body/div[*]/dialog/form/footer/button[2]")
	WebElement submitFolderLabel;
	@FindBy(xpath = "/html/body/div[1]/div[2]/div/div/div[2]/div/main/div/section/div[2]/button[2]")
	WebElement labelButton;
	@FindBy(xpath = "//button[@data-test-id=\"folders/labels:item-delete\"]")
	WebElement deleteButton;
	@FindBy(xpath = "/html/body/div[14]/dialog/form/footer/button[2]")
	WebElement confirmDelButton;

	public void createFolder(String fName) throws InterruptedException {
		Thread.sleep(3000);
		folderButton.click();

		folderLabelName.sendKeys(fName);

		Thread.sleep(3000);
		submitFolderLabel.click();
	}

	public void createLabel(String lName) throws InterruptedException {
		Thread.sleep(3000);
		labelButton.click();

		folderLabelName.sendKeys(lName);

		Thread.sleep(3000);
		submitFolderLabel.click();
	}

	public void modify(String cName, String editNumber) throws InterruptedException {
		Thread.sleep(3000);
		String xpathEdit = "/html/body/div[1]/div[2]/div/div/div[2]/div/main/div/section/table/tbody/tr[" + editNumber
				+ "]/td[4]/div/button[1]";
		WebElement editButton = driver.findElement(By.xpath(xpathEdit));
		editButton.click();

		Thread.sleep(3000);

		folderLabelName.sendKeys(Keys.CONTROL + "a");
		folderLabelName.sendKeys(Keys.DELETE);
		folderLabelName.sendKeys(cName);

		Thread.sleep(3000);
		submitFolderLabel.click();

	}

	public void delete(String deleteNumber) throws InterruptedException {
		Thread.sleep(3000);
		String xpathEdit = "/html/body/div[1]/div[2]/div/div/div[2]/div/main/div/section/table/tbody/tr[" + deleteNumber
				+ "]/td[4]/div/button[2]";
		WebElement optionsButton = driver.findElement(By.xpath(xpathEdit));
		optionsButton.click();

		Thread.sleep(3000);
		deleteButton.click();

		Thread.sleep(3000);
		confirmDelButton.click();
	}

	public void changeOrder(String moveNumber, String moveNumber2) throws InterruptedException {
		Thread.sleep(3000);
		String xpathMove = "/html/body/div[1]/div[2]/div/div/div[2]/div/main/div/section/table/tbody/tr[" + moveNumber
				+ "]/td[1]/span";
		WebElement folderLabelMove = driver.findElement(By.xpath(xpathMove));

		String xpathMove2 = "/html/body/div[1]/div[2]/div/div/div[2]/div/main/div/section/table/tbody/tr[" + moveNumber2
				+ "]/td[1]/span";
		WebElement folderLabelMove2 = driver.findElement(By.xpath(xpathMove2));

		Actions act = new Actions(driver);
		act.dragAndDrop(folderLabelMove, folderLabelMove2).build().perform();

	}

}
