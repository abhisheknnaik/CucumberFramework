package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void perform_Search(String search) {
		driver.navigate().to("https://www.amazon.com/s/ref=nb_sb_noss_1?url=search-alias%3Daps&field-keywords="+search);
	}
	
	public void navigateTo_HomePage() {
		driver.get("https://www.amazon.com/");
	}
}
