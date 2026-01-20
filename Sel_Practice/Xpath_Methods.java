package Sel_Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Xpath_Methods {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://automationwithpiyush.vercel.app/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		WebElement practiceBtn = driver.findElement(By.xpath("//a[@href='#practice' and text()='Practice' ]"));
		practiceBtn.click();
        Thread.sleep(3000);
        
		driver.navigate().back();

		Thread.sleep(3000);
		WebElement serviceBtn = driver.findElement(By.xpath("//a[@href='#services']"));
		serviceBtn.click();
		Thread.sleep(2000);
		driver.navigate().back();
		
		Thread.sleep(2000);
		WebElement worksBtn=driver.findElement(By.xpath("//a[contains(text(),'Works')]"));
		worksBtn.click();
		Thread.sleep(2000);
		driver.navigate().back();
		
		Thread.sleep(2000);
		WebElement blogBtn=driver.findElement(By.xpath("//a[@href='#blog' and @class='hover:text-amber-400 transition']"));
		blogBtn.click();
		Thread.sleep(2000);
		driver.navigate().back();
		
		Thread.sleep(2000);

		 driver.quit();

	}

}
