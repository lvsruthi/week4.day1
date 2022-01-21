package week4.day1.assignment;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class Windows {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/Window.html");
		
		
		//frst page title
		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("//button[text()='Open Home Page']")).click();
		
		//new window is opened and switched to 2nd window print its title
		Set<String> windows= driver.getWindowHandles();
		List<String> window_list = new ArrayList<String>(windows);
		driver.switchTo().window(window_list.get(1));
		System.out.println(driver.getTitle());
		
		//back to main window
		driver.switchTo().window(window_list.get(0));
		
		//click on Open Mutiple window tab and find the total no of windows displaced
		//it will be 3 in total
		driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
		Set<String> windows2= driver.getWindowHandles();
		List<String> window_list2 = new ArrayList<String>(windows2);
		int Total_Size = window_list2.size();
		System.out.println("The total no of windows opened is " + Total_Size);
		
		
		//close all except main windows
		driver.findElement(By.xpath("//button[text()='Do not close me ']")).click();
		Set<String> window3= driver.getWindowHandles();
		List<String> window_list3 = new ArrayList<String>(window3);
		int Size = window_list3.size();
		//closing all windows other than main window
		for(int i=1; i<Size; i++)
		{
			driver.switchTo().window(window_list3.get(i));
			driver.close();
			
		}
		
		//getting the count after closing all windows
		Set<String> windowclose= driver.getWindowHandles();
		List<String> window_listclose = new ArrayList<String>(windowclose);
		int Size_close = window_listclose.size();
		System.out.println("The total no of windows opened after DonotClose is " + Size_close);
		
		driver.switchTo().window(window_listclose.get(0));
		//Wait for 5 seconds
		driver.findElement(By.xpath("//button[text()='Wait for 5 seconds']")).click();
		Thread.sleep(5000);
		Set<String> window4= driver.getWindowHandles();
		List<String> window_list4 = new ArrayList<String>(window4);
		int Size1 = window_list4.size();
		System.out.println("The total no of windows opened after MultipleWindows is " + Size1);
		
		driver.quit();
		
		
		
		
		
		
		

	}

}
