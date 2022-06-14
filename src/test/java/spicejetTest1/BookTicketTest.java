package spicejetTest1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import co.spicejett.genericutility.*;

import co.spicejett.genericutility.*;
import co.spicejett.genericutility.*;
import co.spicejett.genericutility.*;
import co.spicejett.genericutility.*;

import co.spicejett.genericutility.ExcelLibrary;
import co.spicejett.genericutility.FileLibrary;
import co.spicejett.genericutility.JavaLibrary;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BookTicketTest {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		JavaLibrary jutil=new JavaLibrary();
		WebDriver driver=null;
		
		FileLibrary.openPropertyFile(co.spicejett.genericutility.IconstantPath.PROPERTYFILEPATH);
		ExcelLibrary.openExcel(co.spicejett.genericutility.IconstantPath.EXCELFILEPATH);
		
		String url = FileLibrary.getDataFromPropertyFile("url");
	
		String timeout =FileLibrary.getDataFromPropertyFile("timeout");
		String browser = FileLibrary.getDataFromPropertyFile("browser");
		
		long longTimeOut = jutil.stringToLong(timeout);
		
		int randomNumber=jutil.getRandomNumber(1000);
		
		//passenger1
		String fn =ExcelLibrary.getDataFromExcel("contacts", 2, 2)+randomNumber;
		String ln =ExcelLibrary.getDataFromExcel("contacts", 3, 2)+randomNumber;
		String contactno =ExcelLibrary.getDataFromExcel("contacts", 4, 2);
	
		String email =ExcelLibrary.getDataFromExcel("contacts", 5, 2)+randomNumber;
		String town =ExcelLibrary.getDataFromExcel("contacts", 6, 2)+randomNumber;
		
		//passenger2
		String fn1 =ExcelLibrary.getDataFromExcel("contacts", 7, 2)+randomNumber;
		String ln1 =ExcelLibrary.getDataFromExcel("contacts", 8, 2)+randomNumber;
		
		switch(browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver=new ChromeDriver(options);
			break;
		case "firefox":
			WebDriverManager.chromedriver().setup();
			driver=new FirefoxDriver();
			break;

		default:System.out.println("please specify proper browser key");
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		break;
		}
		
		//WebDriverManager.chromedriver().setup();
		//To handle notification popup
		//ChromeOptions options=new ChromeOptions();
		//options.addArguments("--disable-notifications");
		// driver=new ChromeDriver(options);
		 
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		
		//driver.manage().window().maximize();
		//driver.get(url);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebDriverLibrary.navigateApp(url, driver);
		WebDriverLibrary.browserSetting(longTimeOut, driver);
		//WebDriverUtility.explicitlyWait(driver, longTimeOut);
		WebDriverWait wait=new WebDriverWait(driver, longTimeOut);
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
		driver.findElement(By.xpath("//input[@maxlength='32']")).sendKeys(fn);
		
		//lastname
		driver.findElement(By.xpath("(//input[@maxlength='32'])[2]")).sendKeys(ln);
		
		//contact number
		driver.findElement(By.xpath("//input[@maxlength='10']")).sendKeys(contactno);
		
		//email
		driver.findElement(By.xpath("//input[@maxlength='266']")).sendKeys(email);
		
		//town or city
		driver.findElement(By.xpath("(//input[@maxlength='32'])[3]")).sendKeys(town);
		
		//country
		//driver.findElement(By.xpath("(//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep'])[3]")).click();
		
		js.executeScript("arguments[0].scrollIntoView()", driver.findElement(By.xpath("//div[text()='Passenger 1']")));
		
		driver.findElement(By.xpath("//div[text()='I am flying as the primary passenger']")).click();
		
		driver.findElement(By.xpath("//div[text()='Next']")).click();
		
		//passenger 2 details
		driver.findElement(By.xpath("//div[text()='Select']")).click();
		driver.findElement(By.xpath("//div[text()='Master']")).click();
		//firstname1
		driver.findElement(By.xpath("(//input[@type='text'])[6]")).sendKeys(fn1);
		//lastname1
		driver.findElement(By.xpath("(//input[@type='text'])[7]")).sendKeys(ln1);
		
		driver.findElement(By.xpath("//div[@data-testid='traveller-info-continue-cta']")).click();
		
		WebDriverLibrary.quit(driver);

	}

}
