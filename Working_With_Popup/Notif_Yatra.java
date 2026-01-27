package Working_With_Popup;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Notif_Yatra {
	
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions setting = new ChromeOptions();
		setting.addArguments("--disable-notifications");
		
		ChromeDriver driver= new ChromeDriver(setting);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://www.yatra.com");
		
		    Thread.sleep(5000);
			driver.quit();	
		
	}

}
