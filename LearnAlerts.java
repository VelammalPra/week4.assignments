package week4.assignments;

import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnAlerts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/Alert.html");
		//Simple Alert
driver.findElementByXPath("//button[text() = 'Alert Box']").click();
Alert alert = driver.switchTo().alert();//switch the control from main window to alert
//to click ok in alert
Thread.sleep(2000);

//to read the alert
String text = alert.getText();

System.out.println(text);
alert.accept();
//confirm alert
driver.findElementByXPath("//button[text() = 'Confirm Box']").click();
Alert alert1 = driver.switchTo().alert();//switch the control from main window to alert
Thread.sleep(2000);
alert.dismiss();

//Prompt Alert
driver.findElementByXPath("//button[text() = 'Prompt Box']").click();
Alert alert2 = driver.switchTo().alert();//switch the control from main window to alert
alert2.sendKeys("Testleaf");
Thread.sleep(2000);
alert2.accept();

//Line breaks in an alert
driver.findElementByXPath("//button[text()='Line Breaks?']").click();
Alert alert3 = driver.switchTo().alert();//switch the control from main window to alert
String text1 = alert.getText();
System.out.println(text1);
alert3.accept();

//Sweet Alert
driver.findElementByXPath("//button[text()='Sweet Alert']").click();
driver.findElementByXPath("//button[@class='swal-button swal-button--confirm']").click();


	}

}
