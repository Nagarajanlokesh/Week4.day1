package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNow {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		
		
		driver.get("https://dev115136.service-now.com/navpage.do");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		
		driver.switchTo().frame("gsft_main");
		
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Password@2022");
		driver.findElement(By.id("sysverb_login")).click();
		
		
		driver.findElement(By.id("filter")).sendKeys("Incident");
		
		driver.findElement(By.linkText("All")).click();
		
		driver.switchTo().frame("gsft_main");
		
		driver.findElement(By.id("sysverb_new")).click();
		
		driver.findElement(By.xpath("//button[@id='lookup.incident.caller_id']/span")).click();
		
		String windowHandleService = driver.getWindowHandle();
		Set<String> windowHandlesservice = driver.getWindowHandles();
		
		ArrayList<String> arrayListSN = new ArrayList<String>(windowHandlesservice);
		
		String stringSN = arrayListSN.get(1);
		
		driver.switchTo().window(stringSN);
		System.out.println(driver.getTitle());
		
		driver.findElement(By.linkText("Abel Tuter")).click();
		
		
		
		driver.switchTo().window(windowHandleService);
		
		System.out.println(driver.getTitle());
		
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("incident.short_description")).sendKeys("This is just a Testing Assignment created for TestLeaf");
		
		 
		String text = driver.findElement(By.id("incident.number")).getAttribute("value");
		 
		 System.out.println(text);
		
		//driver.findElement(By.xpath("//a[@id='lookup.incident.short_description']/span")).click();
		
		 driver.findElement(By.name("not_important")).click();
		 
		 WebElement findElement = driver.findElement(By.xpath("//input[@class='form-control']"));
		 
		 findElement.sendKeys(text);
		 findElement.sendKeys(Keys.ENTER);
		 
		File FinalScreenshot = driver.getScreenshotAs(OutputType.FILE);
		 
		File filesc = new File("./images/screenshot.png");
		
		FileUtils.copyFile(FinalScreenshot, filesc);
		
		
		
		

	}

}
