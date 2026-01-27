package Working_With_Popup;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class All_In_One {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("https://automationwithpiyush.vercel.app/popups.html");

		Thread.sleep(1000);


		Alert ale = driver.switchTo().alert();
		ale.sendKeys("Sujal");
		ale.accept();

		driver.findElement(By.xpath("//button[contains(text(),'Alert')]")).click();
		Thread.sleep(500);
		ale.accept();

		driver.findElement(By.xpath("//button[contains(text(),'Confirm')]")).click();
		Thread.sleep(500);
		ale.dismiss();

		driver.findElement(By.xpath("//button[contains(text(),'Prompt')]")).click();
		Thread.sleep(500);

		ale.sendKeys("Sujal");
	
		String text = ale.getText();
		Thread.sleep(3000);
		System.out.println(text);

		ale.accept();

		
		driver.navigate().to("https://admin:admin@the-internet.herokuapp.com/basic_auth");
         Thread.sleep(2000);
         
		driver.navigate().to("https://admin:admin@jigsaw.w3.org/HTTP/Basic/");
		Thread.sleep(2000);
		
		driver.navigate().to("https://admin:admin@httpbin.org/basic-auth/user/pass");	
		Thread.sleep(5000);
		
		
		driver.quit();
	}
}