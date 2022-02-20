package stepdefinition;

import io.cucumber.java.en.*;
import static io.restassured.RestAssured.given;

import org.junit.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Parsing {
	RequestSpecification request;
	Response response;
	@Given("API for testing Post register")
	public void api_for_testing_post_register() {
	   
		System.out.println("Given");
		RestAssured.baseURI="https://reqres.in";	
		request=given().header("content-type","application/json").
				body("{\r\n"
						+ "    \"email\": \"eve.holt@reqres.in\",\r\n"
						+ "    \"password\": \"pistol\"\r\n"
						+ "}");
	}

	@When("post with correct information")
	public void post_with_correct_information() {
	   
		System.out.println("When");
		String path="api/register";
		response=request.post(path).then().log().all().extract().response();
	}

	@Then("validate positive response code received for successful register")
	public void validate_positive_response_code_received_for_successful_register() {
	    
		System.out.println("Then");
		Assert.assertEquals(200, response.getStatusCode());
		
	}

}
