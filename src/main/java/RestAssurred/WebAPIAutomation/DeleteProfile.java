package RestAssurred.WebAPIAutomation;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteProfile {

	@Test
	public void deleteProfile() {

		RestAssured.baseURI = "http://dummy.restapiexample.com";

		RequestSpecification httpRequest = RestAssured.given();

		Response response = httpRequest.request(Method.DELETE, "/api/v1/delete/164392");

		String responseBody = response.getBody().asString();
		int responsecode = response.getStatusCode();
		System.out.println(responsecode);
		System.out.println("Response Body is =>  " + responseBody);

	}
}
