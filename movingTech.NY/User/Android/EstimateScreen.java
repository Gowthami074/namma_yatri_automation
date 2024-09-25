package User.Android;

import io.appium.java_client.AppiumBy;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;

import base.BaseClass;
import Driver.DriverprofileScreen;

import java.time.Duration;
import java.util.Arrays;
import java.util.NoSuchElementException;

import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.Test;

public class EstimateScreen extends BaseClass {

	
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
		        selectVehicleVariant();
		    	driver1.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Book Any']")).click();
		        tapFinalXpath();  // Tap final element after vehicle selection
		    }

		    System.out.println("Estimate button selected");
		    Thread.sleep(2000);
		}

		// Method to check if "Book Any" is present
		private boolean isBookAnyPresent() {
		    // This method returns true if "Book Any" is found, false otherwise
		    return driver1.findElements(AppiumBy.xpath("//android.widget.TextView[@text='Book Any']")).size() > 0;
		}

		private void selectVehicleVariant() throws InterruptedException {
		    // Get the vehicle variant text from DriverProfileScreen
		    DriverprofileScreen driverProfile = new DriverprofileScreen();
		    String vehicleVariantText = driverProfile.getDriverVehicleVariant();
		    driver.navigate().back();
		    driver.navigate().back();
		    driver.navigate().back();

		    Thread.sleep(2000);
		    System.out.println("Coming to tap selected estimate");

		    // Scroll and select vehicle variant
		    estimateScroll(vehicleVariantText); // Pass the extracted text to the scroll method
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

		public void estimateScroll(String searchText) {
		    // Get the screen size
		    Dimension screenSize = driver1.manage().window().getSize();
		    int screenHeight = screenSize.height;
		    int screenWidth = screenSize.width;

		    // Define start and end coordinates
		    int startX = screenWidth / 2; // Center of the screen
		    int startY = (int) (screenHeight * 0.8); // Start 80% down the screen
		    int endY = (int) (screenHeight * 0.2); // End 20% down the screen

		    boolean elementFound = false;

		    while (!elementFound) {
		        try {
		            // Attempt to find the element using the extracted text
		            WebElement element = driver1.findElement(AppiumBy.xpath("//android.widget.TextView[@text='" + searchText + "']"));
		            // Check if the element is already selected
		            if (!element.isSelected()) {
		                element.click();
		                System.out.println("Vehicle variant was not selected. Now clicked: " + searchText);
		            } else {
		                System.out.println("Vehicle variant is already selected: " + searchText);
		            }
		            elementFound = true; // Element found, break the loop
		        } catch (NoSuchElementException e) {
		            // Element not found, perform scroll
		            System.out.println("Element not found, scrolling...");

		            // Create a new touch input
		            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		            Sequence swipe = new Sequence(finger, 1);

		            // Move to the start point
		            swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
		            // Tap down
		            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		            // Move to the end point
		            swipe.addAction(finger.createPointerMove(Duration.ofMillis(1500), PointerInput.Origin.viewport(), startX, endY));
		            // Release
		            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		            // Perform the action
		            driver1.perform(Arrays.asList(swipe));

		            System.out.println("Scroll is done via code");
		        }
		    }
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
