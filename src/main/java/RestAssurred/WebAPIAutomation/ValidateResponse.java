package RestAssurred.WebAPIAutomation;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class ValidateResponse {
	
	@Test
	public void verifyResponse(){
		
		RestAssured.baseURI = "https://maps.googleapis.com";
		given().
		 param("location", "-33.8670522,151.1957362").
		 param("radius", "500").
		 param("type", "restaurant").
		 param("key", "AIzaSyB-ZliaFkPtyfykn7E2nW2yxgBPAvRVUMo").
		 when().
		 get("/maps/api/place/nearbysearch/json").
		 then().assertThat().statusCode(200).and().
		 contentType(ContentType.JSON).and().
		 body("results[0].name", equalTo("The Little Snail Restaurant")).and().
		 body("results[13].name", equalTo("Made In Italy Pyrmont")).and().
		 body("results[5].vicinity", equalTo("48 Pirrama Road, Pyrmont")).and().
		 header("server", "pablo");
		 
	}

}
