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
//import org.testng.Assert;
public class Dropdowns {
	static WebDriver driver = new ChromeDriver ();// By System Manager jar

	public static void main(String[] args) throws InterruptedException {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		int a = 1; 
				
		
		StaticDropdown();
		Checkbox();
		UpdatedDropdown();
		DynamicDropdown();
		CalendarCurrentDate();
		DropdownParentChild();
		AutosuggestiveDropdown();
		RadioButton();
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_btn_FindFlights']")).click();
		
		Thread.sleep(3000);
		//driver.close();

	}
	
	/**
	 * @Static dropdowns: tag name starts with select
	 * @Scenario: add currency type
	 */
	static void StaticDropdown(){
		WebElement Currency = driver.findElement(By.name("ctl00$mainContent$DropDownListCurrency"));
		Select dropdown = new Select(Currency);// object created
		// by index
		dropdown.selectByIndex(3);
		System.out.println(dropdown.getFirstSelectedOption().getText());  //sysout" followed by Ctrl + space
		
		// by text
		dropdown.selectByVisibleText("INR");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		// by value
		
		dropdown.selectByValue("AED");
		System.out.println(dropdown.getFirstSelectedOption().getText());
	}
	/**
	 * @Checkbox: 
	 * @scenario: check if the checkbox is checked or unchecked, count the number of checkboxes
	 * @Assertion application: Assert.assertFalse(false), Assert.assertTrue(true),Assert.assertEquals(actual,expected)
	 */
	static void Checkbox() throws InterruptedException {
		
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
		System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		
		
	}
	
	/**
	 * @Updated dropdown: 
	 * @scenario: Add number of passangers
	 */

	static void UpdatedDropdown() throws InterruptedException{
		
		
		driver.findElement(By.id("divpaxinfo")).click();
		for(int i=1;i<5;i++)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
			
		}
		for(int i=1;i<3;i++)
		{
			driver.findElement(By.id("hrefIncChd")).click();
		}
		for(int i=1;i<2;i++)
		{
			driver.findElement(By.id("hrefIncInf")).click();
		}
		
		driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println(driver.findElement(By.className("paxinfo")).getText());
		Assert.assertEquals(driver.findElement(By.className("paxinfo")).getText(),"5 Adult, 2 Child, 1 Infant" );
	}
	/**
	 * @Dynamic dropdown:The value appears after you click the departure/Arrival field. The dropdown values will not be fould until the field is clicked. 
	 * @scenario: Add departure and Arrival
	 */
	static void DynamicDropdown(){
		
		
		System.out.println(driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).getText());
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@text='Guwahati (GAU)']")).click();
		
		System.out.println(driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).getText());
		driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
		driver.findElement(By.xpath("(//a[@text='Bangkok (BKK)'])[2]")).click();
				
		
		
	}
	/**
	 * @Calendar dropdown 
	 * @scenario: select current date
	 */
	static void CalendarCurrentDate() throws InterruptedException {
		
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-hover")).click();
		System.out.println(driver.findElement(By.id("view_fulldate_id_1")).getText());
		Thread.sleep(2000);
		
			
		
	}
	
	/**
	 * @Dynamic dropdown with Parent child xpath: //parentXpath<space>//childXpath
	 * @scenario: Clear Arrival with index and add arrival with parent-child xpath
	 */
	static void DropdownParentChild() throws InterruptedException {
		
		Thread.sleep(2000);
		driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@text='Bangkok (BKK)']")).click();
		
		
	}
	/**
	 * @Autosuggestive dropdown : for loop used
	 * @scenario: search location India from auto suggestion
	 */
	static void AutosuggestiveDropdown() throws InterruptedException {
		
		//Thread.sleep(2000);
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(3000);
		List<WebElement> options = driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));
		
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
		
		
	}
	/**
	 * @Radio_button_and_ReturnDate_calendar: Use condition
	 * @scenario: For One way trio, return Date will be disabled, for round trip, it will be enabled
	 */
	static void RadioButton() throws InterruptedException {
		
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).isEnabled());
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		//System.out.println(driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).isEnabled());
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		//System.out.println(driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).isEnabled());
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		//System.out.println(driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).isEnabled());
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"))
		{
			System.out.println("It is a one way trip. Hence, Return Date field is blocked.");
			Assert.assertTrue(true);
			//driver.findElement(By.id("Div1")).click();
			
		}
		else
		{
			System.out.println("It is a Round trip. Hence, Return Date field can be selected.");
			Assert.assertTrue(true);
			// or Assert.assertFalse(false);
			//driver.findElement(By.id("Div1")).click();
			
		}
		
		
		
		
	}
	

	
		
	}
	
	

