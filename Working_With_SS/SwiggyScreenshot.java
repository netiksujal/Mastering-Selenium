package Working_With_SS;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class SwiggyScreenshot {

	public static void main(String[] args) throws IOException, InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.swiggy.com/");
		Thread.sleep(2000);


		TakesScreenshot tks = (TakesScreenshot) driver;

		File source = tks.getScreenshotAs(OutputType.FILE);
		File destination = new File("./src/test/java/TakesScreenshotMethods/SwiggyScreenshot.jpg");
		FileHandler.copy(source, destination);

		

	}

}
