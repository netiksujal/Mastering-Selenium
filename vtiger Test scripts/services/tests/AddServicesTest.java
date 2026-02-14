package com.crm.vtiger.services.tests;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class AddServicesTest {

	public static void main(String[] args) throws InterruptedException, IOException {
		
	FileInputStream fis= new FileInputStream("./src/test/resources/CommonData.properties");
		
		
		Properties pobj= new Properties();
		pobj.load(fis);
		
        String BROWSER= pobj.getProperty("bro");
		String URL =pobj.getProperty("url");	
		String UserName =pobj.getProperty("un");	
		String Password =pobj.getProperty("pwd");	
		
		FileInputStream fis2 = new FileInputStream("./src/test/resources/testScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis2);
		Cell cell = wb.getSheet("org").getRow(7).getCell(0);
		double ran= Math.random()*999;
		int random=(int)ran;
		
		String serviceName = cell.getStringCellValue();
		
		WebDriver driver = null;
//		String browser = "chrome"; // hardcoded browser

		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//		Login with valid credentials	
//		driver.get("http://localhost:8888/");  // hardcoded
		driver.get(URL);					      // DDT
		
		WebElement un = driver.findElement(By.name("user_name"));
		un.sendKeys(UserName);

		WebElement pw = driver.findElement(By.name("user_password"));
		pw.sendKeys(Password);

		driver.findElement(By.id("submitButton")).click();

		Actions act=new Actions(driver);
		WebElement moreBtn=driver.findElement(By.linkText("More"));
		act.moveToElement(moreBtn).build().perform();
		
		driver.findElement(By.linkText("Services")).click();
        driver.findElement(By.cssSelector("img[title='Create Service...']")).click();
		WebElement ServiceName = driver.findElement(By.name("servicename"));
		 String NserviceName=serviceName+random;
		ServiceName.sendKeys(NserviceName);
       

	   WebElement dateField = driver.findElement(By.name("sales_start_date"));
	   JavascriptExecutor js = (JavascriptExecutor) driver;
	   js.executeScript("arguments[0].removeAttribute('readonly')", dateField);

	   dateField.clear();
	   dateField.sendKeys("2024-01-12");
		driver.findElement(By.cssSelector("input[ value= '  Save  ']")).click();

		Thread.sleep(2000);

	
		WebElement orgServName = driver.findElement(By.xpath("//span[@id='dtlview_Service Name']"));

		String actServText = orgServName.getText();
		
		String expServText = NserviceName;

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
