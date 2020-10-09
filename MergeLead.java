//Steps:
//	MergeLead: Application : http://leaftaps.com/opentaps/control/main
//		==========
//		1. Launch the browser
//		2. Enter the username
//		3. Enter the password
//		4. Click Login
//		5. Click crm/sfa link
//		6. Click Leads link
//		7. Click Merge leads
//		8. Click on Icon near From Lead
//		9. Move to new window
//		10. Enter Lead ID
//		11. Click Find Leads button
//		12. Click First Resulting lead
//		13. Switch back to primary window
//		14. Click on Icon near To Lead
//		15. Move to new window
//		16. Enter Lead ID
//		17. Click Find Leads button
//		18. Click First Resulting lead
//		19. Switch back to primary window
//		20. Click Merge
//		21. Accept Alert
//		22. Click Find Leads link
//		23. Enter From Lead ID
//		24. Click Find Leads button
//		25. Verify message "No records to display" in the Lead List. This message confirms that the successful merge of leads
//		26. Close the browser (Do not log out)




package week4.assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.findElementById("username").sendKeys("demosalesmanager");
		driver.findElementByName("PASSWORD").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Leads").click();
		driver.findElementByXPath("//a[text()='Merge Leads']").click();
		driver.findElementByXPath("//img[@alt='Lookup']").click();
		//From lead lookup new window
		Set<String> setofHandles = driver.getWindowHandles();
		List<String>listofHandles = new ArrayList<String>(setofHandles);
		String secondWinRef = listofHandles.get(1);
		driver.switchTo().window(secondWinRef);
		driver.manage().window().maximize();
		driver.findElementByName("id").sendKeys("10029");
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//a[@class='linktext']").click();
		Thread.sleep(1000);
		//Switching to primary window
		String firstWinRef = listofHandles.get(0);
		driver.switchTo().window(firstWinRef);
		//To lead lookup new window
		driver.findElementByXPath("(//img[@alt='Lookup'])[2]").click();
		Set<String> setofHandles1 = driver.getWindowHandles();

		List<String>listofHandles1 = new ArrayList<String>(setofHandles1);
String ThirdWinRef = listofHandles1.get(1);
driver.switchTo().window(ThirdWinRef);
		driver.manage().window().maximize();
		driver.findElementByName("id").sendKeys("10030");
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//a[@class='linktext']").click();
		//Switching back to primary window
		driver.switchTo().window(firstWinRef);
		driver.findElementByXPath("//a[@class='buttonDangerous']").click();
		Alert alert = driver.switchTo().alert();//switch the control from main window to alert
		Thread.sleep(2000);
		alert.accept();
		driver.findElementByXPath("//a[text()='Find Leads']").click();
		driver.findElementByName("id").sendKeys("10029");
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(1000);
		WebElement element1 = driver.findElementByXPath("//div[text()='No records to display']");
		String leadlist = element1.getText();
		System.out.println("Text is" +leadlist);
		driver.close();


	}

}
