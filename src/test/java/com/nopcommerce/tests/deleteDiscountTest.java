package com.nopcommerce.tests;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.nop.utilities.TestClass;

public class deleteDiscountTest extends TestBase {
	
	
	@BeforeClass
	public void setUp() {
		initialization();
		driver.findElement(By.cssSelector("input[value='Log in']")).click();

		WebElement dashboardHeader = driver.findElement(By.cssSelector(".content-header"));

		TestClass.waitForElementToBeVisible(driver, dashboardHeader, 10);
	}

	@Test(priority = 1)
	public void selectDiscount() {

		driver.findElement(By.xpath("//span[text()='Promotions']")).click();
		driver.findElement(By.xpath("//span[text()='Discounts']")).click();
		
		WebElement discounts= driver.findElement(By.cssSelector(".dataTables_length"));
		TestClass.waitForElementToBeVisible(driver, discounts, 10);


		// Get no of rows in table
		ArrayList<WebElement> rows = (ArrayList<WebElement>) driver
				.findElements(By.cssSelector("table[id='discounts-grid'] tbody tr"));

		for (int i = 0; i < rows.size(); i++) 
		{
			
			ArrayList<WebElement> data = (ArrayList<WebElement>) driver
					.findElements(By.cssSelector("table[id='discounts-grid'] tbody tr:nth-child(" + i + ") td"));

			for (int j = 0; j < data.size(); j++) {
				
				if (data.get(j).getText().contains("CODE20")) {
					
					
					driver.findElement(
							By.cssSelector("table[id='discounts-grid'] tbody tr:nth-child("+i+") td.button-column a"))
							.click();
				
					
					break;
				}

			}
			
			
		}

	}

	@Test(priority = 2)
	public void deleteAddedDiscount() {
		
		
		driver.findElement(By.id("discount-delete")).click();
		driver.findElement(By.cssSelector(".bg-red.pull-right")).click();

		WebElement successMsgBar = driver.findElement(By.cssSelector(".alert-success"));
		TestClass.waitForElementToBeVisible(driver, successMsgBar, 10);
		Assert.assertTrue(successMsgBar.isDisplayed());
		Assert.assertTrue(successMsgBar.getText().contains("The discount has been deleted successfully."));
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	

}
