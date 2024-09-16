package User.Android;

import java.util.Arrays;

import org.testng.annotations.IFactoryAnnotation;

import base.BaseClass;
import io.appium.java_client.AppiumBy;

public class DevicePermission extends BaseClass {

	public static void autoSuggestionDecline() {
		System.out.println(udids.get(2));
		if (Arrays.asList("15913008960024W", "RFCT42T5N9D", "SONJFMDUKV65OJV4", "28301JEGR03129", "R9ZTB0KD0FA", "1371785921000CT", "RZ8N91FWYXT").contains(udids.get(2))) {

			driver1.findElement(AppiumBy.xpath("//android.widget.Button[@text='NONE OF THE ABOVE']")).click();

		} else if (Arrays.asList("", "", "").contains(udids.get(2))) {


			driver1.findElement(AppiumBy.xpath("//android.widget.Button[@text='None of the above']")).click();

		} else {
			System.out.println("No action required for this Udid: " + udids.get(2));
		}
	}

	public static void locationPermissionsConfirmation() {

		if(Arrays.asList("15913008960024W", "1377682723004YR", "1371785921000CT").contains(udids.get(2)))
		{
			driver1.findElement(AppiumBy.xpath("//android.widget.Button[@text='WHILE USING THE APP']")).click();

		}
		else if (Arrays.asList("8cb2f113", "RFCT42T5N9D", "SONJFMDUKV65OJV4", "28301JEGR03129", "R9ZTB0KD0FA", "RZ8N91FWYXT").contains(udids.get(2))) {

			driver1.findElement(AppiumBy.xpath("//android.widget.Button[@text='While using the app']")).click();

		}
		else {
			System.out.println("No action required for this Udid: " + udids.get(2));
		}

	}

	public static void notification() {
		if(Arrays.asList("1371785921000CT", "15913008960024W").contains(udids.get(2)))
		{

			driver1.findElement(AppiumBy.xpath("//android.widget.Button[@text='ALLOW']")).click();

		}
		else if (Arrays.asList("RZ8N91FWYXT").contains(udids.get(2)))
		{
			driver1.findElement(AppiumBy.xpath("//android.widget.Button[@text='Allow']")).click();

		}
		else {
			System.out.println("No action required for this Udid: " + udids.get(2));

		}
	}

}
