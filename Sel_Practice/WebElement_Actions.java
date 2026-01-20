package Sel_Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElement_Actions {

	public static void main(String[] args) throws InterruptedException {

	
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(15));	

		driver.get("https://www.instagram.com");

		
		WebElement loginPageImg = driver
				.findElement(By.cssSelector("img[src='/images/assets_DO_NOT_HARDCODE/lox_brand/landing-2x.png']"));
         
		wait.until(ExpectedConditions.visibilityOfAllElements(loginPageImg));
		
		
		
		boolean loginImg_IsDisplayed=loginPageImg.isDisplayed();
		System.out.println(loginImg_IsDisplayed);
		

		WebElement username= driver.findElement(By.cssSelector("input[aria-label='Phone number, username, or email']"));
		boolean name_IsEnabled=username.isEnabled();
		System.out.println(name_IsEnabled);
		username.click();
		username.sendKeys("mr.sujalrajput");
		
		WebElement password=driver.findElement(By.cssSelector("input[aria-label='Password']"));
		boolean pass_IsEnabled=password.isEnabled();
		System.out.println(pass_IsEnabled);
		password.click();
		password.sendKeys("23443224");
		password.clear();
		password.sendKeys("45756dsf@sf");
		Thread.sleep(3000);
		
		
		
		WebElement login_Btn=driver.findElement(By.cssSelector("button[type='submit']"));
		login_Btn.submit();
		Thread.sleep(3000);
		
		driver.quit();
		
		
		
		
		
	}

}
