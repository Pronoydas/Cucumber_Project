package Elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EbayHome_Element {
	WebDriver driver ;
	
	public EbayHome_Element (WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy (linkText = "Advanced") public WebElement advancedLink ;
	@FindBy (xpath = "//input[@placeholder='Search for anything']") public WebElement searchBox;
	@FindBy (xpath = "//input[@value='Search']") public WebElement searchBtn ;
	@FindBy (xpath = "//h1[@class=\"srp-controls__count-heading\"]") public WebElement resultTag ;
	@FindBy (id = "gh-cat") public WebElement categorydrop ;
	
	
	
	

}
