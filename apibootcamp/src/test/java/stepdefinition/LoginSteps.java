package stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	@Given("user is on login page")
	public void user_is_on_login_page() {
	    System.out.println("inside given");
	}

	@When("user enters")
	public void user_enters() {
		System.out.println("inside when");
	}
	  

	@And("click on login")
	public void click_on_login() {
		System.out.println("inside And");
	   
	}

	@Then("at home page")
	public void at_home_page() {
		System.out.println("inside then");
	    
	}

}
