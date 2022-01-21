package week4.day1.assignment;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class MergeContact {
	
public static void main(String[] args) throws InterruptedException {
		
		 
		//   1. Launch URL "http://leaftaps.com/opentaps/control/login"
	   	
			ChromeDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("http://leaftaps.com/opentaps/control/login");
		   
		//   2. Enter UserName and Password Using Id Locator
			driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
			driver.findElement(By.id("password")).sendKeys("crmsfa");
			
			
		   
		//   3. Click on Login Button using Class Locator
		   driver.findElement(By.className("decorativeSubmit")).click();
		   
		//   4. Click on CRM/SFA Link
		   driver.findElement(By.linkText("CRM/SFA")).click();
			
		   
		//   5. Click on contacts Button
		   driver.findElement(By.linkText("Contacts")).click();
			   	
		//   6. Click on Merge Contacts using Xpath Locator
		   driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		   
		//   7. Click on Widget of From Contact
		   driver.findElement(By.xpath("//table[@name='ComboBox_partyIdFrom']/following-sibling::a")).click();
		   
		 //opens a new frame
		   Set<String> windowHandles = driver.getWindowHandles();
		   List<String> window = new LinkedList<String>(windowHandles);
		   
		   //will switch the control to new window
		   driver.switchTo().window(window.get(1));
		   
		 //  8. Click on First Resulting Contact
		   Thread.sleep(3000);
		   driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
		   
		  // 9. Click on Widget of To Contact
		   driver.switchTo().window(window.get(0));
		   driver.findElement(By.xpath("//table[@name='ComboBox_partyIdTo']/following-sibling::a")).click();
		   
		  // 10. Click on Second Resulting Contact
		   Thread.sleep(1000);
		   Set<String> windowHandles2 = driver.getWindowHandles();
		   List<String> window2 = new LinkedList<String>(windowHandles2);
		   driver.switchTo().window(window2.get(1));
		   
		   Thread.sleep(3000);
		   driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]")).click();
		   
		 //   11. Click on Merge button using Xpath Locator
		   Thread.sleep(1000);
		   driver.switchTo().window(window2.get(0));
		   driver.findElement(By.className("buttonDangerous")).click();
		   
		 //  12. Accept the Alert
		   driver.switchTo().alert().accept();
		   
		  // 13. Verify the title of the page
		  String MainTitle = driver.getTitle();
		  if(MainTitle.contains("View Contact"))
			  System.out.println("Title verified"+  MainTitle);
		  else
			  System.out.println("Not matched witht Title" + MainTitle);
		  
		  driver.quit();
		  
	}

}
