package tests;

import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTest extends LoginPage {
	@Test
	public void verfiyLogin() throws Exception 
	{
		userLogin ("abc@gmail.com", "1234");
	}

}
