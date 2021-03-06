package com.vTiger.testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import com.vTiger.genericLib.Base;
import com.vTiger.genericLib.FileLib;
import com.vTiger.pagerepository.CreateProPage;
import com.vTiger.pagerepository.Home;
import com.vTiger.pagerepository.Products;

@Listeners(com.vTiger.genericLib.ListenerImp.class)
public class TestScript7 extends Base
{

	FileLib lib = new FileLib();
	Products prod;
	Home home;
	CreateProPage cpro;  
	
	@Test
	public void createProductTest3() throws InterruptedException
	{
		home = PageFactory.initElements(driver, Home.class);
		home.getproductLink().click();
		Reporter.log("Clicked on Products Link",true);
		
		prod = PageFactory.initElements(driver, Products.class);
		prod.getCreatePro().click();
		Reporter.log("Clicked on Create Products Icon",true);
		
		cpro = PageFactory.initElements(driver, CreateProPage.class);
		cpro.getProductName().sendKeys(lib.getSpecifiedDataFromExcelFile(lib.getDataFromPrpoertyFile("Sheet4"), 3, 0));
		Reporter.log("Product Name is Entered",true);
		
		cpro.category(lib.getSpecifiedDataFromExcelFile(lib.getDataFromPrpoertyFile("Sheet4"), 3, 1));
		Reporter.log("Product Category is Selected",true);
		
		cpro.getProductWeb().sendKeys(lib.getSpecifiedDataFromExcelFile(lib.getDataFromPrpoertyFile("Sheet4"), 3, 2));
		Reporter.log("Product Website is Entered",true);
		
		cpro.pgl(lib.getSpecifiedDataFromExcelFile(lib.getDataFromPrpoertyFile("Sheet4"), 3, 3));
		Reporter.log("Product GL Account is Selected",true);
		
		cpro.getProductSN().sendKeys(lib.getSpecifiedDataFromExcelFile(lib.getDataFromPrpoertyFile("Sheet4"), 3, 4));
		Reporter.log("Product Serial Number is Entered",true);
		
		cpro.getSavePro().click();
		Reporter.log("Clicked on Save Button",true);
		Thread.sleep(10000);
		
	}
	
	@Test
	public void createProductTest4() throws InterruptedException
	{
		
		home = PageFactory.initElements(driver, Home.class);
		home.getproductLink().click();
		Reporter.log("Clicked on Products Link",true);
		
		prod = PageFactory.initElements(driver, Products.class);
		prod.getCreatePro().click();
		Reporter.log("Clicked on Create Products Icon",true);
		
		cpro = PageFactory.initElements(driver, CreateProPage.class);
		cpro.getProductName().sendKeys(lib.getSpecifiedDataFromExcelFile(lib.getDataFromPrpoertyFile("Sheet4"), 4, 0));
		Reporter.log("Product Name is Entered",true);
		
		cpro.category(lib.getSpecifiedDataFromExcelFile(lib.getDataFromPrpoertyFile("Sheet4"),4, 1));
		Reporter.log("Product Category is Selected",true);
		
		cpro.getProductWeb().sendKeys(lib.getSpecifiedDataFromExcelFile(lib.getDataFromPrpoertyFile("Sheet4"), 4, 2));
		Reporter.log("Product Website is Entered",true);
		
		cpro.pgl(lib.getSpecifiedDataFromExcelFile(lib.getDataFromPrpoertyFile("Sheet4"), 4, 3));
		Reporter.log("Product GL Account is Selected",true);
		
		cpro.getProductSN().sendKeys(lib.getSpecifiedDataFromExcelFile(lib.getDataFromPrpoertyFile("Sheet4"),4, 4));
		Reporter.log("Product Serial Number is Entered",true);
		
		cpro.getSavePro().click();
		Reporter.log("Clicked on Save Button",true);
		Thread.sleep(10000);
		
	}
		
	
	
}
