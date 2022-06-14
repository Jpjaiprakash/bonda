package co.spicejett.genericutility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import co.spicejett.genericutility.*;

/**
 * This is class is used to maintain all web Driver common actions
 */

public class WebDriverLibrary {

	static WebDriverWait wait;
	static Select s;
	static Actions act;
	static JavascriptExecutor js;
	static JavaLibrary jutil=new JavaLibrary();


	/**
	 * This method is used to navigate the application
	 */
	public static void navigateApp(String url,WebDriver driver) 
	{
		driver.get(url);
	}

	/**
	 * This method is used to maximize the browser and implicit wait
	 */
	public static void browserSetting(long longTimeOut,WebDriver driver)
	{
		maximizeBrowser(driver);

	}

	/**
	 * This method is used to maximize the browser
	 */
	public static void maximizeBrowser(WebDriver driver)
	{
		driver.manage().window().maximize();
	}


	/**
	 * This method is used to implicit wait till page load
	 */
	public static void waitTillPageLoad(long longTimeOut,WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(longTimeOut, TimeUnit.SECONDS);
	}

	/**
	 * This method is used to quit the browser
	 */
	public static void quit(WebDriver driver)
	{
		driver.quit();
	}

	public static void intializeJs(WebDriver driver) {
		js=(JavascriptExecutor)driver;
	}

	public static void scrollToBottom() {
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public static void scrollTillElement(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView()",element);
	}


}
