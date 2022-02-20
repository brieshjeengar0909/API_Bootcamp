package stepdefinition;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class dataprovider {
	RequestSpecification request;
	Response response;
	
	@DataProvider(name="User")
	public String [][] createUser(){
			return new String [][] {
				{"morpheus", "Leader"},
			     {"ABC", "Leader"},
				{"XYZ", "Teacher"},				
			};
					
	}
@Test(dataProvider="User")
@Given("API for testing POST method with data provider")
public void api_for_testing_POST_method_with_data_provider(String name, String profile) {
	System.out.println("Given");
	RestAssured.baseURI="https://reqres.in";	
	request=given().header("content-type","application/json").
			body("{\r\n"
					+ "    \"name\": \""+name+"\",\r\n"
					+ "    \"job\": \""+profile+"\"\r\n"
					+ "}");
   
}
@Test
@When("posted with data provider")
public void posted_with_data_provider() {
	System.out.println("When");
	String path="api/users";
	response=request.post(path).then().log().all().extract().response();
   
}
@Test
@Then("validate response code")
public void validate_response_code() {
	System.out.println("Then");
	System.out.println("response status code : "+response.getStatusCode()); 
   
}

}
