package working_with_sc_methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

public class Prct_Login {
public static void main(String args[]) throws InterruptedException {
	

	WebDriver driver= new ChromeDriver();//first line of code
	driver.manage().window().maximize();//To maximize the Browser 
	
	driver.get("https://www.facebook.com"); //To open facebook hompage
	
	WebElement Email_textbox= driver.findElement(By.cssSelector("input[name='email']"));
	Email_textbox.sendKeys("admin");
	Thread.sleep(2000);
	
	WebElement Password_textbox=driver.findElement(By.cssSelector("input[name='pass']"));
	Password_textbox.sendKeys("12345678");
	Thread.sleep(2000);

	WebElement Login_button=driver.findElement(By.cssSelector("button[data-testid='royal-login-button\']"));
	Login_button.click();
	Thread.sleep(5000);
	
	
//	WebElement ForgotPassword_button = driver.findElement(By.linkText("Forgotten password?"));
	//ForgotPassword_button.click();
//	Thread.sleep(5000);

//	WebElement CreateAccount_Button=driver.findElement(By.cssSelector("a[data-testid='open-registration-form-button']"));
//	CreateAccount_Button.click();
//	Thread.sleep(5000);

	
	driver.quit();

	
	
	
}	
}
