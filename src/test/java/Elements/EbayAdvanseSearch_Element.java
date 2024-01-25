package Elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EbayAdvanseSearch_Element {
	
	WebDriver driver ;
	
	public EbayAdvanseSearch_Element (WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy (id = "_nkw") public WebElement keywordField ;
	@FindBy(id = "_ex_kw") public WebElement excludeField ;
	@FindBy (xpath = "//input[@aria-label='Enter minimum price range value, $']") public WebElement minField ;
	@FindBy (xpath = "//input[@aria-label='Enter maximum price range value, $']") public WebElement maxField;
	@FindBy (xpath = "//div[@class='adv-form__actions']/button[text()='Search']") public WebElement searchbtn;

}
