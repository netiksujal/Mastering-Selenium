package WorkingWithDropdown;

import java.util.List;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiValueSelect_DD {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(
				"C:/Users/This%20pc/eclipse-workspace/maven-demo-project/src/test/java/WorkingWithDropdown/dropdown.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		WebElement dayDD = driver.findElement(By.cssSelector("select[name='birthday_day']"));
		Select daySelect = new Select(dayDD);
		daySelect.selectByIndex(1);
		Thread.sleep(3000);

		WebElement monthDD = driver.findElement(By.xpath("//select[@aria-label='Month' and @name='birthday_month']"));
		Select monthSelect = new Select(monthDD);
		monthSelect.selectByValue("3");
		Thread.sleep(3000);

		WebElement yearDD = driver.findElement(By.xpath("//select[contains(@name,'birthday_year')]"));
		Select yearSelect = new Select(yearDD);
		yearSelect.selectByVisibleText("Immortal");
		Thread.sleep(3000);

		WebElement hobbiesDD = driver.findElement(By.xpath("//select[contains(@name,'hobbies')]"));

		Select hobbiesSelect = new Select(hobbiesDD);

		List<WebElement> hobbiesOptions = hobbiesSelect.getOptions();
		for (WebElement option : hobbiesOptions) {
			System.out.println(option.getText());
		}

		hobbiesSelect.selectByVisibleText("Atankvaad Failana");
		hobbiesSelect.selectByVisibleText("Shayari Likhna");
		hobbiesSelect.selectByVisibleText("Bomb Banana");
		Thread.sleep(3000);

		hobbiesSelect.deselectByIndex(0);
		hobbiesSelect.deselectByIndex(1);
		hobbiesSelect.deselectByIndex(2);
		Thread.sleep(3000);

		driver.quit();

	}

}
