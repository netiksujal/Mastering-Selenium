package Working_With_Popup;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Download_Upload_FIle_HDP {

	public static void main(String[] args) throws InterruptedException {
	

		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://automationwithpiyush.vercel.app/popups.html");
		Thread.sleep(3000);
		
		Alert ale= driver.switchTo().alert();	
        ale.sendKeys("sujal");
        ale.accept();
        Thread.sleep(2000);
        
        WebElement hidden_div_popup=driver.findElement(By.xpath("//button[@onclick='openModal()']"));
        hidden_div_popup.click();
        Thread.sleep(3000);

       driver.findElement(By.xpath("//button[@onclick='closeModal()']")).click();
		
		WebElement fileDwBtn= driver.findElement(By.xpath("//button[@onclick='triggerDownload()']"));
		fileDwBtn.click();
		Thread.sleep(2000);

		
		WebElement fileUdBtn=driver.findElement(By.id("fileUpload"));
		fileUdBtn.sendKeys("D:\\automation_report.txt");
		
		Thread.sleep(3000);
		
		
	     driver.quit();
		
		
		
	}

}
