package com.nopcommerce.tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.nop.utilities.TestClass;

public class LoginPageTest extends TestBase{
	
	
	@BeforeClass
	public void setUp() {
		
		initialization();
		
	}
	
	@Test(priority=1)
	public void titleTest() {
		String pageTitle= driver.getTitle();
		Assert.assertEquals(pageTitle, "Your store. Login");
	}
	
	
	@Test(priority=2)
	public void credSectionDisplayedTest() {
		WebElement ele = driver.findElement(By.cssSelector(".topic-block-body p"));
		Assert.assertTrue(ele.isDisplayed());
		
	}
	
	@Test(priority=3)
	public void loginToApplicationTest() {
		driver.findElement(By.cssSelector("#Email")).clear();
		driver.findElement(By.cssSelector("#Email")).sendKeys("admin@yourstore.com");
		
		driver.findElement(By.cssSelector("#Password")).clear();
		driver.findElement(By.cssSelector("#Password")).sendKeys("admin");
		
		driver.findElement(By.cssSelector("input[value='Log in']")).click();
		
		WebElement dashboardHeader= driver.findElement(By.cssSelector(".content-header"));
		
		TestClass.waitForElementToBeVisible(driver,dashboardHeader, 10);
		
		
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
