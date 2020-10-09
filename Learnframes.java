package week4.assignments;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Learnframes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/frame.html");
		driver.switchTo().frame(0);
		WebElement frame1 = driver.findElementById("Click");
				frame1.click();
		String text = frame1.getText();
		System.out.println(text);
		driver.switchTo().defaultContent();
//Nested frame
		  driver.switchTo().frame(1); 
		  driver.switchTo().frame("frame2");
		  WebElement Nestedframe = driver.findElementByXPath("//button[@id='Click1']");
		  Nestedframe.click();
			 String text2 = Nestedframe.getText();
			 System.out.println(text2);
			 driver.switchTo().defaultContent();
			 //total num of frames
				driver.get("http://www.leafground.com/pages/frame.html");
			      List<WebElement> f = driver.findElementsByTagName("iframe");
			      System.out.println("Total number " + f.size());



	}

}
