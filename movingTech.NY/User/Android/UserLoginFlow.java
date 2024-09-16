package User.Android;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.time.Duration;

import base.BaseClass;

public class UserLoginFlow extends BaseClass{
	
	
	public void successfulUserLogin() throws InterruptedException {
		
		driver1.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Get Started']")).click();   
		Thread.sleep(2000);
		
		DevicePermission.autoSuggestionDecline();
		Thread.sleep(1000);
		driver1.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Enter Mobile number']")).sendKeys("9491839588");
		Thread.sleep(2000);
		driver1.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Continue']")).click();
		Thread.sleep(2000);    
		driver1.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Enter 4 digit OTP']")).sendKeys("7891");
		Thread.sleep(3000);
		driver1.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Allow Location Access']")).click();
		Thread.sleep(2000); 
		DevicePermission.locationPermissionsConfirmation();
		Thread.sleep(2000);
		//driver1.findElement(AppiumBy.xpath("//android.widget.Button[@text='Allow']")).click();
//		driver1.findElement(AppiumBy.xpath("//android.widget.Button[@text='ALLOW']")).click();
		Thread.sleep(3000);
		
	}
	
	

}