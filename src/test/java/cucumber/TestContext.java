package cucumber;

import managers.PageObjectManager;
import managers.WebDriverManagerClass;

public class TestContext {
	private WebDriverManagerClass webDriverManager;
	private PageObjectManager pageObjectManager;
	
	public TestContext(){
		webDriverManager = new WebDriverManagerClass();
		pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
	}
	
	public WebDriverManagerClass getWebDriverManager() {
		return webDriverManager;
	}
	
	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}

}