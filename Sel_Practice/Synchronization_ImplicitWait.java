package Sel_Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Synchronization_ImplicitWait {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("https://automationwithpiyush.vercel.app/synchronization.html");

		WebElement addButton = driver.findElement(By.cssSelector("#add"));
		addButton.click();

		WebElement removeButton = driver.findElement(By.cssSelector("#remove"));

		removeButton.click();
		Thread.sleep(5000);
		driver.quit();

		System.out.println("success");

	}

}
