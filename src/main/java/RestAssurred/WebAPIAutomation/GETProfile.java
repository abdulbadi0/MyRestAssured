package RestAssurred.WebAPIAutomation;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GETProfile {
	
	@Test
	public void getProfile() {
		
		
		RestAssured.baseURI = "http://dummy.restapiexample.com";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		Response response = httpRequest.request(Method.GET, "/api/v1/employee/164392");
		
		String responseBody = response.getBody().asString();
		int responsecode = response.getStatusCode();
		System.out.println(responsecode);
		System.out.println("Response Body is =>  " + responseBody);
		

//		HashMap<String, String> cityname = response.jsonPath().getJsonObject("$.");
//		System.out.println(cityname);
//		System.out.println("name of the city : " + cityname.get("City"));
//		Assert.assertEquals(responseBody.contains("Pune"), true, "Response body expected");
		
	}

}
