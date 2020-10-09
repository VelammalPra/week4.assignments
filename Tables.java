package week4.assignments;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;


public class Tables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/table.html");
	    //Getting column count

List<WebElement> columns = driver.findElementsByXPath("//table[@id='table_id']//tr/th");
System.out.println("No of columns:"+columns.size());

//Getting row count
List<WebElement> row = driver.findElementsByXPath("//table[@id='table_id']//tr");
System.out.println("No of rows:"+row.size());

//getting progress value
String text = driver.findElementByXPath("//table[@id='table_id']/tbody[1]/tr[3]/td[2]").getText();
System.out.println(text);
//Check the least completed progress check	
//declaring empty array
	ArrayList<Integer> newval = new ArrayList<Integer>();
	for (int i = 2; i <= 5; i++) {
String leastvalue = driver.findElementByXPath("//table[@id='table_id']//tr["+i+"]/td[2]").getText();
String newleastvalue = leastvalue.replaceAll("%", "");//removing special chars

int least = Integer.parseInt(newleastvalue);//converting string to int
newval.add(least);		  //add to array
	}
	  Collections.sort(newval); //sorting array
	  System.out.println("Smallest:"+newval.get(0));
	  driver.findElementByXPath("//td[text()='"+newval.get(0)+"%']/parent::tr//td[3]/input[1]").click();


}
}
