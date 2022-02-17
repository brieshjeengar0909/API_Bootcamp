package stepdefinition;

import org.junit.Assert;
import static io.restassured.RestAssured.given;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Assertion {
	RequestSpecification request;
	Response response;
	
	@Given("API for testing")
	public void api_for_testing() {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
		System.out.println("Given");
		RestAssured.baseURI="https://reqres.in";	
		request=given().header("content-type","application/json").
				body("{\r\n"
						+ "    \"name\": \"ABC\",\r\n"
						+ "    \"job\": \"leader\"\r\n"
						+ "}");
		
	}

	@When("posted with correct information")
	public void posted_with_correct_information() {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
		System.out.println("When");
		String path="api/users";
		response=request.post(path).then().log().all().extract().response();
		
	}

	@Then("validate positive response code received")
	public void validate_positive_response_code_received() {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
		System.out.println("Then");
		System.out.println("response status code : "+response.getStatusCode()); 
		System.out.println("response status line : "+response.getStatusLine());
		Assert.assertEquals("HTTP/1.1 201 Created", response.getStatusLine());
		Assert.assertEquals(201, response.getStatusCode());
		Assert.assertEquals("application/json; charset=utf-8", response.getContentType());
		System.out.println("response content type : "+response.getContentType());
	}

}
