package com.crm.vtiger.contacts.tests;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
public class AddContactsTest {

	public static void main(String[] args) throws InterruptedException {
		

		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		WebElement un= driver.findElement(By.name("user_name"));
		un.sendKeys("admin");
		
		WebElement pw= driver.findElement(By.name("user_password"));
		pw.sendKeys("manager");
		
		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.linkText("Contacts")).click();
		
		WebElement addLeadBtn= driver.findElement(By.cssSelector("img[title='Create Contact...']"));
		addLeadBtn.click();
		
		WebElement NameTitleDD= driver.findElement(By.name("salutationtype"));
		Select sel= new Select(NameTitleDD);
		sel.selectByValue("Mr.");
		
		WebElement firstNameInf=driver.findElement(By.name("firstname"));
		firstNameInf.sendKeys("Sujal");
	    
		WebElement lastNameInf=driver.findElement(By.name("lastname"));
		lastNameInf.sendKeys("Rajput");
		
		
		String parentWindow= driver.getWindowHandle();
		
		driver.findElement(By.cssSelector("img[src='themes/softed/images/select.gif']")).click();
		//handling another pop up window
	   Set<String> allwindows =	driver.getWindowHandles();
	    for (String win : allwindows) {
			if(!win.equals(parentWindow)) {
				driver.switchTo().window(win);
				driver.findElement(By.linkText("vtiger")).click();
			}
		} 
	  //child window handled and now getting back to parent window
	    driver.switchTo().window(parentWindow);
	    
	    
	
		
		driver.findElement(By.cssSelector("input[ value= '  Save  ']")).click();
		
		Thread.sleep(2000);
		
		Actions act= new Actions(driver);
		WebElement orgFnInf = driver.findElement(By.xpath("//span[@id='dtlview_First Name']"));
	    
		String actFnText= orgFnInf.getText();
		String expFnText= "Sujal";
		
		
		// verification section
		boolean fnTextStatus = false,lnTextStatus=false,orgTextStatus=false;
		if(actFnText.equals(expFnText)){
			System.out.println("Firstname verified successfully");
			fnTextStatus= true;
		}
		else{
			System.out.println("FirstName verification failed....");
		}
		
       WebElement orgLnInf = driver.findElement(By.xpath("//span[@id='dtlview_Last Name']"));
	    
		String actLnText= orgLnInf.getText();
		String expLnText= "Rajput";
		
		if(actLnText.equals(expLnText)) {
			System.out.println("Last name verified successfully");
		    lnTextStatus=true;
		}
		else {
			System.out.println("Last name verification failed.....");
		
		}
		
		   WebElement orgName = driver.findElement(By.linkText("vtiger"));
		    
			String actOrgText= orgName.getText();
			String expOrgText= "vtiger";
			
			if(actOrgText.equals(expOrgText)) {
				System.out.println("Company name verified successfully");
			    orgTextStatus=true;
			}
			else {
				System.out.println("Company name verification failed.....");
			
			}
			
	    if(fnTextStatus && lnTextStatus && orgTextStatus) {
	    	    System.out.println("Test Scipt passed with zero failed test cases");
	    }
			
	    else{
	    	System.out.println("Test script passed but some of test cases are failed... ");
	    }
	    
		WebElement profile = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG' ]"));
	    act.moveToElement(profile).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		
		Thread.sleep(3000);
		driver.quit();
				
	}
		
		
		
	}
