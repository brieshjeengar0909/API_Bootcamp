package stepdefinition;
import org.testng. annotations.DataProvider;
import org.testng. annotations. Test;
import io.restassured.RestAssured;

public class parameterisation {

	
	public class DataParameterize {
	@DataProvider (name = "DeleteData")
	public Object[] dataForDelete() {
	return new Object[] {4,5,6,7};
	}
	@Test (dataProvider = "DeleteData") 
	public void test_delete(int userid) {
	 RestAssured.baseURI = "https://reqres.in/api/users?page=2";
	  RestAssured.given()
	  .when()
	  .delete("/users/"+userid).
	  then ().
	  statusCode (204);
	}
	}
}
