package Sel_Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElement_Getters {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://www.instagram.com");

		WebElement username = driver
				.findElement(By.cssSelector("input[aria-label='Phone number, username, or email']"));
		boolean name_IsEnabled = username.isEnabled();
		System.out.println(name_IsEnabled);
		
		username.click();
		username.sendKeys("mr.sujalrajput");
		

		WebElement loginPageImg = driver
				.findElement(By.cssSelector("img[src='/images/assets_DO_NOT_HARDCODE/lox_brand/landing-2x.png']"));
		Dimension loginImg_Dim = loginPageImg.getSize();
		System.out.println(loginImg_Dim);

		Point loginImg_Pos = loginPageImg.getLocation();
		System.out.println(loginImg_Pos);

		String loginImg_Tn = loginPageImg.getTagName();
		System.out.println(loginImg_Tn);

		String loginImg_Attv = loginPageImg.getAttribute("src");
		System.out.println(loginImg_Attv);

		WebElement login_Btn=driver.findElement(By.cssSelector("button[type='submit']"));
		String get_loginBtnText = login_Btn.getText();
		System.out.println(get_loginBtnText);
		
		
		Thread.sleep(3000);
		driver.quit();

	}

}
