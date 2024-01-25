package Step_Defination;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Actions_Class.Common_Actions;
import Actions_Class.EbayHome_Actions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class EbayHome_Step {
	EbayHome_Actions ebayHome_action ;
	Common_Actions   common_actions;
	WebDriver driver ;
	
	
	public EbayHome_Step(EbayHome_Actions ebayHome_action,Common_Actions  common_actions,Common_Step com) {
		this.ebayHome_action=ebayHome_action;
		this.common_actions=common_actions;
		this.driver=com.getDriver();	
	}
	
	@Given ("I am in Ebay Home Page")
	public void I_am_in_Ebay_Home_Page() {
		common_actions.openWebsite("https://www.ebay.com");
		
	}
	@Then("Verify Page Title")
	public void Verify_Page_Title() throws Exception {
		String actualTitle="Electronics, Cars, Fashion, Collectibles & More | eBay";
		String title = common_actions.getPageTitle();
		if(!actualTitle.equals(title)) {
			Assert.fail("Page Tilte is not matching");
		}
		System.out.println("Page Title Is Matching");
	}
	
	@Given("Ebay Home Page Opened")
	public void ebay_Home_Page_Opened() {
		common_actions.openWebsite("https://www.ebay.com");
		
	}
	@When("Click on Advanced Linked")
	public void click_on_Advanced_Linked() {
		ebayHome_action.clickOnAdvancedLink();
		
		WebDriverWait wdw = new WebDriverWait(driver,Duration.ofMillis(10));
		wdw.until(ExpectedConditions.urlContains("sch/ebayadvsearch"));
		
}
	
	@Then("Verify Redirect to Advanced Search Page Open")
	public void verify_Redirect_to_Advanced_Search_Page_Open() throws InterruptedException {
		String expectedTitle="Advanced Search | eBay";
		String actualTString=common_actions.getPageTitle();
		if(!expectedTitle.equals(actualTString)) {
			Assert.fail();
		}
		System.out.println("Successfully Landed To Advanced Search Page");
		
	}
	
	@When("Enter Product Name as {string} that need to Search")
	public void ente_Product_Name_that_need_to_Search(String str) {
//		WebElement searchBox=driver.findElement(By.xpath("//input[@placeholder='Search for anything']"));
//		WebElement searchBtn =driver.findElement(By.xpath("//input[@value='Search']"));
//		searchBox.clear();
//		searchBox.click();
//		searchBox.sendKeys(str);
//		searchBtn.click();
		
		ebayHome_action.enterDataInSearchBox(str);
		ebayHome_action.clickOnSearchBtn();
		WebDriverWait wdw = new WebDriverWait(driver, Duration.ofMillis(30));
		wdw.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//span[normalize-space()='iphone 14 pro max']")),
				str));
		
	}
	
	@Then("Verify Search Result")
	public void verify_Search_Result() {
	String result=ebayHome_action.resultTag();
	if(!result.endsWith("iphone 14 pro max")) {
		Assert.fail("Message Not Matchig" +result);
	}
		
	}
	
	@Given("Ebay Home Page Already Opened")
	public void ebay_Home_Page_Already_Opened() {
		common_actions.openWebsite("https://www.ebay.com");
	
	
	}
	
	@When ("Search for product {string} in {string} category")
	public void search_for_Product_Category(String itemName , String category) {
//		WebElement searchBox=driver.findElement(By.xpath("//input[@placeholder='Search for anything']"));
//		WebElement searchBtn =driver.findElement(By.xpath("//input[@value='Search']"));
//		WebElement categorydrop = driver.findElement(By.id("gh-cat"));
//		searchBox.click();
//		searchBox.clear();
//		searchBox.sendKeys(itemName);
//		Select select = new Select(categorydrop);
//		select.selectByVisibleText(category);
//		searchBtn.click();
		ebayHome_action.enterDataInSearchBox(itemName);
		ebayHome_action.selectCategory(category);
		ebayHome_action.clickOnSearchBtn();
		
	}
	@Then ("Verify Search Result for category")
	public void verify_Search_Result_For_Category() {
		String result=ebayHome_action.resultTag();
		System.out.println(result);
		
	}
	
	@When("Click on Home Page {string}")
	public void click_On_Home_Page(String str) throws Exception {
//		WebElement link = driver.findElement(By.linkText(str));
//		link.click();
		ebayHome_action.clickOnHomePageLinks(str);
		Thread.sleep(3000);
		
	}
	
	@Then("I Verify page {string} and page {string}")
	public void i_Verify_page_Url_And_Page_Title(String url , String tiltle) {
		String currentUrl =common_actions.getCurrentUrl();
		String currentTitle= common_actions.getPageTitle();
		
		if (!currentUrl.equals(url) || !currentTitle.contains(tiltle)) {
			Assert.fail("Url Or Title are not Match "+" "+ "Url==> "+currentUrl+" "+"Title==> "+currentTitle);
		}
		
	}
}


