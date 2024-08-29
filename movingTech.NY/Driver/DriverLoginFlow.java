package Driver;

import org.testng.annotations.Test;

import base.BaseClass;
import io.appium.java_client.AppiumBy;

public class DriverLoginFlow extends BaseClass{
	
	 
	
    @Test
	public void successfulDriverLogin() throws InterruptedException {
String str="Namma Yatri Partner";
		Thread.sleep(3000);
		System.out.println("Driver login begin");
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Enable Location\"]")).click();
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
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Namma Yatri Partner']")).click();//
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
		Thread.sleep(4000);
//		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='Okay : Button']")).click();
//		Thread.sleep(4000);---------
		System.out.println("Waiting to enable pop up screen");
		Thread.sleep(2000);
//		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Enable Permission']")).click();
//		Thread.sleep(1000);
//		driver.findElement(AppiumBy.xpath("//android.widget.RadioButton[@text='Allow all the time']")).click();
		Thread.sleep(1000);
//
//		driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]")).click();
//		
//
//		//HomeScreen
//		Thread.sleep(1000);
//		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Okay']")).click();
//		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Check Now']")).click();
//		
//		Thread.sleep(1000);
//		
//		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Home']")).click();
//		Thread.sleep(2000);
		//driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Maybe later']")).click();

//		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='GO!']")).click();
//		System.out.println("Driver Flow is success, Moving to user");
//		Thread.sleep(2000);
//		System.out.println("Driver is online....");
	
	}
    
    
}