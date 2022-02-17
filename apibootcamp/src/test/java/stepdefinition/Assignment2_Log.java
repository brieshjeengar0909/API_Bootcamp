package stepdefinition;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

import org.junit.Assert;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Assignment2_Log {
	RequestSpecification request;
	Response response;
	@Given("Api for testing")
	public void api_for_testing1() {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
		System.out.println("Given");
		RestAssured.baseURI="https://reqres.in";	
		request=given().header("content-type","application/json");
		
	}

	@When("Retrieve correct information")
	public void retrieve_correct_information() {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
		System.out.println("When");
		String path="api/users?page=2";
		response=request.get(path).then().log().all().extract().response();
	}

	@Then("validate positive response code")
	public void validate_positive_response_code() {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
		System.out.println("Then");
		Assert.assertEquals(200, response.getStatusCode());
	}

}
