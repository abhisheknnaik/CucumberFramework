package seleniumHelper;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsHelper {

	private WebDriver driver;
	private Logger oLog = Logger.getLogger(AlertHelper.class);

	public ActionsHelper(WebDriver driver) {
		this.driver = driver;
		oLog.debug("ActionsHelper : " + this.driver.hashCode());
	}
	
	public void moveToElement(WebElement element)
	{
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

}
