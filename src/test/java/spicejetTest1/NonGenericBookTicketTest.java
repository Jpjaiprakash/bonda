package spicejetTest1;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NonGenericBookTicketTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		
		//To handle notification popup
		ChromeOptions options=new ChromeOptions();
		
		options.addArguments("--disable-notifications");
		
		WebDriver driver=new ChromeDriver(options);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		driver.manage().window().maximize();
		driver.get("https://www.spicejet.com/");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[text()='round trip']")).click();
		driver.findElement(By.xpath("//input[@autocapitalize='sentences']")).click();
		driver.findElement(By.xpath("//div[text()='Bengaluru']")).click();
		driver.findElement(By.xpath("//div[text()='Delhi']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[text()='20']")).click();
		driver.findElement(By.xpath("//div[text()='21']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[text()='Passengers']")).click();
		driver.findElement(By.xpath("//div[@data-testid='Children-testID-plus-one-cta']")).click();
		
		driver.findElement(By.xpath("//div[@data-testid='home-page-travellers-done-cta']")).click();
		
		driver.findElement(By.xpath("//div[@data-testid='home-page-flight-cta']")).click();
		
		driver.findElement(By.xpath("//div[@data-testid='spiceflex-flight-select-radio-button-2']")).click();
		
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		js.executeScript("arguments[0].scrollIntoView()", driver.findElement(By.xpath("//div[text()='SG 191']")));
		
		driver.findElement(By.xpath("//div[@data-testid='spicemax-flight-select-radio-button-3']")).click();
		
		driver.findElement(By.xpath("//div[@data-testid='continue-search-page-cta']")).click();
		
		//first name
		driver.findElement(By.xpath("//input[@maxlength='32']")).sendKeys("jaiprakash");
		
		//lastname
		driver.findElement(By.xpath("(//input[@maxlength='32'])[2]")).sendKeys("C");
		
		//contact number
		driver.findElement(By.xpath("//input[@maxlength='10']")).sendKeys("8722222452");
		
		//email
		driver.findElement(By.xpath("//input[@maxlength='266']")).sendKeys("jpjaiprakash245@gmail.com");
		
		//town or city
		driver.findElement(By.xpath("(//input[@maxlength='32'])[3]")).sendKeys("Davanagere");
		
		//country
		//driver.findElement(By.xpath("(//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep'])[3]")).click();
		
		js.executeScript("arguments[0].scrollIntoView()", driver.findElement(By.xpath("//div[text()='Passenger 1']")));
		
		driver.findElement(By.xpath("//div[text()='I am flying as the primary passenger']")).click();
		
		driver.findElement(By.xpath("//div[text()='Next']")).click();
		
		//passenger 2 details
		driver.findElement(By.xpath("//div[text()='Select']")).click();
		driver.findElement(By.xpath("//div[text()='Master']")).click();
		//firstname1
		driver.findElement(By.xpath("(//input[@type='text'])[6]")).sendKeys("AKHI");
		//lastname1
		driver.findElement(By.xpath("(//input[@type='text'])[7]")).sendKeys("BM");
		
		driver.findElement(By.xpath("//div[@data-testid='traveller-info-continue-cta']")).click();	
	
	}

}