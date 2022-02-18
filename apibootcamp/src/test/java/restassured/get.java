package restassured;


import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;



public class get {
	@Test
	public void test_1() {
		
			Response res =	given().
						header("Content-Type", "application/JSON").
				when().
						get("https://reqres.in/api/users?page=2").
				then().
						statusCode(200).
						log().all().
						extract().response();				
		
	}
}
