package WorkingWithActionClas;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class ActionsClassMethods {
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://automationwithpiyush.vercel.app/actions.html");

		WebElement tissue = driver.findElement(By.id("hover-box"));
		Actions act = new Actions(driver);
		act.moveToElement(tissue).perform();
		System.out.println("Step 1: Hover performed.");
		Thread.sleep(1000);

		WebElement click = driver.findElement(By.id("click-target"));
		act.click(click).perform();
		System.out.println("Step 2: Standard click performed.");
		Thread.sleep(1000);

		WebElement rightClick = driver.findElement(By.id("context-area"));
		act.contextClick(rightClick).perform();
		System.out.println("Step 3: Right-click diagnostic performed.");
		Thread.sleep(1000);

		WebElement doubleClick = driver.findElement(By.xpath("//button[contains(text(),'DOUBLE TAP')]"));
		act.doubleClick(doubleClick).perform();
		System.out.println("Step 4: Double-tap successful.");
		Thread.sleep(1000);

		WebElement clickAndHoldE = driver.findElement(By.id("hold-target"));
		act.moveToElement(clickAndHoldE).clickAndHold().pause(Duration.ofSeconds(2)).release().build().perform();
		System.out.println("Step 5: Pressure applied (Click & Hold).");
		Thread.sleep(1000);

		WebElement drag_Source = driver.findElement(By.xpath("//div[contains(text(),'PATIENT ORGAN')]"));
		WebElement drag_DropSource = driver.findElement(By.cssSelector("div[id='drop-target']"));
		act.dragAndDrop(drag_Source, drag_DropSource).perform();

		WebElement seekbar = driver.findElement(By.id("precision-seekbar"));

		act.scrollByAmount(0, 700).build().perform();
		// act.scrollToElement(seekbar).perform();
		Thread.sleep(3000);

		// move to bradycardia
		act.moveToElement(seekbar).moveByOffset(-430, 0).click().build().perform();
		System.out.println("Step 7: Slider moved to Bradycardia.");
		Thread.sleep(2000);
		
		/* without using method chaining
		 * act.moveToElement(seekbar).perform(); act.moveByOffset(-430, 0).perform();
		 * act.click().perform();
		 * System.out.println("Step 7: Slider moved to Bradycardia.");
		 * Thread.sleep(2000);
		 */

		// move to tachycardia
		act.moveToElement(seekbar, 431 , 0).click().build().perform();
		System.out.println("Step 8: Slider moved to Tachycardia.");
		Thread.sleep(2000);

		driver.quit();

	}
}
