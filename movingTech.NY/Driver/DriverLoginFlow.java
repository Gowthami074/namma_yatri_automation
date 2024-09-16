package Driver;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.BaseClass;
import io.appium.java_client.AppiumBy;

public class DriverLoginFlow extends BaseClass{



	@Test
	public void successfulDriverLogin() throws InterruptedException {
		String str="Namma Yatri Partner";
		Thread.sleep(3000);


		System.out.println("Driver login begin");
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Enable Location']")).click();
		Thread.sleep(2000);
		//driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='While using the app']")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='WHILE USING THE APP']")).click(); //vivo

		Thread.sleep(4000);
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Confirm']")).click();
		Thread.sleep(2000);
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Get Started']")).click();
		Thread.sleep(2000);
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='10-digit mobile number']")).sendKeys("9603578766"); 
		Thread.sleep(2000);
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Continue']")).click();
		Thread.sleep(2000);
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Auto Reading OTP...']")).sendKeys("7891");
		Thread.sleep(2000);
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Draw over applications']")).click();//
		Thread.sleep(2000);
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='Search']")).click();//
		Thread.sleep(2000);
		driver.findElement(AppiumBy.xpath("//android.widget.AutoCompleteTextView[@text='Search']")).sendKeys("Namma");//
		Thread.sleep(3000);
		List<WebElement> appPacakgeName = driver.findElements(AppiumBy.xpath("//android.widget.TextView[@text='in.juspay.nammayatripartner.debug']"));

		if(!appPacakgeName.isEmpty() && appPacakgeName.get(0).isDisplayed()) {
			System.out.println("App pacakge name displyed");
			appPacakgeName.get(0).click();
			}
		else {
			driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Namma Yatri Partner']")).click();//
		}
		
		Thread.sleep(2000);
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Allow display over other apps\"]")).click();//
		Thread.sleep(2000);
		driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Back\"]")).click();//
		Thread.sleep(2000);
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Autostart in background']")).click();
		Thread.sleep(2000);
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Battery Optimization']")).click();
		Thread.sleep(4000);
		System.out.println("battery settings");
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='ALLOW']")).click();
		Thread.sleep(2000);
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Notification Access']")).click();
		Thread.sleep(2000);
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='ALLOW']")).click();
		Thread.sleep(2000);
		System.out.println("Proceeding to continue in permissions");
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Continue']")).click();
		Thread.sleep(2000);
		pointsAndUpiPopsHandling();
		driverModeValidation();		
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
