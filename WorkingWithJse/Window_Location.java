package WorkingWithJse;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Window_Location {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		String url1 = "https://www.facebook.com/";
		String url2 = "https://www.instagram.com";
		String url3 = "https://www.zomato.com";

//		jse.executeScript("window.location='https://www.facebook.com';"); 
//		jse.executeScript("window.location='"+url1+"';");//using concatenation
		jse.executeScript("window.location=arguments[0];", url1); // using argument
		Thread.sleep(1000);

//		jse.executeScript("window.location='https://wwww.zomato.com;");
//		jse.executeScript("window.location='"+url2+"';");
		jse.executeScript("window.location=arguments[1]", url1, url2, url3); // using different index
		Thread.sleep(1000);

//		jse.executeScript("window.location='https://www.instagram.com'");
//		jse.executeScript("window.location='"+url3+"'");
		jse.executeScript("window.location=arguments[0];", url3);

		// returning title of the webpage
		System.out.println("Title of url3 is: " + jse.executeScript("return document.title;"));

		// to scroll
		jse.executeScript("window.scrollTo(0,500);");

		int x = 0;
		int y = 500;
		jse.executeScript("window.scrollTo(" + x + "," + y + ");");

		Thread.sleep(2000);

		jse.executeScript("window.scrollTo(" + x + "," + y * 2 + ");");

		// facebook login block starts----------------

		jse.executeScript("window.location='https://facebook.com';");

		String username = "admin";
		WebElement username_Tf = driver.findElement(By.id("email"));
		// don't use single quote when using arguments
		// jse.executeScript("aruguments[0].value='argument[1]';",username_Tf,username);
		// *wrong syntax

		jse.executeScript("arguments[0].value = arguments[1];", username_Tf, username);  // correct
		// jse.executeScript("arguments[0].value='admin';",username_Tf); //alternate of
		// previous statement

		WebElement password_Tf = driver.findElement(By.id("pass"));
		password_Tf.sendKeys("124343434");


		WebElement login_Btn = driver.findElement(By.name("login"));
		jse.executeScript("arguments[0].click();", login_Btn);

		Thread.sleep(3000);

		// login block end------------------------

		// create account block starts
		jse.executeScript("window.location='https://www.facebook.com/r.php?entry_point=login';");

		WebElement customGender_Tf = driver.findElement(By.id("custom_gender"));
		jse.executeScript("arguments[0].value='MALE';", customGender_Tf);

		Thread.sleep(2000);

		driver.quit();

	}

}
