package pages;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import baseUtility.CommonUtility;

public class LoginPage extends CommonUtility {

	public final String btnLogin = "//a[contains(text(),'Login')]";
	public final String emailAddress = "//input[@placeholder='Email/Phone']";
	public final String password = "//input[@type=\"password\"]";
	public final String login = "//button[contains(text(),'Login')]";

	public void userLogin(String userEmail, String userPassword) throws Exception {

		scrollToElement(btnLogin);
		driver.findElement(By.xpath(btnLogin)).click();
		driver.findElement(By.xpath(emailAddress)).sendKeys(userEmail);
		driver.findElement(By.xpath(password)).sendKeys(userPassword);
		driver.findElement(By.xpath(login)).click();

	}

}
