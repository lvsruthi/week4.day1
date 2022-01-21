package week4.day1.assignment;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class Frames_Screenshot {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/frame.html");
		
		//to take SS of 1st frame
		//go inside frame1 and take SS
		driver.switchTo().frame(0);
		WebElement clickme = driver.findElement(By.id("Click"));
		//Take the the screenshot of the click me button of first frame
		File source = clickme .getScreenshotAs(OutputType.FILE);
		File des = new File("./screenshot/image.png");
		FileUtils.copyFile(source, des);
		
		/*2.Find the number of frames
		  - find the Elements by tagname - iframe
		  - Store it in a list
		  - Get the size of the list. (This gives the count of the frames visible to the main page)
	   */
		
		driver.switchTo().parentFrame();
		List <WebElement> noofFrame = driver.findElements(By.tagName("iframe"));
		int count = noofFrame.size();
		System.out.println("Total no of frames is"+ count);
		
		
		//additional
		//go inside nested frame
		driver.switchTo().frame(1);
		driver.switchTo().frame("frame2");
		driver.findElement(By.id("Click1")).click();
		
		driver.switchTo().defaultContent();
		
		Thread.sleep(3000);
		
		driver.close();
		
		
		
		
		
		
		
		
		
		
		

	}

}
