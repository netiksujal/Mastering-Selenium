package working_with_sc_methods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitWait_xpath {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver(); /* WebDriver is an Interface * ChromeDriver → Class that implements WebDriver, Creates a browser session, Enables automation commands like get(), findElement(), click(), etc.*/
		driver.manage().window().maximize();//to maximize window
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://automationwithpiyush.vercel.app/#practice");
		
		Thread.sleep(2000);
		WebElement practice= driver.findElement(By.linkText("Practice"));
		practice.click();
	
		
		WebElement locators=driver.findElement(By.xpath("//h4[text()='Locators']"));
		locators.click();
		Thread.sleep(2000);
		
		WebElement username_TextField=driver.findElement(By.cssSelector("#email"));
		username_TextField.sendKeys("darling@loveworld.com");
		username_TextField.click();
		Thread.sleep(2000);
		
		WebElement password_TextField=driver.findElement(By.cssSelector("input[name='pass']"));
		password_TextField.sendKeys("iloveyou@piyushsir");
		password_TextField.click();
		Thread.sleep(2000);
		
		WebElement policy_Checkbox=driver.findElement(By.xpath("//input[@type='checkbox' and @class='custom-checkbox']"));
		policy_Checkbox.click();
		Thread.sleep(2000);
		
		/*
		 * WebElement login_Button=driver.findElement(By.
		 * xpath("//button[contains(text(),'Log In')]")); 
		 * login_Button.click();
		 * Thread.sleep(2000);
		 */
        
        WebElement login_Button=driver.findElement(By.xpath("//button[contains(@id,'u_0_5_')]"));
        login_Button.click();
        Thread.sleep(2000);
        
        driver.quit();
		
		
	}

}
