/**
* @author PamelaDey
*/
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class Assignment2 {
	//static WebDriver driver = new ChromeDriver ();// By System Manager jar

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver ();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		driver.findElement(By.name("name")).sendKeys("Pamela Dey");
		System.out.println("Name : "+driver.findElement(By.name("name")).getAttribute("value"));
		driver.findElement(By.name("email")).sendKeys("pameladey123@gmail.com");
		System.out.println("Email id : "+driver.findElement(By.name("email")).getAttribute("value"));
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("123@abc");
		driver.findElement(By.id("exampleCheck1")).click();
		System.out.println(driver.findElement(By.id("exampleCheck1")).isEnabled());
		
		WebElement Gender = driver.findElement(By.id("exampleFormControlSelect1"));
		Select dropdown = new Select(Gender);
		dropdown.selectByVisibleText("Female");
		
		driver.findElement(By.id("inlineRadio1")).click();
		System.out.println(driver.findElement(By.id("inlineRadio1")).isSelected());
		driver.findElement(By.name("bday")).sendKeys("12/12/1996");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		System.out.println(driver.findElement(By.className("alert-success")).getText());
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']/strong[contains(text(),'Success!')]")).getText(), "Success!");
	}
}
