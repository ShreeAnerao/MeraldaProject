package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import baseUtility.CommonUtility;

public class RegistrationPage extends CommonUtility {

	//Xpaths
	public final String userFirstName = "//input[@name='first_name']";
	public final String userLastName ="//input[@name='last_name']";
	public final String userEmail="//input[@placeholder='Email Address']";
	public final String userMobileNo ="//input[@placeholder='Mobile Number']";
	public final String calender ="//input[@placeholder='DOB']";
	public final String btnBackCalender="//button[@class='mx-btn mx-btn-text mx-btn-icon-double-left']";
	public final String listOfMonths ="//table/tr/td[@class='cell']/div";
	public final String listOfDates = "//tbody/tr/td[@class='cell']/div";
	public final String currentYear="//button[contains(text(),'2022')]";
	public final String listOfYears="//div[@class='mx-calendar-content']//child::tr/td/div";
	public final String userPassword ="//input[@placeholder='Password']";
	public final String userConfirmPassword ="//input[@placeholder='Confirm password']";
	public final String btnSubmit ="//div/button[contains(text(),'Register')]";
	
	
	// Page Methods
	public void userRegistration (String fName,String lName,String mobileNo,String uBirthyear,String uBirthMonth, String uBDate,String email,String password,String confirmPassword ) throws Exception
	{
		
		driver.findElement(By.xpath(userFirstName)).sendKeys(fName);
		driver.findElement(By.xpath(userLastName)).sendKeys(lName);
		
		driver.findElement(By.xpath(userEmail)).sendKeys(email);
		driver.findElement(By.xpath(userMobileNo)).sendKeys(mobileNo);
		userDOB(uBirthyear, uBirthMonth, uBDate);
		driver.findElement(By.xpath(userPassword)).sendKeys(password);
		driver.findElement(By.xpath(userConfirmPassword)).sendKeys(confirmPassword);
		
		scrollToElement(btnSubmit);
		Thread.sleep(2000);
		driver.findElement(By.xpath(btnSubmit)).click();
	}
	
	public void userDOB(String reqyear,String reqMonth,String reqDate ) throws Exception
	{
		driver.findElement(By.xpath(calender)).click();
		driver.findElement(By.xpath(currentYear)).click();
		List<WebElement> listYears = new ArrayList();

		boolean flag = false;

		while (!flag) {
			listYears = driver.findElements(By.xpath(listOfYears));
			for (WebElement year : listYears) {
				System.out.println(year.getText());
				if (year.getText().equalsIgnoreCase(reqyear)) {
					year.click();
					flag = true;
					System.out.println("found");
					break;
				}
			}
			System.out.println(flag);
			if (flag == false) {
				WebElement back = driver
						.findElement(By.xpath(btnBackCalender));
				back.click();
				System.out.println("going to back page");
			}
		}
		List<WebElement> monthsList = driver.findElements(By.xpath(listOfMonths));
		for (WebElement month : monthsList) {
			System.out.println("List of months : " + month.getText());
			if (month.getText().equalsIgnoreCase(reqMonth)) {
				month.click();
			}
		}
		List<WebElement> dates = driver.findElements(By.xpath(listOfDates));
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfAllElements(dates));
		System.out.println(dates.size());
		System.out.println("size of date is :" + dates.size());
		for (WebElement date : dates) {
			if (date.getText().equalsIgnoreCase(reqDate)) {

				clickOnElement(date);
				
			}
		}

	}

}
