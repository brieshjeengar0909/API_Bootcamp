package stepdefinition;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

import org.junit.Assert;

public class NegativeScenario {
	RequestSpecification request;
	Response response;
	
	@Given("API for testing negative get method")
	public void api_for_testing_negative_get_method() {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
		System.out.println("Given");
		
		RestAssured.baseURI="https://reqres.in";	
		request=given().header("content-type","application/json");
		
	}

	@When("retrieved incorrect information")
	public void retrieved_incorrect_information() {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
		System.out.println("When");
		String path="api/unknown/23";
		response=request.get(path).then().log().all().extract().response();
		
	}

	@Then("Validate negative response code for negative get method")
	public void validate_negative_response_code_for_negative_get_method() {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
		System.out.println("Then");
		Assert.assertEquals(404, response.getStatusCode());
		
	}

	@Given("API for testing negative post method")
	public void api_for_testing_negative_post_method() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		System.out.println("Given");
		RestAssured.baseURI="https://reqres.in";	
		request=given().header("content-type","application/json").
				body("{\r\n"
						+ "    \"email\": \"sydney@fife\"\r\n"
						+ "}");
	}

	@When("posted incorrect information")
	public void posted_incorrect_information() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		System.out.println("When");
		String path="api/register";
		response=request.post(path).then().log().all().extract().response();
	}

	@Then("Validate negative response code for negative post method")
	public void validate_negative_response_code_for_negative_post_method() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		System.out.println("Then");
		System.out.println("response status code : "+response.getStatusCode()); 
		System.out.println("response status line : "+response.getStatusLine());
		//Assert.assertEquals("HTTP/1.1 201 Created", response.getStatusLine());
		Assert.assertEquals(400, response.getStatusCode());
	}

}
