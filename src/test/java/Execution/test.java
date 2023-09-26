package Execution;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.HomePage;

public class test extends HomePage{
	
	@BeforeClass
	public void browserSetup() throws IOException {
		
		launchBrowser();
		implicitWait(20);
	}
	
	@Test(priority=1,enabled=true)
	public void login() {
	
		loginbtn();
	}
	
	@Test(priority=2,enabled=true)
	public void searchFunctionality() {
		
		searchTest();

	}


	@AfterClass
	public void close() {
		
	  quitBrowser();
	 
	}

}
