package RestAssurred.WebAPIAutomation;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequestExample {

	@Test
	public void GetWeatherDetails() {
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

		// Get the RequestSpecification of the request that you want to sent
		// to the server. The server is specified by the BaseURI that we have
		// specified in the above step.
		RequestSpecification httpRequest = RestAssured.given();

		// Make a request to the server by specifying the method Type and the
		// method URL.
		// This will return the Response from the server. Store the response in
		// a variable.
		Response response = httpRequest.request(Method.GET, "/Pune");

		// Now let us print the body of the message to see what response
		// we have recieved from the server
		String responseBody = response.getBody().asString();
		int responsecode = response.getStatusCode();
		System.out.println(responsecode);
		System.out.println("Response Body is =>  " + responseBody);
		

		HashMap<String, String> cityname = response.jsonPath().getJsonObject("$.");
		System.out.println(cityname);
		System.out.println("name of the city : " + cityname.get("City"));
		Assert.assertEquals(responseBody.contains("Pune"), true, "Response body expected");
//		Assert.assertEquals(actual, expected);

	}

}
