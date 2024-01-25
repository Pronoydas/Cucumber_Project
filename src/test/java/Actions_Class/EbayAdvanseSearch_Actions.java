package Actions_Class;

import org.openqa.selenium.WebDriver;

import Elements.EbayAdvanseSearch_Element;
import Step_Defination.Common_Step;
import io.cucumber.datatable.DataTable;

public class EbayAdvanseSearch_Actions {
	private WebDriver driver;
	private EbayAdvanseSearch_Element ebayAdvanseSearch_element;
	
	
	public EbayAdvanseSearch_Actions(Common_Step comm) {
		driver = comm.getDriver();
		ebayAdvanseSearch_element = new EbayAdvanseSearch_Element(driver);
			
	}
	
	public void enterAdvancedSearchData(DataTable dt) {
		ebayAdvanseSearch_element.keywordField.sendKeys(dt.cell(1,0));
		ebayAdvanseSearch_element.excludeField.sendKeys(dt.cell(1,1));
		ebayAdvanseSearch_element.maxField.sendKeys(dt.cell(1,3));
		ebayAdvanseSearch_element.minField.sendKeys(dt.cell(1,2));
		
	}
	
	public void clickOnAdvancedSearchBtn() {
		ebayAdvanseSearch_element.searchbtn.click();
	}
	
	

}
