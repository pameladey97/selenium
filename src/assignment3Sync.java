/**
 * @author PamelaDey
 * Use of implicit and Explicit wait
 */

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class assignment3Sync {
	static WebDriver driver = new ChromeDriver ();
	static WebDriverWait explicit_wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		//String[] itemsToBuy= {"iphone X","Nokia Edge","Samsung Note 8"};
		Login();
		addItems();
		AutosuggestiveDropdown();
		driver.close();
		
	}
	public static void Login()
	{
		String username= driver.findElement(By.xpath("//i[contains(text(),'rahulshettyacademy')]")).getText();
		String password= driver.findElement(By.xpath("//i[contains(text(),'learning')]")).getText();
		driver.findElement(By.cssSelector("#username")).sendKeys(username);
		driver.findElement(By.cssSelector("#password")).sendKeys(password);
		//WebElement userName= driver.findElement(By.cssSelector("#username"));
		//System.out.println(userName.getText());
		driver.findElement(By.xpath("(//label[@class='customradio']/span[@class='checkmark'])[2]")).click();
		//WebDriverWait expWait = new WebDriverWait(driver,Duration.ofSeconds(5));
		explicit_wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div [class='modal-body']")));
		System.out.print(driver.findElement(By.cssSelector("div [class='modal-body']")).getText());
		driver.findElement(By.cssSelector("#cancelBtn")).click();
		driver.findElement(By.cssSelector("select.form-control")).click();
		Select dropdown = new Select(driver.findElement(By.cssSelector("select.form-control")));// object created
		//by index
		dropdown.selectByIndex(1);
		System.out.println(dropdown.getFirstSelectedOption().getText());
		driver.findElement(By.cssSelector("select.form-control")).click();//to close the dropdown
		// by text
		dropdown.selectByVisibleText("Consultant");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		System.out.println(driver.findElement(By.cssSelector("input[type='checkbox']")).isSelected());
		driver.findElement(By.cssSelector("input[type='checkbox']")).click();
		driver.findElement(By.cssSelector("#signInBtn")).click();

		
	}
	public static void addItems()
	{
		//WebDriverWait explicit_wait1 = new WebDriverWait(driver,Duration.ofSeconds(5));
		explicit_wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='my-4']")));
		System.out.println(driver.findElement(By.xpath("//h1[@class='my-4']")).getText());
		
		List<WebElement> AllProducts =driver.findElements(By.xpath("//h4[@class='card-title']"));
		for (int i=0;i<AllProducts.size();i++) 
		{
			driver.findElements(By.xpath("//button[@class='btn btn-info']")).get(i).click();
            
		}
		driver.findElement(By.className("btn-primary")).click();
		explicit_wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col-sm-12 col-md-10 col-md-offset-1']")));
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		
	}
	static void AutosuggestiveDropdown()
	{
		//WebDriverWait explicit_wait3 = new WebDriverWait(driver,Duration.ofSeconds(5));
		explicit_wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='input-field col s12']/label[@for='country']")));
		System.out.println(driver.findElement(By.xpath("//div[@class='input-field col s12']/label[@for='country']")).getText());
		driver.findElement(By.xpath("//input[@id='country']")).sendKeys("ind");
		List<WebElement> options = driver.findElements(By.xpath("//div[@class='suggestions']/ul/li/a"));
		
		for(WebElement option :options )
		{
			if (option.getText().equalsIgnoreCase("India"))
			{
				String country= option.getText();
				System.out.println(country);
				option.click();
				
				break;	
			}	
		}
		driver.findElement(By.xpath("//div[@class='checkbox checkbox-primary']")).click();
		driver.findElement(By.xpath("//input[@class='btn btn-success btn-lg']")).click();
		WebElement success = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']/strong"));
		System.out.println(success.getText());
		Assert.assertEquals(success.getText(), "Success!");
		
	}
}
