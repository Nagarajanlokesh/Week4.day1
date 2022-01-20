package week4.day1;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestLeafFramesAssignment {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leafground.com/pages/frame.html");
		
		driver.switchTo().frame(0);
		
		driver.findElement(By.id("Click")).click();
		
		//Screenshot 
		
		File TempScreenshot = driver.getScreenshotAs(OutputType.FILE);
		File file = new File("./images/framesscreenshot.png");
		
		FileUtils.copyFileToDirectory(TempScreenshot, file);
		
		driver.switchTo().defaultContent();
		
		Thread.sleep(2000);
		
		 List<WebElement> elements = driver.findElements(By.tagName("iframe"));
		 
		 int sizeofframes = elements.size();
		 System.out.println("The size is"+sizeofframes);
		
		

	}

}
