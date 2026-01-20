package Sel_Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Prct_CreateAccount {
	public static void main(String args[]) throws InterruptedException {

		WebDriver driver = new ChromeDriver();// First line of code
		driver.manage().window().maximize();// To maximize the Browser

		driver.get("https://www.facebook.com"); // Navigates to the Facebook home page using fully qualified path

        //locating the webelement - create account button
		WebElement CreateAccount_Button = driver
				.findElement(By.cssSelector("a[data-testid='open-registration-form-button']"));
		CreateAccount_Button.click();// To click on CreateAccount Button
		Thread.sleep(2000);

		WebElement FirstName_textbox = driver.findElement(By.cssSelector("input[name='firstname']"));
		FirstName_textbox.sendKeys("Sujal");
		Thread.sleep(2000);

		WebElement LastName_textbox = driver.findElement(By.cssSelector("input[name='lastname']"));
		LastName_textbox.sendKeys("Rajput");
		Thread.sleep(2000);

		WebElement dateDD = driver.findElement(By.cssSelector("select[name='birthday_day']"));
		Select selDate = new Select(dateDD);
		selDate.selectByVisibleText("20");

		WebElement monthDD = driver.findElement(By.cssSelector("select[name='birthday_month']"));
		Select selMonth = new Select(monthDD);
		selMonth.selectByIndex(8);

		WebElement yearDD = driver.findElement(By.cssSelector("select[name='birthday_year']"));
		Select selYear = new Select(yearDD);
		selYear.selectByIndex(22);

		WebElement CustomGender_radioBt = driver.findElement(By.cssSelector("input[value='-1']"));
		CustomGender_radioBt.click();
		Thread.sleep(2000);

		WebElement CustomGender_textfield = driver.findElement(By.cssSelector("input[aria-label='Gender (optional)']"));
		CustomGender_textfield.sendKeys("Male");
		Thread.sleep(2000);

		WebElement email = driver.findElement(By.cssSelector("input[name='reg_email__']"));
		email.sendKeys("netiksujal42@gmail.com");
		Thread.sleep(2000);

		WebElement password = driver.findElement(By.cssSelector("input[type='password']")); // tag + attribute
		password.sendKeys("Sujal@2347");
		Thread.sleep(2000);

		WebElement signUp_Btn = driver.findElement(By.cssSelector("button[name='websubmit']"));
		signUp_Btn.click();
		Thread.sleep(2000);

	}
}
