package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import seleniumHelper.ButtonHelper;

public class CartPage {

	WebDriver driver;
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	@FindBy(how = How.ID, using = "nav-cart-count") 
	private WebElement btn_Cart;
	
	@FindBy(how = How.NAME, using = "proceedToCheckout") 
	private WebElement btn_ContinueToCheckout;
	
	
	public void clickOn_Cart() {
	//	btn_Cart.click();
		new ButtonHelper(driver).click(btn_Cart);
	}
	
	public void clickOn_ContinueToCheckout(){
		btn_ContinueToCheckout.click();
		try { Thread.sleep(5000);}
		catch (InterruptedException e) {}
	}
}
