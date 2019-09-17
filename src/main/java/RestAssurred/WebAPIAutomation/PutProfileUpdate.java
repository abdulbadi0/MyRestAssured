package RestAssurred.WebAPIAutomation;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutProfileUpdate {
	
	@Test
	public void verifyProfileUpdated() {
		
		
		RestAssured.baseURI="http://dummy.restapiexample.com";
		
		
		String requestParams = "{\r\n" + 
				"  \"name\": \"BADI ABDUL\",\r\n" + 
				"  \"salary\": \"1123\",\r\n" + 
				"  \"age\": \"82\"\r\n" + 
				"}";
		
		 RequestSpecification httpRequestPut = RestAssured.given().contentType(ContentType.JSON).body(requestParams);
		
		Response res =  httpRequestPut.given().queryParam("Content-Type", "application/json")
		 .when().put("/api/v1/update/164392")
		 .then().assertThat().statusCode(200).extract().response();
		
		String response = res.asString();
		System.out.println(response);
	}

}
