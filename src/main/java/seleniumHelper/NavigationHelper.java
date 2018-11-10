/**
 * @author rahul.rathore
 *	
 *	07-Aug-2016
 */
package seleniumHelper;

import java.net.URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;


public class NavigationHelper {
	
	private WebDriver driver;
	private Logger oLog = Logger.getLogger(NavigationHelper.class);

	public NavigationHelper(WebDriver driver) {
		this.driver = driver;
		oLog.debug("NavigationHelper : " + this.driver.hashCode());
	}
	
	public void navigateTo(String url) {
		oLog.info(url);
		driver.get(url);
	}

	public void naviagteTo(URL url) {
		oLog.info(url.getPath());
		driver.get(url.getPath());
	}

	public String getTitle() {
		String title = driver.getTitle();
		oLog.info(title);
		return driver.getTitle();
	}

	public String getCurrentUrl() {
		String url = driver.getCurrentUrl();
		oLog.info(url);
		return driver.getCurrentUrl();
	}
	

}
