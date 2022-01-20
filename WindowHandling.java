package week4.day1;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://www.leafground.com/pages/Window.html");
		
		driver.findElement(By.id("home")).click();
		
		// WindowHandle will give specific reference of main window 
		
		String windowHandle = driver.getWindowHandle();
		
		System.out.println(windowHandle);
		
		// WindowHandles will give specfic reference of all windows and tabs 
		// Return type is Set so saving in set 
		// Set will not have duplicate so we use set 
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		// Set will not allow the get function
		//So we are converting the Set to list by creating object to list and passing the set in constructor 
		
		ArrayList<String> Wind = new ArrayList<String>(windowHandles);
		
		// By using get function we identify the window
		// get(0) - 0 index refers to parent window 
		// get(1) - 1 index refers to child window 
		
		String ChildWindow = Wind.get(1);
		System.out.println(ChildWindow);
		
		
		// Here by using Window() function we pass the ChildWindow
		driver.switchTo().window(ChildWindow
				);
		
		String childWindowTitle = driver.getTitle();
		
		System.out.println(childWindowTitle);
		
		// This will close only the child window 
		driver.close();
		// To return back to main window 
		driver.switchTo().window(windowHandle);
		
		//  Multiple windows 
		
		driver.findElement(By.xpath("//button[contains(text(),'Multiple Windows')]")).click();
		
		Set<String> windowHandles2 = driver.getWindowHandles();
		
		// Foreach loop will show how many reference available 
		
		for (String Checkwindow : windowHandles2) {
			
			System.out.println(Checkwindow);
			
		}
		
		
		// Again coverting set tolist
		
		ArrayList<String> multiWind = new ArrayList<String>(windowHandles2);
	
		String multiplewindow1 = multiWind.get(1);
		String multiplewindow2 = multiWind.get(2);
		
		driver.switchTo().window(multiplewindow1);
		
		String multi = driver.getTitle();
		
		System.out.println(multi);
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("(//a[contains(text(),'Go to Home Page')])[1]")).click();
		
		driver.close();
		
		driver.switchTo().window(multiplewindow2);
		
		String Windtitle2 = driver.getTitle();
		System.out.println(Windtitle2);
		
		driver.findElement(By.id("home")).click();
		
		driver.close();
		
		driver.switchTo().window(windowHandle);
		
		driver.findElement(By.id("color")).click();
		
		Thread.sleep(3000);

		
		driver.quit();
		
	}

}
