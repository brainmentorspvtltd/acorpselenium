package com.acorp.travel.test;

import java.util.ResourceBundle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePageTest {
	static ResourceBundle readResourceBundle(){
		//ResourceBundle rb = new ResourceBundle(); // abstract class
		ResourceBundle rb = ResourceBundle.getBundle("config");
		return rb;
	}
	static String getValue(String key){
		ResourceBundle rb = readResourceBundle();
		String value = rb.getString(key);
		return  value;
	}

	public static void main(String[] args) {
		System.out.println("Hello Java");
		//   c:\\abcd\\driverfilename
//		System.setProperty("webdriver.chrome.driver", 
//				"/Users/amit/Documents/selenium-things/chromedriver");
		//String driverName = getValue("drivername");
		//String path = getValue("driverpath");
		//System.setProperty(driverName, path);
		System.setProperty(getValue("drivername"), getValue("driverpath"));
		WebDriver driver= new ChromeDriver();
		//driver.get("https://www.google.com");
		driver.get(getValue("url"));
		//driver = new FirefoxDriver();
		//ChromeDriver driver = new ChromeDriver();
		//WebDriver driver = new ChromeDriver();
	}

}
