package appium;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class MyAppium {
	// http://www.automationtestinghub.com/appium-tutorial/

	// **********************
	// use C:\Users\DELL\AppData\Local\Android\android-sdk\platform-tools>adb
	// devices
	// if only adb devices is not working
	// ******************
	public static void main(String[] args) throws InterruptedException {
		 calculator();
		//playstore();
	}

	public static void calculator() throws InterruptedException {

		// AppiumDriver<MobileElement> driver = null;
		AppiumDriver<MobileElement> driver = null;
		// Set the Desired Capabilities
		// cmd for getting device id and name etc
		//---------------
		// C:\Users\DELL\AppData\Local\Android\android-sdk\platform-tools>adb
		// devices
		//-------------
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Micromax A120");
		caps.setCapability("udid", "0123456789ABCDEF"); // Give Device ID of
														// your mobile phone
		// Mobile setting will give the platform version
		// settings > about phone
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "4.4.2");
		// open app you want to test
		// http://www.automationtestinghub.com/apppackage-and-appactivity-name/
		// com.android.vending
		// enter below 2 commands for getting appPackage and appActivity
		//--------------------
		// adb shell
		// shell@A120:/ $ dumpsys window windows | grep -E 'mCurrentFocus'
		//---------------
		// mCurrentFocus=Window{427352a8 u0
		// com.android.calculator2/com.android.calculator2.Calculator}
		caps.setCapability("appPackage", "com.android.calculator2");
		caps.setCapability("appActivity", "com.android.calculator2.Calculator");
		caps.setCapability("noReset", "true");

		// Instantiate Appium Driver
		try {

			// start appium server using destop app 'appium':
			// appipum >advance > start server get server
			// Default values : address 0.0.0.0 and port : 4723
			driver = new AndroidDriver<MobileElement>(new URL(
					"http://0.0.0.0:4723/wd/hub"), caps);

		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}

		// Added 5 seconds wait so that the app loads completely before starting
		// with element identification

		Thread.sleep(2000);
		// open uiautomatorviewer.bat for locating elements
		// C:\Users\DELL\AppData\Local\Android\android-sdk\tools\bin\ uiautomatorviewer.bat 
		// click on capture screen shot
		// Find Google Play element using ID property and click on it
		driver.findElement(By.id("com.android.calculator2:id/digit1")).click();

		driver.findElement(By.id("com.android.calculator2:id/plus")).click();
		driver.findElement(By.id("com.android.calculator2:id/digit5")).click();
		driver.findElement(By.id("com.android.calculator2:id/equal")).click();

		//
		Thread.sleep(2000);
		// Find 'Google Play Store' element and set the value Google
		// CharSequence[] c=new CharSequence "Google";
		String result = driver.findElement(
				By.className("android.widget.EditText")).getText();
		System.out.println(result);

		// Press Enter key from Keyboard using any of the below methods
		((AndroidDriver<MobileElement>) driver).pressKeyCode(66);

	}

	public static void playstore() throws InterruptedException {

		// AppiumDriver<MobileElement> driver = null;
		AppiumDriver driver = null;
		// Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Micromax A120");
		caps.setCapability("udid", "0123456789ABCDEF"); // Give Device ID of
														// your mobile phone
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "4.4.2");
		// com.android.vending
		// command for getting appPackage and appActivity
		// dumpsys window windows | grep -E �mCurrentFocus�
		caps.setCapability("appPackage", "com.android.vending");
		// shell@A120:/ $ dumpsys window windows | grep -E 'mCurrentFocus'
		// mCurrentFocus=Window{427352a8 u0
		// com.android.calculator2/com.android.calculator2.Calculator}
		caps.setCapability("appActivity",
				"com.google.android.finsky.activities.MainActivity");
		caps.setCapability("noReset", "true");

		// Instantiate Appium Driver
		try {
			driver = new AndroidDriver<MobileElement>(new URL(
					"http://0.0.0.0:4723/wd/hub"), caps);

		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}

		// Added 5 seconds wait so that the app loads completely before starting
		// with element identification

		Thread.sleep(5000);

		// Find Google Play element using ID property and click on it
		driver.findElement(By.id("com.android.vending:id/search_box_idle_text"))
				.click();
		Thread.sleep(2000);
		// Find 'Google Play Store' element and set the value Google
		// CharSequence[] c=new CharSequence "Google";
		driver.findElement(
				By.id("com.android.vending:id/search_box_text_input"))
				.sendKeys("BMS");

		// Press Enter key from Keyboard using any of the below methods
		((AndroidDriver<MobileElement>) driver).pressKeyCode(66);

		// OR
		// The below code might now work for you, as some keyboards use Search
		// button instead of ENTER. Hence,
		// there are chances that the below line would fail on specific devices
		// driver.findElement(By.id("com.android.vending:id/search_box_text_input")).sendKeys(Keys.ENTER);

	}

}