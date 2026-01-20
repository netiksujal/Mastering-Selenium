package Sel_Practice;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Syncronizarion_ExplicitWait {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
        WebDriver driver=new ChromeDriver(); //first line of code 
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // will wait till element is not present
        
        driver.get("https://automationwithpiyush.vercel.app/synchronization.html");
       /// Navigates to the synchronization lap page using fully qualified path
        
        WebElement enableBox1_Button=driver.findElement(By.xpath("//button[@onclick='enableInput(1, 5000)']"));
        		enableBox1_Button.click();
        // used to find or locate the web element like enable box 1
        
         WebElement textBox1=driver.findElement(By.xpath("//input[@id='target-1']"));
          
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(textBox1));
        if(textBox1.isEnabled()) {
        	textBox1.sendKeys("LoveYouPiyushSir, mast knowledge dete ho aap");
        }
        
        else{
        	System.out.println("😭😭 cryyyyy, sir enable ni hopaya textbox1");
        }
        
        Thread.sleep(2000);
       driver.quit();	
	}

}
