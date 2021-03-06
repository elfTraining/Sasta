package com.SastaSundar.TestScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SastaSundar.Pagerepository.OrderMedicine_AddToCart;
import SastaSundar.genericLib.Base;
import SastaSundar.genericLib.FileLib;

public class OrderMedicine_DeleteFromCartTest extends Base 
{
	OrderMedicine_AddToCart medicine;
	FileLib fl  = new FileLib();
	
	@DataProvider
	public Object[][] readData()
	{
		return fl.getAllDataFromExcelFile("OrderMedicine");
	}
	@Test(dataProvider = "readData")
	public void deleteMedicineFromCartTest(String med) throws Exception
	{
		medicine = PageFactory.initElements(driver, OrderMedicine_AddToCart.class);
		Thread.sleep(4000);
		medicine.clickOrderMedicine();
		Reporter.log("clicked on order by medicine lick",true);
		Thread.sleep(4000);
		medicine.searchMedicine(""+med+"");
		Reporter.log("clicked on search field",true);
		
		String result = medicine.getShowingResults().getText();
		System.out.println(result);
		
		medicine.getAddButton().click();
		Reporter.log("clicked add button",true);
		
		String actul = driver.findElement(By.xpath("//a[contains(text(),'"+med+" ')]")).getText();
		System.out.println(actul);
		Assert.assertTrue(actul.contains(""+med+""));
		Reporter.log("medicine added to cart that is displayed in ordermedicine page",true);
		
		medicine.getCheckOutButton().click();
		Reporter.log("clicked on checkou button",true);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'"+med+"')]/../../following-sibling::div[@class='removeSFL']/a[text()='Remove']")).click();
		Reporter.log("clicked on remove link",true);
		Thread.sleep(1000);
		medicine.getOkButton().click();
		Reporter.log("cliked on ok buttton",true);
		
		String verify = medicine.getVerifying().getText();
		Assert.assertTrue(verify.contains("Search & Select Medicines you want to Order"));
		Reporter.log("deleted successsfully",true);
	}
}
