package com.crm.vtiger.opportunities.tests;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AddOpportunitiesTest {

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

		driver.findElement(By.linkText("Opportunities")).click();

		WebElement addLeadBtn = driver.findElement(By.cssSelector("img[title='Create Opportunity...']"));
		addLeadBtn.click();

		WebElement oppName = driver.findElement(By.name("potentialname"));
		oppName.sendKeys("Aantakvadii");

		String parentWindow = driver.getWindowHandle();

		driver.findElement(By.cssSelector("img[src='themes/softed/images/select.gif']")).click();
		// handling another pop up window
		Set<String> allwindows = driver.getWindowHandles();
		for (String win : allwindows) {
			if (!win.equals(parentWindow)) {
				driver.switchTo().window(win);
				driver.findElement(By.linkText("vtiger")).click();
			}
		}
		// child window handled and now getting back to parent window
		driver.switchTo().window(parentWindow);

		driver.findElement(By.cssSelector("input[ value= '  Save  ']")).click();

		Thread.sleep(2000);

		Actions act = new Actions(driver);
		WebElement orgOppName = driver.findElement(By.xpath("//span[@id='dtlview_Opportunity Name']"));

		String actOppText = orgOppName.getText();
		String expOppText = "Aantakvadii";

		// verification section
		boolean actOrgTextStatus = false, orgRelToStatus = false;
		if (actOppText.equals(expOppText)) {
			System.out.println("Opportunity name verified successfully");
			actOrgTextStatus = true;
		} else {
			System.out.println("Opportunity name verification failed....");
		}


		WebElement orgName = driver.findElement(By.linkText("vtiger"));

		String actRelToText = orgName.getText();
		String expRelToText = "vtiger";

		if (actRelToText.equals(expRelToText)) {
			System.out.println("Related to organization verified successfully");
			orgRelToStatus = true;
		} else {
			System.out.println("Related to organiztaion verification failed.....");

		}

		if (actOrgTextStatus && orgRelToStatus) {
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
