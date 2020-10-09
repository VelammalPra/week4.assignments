package week4.assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnWindows {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/Window.html");
		//Clicking home page
		driver.findElementByXPath("//button[@id='home']").click();

		//Find the number of opened windows
driver.findElementByXPath("//button[text()='Open Multiple Windows']").click();
Set<String> winhandles=driver.getWindowHandles();
List<String> noOfWindowsList = new ArrayList<String>(winhandles);

System.out.println("Number of open windows:"+noOfWindowsList.size());
Thread.sleep(2000);

//Do not close me
for (int i = 1; i < noOfWindowsList.size(); i++) {
	
	driver.switchTo().window(noOfWindowsList.get(i));
	driver.close();
}

//wait for 5 seconds
driver.switchTo().window(noOfWindowsList.get(0));

driver.findElementByXPath("//button[text()='Wait for 5 seconds']").click();
Thread.sleep(5000);
driver.quit();

	}

}
