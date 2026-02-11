package com.crm.vtiger.leads.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AddLeadTest{
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

		driver.findElement(By.linkText("Leads")).click();
		
		WebElement addLeadBtn= driver.findElement(By.cssSelector("img[title='Create Lead...']"));
		addLeadBtn.click();
		
		WebElement NameTitleDD= driver.findElement(By.name("salutationtype"));
		Select sel= new Select(NameTitleDD);
		sel.selectByValue("Mr.");
		
		WebElement firstNameInf=driver.findElement(By.name("firstname"));
		firstNameInf.sendKeys("Sujal");
	    
		WebElement lastNameInf=driver.findElement(By.name("lastname"));
		lastNameInf.sendKeys("Rajput");
		
		WebElement companyNameInf= driver.findElement(By.name("company"));
		companyNameInf.sendKeys("RDX");
		
		driver.findElement(By.cssSelector("input[ value= '  Save  ']")).click();
		
		Thread.sleep(2000);
		
		Actions act= new Actions(driver);
		WebElement orgFnInf = driver.findElement(By.xpath("//span[@id='dtlview_First Name']"));
	    
		String actFnText= orgFnInf.getText();
		String expFnText= "Sujal";
		
		
		// verification section
		boolean fnTextStatus = false,lnTextStatus=false,cmpTextStatus=false;
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
		
		   WebElement orgCmpInf = driver.findElement(By.xpath("//span[@id='dtlview_Company']"));
		    
			String actCmpText= orgCmpInf.getText();
			String expCmpText= "RDX";
			
			if(actCmpText.equals(expCmpText)) {
				System.out.println("Company name verified successfully");
			    cmpTextStatus=true;
			}
			else {
				System.out.println("Company name verification failed.....");
			
			}
			
	    if(fnTextStatus && lnTextStatus && cmpTextStatus) {
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