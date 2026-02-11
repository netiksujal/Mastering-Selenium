package com.crm.vtiger.services.tests;


import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AddServicesTest {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		WebElement un = driver.findElement(By.name("user_name"));
		un.sendKeys("admin");

		WebElement pw = driver.findElement(By.name("user_password"));
		pw.sendKeys("manager");

		driver.findElement(By.id("submitButton")).click();

		Actions act=new Actions(driver);
		WebElement moreBtn=driver.findElement(By.linkText("More"));
		act.moveToElement(moreBtn).build().perform();
		
		driver.findElement(By.linkText("Services")).click();
        driver.findElement(By.cssSelector("img[title='Create Service...']")).click();
		WebElement ServiceName = driver.findElement(By.name("servicename"));
		ServiceName.sendKeys("Aantakvad");


	   WebElement dateField = driver.findElement(By.name("sales_start_date"));
	   JavascriptExecutor js = (JavascriptExecutor) driver;
	   js.executeScript("arguments[0].removeAttribute('readonly')", dateField);

	   dateField.clear();
	   dateField.sendKeys("2024-01-12");
		driver.findElement(By.cssSelector("input[ value= '  Save  ']")).click();

		Thread.sleep(2000);

	
		WebElement orgServName = driver.findElement(By.xpath("//span[@id='dtlview_Service Name']"));

		String actServText = orgServName.getText();
		String expServText = "Aantakvad";

		// verification section
		boolean actServTextStatus = false, orgSalesSdStatus= false;
		if (actServText.equals(expServText)) {
			System.out.println("Service name verified successfully");
			actServTextStatus = true;
		} else {
			System.out.println("Service name verification failed....");
		}


		WebElement orgSalesSd = driver.findElement(By.id("dtlview_Sales Start Date"));

		String actSalesSd = orgSalesSd.getText();
		String expSalesSd = "2024-01-12";

		if (actSalesSd.trim().equals(expSalesSd.trim())) {
			System.out.println("Sales start date verified successfully");
			orgSalesSdStatus = true;
		} else {
			System.out.println("Sales start date verification failed.....");

		}

		if (actServTextStatus && orgSalesSdStatus ) {
			System.out.println("Test Scipt passed");
		}

		else {
			System.out.println("Test script failed... ");
		}

		WebElement profile = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG' ]"));
		act.moveToElement(profile).perform();
		driver.findElement(By.linkText("Sign Out")).click();

		Thread.sleep(3000);
		driver.quit();

	}

}
