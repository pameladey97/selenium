import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;


public class Selenium {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		//Invoke Browser
		/*//step to invoke chrome driver manually//
		System.setProperty("webdriver.edge.driver", "C:/Program Files (x86)/Microsoft/Edge/Application/msedge.exe");
		WebDriver driver = new EdgeDriver();*/
		
		//Selenium Manager can directly find the chrome driver and if the driver is not installed, it can install in proper path and run automatically
		
		WebDriver driver = new ChromeDriver ();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https:/rahulshettyacademy.com/locatorspractice/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		//Scenarion 1: Wrong Password
		driver.findElement(By.id("inputUsername")).sendKeys("Pamela");
		driver.findElement(By.name("inputPassword")).sendKeys("WrongPassword");
		driver.findElement(By.className("signInBtn")).click();
		
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[placeholder='Name']")).sendKeys("Pamela");
		
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("abc97@gmail.com");
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("abcd@gmail.com");
		
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("3451237890");
		
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		
		
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#inputUsername")).sendKeys("SeleniumStudy");
		driver.findElement(By.cssSelector("#inputUsername")).clear();
		driver.findElement(By.cssSelector("input[id*='input']")).sendKeys("Pamela");
		
		driver.findElement(By.xpath("//input[contains(@name,'input')]")).sendKeys("rahulshettyacademy");
		
		driver.findElement(By.xpath("//form/div/span/input[@id='chkboxOne']")).click();
		
		driver.findElement(By.cssSelector("form div span input[id='chkboxTwo']")).click();
		
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		
		
		
		
		//Thread.sleep(3000);
		//Close the url
		driver.close();
		/*//Close the whole driver
		driver.quit();*/
		

	}

}
