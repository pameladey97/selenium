import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Section8_AddToCart {

	static WebDriver driver = new ChromeDriver ();
	public static void main(String[] args) throws InterruptedException {
		//WebDriver driver = new ChromeDriver ();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		
		String[] itemsToBuy= {"Cucumber","Brocolli","Beetroot"};		
		addItems(itemsToBuy);
		GotoKart(driver);
		Thread.sleep(2000);
		driver.close();

	}
	public static void addItems(String[] itemsToBuy)
	{
		List<WebElement> AllProducts =driver.findElements(By.xpath("//h4[@class ='product-name']"));
		for(int i=0;i<AllProducts.size();i++ )
		{
			String[] splitVegName = AllProducts.get(i).getText().split("-");
			String VegName = splitVegName[0].trim();
			
			//Convert itemsToBuy array into arrayList
			List itemsToBuyAL = Arrays.asList(itemsToBuy);
			int j=0;
			if(itemsToBuyAL.contains(VegName))
			{
				
				j++;
				System.out.println(j);

				//click on Add to cart

				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if(j== itemsToBuy.length )
				{
					System.out.println(j);
					break;
				}
			}
			
			
			
		}
	}
	public static void GotoKart(WebDriver driver)
	{
		driver.findElement(By.xpath("//a[@class='cart-icon']/img")).click();
		driver.findElement(By.xpath("//div[@class='action-block']/button[contains(text(), 'PROCEED TO CHECKOUT')]")).click();
		driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
		WebDriverWait expWait = new WebDriverWait(driver,Duration.ofSeconds(5));
		expWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		driver.findElement(By.xpath("//button[contains(text(),'Place Order')]")).click();
		
	}

}
