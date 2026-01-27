package Working_With_SS;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;


public class ZomatoScreenshot {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.zomato.com");
		
		TakesScreenshot tks= (TakesScreenshot)driver;
		
		    File  source  = tks.getScreenshotAs(OutputType.FILE);
		    File destination= new File("./src/test/java/TakesScreenshotMethods/ZomatoScreenshot.jpg");
		    
		    FileHandler.copy(source, destination);
		    
		    Thread.sleep(2);
		    driver.quit();	
		
	}

}
