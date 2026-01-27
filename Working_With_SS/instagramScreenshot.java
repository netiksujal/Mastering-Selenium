package Working_With_SS;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class instagramScreenshot {

	public static void main(String[] args) throws IOException {
	
		 WebDriver driver= new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		 
		 driver.get("https://www.instagram.com");
		 
		 //downcasting 
		 TakesScreenshot tks= (TakesScreenshot)driver;
		 
		 File source  = tks.getScreenshotAs(OutputType.FILE);
		 File destination= new File("./src/test/java/TakesScreenshotMethods/instagramScreenshot.jpg");
		    
		 FileHandler.copy(source, destination);
		 
		 System.out.println("screenshot taken successfully");
		 
		 driver.quit();
		 
		
	}

}
