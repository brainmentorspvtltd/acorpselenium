package testngdemos;

import org.testng.annotations.Test;

public class TestDemo3 {
	 @Test (priority=2)
	public void testPr2() {
		System.out.println("P2");
	}
	 
	 @Test (priority=1)
		public void testPr1() {
			System.out.println("P1");
		}

}
