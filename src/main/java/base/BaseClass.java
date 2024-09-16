package base;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.LocksDevice;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class BaseClass{
	protected static AppiumDriver driver; 
	protected static AppiumDriver driver1;
	protected static AndroidDriver androidDriver;
	public static String rideOTP = null;
	public static String userDeviceUdid =null;
	public static String driverVechileVariant;
	public static List<String> udids;

	@BeforeTest
	public void setUp() throws MalformedURLException {
		try {
			udids = getDeviceUDIDs(); 
			System.out.println("Device1 udid "+udids.get(1));
			System.out.println("Device2 udid "+udids.get(2));
			
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability("platformName", "Android");
			cap.setCapability("udid", udids.get(1));
			cap.setCapability("automationName", "UIAutomator2");
            cap.setCapability("unlockKey", "14789");
            cap.setCapability("unlockType", "pattern");
			cap.setCapability("newCommandTimeout", 600);
			cap.setCapability("app", "/Users/gowthami.allu/Documents/NammaYatriAutomation/movingTech.NY/Resources/driver-2-sept-master.apk");
			//driver = new AppiumDriver(new URL("http://0.0.0.0:4723"), cap);
			driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
            if(((LocksDevice) driver).isDeviceLocked())
			{
				((LocksDevice) driver).unlockDevice();			
			}
			else
			{
				System.out.println("Already ulocked");		
			}
//			//logger.info("Driver App Launched Successfully");

			// Launch User App
			DesiredCapabilities cap1 = new DesiredCapabilities();

			cap1.setCapability("platformName", "Android");
			cap1.setCapability("udid", udids.get(2)); 
			cap1.setCapability("automationName", "UIAutomator2");
			cap1.setCapability("unlockKey", "14789");
			cap1.setCapability("unlockType", "pattern");
			cap1.setCapability("newCommandTimeout", 600);
			cap1.setCapability("app", "/Users/gowthami.allu/Documents/NammaYatriAutomation/movingTech.NY/Resources/user-2-sept-master.apk");
//			driver1 = new AppiumDriver(new URL("http://0.0.0.0:4723"), cap1);
			driver1 = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap1);// appium driver casted to Android driver
		
			driver1.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);


		
			if(((LocksDevice) driver).isDeviceLocked())
			{
				((LocksDevice) driver).unlockDevice();			
			}
			else
			{
				System.out.println("Already ulocked");		
			}



		} catch (Exception exp) {
			System.out.println("Cause is: " + exp.getCause());
			System.out.println("Message is: " + exp.getMessage());
			exp.printStackTrace();
		}
	}
	 public static AndroidDriver getAndroidDriver() {
	        return androidDriver;
	    }

	    public static AppiumDriver getAppiumDriver() {
	        return driver1;
	    }

	//	@Test
	//	public void sampleTest() throws InterruptedException {
	//		System.out.println("I'm here");
	//		DriverLoginFlow ab = new DriverLoginFlow();
	//		ab.successfulDriverLogin();
	//
	//	}

	public void scrollToText(String text) {

		driver.findElement(
				new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))"
						+ ".scrollIntoView(new UiSelector()" + ".textMatches(\"" + text + "\").instance(0))"));
	}

	public static List<String> getDeviceUDIDs() {
		List<String> udids = new ArrayList<>();
		try {
			
			ProcessBuilder processBuilder = new ProcessBuilder("/usr/local/bin/adb", "devices", "-l");   
			//	        System.out.println(System.getenv("PATH"));
			Process process = processBuilder.start();
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				if (line.contains("device")) {
					String[] parts = line.split("\\s+");
					if (parts.length > 0) {
						udids.add(parts[0]);
					
						
					}
				} 
			}
			process.waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return udids;
	}
	@AfterTest
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
		if (driver1 != null) {
			driver1.quit();
	}
		
		
	
	
}}
