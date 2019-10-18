import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

interface Calc{
	int compute(int x, int y);
}
class Calculate implements Calc{
	@Override
	public int compute(int x, int y) {
		return x +y;
	}
}
public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calc d =(a,b)->a*b;
//		 new Calc() {
//				@Override
//				public int compute(int x, int y) {
//					return x +y;
//				}
//			};
			
			
		
		WebDriver driver = new ChromeDriver();
		WebElement w2 = driver.findElement(By.id("aaa"));
		Wait<WebDriver> w = new FluentWait<WebDriver>(driver)
				.withTimeout(30,TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS).ignoring(Exception.class);
//		WebElement ee = w.until(new Function<WebDriver, WebElement>() {
//
//			@Override
//			public WebElement apply(WebDriver t) {
//				// TODO Auto-generated method stub
//				return driver.findElement(By.id("xyz"));
//			}
//			
//		});
		
		WebElement ee = w.until((t) ->driver.findElement(By.id("xyz")));
			
			
		
		
		
		Calculate obj = new Calculate();
		Calculate obj1 = new Calculate();
		Calculate obj2 = new Calculate();
		int z = obj.compute(10, 20);
		System.out.println(z);

	}

}
