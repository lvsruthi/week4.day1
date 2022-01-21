package week4.day1.assignment;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class Alerts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/Alert.html");
		
		//click simple Alert Box
		driver.findElement(By.xpath("//button[text()='Alert Box']")).click();
		
		//switch to alert and accept
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		
		//click on confirmation alert
		driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();
	    Alert a = driver.switchTo().alert();
	    Thread.sleep(1000);
	    String confirmation_alert = a.getText();
	    System.out.println(confirmation_alert);
	    a.dismiss();
	    String text = driver.findElement(By.xpath("//p[@id='result']")).getText();
	    System.out.println(text);
	    if(text.contains("Cancel"))
	    	System.out.println("Confirmation text is displayed +" + text);
	    else
	    	System.out.println("Confirmation Text is not displayed + " + text);
	    
	   
	    //click on prompt box
	    driver.findElement(By.xpath("//button[text()='Prompt Box']")).click();
	    Alert prompt = driver.switchTo().alert();
		//send keys
	    Thread.sleep(1000);
	    prompt.sendKeys("TestLeaf");
	    prompt.accept();
	    String text1 = driver.findElement(By.xpath("//p[@id='result1']")).getText();
	    if(text1.contains("TestLeaf"))
	    	System.out.println("Prompt text is displayed with TestLeaf");
	    else
	    	System.out.println("Prompt Text is not displayed");
	    
	    
	    //click on Line box
	    driver.findElement(By.xpath("//button[text()='Line Breaks?']")).click();
	    Alert line = driver.switchTo().alert();
		//send keys
	    String text3 = line.getText();
	    prompt.accept();
	    System.out.println("Line text is "+ text3);
	    
	    
	    //click on sweet alert
	    driver.findElement(By.xpath("//button[text()='Sweet Alert']")).click();
	    String text4 = driver.findElement(By.xpath("//div[@class='swal-text']")).getText();
	    System.out.println("Sweet alert text is "+ text4);
	    driver.findElement(By.xpath("//button[text()='OK']")).click();
	  //button[text()='OK']
	   
	    driver.close();
	    

	}

}
