package week4.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		
		driver.switchTo().frame("frame1");
		
		WebElement frames1 = driver.findElement(By.xpath("//b[@id='topic']/following-sibling::input"));
		frames1.sendKeys("Selenium");
		
		driver.switchTo().frame("frame3");
		
		driver.findElement(By.id("a")).click();
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("frame2");
		
		WebElement dropdowmFrames = driver.findElement(By.id("animals"));
		
		Select dpframes = new Select(dropdowmFrames);
		
		dpframes.selectByIndex(2);
		

	}

}
