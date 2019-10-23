package com.brainmentors.tests;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.brainmentors.dao.UserDAO;
import com.brainmentors.dto.User;
import com.brainmentors.utils.ExcelReader;

public class LoginTest {
	private static Logger logger = Logger.getLogger(LoginTest.class);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//WebDriver driver = new ChromeDriver();
		//driver.findElement(By.id("")).sendKeys(String.valueOf(9999.20));
		/* Excel Reader Code
		try {
			int sheetNumber = 0;
			ArrayList<User> users = ExcelReader.readXLS(sheetNumber);
			System.out.println("Users are "+users);  // users.toString()
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		// DB Reader Code
		logger.debug("Inside LoginTest");
		UserDAO userDAO = new UserDAO();
		try {
			ArrayList<User> users = userDAO.getUsers();
			System.out.println("Users are "+users);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			logger.error(e);
			e.printStackTrace();
		} catch (SQLException e) {
			logger.error(e);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.debug("Exit LoginTest");

	}

}
