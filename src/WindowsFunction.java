
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsFunction {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		System.out.println(driver.manage().window().getSize());
		Thread.sleep(2000);
		driver.manage().window().minimize();
		System.out.println(driver.manage().window().getSize());
		Thread.sleep(2000);
		driver.manage().window().maximize();
		System.out.println(driver.manage().window().getSize());
		Thread.sleep(2000);

		driver.get("http://google.com");

		driver.navigate().to("https://rahulshettyacademy.com");

		driver.navigate().back();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());

		driver.navigate().forward();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		Thread.sleep(1000);
		driver.quit();
		
		

	}

}
