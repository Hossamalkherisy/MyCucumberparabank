package stepsDefinitions;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Base.BaseUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsLogin extends BaseUtil{

	private BaseUtil baseUtil;
	
	public StepsLogin(BaseUtil baseUtil)
	{
		this.baseUtil=baseUtil;
	}
	private WebDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Win 10/eclipse-workspace/MyCucumberPJava/resources/chromedriver.exe");
		driver = new ChromeDriver();
		
	}
	
	@Given("I am in the login page of the para Bank Appliction")
	public void i_am_in_the_login_page_of_the_para_bank_appliction() {
		
		
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		driver.manage().window().maximize();
	}

	@When("I enter valid {string} and {string} with {string}")
	public void i_enter_valid_credentials( String username ,String password,String userFullName1) {
		baseUtil.userFullName=userFullName1;
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("username")).submit();
	}

	@Then("I should be taken to Overview page")
	public void i_should_be_taken_to_overview_page() throws Exception {
		
		Thread.sleep(1000);
	
		String actualuserFullName = driver.findElement(By.className("smallText")).getText().toString();
		assertTrue(actualuserFullName, actualuserFullName.contains(baseUtil.userFullName));
        driver.findElement(By.xpath("//*[@id=\"leftPanel\"]/ul/li[8]/a")).click();

        
	}
	@After
	public void quitBrowser() {
		driver.quit();
	}
	

}
