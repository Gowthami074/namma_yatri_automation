package User.Android;
import io.appium.java_client.AppiumBy;
import io.netty.handler.timeout.TimeoutException;
import org.openqa.selenium.WebElement;
import base.BaseClass;
import Driver.DriverprofileScreen;
import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
public class EstimateScreen extends BaseClass {
    String vehicleVariantText;
    @Test
    public void autoAssignDriver() throws InterruptedException {
        Thread.sleep(7000);
        System.out.println("Getting in for estimate");
        // Check for "Book Any" presence
        if (!isBookAnyPresent()) {
            System.out.println("'Book Any' option not found. Skipping to the final element.");
            tapFinalXpath();  // Skip to final tap when "Book Any" is not present
        } else {
            System.out.println("'Book Any' option found. Proceeding...");
            Thread.sleep(2000); // Handle UI transition delay
            driver1.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Book Any']")).click();
            getVehicleVariantFromDriverProfile();
            variantSelectedOrNot();
            tapFinalXpath();  // Tap final element after vehicle selection
        }
    }
    // Method to check if "Book Any" is present
    private boolean isBookAnyPresent() {
        // This method returns true if "Book Any" is found, false otherwise
        return driver1.findElements(AppiumBy.xpath("//android.widget.TextView[@text='Book Any']")).size() > 0;
    }   
    private void getVehicleVariantFromDriverProfile() throws InterruptedException {
        // Get the vehicle variant text from DriverProfileScreen
        DriverprofileScreen driverProfile = new DriverprofileScreen();
        vehicleVariantText = driverProfile.getDriverVehicleVariant();
        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();
        Thread.sleep(2000);
        System.out.println("Coming to tap selected estimate");
    }
    private void tapFinalXpath() {
        // Tapping on the final XPath element
        try {
            driver1.findElement(AppiumBy.xpath("//android.widget.LinearLayout[@content-desc='Back : Button']/../../../android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]")).click();
            System.out.println("Tapped on the final element.");
        } catch (NoSuchElementException e) {
            System.out.println("Final element not found.");
        }
    }
    public void variantSelectedOrNot()  {
        implicitWaitMethod(driver1,5); //This method is defined in BaseClass
        WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(5)); // Set a small explicit wait time
        try {
         wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.LinearLayout[@content-desc='Inside Book Any : " + vehicleVariantText + " Checkbox : selected ']")));
             System.out.println(vehicleVariantText +"Variant already selected");
            
        } catch (Exception e3) {
             System.out.println(vehicleVariantText +"Variant Unselected");
                          WebElement elementUnSelectedElement = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.LinearLayout[@content-desc='Inside Book Any : " + vehicleVariantText + " Checkbox : Un Selected']")));
                          System.out.println(vehicleVariantText +"Variant selected Now");
                elementUnSelectedElement.click();
        }
        implicitWaitMethod(driver1,60);
    }
  
    public void chooseBetweenMultipleDrivers() {
        //Choose between multiple drivers
        driver1.findElement(AppiumBy.xpath("//android.widget.TextView[@test='Choose between multiple drivers']")).click();
        //if chosen this option automatically it will assign hence give sleep of 12-15 sec
    }
    public void confirmRideByChoosingBetweenMultipleDriverOffers() {
    }
    public void autoConfirmFirstDriverOffer() {
    }
    public void cancelAutoConfirm() {
    }
}