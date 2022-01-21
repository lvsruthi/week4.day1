package week4.day1.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class FramesAss3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		
		//1st frame
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//b[@id='topic']/following::input")).sendKeys("TEST");
		//nested frame 2nd
		driver.switchTo().frame("frame3");
		driver.findElement(By.xpath("//b[text()='Inner Frame Check box :']/following::input")).click();
		//come out of all frames
		driver.switchTo().defaultContent();
		
		//go to 3rd frame
		driver.switchTo().frame("frame2");
		WebElement dropdown = driver.findElement(By.id("animals"));
		Select s = new Select(dropdown);
		s.selectByIndex(1);
		
		Thread.sleep(5000);
		driver.close();
		
		

	}

}
