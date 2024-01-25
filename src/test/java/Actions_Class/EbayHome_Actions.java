package Actions_Class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Elements.EbayHome_Element;
import Step_Defination.Common_Step;

public class EbayHome_Actions {
	
	private WebDriver driver ;
	EbayHome_Element ebayHome_element;
	
	public EbayHome_Actions (Common_Step comm){
		driver=comm.getDriver();
		ebayHome_element= new EbayHome_Element(driver);
	}
	
	public void clickOnAdvancedLink() {
		ebayHome_element.advancedLink.click();
	}
	
	public void enterDataInSearchBox(String str) {
		ebayHome_element.searchBox.clear();
		ebayHome_element.searchBox.click();
		ebayHome_element.searchBox.sendKeys(str);
	}
	
	public void clickOnSearchBtn() {
		ebayHome_element.searchBtn.click();
	}
	
	public String resultTag() {
		return ebayHome_element.resultTag.getText();
	}
	
	public void selectCategory(String categoryName) {
		Select select = new Select(ebayHome_element.categorydrop);
		select.selectByVisibleText(categoryName);
		
	}
	
	public void clickOnHomePageLinks(String link) {
		WebElement links = driver.findElement(By.linkText(link));
		links.click();
	}
	

}
