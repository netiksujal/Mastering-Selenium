package working_with_sc_methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

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

		WebElement CustomGender_radioBt = driver.findElement(By.cssSelector("input[value='-1']"));
		CustomGender_radioBt.click();
		Thread.sleep(1000);

		WebElement CustomGender_textfield = driver.findElement(By.cssSelector("input[aria-label='Gender (optional)']"));
		CustomGender_textfield.sendKeys("Male");
		Thread.sleep(2000);

		WebElement email = driver.findElement(By.cssSelector("input[name='reg_email__']"));
		email.sendKeys("netiksujal@gmail.com");
		Thread.sleep(1000);

		WebElement password = driver.findElement(By.cssSelector("input[type='password']")); // tag + attribute
		password.sendKeys("sujal@234");
		Thread.sleep(1000);

		WebElement signUp = driver.findElement(By.cssSelector("button[name='websubmit']"));
		signUp.click();
		Thread.sleep(5000);

		driver.quit();

	}
}
