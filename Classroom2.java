package week4.day1.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class Classroom2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		/* ClassRoom2:
			1. Navigate to https://www.irctc.co.in/nget/train-search
			2. Close Sweet Alert
			3. Click on Flights
			4. Navigate to new window and print its title
			5. Close the Parent Window */
		
		ChromeDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--start-maximized");
		options.addArguments("----start-in-incognito");
		
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		
		driver.get("https://www.irctc.co.in/nget/train-search");
		
		Thread.sleep(2000);
		//close the pop up
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		String First_Title = driver.getTitle();
		System.out.println("First window title"+ First_Title );
		
		//click on flights
		driver.findElement(By.xpath("//a[text()=' FLIGHTS ']")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		List<String> window = new ArrayList<String>(windowHandles);
		
		//switch to 2nd window
		driver.switchTo().window(window.get(1));
		
		String Second_Title = driver.getTitle();
		System.out.println("Second window title"+ Second_Title );
		
		driver.switchTo().window(window.get(0));
		driver.close();
		
		Thread.sleep(1000);
		driver.quit();
		
		
		

	}

}
