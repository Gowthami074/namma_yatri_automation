package User.Android;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.time.Duration;

import base.BaseClass;

public class UserLoginFlow extends BaseClass{
	
	
	public void successfulUserLogin() throws InterruptedException {
		
		//Thread.sleep(5000);
		//User
		driver1.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Get Started']")).click();   
		Thread.sleep(2000);
		driver1.findElement(AppiumBy.xpath("//android.widget.Button[@text='NONE OF THE ABOVE']")).click(); 
		Thread.sleep(1000);
		driver1.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Enter Mobile number']")).sendKeys("9491839588");
		Thread.sleep(2000);
		driver1.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Continue']")).click();
		Thread.sleep(2000);
//		((AndroidDriver)driver1).runAppInBackground(Duration.ofSeconds(10));    
		driver1.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Enter 4 digit OTP']")).sendKeys("7891");
		Thread.sleep(3000);
//		driver1.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Enter Your Name']")).sendKeys("Automation Testing");
//		Thread.sleep(2000);
//		driver1.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Select Your Gender']")).click();
//		Thread.sleep(2000);
//		driver1.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Male']")).click();
//		Thread.sleep(2000);
//		driver1.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Let’s go!']")).click();
//		Thread.sleep(3000);
		driver1.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Allow Location Access']")).click();
		Thread.sleep(2000);
//		driver1.findElement(AppiumBy.xpath("//android.widget.Button[@text='While using the app']")).click();
		driver1.findElement(AppiumBy.xpath("//android.widget.Button[@text='WHILE USING THE APP']")).click();

		Thread.sleep(2000);
		//driver1.findElement(AppiumBy.xpath("//android.widget.Button[@text='Allow']")).click();
//		driver1.findElement(AppiumBy.xpath("//android.widget.Button[@text='ALLOW']")).click();
		Thread.sleep(3000);
		
		
	}
	
	

}