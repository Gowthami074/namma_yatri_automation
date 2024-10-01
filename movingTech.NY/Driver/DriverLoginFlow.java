package Driver;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.TimeoutException;
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

		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='10-digit mobile number']")).sendKeys("9876544445"); 

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
		driverModeValidation();		
	}


	
	public void pointsAndUpiPopsHandling() {
		// Temporarily reduce implicit wait before using explicit wait
		implicitWaitMethod(driver,5); //This method is defined in BaseClass
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Set a small explicit wait time
		
		try {
			// Wait for 'Later' button (UPI Overlay)
			WebElement laterButton = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='Later']")));
			System.out.println("Skipping UPI Overlay");
			laterButton.click();


		} catch (TimeoutException e) {
			System.out.println("No UPI Overlay found");
		}
		try {
			// Wait for 'Later' button (UPI Overlay)
			WebElement yatriCoinsOkayButton = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='Okay']")));
			System.out.println("Skipping UPI Overlay");
			yatriCoinsOkayButton.click();


		} catch (TimeoutException e) {
			System.out.println("No Yatricoins Overlay found");
		}
		try {
			// Wait for 'Maybe Later' button (Points Overlay)
			WebElement maybeLaterButton = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='Maybe Later']")));
			System.out.println("Skipping Points Overlay");
			maybeLaterButton.click();
		} catch (TimeoutException e) {
			System.out.println("No Points Overlay found");
		}
		// Temporarily reduce implicit wait before using explicit wait
		implicitWaitMethod(driver,60);
	}


	public void driverModeValidation() throws InterruptedException {
		implicitWaitMethod(driver,5);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Adjust the timeout as needed

		try {
			// Wait for 'GO!' button to appear (Driver is offline)
			WebElement goButton = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='GO!']")));
			System.out.println("The driver is offline");
			goButton.click();

		} catch (TimeoutException e1) {
			try {
				// Wait for 'Silent' button (Driver is silent)
				WebElement silentButton = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='Silent']/../android.widget.ImageView")));
				System.out.println("The Driver is Silent");

				// Now wait for 'Online' button and click it
				WebElement onlineButton = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='Online']")));
				onlineButton.click();

			} catch (TimeoutException e2) {
				System.out.println("The driver is online");
			}
			implicitWaitMethod(driver,60);
		}
	}}

