package testngdemos;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestDemo {
	
	@BeforeClass
	public void load() {
		// it will run once after the Test
		System.out.println("Before Class Called");
	}
	@AfterClass
	public void after() {
		System.out.println("After Class Called..");
	}
	
	@BeforeMethod	
	public void methodA() {
		// It will run before every @Test
		System.out.println("I am Before Method");
	}
	@BeforeTest
	public void start() {
		// this will call only once in test cycle no matter how many @Test
		System.out.println("Start Run before Test");
	}
	@Test
	public void test1() {
		System.out.println("Test1 Execute");
		Assert.assertTrue(10>2);
	}
	@Test
	public void test2() {
		System.out.println("Test2 Execute");
		Assert.assertTrue(10>2);
	}
	@AfterTest
	public void end() {
		System.out.println("End Run After Test");
	}

}
