package com.acorp.travel.test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.acorp.travel.utils.BundleReader;

public class HomePageTest {
//	static ResourceBundle readResourceBundle(){
//		//ResourceBundle rb = new ResourceBundle(); // abstract class
//		ResourceBundle rb = ResourceBundle.getBundle("config");
//		return rb;
//	}
//	static String getValue(String key){
//		ResourceBundle rb = readResourceBundle();
//		String value = rb.getString(key);
//		return  value;
//	}

	public static void main(String[] args) {
		System.out.println("Hello Java");
		//   c:\\abcd\\driverfilename
//		System.setProperty("webdriver.chrome.driver", 
//				"/Users/amit/Documents/selenium-things/chromedriver");
		//String driverName = getValue("drivername");
		//String path = getValue("driverpath");
		//System.setProperty(driverName, path);
		System.setProperty(BundleReader.getValue("drivername")
				, BundleReader.getValue("driverpath"));
		WebDriver driver= new ChromeDriver();
		//driver.get("https://www.google.com");
		driver.get(BundleReader.getValue("url"));
		WebElement element = driver.findElement(By.linkText("MSDH"));
		element.click();
		driver.findElement(By.id("txtLoginID")).sendKeys("supadmin");
		driver.findElement(By.id("txtPassword")).sendKeys("Acro@123");
		driver.findElement(By.id("btnSignIn")).click();
		driver.findElement(By.className("prog_name")).click();
		// document.getElementById('dvAttention').style.display='none';
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('dvAttention').style.display='none'");
		js.executeScript("document.querySelector('a[href=\"../Intake/frm_Intake.aspx?TabId=0\"]').click()");
		WebElement cat = driver.findElement(By.id("body_ctl00_ddlClientCategory"));
		Select select = new Select(cat);
		//select.selectByIndex(1);
		//select.selectByValue("1246");
		select.selectByVisibleText("New Client");
		WebElement h5 = driver.findElement(By.cssSelector("#phlnkliIntake > div.box-form > div.heading-div.clearfix > h5"));
		String val = h5.getText();
		if(val.startsWith("PER")) {
			
		}
		if(val.endsWith("ION")) {
			
		}
		if(val.contains("INF")) {
			
		}
//		if(val.equals("PERSONAL INFORMATION")) {
//			System.out.println("Pass");
//		}
//		else {
//			System.out.println("Fail");
//		}
		//driver.close();
		//driver = new FirefoxDriver();
		//ChromeDriver driver = new ChromeDriver();
		//WebDriver driver = new ChromeDriver();
	}

}
