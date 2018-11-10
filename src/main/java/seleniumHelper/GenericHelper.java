
package seleniumHelper;

import java.io.File;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.google.common.io.Files;


public class GenericHelper {

	private WebDriver driver;
	private Logger oLog = Logger.getLogger(GenericHelper.class);

	public GenericHelper(WebDriver driver) {
		this.driver = driver;
		oLog.debug("GenericHelper : " + this.driver.hashCode());
	}

	public WebElement getElement(By locator) {
		oLog.info(locator);
		if (IsElementPresentQuick(locator))
			return driver.findElement(locator);

		try {
			throw new NoSuchElementException("Element Not Found : " + locator);
		} catch (RuntimeException re) {
			oLog.error(re);
			throw re;
		}
	}

	/**
	 * Check for element is present based on locator If the element is present
	 * return the web element otherwise null
	 * 
	 * @param locator
	 * @return WebElement or null
	 */

	public WebElement getElementWithNull(By locator) {
		oLog.info(locator);
		try {
			return driver.findElement(locator);
		} catch (NoSuchElementException e) {
			// Ignore
		}
		return null;
	}

	public boolean IsElementPresentQuick(By locator) {
		boolean flag = driver.findElements(locator).size() >= 1;
		oLog.info(flag);
		return flag;
	}

	public String takeScreenShot() {
		oLog.info("");
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	}

	public  void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {

		// Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);

		// Call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		// Move image file to new destination
		File DestFile = new File(fileWithPath);

		// Copy file at destination
		Files.copy(SrcFile, DestFile);
		oLog.info("saved screen shot at location : "+fileWithPath);
		

	}
}
