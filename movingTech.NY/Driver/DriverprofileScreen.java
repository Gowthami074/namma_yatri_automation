package Driver;

import org.openqa.selenium.WebElement;
import base.BaseClass;
import io.appium.java_client.AppiumBy;

public class DriverprofileScreen extends BaseClass {
	
	String vehicleText = "";

    public String getDriverVehicleVariant() throws InterruptedException{
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text= 'Offline']/../../../../android.widget.LinearLayout[1]")).click(); //profileAvator
        Thread.sleep(2000);
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text= 'Settings']")).click(); //Settings
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text= 'Booking Preferences']")).click(); //BookingPreference
        
        String vehicleXpath = "//android.widget.TextView[@text= 'Your Vehicle']/../android.widget.TextView[2]"; // XPath to get vehicle variant text

        //String vehicleText = "";
        try {
            // Locate the element using the XPath
            WebElement vehicleElement = driver.findElement(AppiumBy.xpath(vehicleXpath));
            
            // Get the text from the element
            vehicleText = vehicleElement.getText();
            System.out.println("Logged In Driver Vehicle variant is: " + vehicleText);
        } catch (Exception e) {
            System.out.println("Element not found using the XPath: " + vehicleXpath);
            e.printStackTrace();
        }
        return vehicleText;
    }
}
