import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import test.ScreenShotDemo;

public class MMTTest {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "/Users/amit/Documents/selenium-things/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		WebDriverWait webwait = new WebDriverWait(driver, 30);
		webwait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fromCity")));
		driver.findElement(By.id("fromCity")).sendKeys("Delhi");
		driver.findElement(By.cssSelector("#react-autowhatever-1-section-0-item-0 > div > div.calc60 > p.font14.appendBottom5.blackText")).click();
		Thread.sleep(2000);
		WebElement city = driver.findElement(By.id("toCity"));
		webwait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toCity")));
		
		city.sendKeys("Mumbai");
		//#react-autowhatever-1-section-0-item-1 > div > div.calc60 > p.font14.appendBottom5.blackText
		driver.findElement(By.cssSelector("#react-autowhatever-1-section-0-item-0 > div > div.calc60 > p.font14.appendBottom5.blackText")).click();
		driver.findElement(By.cssSelector("#root > div > div.minContainer > div > div > div.fsw > div.fsw_inner > div:nth-child(4)")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the Day ");
		int day = s.nextInt() - 1;
		//int day = 24; // index 23
		js.executeScript("document.querySelectorAll('.DayPicker-Day')[28].click();");
		driver.findElement(By.cssSelector("#root > div > div.minContainer > div > div > div.fsw > div.fsw_inner > div.fsw_inputBox.flightTravllers.inactiveWidget > label > p.blackText.font20.code")).click();
		js.executeScript("document.querySelectorAll('.guestCounter')[0].children[2].click();");
		driver.findElement(By.cssSelector("#root > div > div.minContainer > div > div > div.fsw.widgetOpen > div.fsw_inner > div.fsw_inputBox.flightTravllers.inactiveWidget.activeWidget > div.travellers > button")).click();
		driver.findElement(By.className("widgetSearchBtn")).click();
		int checkBoxIndex = 0;
		//webwait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.className("check"))));
//		js.executeScript("document.querySelectorAll('.check')["+checkBoxIndex+"].click();");
//		//make_flex
//		webwait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("sorter_btn_onward")));
//		webwait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("sorter_btn_onward"))));
//		driver.findElement(By.id("sorter_btn_onward")).click();
//		int sortIndex = 2;
//		js.executeScript("document.querySelectorAll('.sortbytype')["+sortIndex+"].parentNode.click();");
		// document.querySelectorAll('.fli-list')[2].click();
		int listClick = 2; // index
		webwait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("fli-list")));
		List<WebElement> list = driver.findElements(By.className("fli-list"));
		list.get(listClick).click();
		driver.findElements(By.className("fli_primary_btn")).get(1).click();
//		new WebDriverWait(driver, 100).until(
//			      webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
		//js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			    .withTimeout(130, TimeUnit.SECONDS)
			    .pollingEvery(5, TimeUnit.SECONDS)
			    .ignoring(NoSuchElementException.class);
		Thread.sleep(20000);
//		WebElement term = wait.until(new Function<WebDriver, WebElement>() 
//		{
//		  public WebElement apply(WebDriver driver) {
//		  return driver.findElement(By.partialLinkText("Terms & Condition"));
//		}
//		});
//		webwait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Terms ")));
//		//int y  = term.getLocation().getY();
//		int y = driver.findElement(By.partialLinkText("Terms ")).getLocation().getY();
//		System.out.println("Y is "+y);
//		
//		//js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//		js.executeScript("window.scrollTo(0, "+y+")");
//		webwait.until(ExpectedConditions.visibilityOfElementLocated(By.id("review-continue")));
		
		//webwait.until(ExpectedConditions.elementToBeClickable(By.id("review-continue")));
		//driver.findElement(By.id("review-continue")).click();
		//Thread.sleep(5000);
		//js.executeScript("document.querySelector('#review-continue').click();");
		ScreenShotDemo.takeScreenShot(driver);
		Thread.sleep(5000);
		driver.quit();
	}

}
