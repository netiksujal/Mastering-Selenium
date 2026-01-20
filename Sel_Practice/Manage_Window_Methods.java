package Sel_Practice;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;

public class Manage_Window_Methods {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver(); // first line of code
		driver.manage().window().maximize();// second line of code

		driver.get("https://www.facebook.com/"); // opening facebook.com using get() method

//		driver.manage().window().maximize();

		Options opt = driver.manage();
		Window win = opt.window();


		Thread.sleep(1000);
		win.maximize();
		Thread.sleep(1000);

		win.minimize();
		Thread.sleep(1000);

		win.fullscreen();
		Thread.sleep(2000);

		win.maximize();
		Thread.sleep(2000);

		Dimension toStoreSize = win.getSize();
		System.out.println(toStoreSize);

		Point toStorePosition = win.getPosition();
		System.out.println(toStorePosition);

		win.setPosition(new Point(-2, -2));

		Dimension dim = new Dimension(200, 500);
		win.setSize(dim);

		Thread.sleep(3000);

		driver.quit();

	}

}
