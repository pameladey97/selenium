import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Session68_Alerts {
	static WebDriver driver = new ChromeDriver ();

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.name("enter-name")).sendKeys("Pam");
		driver.findElement(By.cssSelector("input[value='Alert']")).click();
		Thread.sleep(1000);
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[value='Confirm']")).click();
		Thread.sleep(1000);
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
		
		
	}

}
