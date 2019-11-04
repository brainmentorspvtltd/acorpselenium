package testngdemos;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDemo4 {
	
	@Test(dependsOnGroups = {"groupA"})
	public void caller() {
		
	}
	
	@Test(groups = { "groupA", "groupB" })
	   
	   public void testG1() {
	      System.out.println("TestGroups Called");
	     
	      Assert.assertTrue(10>2);
	   }

	   @Test(groups = { "groupA" })
	   
	   public void group1() {
		   System.out.println("Group1 Called");
		     
		      Assert.assertTrue(10>200);
	   }
	   
       @Test(groups = { "groupA" })
	   public void groupA1() {
		   System.out.println("Group1 Called");
		     
		      Assert.assertTrue(10>200);
	   }

	   @Test(groups = { "groupB" })
	   
	   public void group2() {
		   System.out.println("Group2 Called");
		     
		      Assert.assertTrue(10>2);
	   }
}
