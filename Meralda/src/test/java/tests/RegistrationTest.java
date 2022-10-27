package tests;

import org.testng.annotations.Test;

import pages.RegistrationPage;

public class RegistrationTest extends RegistrationPage {


	@Test
	public void verifyRegistration() throws Exception
	{
		userRegistration("jhon", "Smith", "9130727251","2000","Aug","19", "abc@gmail.com", "1234", "1234");
	}

}
