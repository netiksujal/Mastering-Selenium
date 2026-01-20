package working_with_sc_methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

public class SearchContext_xpath {
	public static void main(String args[]) throws InterruptedException {

		WebDriver driver = new ChromeDriver();// First line of code
		driver.manage().window().maximize();// To maximize the Browser

		driver.get("https://www.facebook.com/"); // Navigates to the Facebook home page using fully qualified path

		WebElement CreateAccount_Button = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
		// locating the webelement - create account button through attribute using xpath
		CreateAccount_Button.click();// To click on CreateAccount Button
		Thread.sleep(2000);
		
       //locating the text 'Create a new account' on the create new account webpage through text() function 
		WebElement CreateNewAcc_text= driver.findElement(By.xpath("//div[text()='Create a new account']"));
		
		//locating the text 'Create a new account' on the create new account webpage through text() function 
		//it is basically use to search element by using partial text only
		//WebElement CreateNewAcc_text= driver.findElement(By.xpath("//div[contains(text(),'Create'])"));
		
		WebElement FirstName_textbox = driver.findElement(By.cssSelector("input[name='firstname']"));
		
		
//passing sujal as input in firstname textfield
		FirstName_textbox.sendKeys("Sujal");
		Thread.sleep(2000);

		WebElement LastName_textbox = driver.findElement(By.cssSelector("input[name='lastname']"));
		LastName_textbox.sendKeys("Rajput");
		Thread.sleep(2000);

		//locating the webelement - custom gender radio button through multiple attribute using xpath
		WebElement CustomGender_radioBt = driver.findElement(By.xpath("//input[@value='-1' and @aria-describedby='gender-error-message']"));
		CustomGender_radioBt.click();
		Thread.sleep(1000);
                                                                         
		WebElement CustomGender_textfield = driver.findElement(By.cssSelector("input[aria-label='Gender (optional)']"));
		CustomGender_textfield.sendKeys("Male");
		Thread.sleep(2000);

		WebElement email = driver.findElement(By.cssSelector("input[name='reg_email__']"));
		email.sendKeys("netiksujal@gmail.com");
		Thread.sleep(1000);

		WebElement password = driver.findElement(By.xpath("//input[contains(@type,'password')]")); // tag + attribute
		password.sendKeys("sujal@234");
		Thread.sleep(1000);

		WebElement signUp = driver.findElement(By.xpath("//button[@name='websubmit']"));
		signUp.click();
		Thread.sleep(5000);

		driver.quit();

	}
}
