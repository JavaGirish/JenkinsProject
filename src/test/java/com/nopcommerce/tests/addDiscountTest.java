package com.nopcommerce.tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.nop.utilities.TestClass;

public class addDiscountTest extends TestBase {
	
	@BeforeMethod
	public void setUp() {
		initialization();
		driver.findElement(By.cssSelector("input[value='Log in']")).click();
		
		WebElement dashboardHeader= driver.findElement(By.cssSelector(".content-header"));
		
		TestClass.waitForElementToBeVisible(driver,dashboardHeader, 10);
	}
	
	
	@Test
	public void addNewDiscount() {
		
		driver.findElement(By.xpath("//span[text()='Promotions']")).click();
		driver.findElement(By.xpath("//span[text()='Discounts']")).click();
		driver.findElement(By.cssSelector(".btn.bg-blue")).click();
		driver.findElement(By.id("Name")).sendKeys("CODE20");
		driver.findElement(By.cssSelector("button[name='save']")).click();
		
		WebElement successMsgBar= driver.findElement(By.cssSelector(".alert-success"));
		Assert.assertTrue(successMsgBar.isDisplayed());
		Assert.assertTrue(successMsgBar.getText().contains("The new discount has been added successfully."));
			
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
