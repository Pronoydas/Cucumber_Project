package Actions_Class;

import org.openqa.selenium.WebDriver;

import Step_Defination.Common_Step;

public class Common_Actions {
	 private WebDriver driver;
	
	public Common_Actions (Common_Step comm) {
		this.driver=comm.getDriver();
	}
	
	
	public void openWebsite(String url) {
		driver.get(url);
	}
	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}

}
