package week4.day1.assignment;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class Classroom1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		/*
		 * ClassRoom1:
1. Navigate to https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt
2. Click on Try it button
3. Enter your name in Alert field
4. Accept the alert
5. Verify your name is displayed correctly
		 */

		ChromeDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().fullscreen();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
		
		//inside frame
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		//inside alert
		Alert a = driver.switchTo().alert();
		a.sendKeys("sruthi");
		Thread.sleep(1000);
		a.accept();
		
		//check if value is visible
		String prompt_text = driver.findElement(By.id("demo")).getText();
		if(prompt_text.contains("sruthi"))
			System.out.println(prompt_text + " Sruthi is present and Alert works fine");
		else
			System.out.println("Alert is not working properly");
		
	
		
	}

}
