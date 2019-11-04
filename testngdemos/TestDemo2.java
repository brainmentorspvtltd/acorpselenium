package testngdemos;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDemo2 {

	@Test(enabled = false)
	public void testA() {
		System.out.println("TestA");
		Assert.assertTrue(10>2);
	}
	
	 @Test
     public void testA1() { 
       System.out.println("Fail Method");
       Assert.assertTrue(10>200);
     }
    
     @Test(dependsOnMethods={"testA1"}, alwaysRun=true) 
     public void testB() { 
       System.out.println("TestB Run Always");
     }
	

}
