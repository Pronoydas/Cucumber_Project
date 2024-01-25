package Step_Defination;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Common_Step {
	private WebDriver driver ;
	
	@Before
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		System.out.println("Global Before Hook Executed !!");
	}
	
	@Before("@BeforeHookTag")
	public void beforeHook() {
		System.out.println("Scenario Base Before Hook Executed !!");
		
	}
	
	@After
	public void tearDown(Scenario scenario) throws Exception {
		if(scenario.isFailed()) {
			final byte[] scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(scr, "image/png", scenario.getName());
		}
		driver.quit();
		System.out.println("Global After Hook Executed");
		Thread.sleep(1000);
	}
	
	@After("@AfterHookTag")
	public void afterHook() {
		System.out.println("Scenario Base After Hook Executed !!");
	}

	public WebDriver getDriver() {
		return driver;
	}
	
	
	
	

}
