package Driver;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.BaseClass;
import io.appium.java_client.AppiumBy;

public class DriverLoginFlow extends BaseClass{

	@Test
	public void successfulDriverLogin() throws InterruptedException {
		System.out.println("Driver login begins");
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Enable Location']")).click();
		Thread.sleep(2000);
		System.out.println(driverUdid);
		System.out.println("Trying to Tap While Using the app");
		switch(driverUdid) {
		case "RZ8N91FWYXT": 
		case "R9ZTB0KD0FA":
		case "RFCT42T5N9D":
		case "28301JEGR03129":
		case "RZ8R72RE6AB":
		case "8cb2f113":
		case "SONJFMDUKV65OJV4":
			driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='While using the app']")).click();
			break;
		case "1377682723004YR":
		case "1371785921000CT":
		case "15913008960024W":
		case "9618349153000CS":
		case "eb23ba":
			driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='WHILE USING THE APP']")).click();
			break;
		case "062c68090409":
			driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='ALLOW ONLY WHILE USING THE APP']")).click();
			break;
		default:
			throw new NoSuchElementException("Invalid Selectors");

		}
  
		Thread.sleep(5000);
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Confirm']")).click();
		Thread.sleep(2000);
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Get Started']")).click();
		Thread.sleep(2000);
		System.out.println("Entering Mobile Number");
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='10-digit mobile number']")).sendKeys("9603578766"); 
		Thread.sleep(2000);
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Continue']")).click();
		Thread.sleep(2000);
		System.out.println("Entering OTP");
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Auto Reading OTP...']")).sendKeys("7891");
		Thread.sleep(2000);
		DevicePermission devicePermissions = new DevicePermission();
		devicePermissions.handlePermissions();
		
//		driver.findElements(AppiumBy.xpath("//android.widget.TextView[@text='Maybe Later']"));
//		driver.findElements(AppiumBy.xpath("//android.widget.TextView[@text='GO!']"));
		
		pointsAndUpiPopsHandling();
//		driverModeValidation();		
	}
	
	public void pointsAndUpiPopsHandling() {

		List<WebElement> elements3 = driver.findElements(AppiumBy.xpath("//android.widget.TextView[@text='Later']"));
		if(!elements3.isEmpty() && elements3.get(0).isDisplayed()) {
			System.out.println("Skipping UPI Overlay");
			elements3.get(0).click();
			List<WebElement> elements4 = driver.findElements(AppiumBy.xpath("//android.widget.TextView[@text='Maybe Later']"));
			if(!elements4.isEmpty()&&elements4.get(0).isDisplayed()) {
				System.out.println("Skipping Points Overlay");
				elements4.get(0).click();
			}
		} 
		else {
			System.out.println("No overlay found after login");

		}
	}

	public void driverModeValidation() throws InterruptedException {

		List<WebElement> elements = driver.findElements(AppiumBy.xpath("//android.widget.TextView[@text='GO!']"));

		if (!elements.isEmpty() && elements.get(0).isDisplayed()) {
			System.out.println("The driver is offline");
			driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='GO!']")).click();
		} else{
			List<WebElement> elements2 = driver.findElements(AppiumBy.xpath("//android.widget.TextView[@text='Silent']/../android.widget.ImageView"));
			if (!elements2.isEmpty() && elements2.get(0).isDisplayed()) {
				System.out.println("The Driver is Silent");
				driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Online']")).click();

			}
			else {
				System.out.println("The driver is online");
			}

		}
 
	}
	
	
}