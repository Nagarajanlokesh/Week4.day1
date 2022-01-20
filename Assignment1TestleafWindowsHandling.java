package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1TestleafWindowsHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub4
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//1. Launch URL "http://leaftaps.com/opentaps/control/login"
		
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
		 //2. Enter UserName and Password Using Id Locator
		 
		 WebElement uName = driver.findElement(By.xpath("//input[@id = 'username']"));
		 
		 uName.sendKeys("DemoSalesManager");
		 
		 driver.findElement(By.xpath("//input[@name = 'PASSWORD']")).sendKeys("crmsfa");
		 
		 // 3. Click on Login Button using Class Locator
		 
        driver.findElement(By.xpath("//input[contains(@class, 'decorative')]")).click();
        
        //4. Click on CRM/SFA Link
		 
		 driver.findElement(By.xpath("//a[contains(text(),'CRM')]")).click();
		 
		 // 5. Click on contacts Button

		 
		 driver.findElement(By.linkText("Contacts")).click();
		 
		 //6. Click on Merge Contacts using Xpath Locator
		 driver.findElement(By.linkText("Merge Contacts")).click();
		 
		 //7. Click on Widget of From Contact
		 
		 driver.findElement(By.xpath("//table[@id='widget_ComboBox_partyIdFrom']/following-sibling::a")).click();
		 
		//8. Click on First Resulting Contact
		 
		 String testlead = driver.getWindowHandle();
		 Set<String> testleads1 = driver.getWindowHandles();
		 for (String testleads12 : testleads1) {
			 System.out.println(testleads12);
			
		}
		 
		 ArrayList<String> list1 = new ArrayList<String>(testleads1);
		 String convert1 = list1.get(1);
		 driver.switchTo().window(convert1);
		 System.out.println(driver.getTitle());
		 
		 driver.findElement(By.className("linktext")).click();
		 
		 driver.switchTo().window(testlead);
		 
		 //9. Click on Widget of To Contact
		 
		 //Elder to younger sibling 
		 driver.findElement(By.xpath("//table[@id='widget_ComboBox_partyIdTo']/following-sibling::a")).click();
		 
		 //10. Click on Second Resulting Contact
		 
		 Set<String> testleads2 = driver.getWindowHandles();
		 for (String testleads23 : testleads2) {
			 System.out.println(testleads23);
			
		}
		 
		 ArrayList<String> list2 = new ArrayList<String>(testleads2);
		 String convert2 = list2.get(1);
		 driver.switchTo().window(convert2);
		 System.out.println(driver.getTitle());
		 
		 driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]")).click();
		 driver.switchTo().window(testlead);
		 
		 //11. Click on Merge button using Xpath Locator
		 
		 driver.findElement(By.xpath("//a[text()='Merge']")).click();
		 
		 //12. Accept the Alert
		 
		 driver.switchTo().alert().accept();
		 
		 //13. Verify the title of the page
		 
		System.out.println(driver.getTitle()); 
		 
		 
		 
		 
		 
		
		 
		 
		 
		 
		 
		 

	}

}
