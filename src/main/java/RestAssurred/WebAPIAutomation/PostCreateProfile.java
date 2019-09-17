package RestAssurred.WebAPIAutomation;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class PostCreateProfile {

	@Test
	public void verifyProfileCreated() {
		
		
		RestAssured.baseURI="http://dummy.restapiexample.com";
		
//		JSONObject requestParams = new JSONObject();
//		
//		requestParams.put("name", "ABDUL BADI"); 
//		requestParams.put("job", "TEST ANALYST");
		
		String requestParams = "{\r\n" + 
				"  \"name\": \"BADI ABDUL INFOSYS NEW\",\r\n" + 
				"  \"salary\": \"123\",\r\n" + 
				"  \"age\": \"23\"\r\n" + 
				"}";
		
		
		RequestSpecification httpReq_var= RestAssured.given().contentType(ContentType.JSON).body(requestParams);
		
		
		
		
		Response res = httpReq_var.given().queryParam("Content-Type", "application/json")
				.when().post("/api/v1/create").then().assertThat().statusCode(200).extract().response();
		
		String response = res.asString();
		System.out.println(response);
		
	}
}
