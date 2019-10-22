package com.acorp.travel.test;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchingTabs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "https://www.monsterindia.com/seeker/registration?utm_expid=.iO1Vg59kR7udg4RYmnvdsA.0&utm_referrer=";
		System.setProperty("webdriver.chrome.driver", "/Users/amit/Documents/selenium-things/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElements(By.className("box")).get(0).click();
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1)); //open google.com on tab then test
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.querySelectorAll('.gb_e')[0].click();");
		
		

	}

}
