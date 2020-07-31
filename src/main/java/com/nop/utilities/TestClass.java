package com.nop.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.TestBase;

public class TestClass extends TestBase{

	// 1.
	// Explicit Wait to Click on any WebElement.
	public static void clickOn(WebDriver driver, WebElement element, int timeout) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	// 2.
	// Explicit Wait to Send Data to any WebElement.
	public static void sendKeys(WebDriver driver, WebElement element, int timeout, String value) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
	}

	// 3.
	// Explicit Wait for Element To Be Visible.
	public static void waitForElementToBeVisible(WebDriver driver, WebElement locator, int timeout) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(locator));
	}

}
