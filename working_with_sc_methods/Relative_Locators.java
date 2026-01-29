package working_with_sc_methods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.with;


public class Relative_Locators {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://automationwithpiyush.vercel.app/relative.html");
		
		WebElement core= driver.findElement(By.id("center_monitor"));
		WebElement targetAbove= driver.findElement(
				with(By.tagName("button"))
				.above(core)
				);
	        targetAbove.click();
		Thread.sleep(2000);
		
		
		WebElement targetBelow= driver.findElement(
				with(By.tagName("button"))
				.below(core)
				);
	       targetBelow.click();
		Thread.sleep(2000);
		
		
		WebElement targetToLeftof=driver.findElement(
				with(By.tagName("button"))
				.toLeftOf(core)
				);
				targetToLeftof.click();
				Thread.sleep(2000);
				
		WebElement targetToRightof=driver.findElement(
				with(By.tagName("button"))
				.toRightOf(core)
				);
		          targetToRightof.click();
		          Thread.sleep(2000);
		       
//		WebElement targetNear=driver.findElement(
//				with(By.tagName("button"))
//				.near(core)
//				);
//		
//		       Thread.sleep(2000);
		
		
		//driver.quit();
		
	}

}
