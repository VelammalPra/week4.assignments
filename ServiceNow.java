//Step1: Load ServiceNow application https://dev68594.service-now.com/
//Step2: Enter username as “admin”
//Step3: Enter password as “India@123”
//Step4: Click Login
//Step5: Search “incident “ Filter Navigator
//Step6: Click “All”
//Step7: Click New button
//Step8: Select a value for Caller and Enter value for short_description
//Step9: Read the incident number and save it a variable
//Click 
//Step10: Click on Submit button
//Step 11: Search the same incident number in the next search screen as below
//Step12: Verify the incident is created successful

package week4.assignments;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNow {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://dev68594.service-now.com/");
		driver.switchTo().frame(0);
		driver.findElementByXPath("//input[@id='user_name']").sendKeys("admin");
		driver.findElementByXPath("//input[@id='user_password']").sendKeys("India@123");
		driver.findElementByXPath("//button[@type='submit']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//input[@id='filter']").sendKeys("Incident");
		Thread.sleep(5000);
		driver.findElementByXPath("(//div[text()='All'])[2]").click();
		driver.switchTo().frame("gsft_main");
		driver.findElementByXPath("//button[@class='selected_action action_context btn btn-primary']").click();
		driver.findElementByXPath("//input[@id='sys_display.incident.caller_id']").sendKeys("Abel Tuter");
		driver.findElementByXPath("//input[@id='incident.short_description']").sendKeys("test");
		 String incidentnumber = driver.findElementById("incident.number").getAttribute("value");
			System.out.println(incidentnumber);
			Thread.sleep(2000);
driver.findElementByXPath("//button[@class='form_action_button header  action_context btn btn-default']").click();
Thread.sleep(2000);
//Search Incident num
driver.findElementByXPath("//input[@class='form-control']").click();
driver.findElementByXPath("//input[@class='form-control']").sendKeys(Keys.ENTER);
Thread.sleep(2000);
driver.findElementByXPath("//input[@placeholder='Search']").sendKeys(incidentnumber);
driver.findElementByXPath("//input[@placeholder='Search']").sendKeys(Keys.ENTER);
WebElement search = driver.findElementByXPath("//a[@class='linked formlink']");
String result = search.getText();
System.out.println("Sear value is:"+search);

if(result
		.equalsIgnoreCase(incidentnumber)) 
{
System.out.println("Successfully added");

}
else {
System.out.println("Not created");
}

driver.close();
}



		
	}


