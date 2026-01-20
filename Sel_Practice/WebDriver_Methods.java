package Sel_Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriver_Methods {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver(); // first line of code
		driver.manage().window().maximize();// second line of code

		driver.get("https://www.facebook.com/"); // opening facebook.com using get() method

		String title = driver.getTitle(); // getting title of the web page
		System.out.println(title);
		

		String currentUrl = driver.getCurrentUrl(); // getting current URL
		System.out.println(currentUrl);

		String sourceCode = driver.getPageSource(); // getting source code of web page
		System.out.println(sourceCode);

		Thread.sleep(5000);

		driver.navigate().back();
		Thread.sleep(2000);

		driver.navigate().forward();
		Thread.sleep(2000);

		driver.navigate().refresh();
		Thread.sleep(2000);

		System.out.println("Program Executed Successfully");

		// driver.close(); // it will close the current window but it will not stop the
		// server
		driver.quit();

	}
}