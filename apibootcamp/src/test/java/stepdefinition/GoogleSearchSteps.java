package stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class GoogleSearchSteps {
	
	WebDriver driver=null;
	
	@Given("browser is open")
	public void browser_is_open() {
		System.out.println("inside step- browser open");
		String projectPath=System.getProperty("use.dir");
		System.setProperty("webdriver.chrome.driver", "C:/Users/Administrator/git/API_Bootcamp/apibootcamp/src/test/resources/drivers/chromedriver.exe");
		driver  = new ChromeDriver();
	    System.out.println("project path is"+projectPath);
	}

	@And("usr is on google search page")
	public void usr_is_on_google_search_page() {
		System.out.println("inside step-usr is on google search page");
		driver.navigate().to("https://google.com");
	    
	}

	@When("user enters a text in search box")
	public void user_enters_a_text_in_search_box() {
		System.out.println("inside step-user enters a text in search box");
		driver.findElement(By.id("input")).sendKeys("facebook");
	   
	}

	@And("hits enter")
	public void hits_enter() {
		System.out.println("inside step-hits enter");
		driver.findElement(By.id("input")).sendKeys(Keys.ENTER);
	   
	}

	@Then("user is navigated to search results")
	public void user_is_navigated_to_search_results() {
		System.out.println("inside step-user is navigated to search results");
		driver.getPageSource().contains("Log In");
		driver.close();
		driver.quit();
	   
	}


}
