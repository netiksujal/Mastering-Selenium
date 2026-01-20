package Sel_Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DirectLocator {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.facebook.com");// opening facebook.com in a new browser using its fully qualified path

//		write admin in an input field using id 
		WebElement un = driver.findElement(By.id("email"));
		un.sendKeys("admin");

		Thread.sleep(1000);

//		write 12345678 in pwd input field using name
		WebElement pwd = driver.findElement(By.name("pass"));
		pwd.sendKeys("12345678");

		Thread.sleep(1000);

//		click on forgotten pwd? using linktext & partialLinkText
//		WebElement fp = driver.findElement(By.linkText("Forgotten password?"));
		WebElement fp = driver.findElement(By.partialLinkText("Forgotten"));
		fp.click();
		Thread.sleep(3000);

		driver.findElement(By.linkText("Log in")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.className("_97w5")).click();
		Thread.sleep(2000);

		WebElement button_tag = driver.findElement(By.tagName("button"));
		System.out.println(button_tag);

		Thread.sleep(2000);

		driver.quit();

	}

}
