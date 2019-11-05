package com.brainmentors.apps.xrmtesting;


import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.brainmentors.apps.xrmtesting.utils.BundleReader;




public class LoginTest {

	WebDriver driver;
	Logger logger;
	@BeforeClass
	public void load() {
		logger =Logger.getLogger(LoginTest.class);
	}
	
	@BeforeMethod
	public void loadDriver() {
		System.setProperty(BundleReader.getValue("drivername"), BundleReader.getValue("driverpath"));
		 driver=new ChromeDriver();
		//driver=new InternetExplorerDriver();
		
		
		//System.setProperty(BundleReader.getValue("iedrivername"), BundleReader.getValue("iedriverpath"));
		
		driver.get(BundleReader.getValue("url"));
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void close() {
		if(driver!=null) {
			driver.close();
		}
	}
	
	@DataProvider(name = "userdata")
	public Object[][] giveMeData() {
		try {
			ExcelReader reader = new ExcelReader();
			ArrayList<User> users = reader.readLoginXLS();
			Object arr [][]= new Object[users.size()][2];
			int row = 0;
			for(User user: users) {
				arr[row][0] = user.getUserid();
				arr[row][1] = user.getPassword();
				row++;
			}
			return arr;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	@Test(dataProvider = "userdata")
	public void loginMultipleUser(String userid, String password) throws IOException, InterruptedException {
		
					
					
					
						Controls.textbox("txtLoginID", userid, driver);
						Controls.textbox("txtPassword", password, driver);
											  
						driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS); 
					  
						//Submit Button 
						Controls.onClick("btnSignIn", driver);
						
					  Thread.sleep(5000);
					 
					
						String text= driver.findElement(By.cssSelector("#wrapper > header > div.topbar > div > div > div > div")).getText();
						System.out.println("text......"+text);
						
						Assert.assertTrue(text.startsWith("HELLO"));	
						
	}
	
}
