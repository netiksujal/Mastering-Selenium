package WorkingWithSync;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;


public class  Sync_FluentWait  {

	public static void main(String[] args) throws InterruptedException {
		
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver(); // first line of code
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		// will wait till element is not present

		driver.get("https://automationwithpiyush.vercel.app/synchronization.html");
		/// Navigates to the synchronization lap page using fully qualified path

		WebElement enableBox2_Button = driver.findElement(By.xpath("//button[@onclick='enableInput(2, 10000)']"));
		enableBox2_Button.click();
		// used to find or locate the web element like enable box 1
		
		WebElement textBox2=driver.findElement(By.xpath("//input[@type='text' and @id='target-2']"));
		
		 FluentWait<WebDriver> wait = new FluentWait<>(driver);
		 
		 wait.withTimeout(Duration.ofSeconds(15));
		 wait.pollingEvery(Duration.ofSeconds(3));
			wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.elementToBeClickable(textBox2));
		
			 
		if (textBox2.isEnabled()) {
			textBox2.sendKeys("LoveYouPiyushSir, mast knowledge dete ho aap");
		}

		else {
			System.out.println("😭😭 cryyyyy, sir enable ni hopaya textbox2");
		}

		Thread.sleep(2000);
		driver.quit();
	}

}
 