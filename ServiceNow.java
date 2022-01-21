package week4.day1.assignment;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNow {
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();

		// Step1: Load ServiceNow application URL
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://dev66585.service-now.com");

		// Maximize
		driver.manage().window().maximize();
		
		//inside frame gsft_main
		//using WebElement
		WebElement frame = driver.findElement(By.id("gsft_main"));
		driver.switchTo().frame(frame);
		//enter username and password
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Temen0s@123");
		//click okay
		driver.findElement(By.id("sysverb_login")).click();
		
		//Search “incident “ Filter Navigator
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("incident");
		
		//click "All"
		//driver.findElement(By.xpath("//span[@id='incident_breadcrumb']/a")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();
		
		
		//Click New button
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("sysverb_new")).click();
		
		//Select a value for Caller and Enter value for short_description
		driver.findElement(By.id("lookup.incident.caller_id")).click();
		//go to next window
		Set<String> windows = driver.getWindowHandles();
		List <String> window = new ArrayList<String>(windows);
		driver.switchTo().window(window.get(1));
		driver.findElement(By.xpath("(//a[@class='glide_ref_item_link'])[1]")).click();
		driver.switchTo().window(window.get(0));
		
		
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("incident.short_description")).sendKeys("Testing Testing");
		
		//Read the incident number and save it a variable
		String inciNumber = driver.findElement(By.id("incident.number")).getAttribute("value");
		
		//Click on Submit button
		Thread.sleep(5000);
		driver.findElement(By.id("sysverb_insert_bottom")).click();
		
		System.out.println("The id is "+ inciNumber);
		//driver.switchTo().defaultContent();
		// Search the same incident number in the next search screen as below
		
		//driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//div[@class='input-group']/input")).sendKeys(inciNumber, Keys.ENTER);
		
		//Verify the incident is created successful and take snapshot of the created incident.
		String frst_result = driver.findElement(By.xpath("(//a[@class='linked formlink'])[1]")).getText();
		if (frst_result.contains(inciNumber))
			System.out.println("Created sucessfully");
		
		//Take ss
		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/img.png");
		FileUtils.copyFile(source, dest);
		
		Thread.sleep(1000);
		driver.close();
		
		
		
	}
	

}