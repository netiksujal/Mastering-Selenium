package Working_With_SS;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class getScreenshotAs {

	public static void main(String[] args) throws IOException {
    
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.facebook.com");
		
		TakesScreenshot tks= (TakesScreenshot)driver;
		//method to take screenshot from the source i.e. Facebook webpage
		 File source =tks.getScreenshotAs(OutputType.FILE);
		
		 //Specifying path to save screenshot
		 File destination = new File("./src/test/java/TakesScreenshotMethods/getScreenshotAs.jpg") ;
		 //copying the image from the source and saving it to the specified path
		  FileHandler.copy(source, destination);
		
		System.out.println("Screenshot captured successfully");
		
		driver.quit();	
		
	}

}
