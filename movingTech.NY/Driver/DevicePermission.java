package Driver;

import java.util.Arrays;

import base.BaseClass;
import io.appium.java_client.AppiumBy;

public class DevicePermission extends BaseClass {
 
	
    public void handlePermissions() throws InterruptedException {
		System.out.println("Setting Up the permissions");
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Draw over applications']")).click();
		System.out.println("Draw Over Applications permission");
		System.out.println(driverUdid);
		Thread.sleep(2000);
		drawOverApplicationsFlow();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Autostart in background']")).click();
		Thread.sleep(2000);	
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Battery Optimization']")).click();
		Thread.sleep(1000);
		batteryOptimizationPopUp();
		switch(driverUdid) {
	    case "8cb2f113":
	    case "SONJFMDUKV65OJV4":
	    case "1377682723004YR":
	    case "RZ8R72RE6AB":
	        break;
	    default:
	        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Notification Access']")).click();
	        Thread.sleep(1000);
	        notificationAccessPopUp();
	}
		System.out.println("Permissions are setted Up successfully");
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Continue']")).click();
	}
	
	
	private void permissionForSamsungGalaxyA03Core() throws InterruptedException {

		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Grant Permissions']")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Draw over applications']")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Autostart in background']")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Battery Optimization']")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Allow']")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Notification Access']")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Allow']")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Continue']")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Okay']")).click();
		Thread.sleep(2000);
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Check Now']")).click();
		Thread.sleep(2000);
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Home']")).click();
		Thread.sleep(5000);
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='GO!']")).click();
		Thread.sleep(2000);
	}
	

	
	private void drawOverApplicationsFlow() throws InterruptedException {
		switch(driverUdid) {
		case "1371785921000CT":
		case "1377682723004YR":
		case "15913008960024W":
		case "9618349153000CS":
		case "28301JEGR03129" :
			driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='Search']")).click();
			Thread.sleep(2000);
			driver.findElement(AppiumBy.xpath("//android.widget.AutoCompleteTextView[@text='Search']")).sendKeys("Namma");
			Thread.sleep(3000);
			driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Namma Yatri Partner']")).click();
			Thread.sleep(2000);
			driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Allow display over other apps\"]")).click();
			Thread.sleep(2000);
			driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Back\"]")).click();
			Thread.sleep(2000);
			break;
		case "RZ8N91FWYXT":
		case "RFCT42T5N9D":
		case "RZ8R72RE6AB":
		case "8cb2f113":
			driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Namma Yatri Partner']")).click();
			Thread.sleep(4000);
			driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc='Navigate up']")).click();
			Thread.sleep(1000);
			break;
		case "SONJFMDUKV65OJV4":
			driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Namma Yatri Partner']")).click();
			Thread.sleep(4000);
			driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@text='Always']")).click();
			Thread.sleep(1000);
			driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc='Navigate up']")).click();
			Thread.sleep(1000);
			break;
		default: 
			break;
		}
		}
	
	private void batteryOptimizationPopUp() throws InterruptedException{
		switch(driverUdid) {
		case "1371785921000CT":
		case "1377682723004YR":
		case "15913008960024W": 
		case "9618349153000CS":
		case "8cb2f113":
		case "SONJFMDUKV65OJV4":
			driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='ALLOW']")).click();
			break;
		case "RZ8N91FWYXT":
		case "RFCT42T5N9D":
		case "R9ZTB0KD0FA":
		case "RZ8R72RE6AB":
		case "28301JEGR03129" :
			driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Allow']")).click();
			break;
		default:
		    break;
		}
	}
	
	private void notificationAccessPopUp() {
		switch(driverUdid) {
		case "1371785921000CT":
		case "1377682723004YR":
		case "15913008960024W": 
		case "9618349153000CS":
			driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='ALLOW']")).click();
			break;
		case "RZ8N91FWYXT":
		case "RFCT42T5N9D":
		case "R9ZTB0KD0FA":
		case "28301JEGR03129" :
			driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Allow']")).click();
			break;
		default:
		    break;
			
		}
	}
}