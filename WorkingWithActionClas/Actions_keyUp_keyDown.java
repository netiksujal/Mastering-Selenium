package WorkingWithActionClas;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Actions_keyUp_keyDown {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("https://www.facebook.com");
		Actions act = new Actions(driver);
		Thread.sleep(3000);

		/*
		 * //To enter user and password without using webElement
		 * act.sendKeys("sujal234@gmail.com").pause(Duration.ofSeconds(1))
		 * .sendKeys(Keys.TAB).sendKeys("343242")
		 * .pause(Duration.ofSeconds(1)).sendKeys(Keys.ENTER).build().perform();
		 */

		// act.sendKeys("admin@123" + Keys.TAB + "123456789" +
		// Keys.ENTER).build().perform();

		// enter username
		act.sendKeys("sujal234@gmail.com").build().perform();

		// pressing control + A to select all text written in username text field
		act.keyDown(Keys.CONTROL).perform();
		act.sendKeys("a").build().perform();
		act.keyUp(Keys.CONTROL).perform();

		// Control c
		act.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();

		// Control v
		act.sendKeys(Keys.TAB).keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();

//		click on enter
		act.sendKeys(Keys.ENTER).build().perform();

		Thread.sleep(3000);
		driver.quit();

	}

}
