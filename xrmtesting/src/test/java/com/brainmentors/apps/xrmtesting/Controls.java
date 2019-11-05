package com.brainmentors.apps.xrmtesting;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public interface Controls {

		
	public static void userSelection(String value, WebDriver driver) {
		WebElement val = driver.findElement(By.linkText(value));
		val.click();
	}

	public static void dropDown(String id, String value, WebDriver driver){
	 
	 WebElement val = driver.findElement(By.id(id));
	 Select select = new Select(val);
	 select.selectByVisibleText(value);
	}

	public static void textbox(String id, String value, WebDriver driver) {
	 WebElement val = driver.findElement(By.id(id));
	 System.out.println("String "+value);
	 val.sendKeys(""+value);
	}


	public static void onClick(String id,  WebDriver driver) {
	 WebElement val = driver.findElement(By.id(id));
	 val.click();
	}
	
	public static void implicitWait(long id,  WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(id, TimeUnit.SECONDS); 
	}
	
	public static void multiSelect(String id, String value, WebDriver driver) throws InterruptedException{
		
		Select oSelect = new Select(driver.findElement(By.name(id)));
		List<WebElement> oSize = oSelect.getOptions();
		 int iListSize = oSize.size();
		 
		 // Setting up the loop to print all the options
		 for(int i =0; i < iListSize ; i++){
		 // Storing the value of the option 
		 String sValue = oSelect.getOptions().get(i).getText();
		 
		 // Printing the stored value
		 System.out.println(sValue);
		 
		 // Selecting all the elements one by one
		 oSelect.selectByIndex(i);
		 Thread.sleep(2000);
		 }
	}

}
