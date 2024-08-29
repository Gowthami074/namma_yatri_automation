package Driver;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import base.BaseClass;
import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import com.google.common.collect.ImmutableList;

public class DriverCancellation extends BaseClass{

	public void cancelRide() throws InterruptedException {
		System.out.println("Driver cancel about to start");
		DriverCancellation.scroll();
	WebElement homeElement = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Home']"));
	
	//Ride Cancellation Action
	
	driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Cancel Ride']")).click();
	
	Thread.sleep(5000);	
    
    driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Continue']")).click();
	driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Vehicle issue']")).click();
	driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Cancel Ride']")).click();
	//Assert that "Home" Element is present after cancellation
	
	//Assert.assertTrue(homeElement.isDisplayed(), "Home element is not displayed.");
	//homeElement.click();

	
	}
	public static void scroll() {
		System.out.println("Coming scroll");
		Dimension size = DriverCancellation.driver.manage().window().getSize();
		Point midpoint = new Point((int)(size.width*0.5),(int)(size.height*0.5));
		int bottom = midpoint.y + (int)(midpoint.y * 0.75); // can change 0.75 according to need
		int top = midpoint.y - (int)(midpoint.y * 0.75);   // can change 0.75 according to need
		Point start = new Point(midpoint.x , bottom);
		Point end = new Point(midpoint.x,top);
		swipe(start, end , Duration.ofMillis(300));
	}
	public static  void swipe(Point start, Point end, Duration duration) {
		System.out.println("Coming swipe");
		PointerInput input = new PointerInput(PointerInput.Kind.TOUCH,"myfinger"); //put finger on screen
		Sequence swipe = new Sequence(input,1);
		
		swipe.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), start.x,start.y));
		swipe.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg())); // press left button of mouse
		
		swipe.addAction(input.createPointerMove(duration, PointerInput.Origin.viewport(), end.x,end.y));
		swipe.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));//release left button of mouse
		((AppiumDriver)DriverCancellation.driver).perform(ImmutableList.of(swipe));
	}
//	public void verticalSwipeByPercentages(double startPercentage, double endPercentage, double anchorPercentage) {
//        Dimension size = driver.manage().window().getSize();
//        int anchor = (int) (size.width * anchorPercentage);
//        int startPoint = (int) (size.height * startPercentage);
//        int endPoint = (int) (size.height * endPercentage);
//        new TouchAction<AppiumDriver>(driver)
//            .press(PointOption.point(anchor, startPoint))
//            .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
//            .moveTo(PointOption.point(anchor, endPoint))
//            .release()
//            .perform();
//    }
	

}
