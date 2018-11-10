/**
 * @author rahul.rathore
 *	
 *	07-Aug-2016
 */
package seleniumHelper;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownHelper  {
	
	private WebDriver driver;
	private Logger oLog = Logger.getLogger(DropDownHelper.class);

	public DropDownHelper(WebDriver driver) {
		
		this.driver = driver;
		oLog.debug("DropDownHelper : " + this.driver.hashCode());
	}
	
	public void SelectUsingVisibleValue(By locator,String visibleValue) {
		SelectUsingVisibleValue(driver.findElement(locator),visibleValue);
	}
	
	public void SelectUsingVisibleValue(WebElement element,String visibleValue) {
		Select select = new Select(element);
		select.selectByVisibleText(visibleValue);
		oLog.info("Locator : " + element + " Value : " + visibleValue);
	}
	
	public void SelectUsingValue(By locator,String value) {
		Select select = new Select(driver.findElement(locator));
		select.selectByValue(value);
		oLog.info("Locator : " + locator + " Value : " + value);
	}
	
	public void SelectUsingIndex(By locator,int index) {
		Select select = new Select(driver.findElement(locator));
		select.selectByIndex(index);
		oLog.info("Locator : " + locator + " Index : " + index);
	}
	
	public String getSelectedValue(By locator) {
		oLog.info(locator);
		return getSelectedValue(driver.findElement(locator));
	}
	
	public String getSelectedValue(WebElement element) {
		String value = new Select(element).getFirstSelectedOption().getText();
		oLog.info("WebELement : " + element + " Value : "+ value);
		return value;
	}
	
	
	public List<String> getAllDropDownValues(WebElement webElement) {
		Select select = new Select(webElement);
		List<WebElement> elementList = select.getOptions();
		List<String> valueList = new LinkedList<String>();
		
		for (WebElement element : elementList) {
			oLog.info(element.getText());
			valueList.add(element.getText());
		}
		return valueList;
	}
}
