/**
 * @author rahul.rathore
 *	
 *	06-Aug-2016
 */
package seleniumHelper;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author rahul.rathore
 *
 *         06-Aug-2016
 *
 */
public class BrowserHelper {

	private WebDriver driver;
	private Logger oLog = Logger.getLogger(BrowserHelper.class);

	public BrowserHelper(WebDriver driver) {

		this.driver = driver;
		oLog.debug("BrowserHelper : " + this.driver.hashCode());
	}

	public void goBack() {
		driver.navigate().back();
		oLog.info("");
	}

	public void goForward() {
		driver.navigate().forward();
		oLog.info("");
	}

	public void refresh() {
		driver.navigate().refresh();
		oLog.info("");
	}

	public Set<String> getWindowHandlens() {
		oLog.info("Window handles : "+driver.getWindowHandles());
		return driver.getWindowHandles();
	}

	public void SwitchToWindow(int index) {

		LinkedList<String> windowsId = new LinkedList<String>(getWindowHandlens());

		if (index < 0 || index > windowsId.size())
			throw new IllegalArgumentException("Invalid Index : " + index);

		driver.switchTo().window(windowsId.get(index));
		oLog.info(windowsId.get(index));
	}

	/**
	 * Use method when their are multiple window alrady opened 
	 * @param allParents  set of all open parent window handles 
	 */
	public void SwitchToNewWindow(LinkedHashSet<String> allParents) {

		LinkedList<String> windowsId = new LinkedList<String>(getWindowHandlens());

		for (int i = 0; i < windowsId.size(); i++) {
			if (!allParents.contains(windowsId.get(i))) {
				driver.switchTo().window(windowsId.get(i));
				oLog.info("Switched to new  window " + windowsId.get(i));
				break;
			}
		}
	}

	public void switchToParentWindow() {
		LinkedList<String> windowsId = new LinkedList<String>(getWindowHandlens());
		driver.switchTo().window(windowsId.get(0));
		oLog.info("swicthed to parent window : "+windowsId.get(0));
	}

	public void switchToParentWithChildClose() {
		switchToParentWindow();

		LinkedList<String> windowsId = new LinkedList<String>(getWindowHandlens());

		for (int i = 1; i < windowsId.size(); i++) {
			oLog.info("Closing window " + windowsId.get(i));
			driver.switchTo().window(windowsId.get(i));
			driver.close();
		}

		switchToParentWindow();
	}

	public void switchToFrame(By locator) {
		driver.switchTo().frame(driver.findElement(locator));
		oLog.info(locator);
	}

	public void switchToFrame(String nameOrId) {
		driver.switchTo().frame(nameOrId);
		oLog.info(nameOrId);
	}

}
