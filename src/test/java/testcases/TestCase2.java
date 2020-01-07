package testcases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class TestCase2 {
	
	@Test
	public void doLogin() {
		System.out.println("Executing Logging Test");
	}
	
	@Test
	public void doUserReg() {
		System.out.println("Executing User Reg Test");
		
		Assert.fail("User Registration test failed");
		
	}
	
	@Test
	public void isSkip() {
		System.out.println("Skippin  Test");
		
		throw new SkipException("Skipping the test cases");
		
	}
}
