package Step_Defination;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Actions_Class.Common_Actions;
import Actions_Class.EbayAdvanseSearch_Actions;
import Actions_Class.EbayHome_Actions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EbayAdvanceSearch_Step {
	private WebDriver driver ;
	private EbayHome_Actions ebayhome_actions;
	private EbayAdvanseSearch_Actions ebayadvanceSearch_actions ;
	private Common_Actions comm;
	
	public EbayAdvanceSearch_Step(Common_Step cs,EbayHome_Actions ebayhome_actions,EbayAdvanseSearch_Actions ebayadvanceSearch_actions,Common_Actions comm) {
		this.driver = cs.getDriver();
		this.ebayhome_actions=ebayhome_actions;
		this.ebayadvanceSearch_actions = ebayadvanceSearch_actions;
		this.comm=comm;
	}
	
	
	@Given("I am on Ebay Advanced Search Page")
	public void i_Am_On_Ebay_Advanced_Search_Page() {
//		driver.get("https://www.ebay.com");
//		driver.findElement(By.linkText("Advanced")).click();
		
		comm.openWebsite("https://www.ebay.com");
		ebayhome_actions.clickOnAdvancedLink();
		WebDriverWait wdw = new WebDriverWait(driver,Duration.ofMillis(10));
		wdw.until(ExpectedConditions.urlContains("sch/ebayadvsearch"));
		
	}
	
	@When("I advanced search on item")
	public void i_Advanced_Search_On_Item(DataTable datatable) throws InterruptedException {
//		WebElement keywordField = driver.findElement(By.id("_nkw"));
//		WebElement excludeField = driver.findElement(By.id("_ex_kw"));
//		WebElement minField = driver.findElement(By.xpath("//input[@aria-label='Enter minimum price range value, $']"));
//		WebElement maxField = driver.findElement(By.xpath("//input[@aria-label='Enter maximum price range value, $']"));
//		WebElement searchbtn = driver.findElement(By.xpath("//div[@class='adv-form__actions']/button[text()='Search']"));
//		
		System.out.println(datatable.cell(0,0)+" "+datatable.cell(0, 1)+" "+datatable.cell(0, 2)+" "+datatable.cell(0,3));
		
//		keywordField.sendKeys(datatable.cell(1,0));
//		excludeField.sendKeys(datatable.cell(1,1));
//		minField.sendKeys(datatable.cell(1,2));
//		maxField.sendKeys(datatable.cell(1,3));
//		searchbtn.click();
		
		ebayadvanceSearch_actions.enterAdvancedSearchData(datatable);
		ebayadvanceSearch_actions.clickOnAdvancedSearchBtn();
		Thread.sleep(3000);	
	}
	
	@Then("Verify Search Result for Advanced Search")
	public void verify_Search_Result_For_Advanced_Search() {
		String result=ebayhome_actions.resultTag();
		System.out.println(result);
		
	}

}
