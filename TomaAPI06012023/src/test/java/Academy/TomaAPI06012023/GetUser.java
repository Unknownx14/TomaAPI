package Academy.TomaAPI06012023;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*; //This import is for given()
import static org.hamcrest.Matchers.*; //This import is for equalTo()

import org.testng.Assert;

import Academy.POJO.GetUserPOJO;

public class GetUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//01. Get a user
		
		String wantedUserID="2";
		int userID = 2;
		String userFirstName = "Janet";
		
		RestAssured.baseURI = "https://reqres.in/";
		
	/*	String response01 = given().log().all()
		.when().get("api/users/"+wantedUserID)
		.then().log().all().assertThat().statusCode(200)
		.header("Server", "cloudflare").extract().response().asString();
		
		System.out.println(response01);
		*/
		
		GetUserPOJO response01 = given().log().all()
		.when().get("api/users/"+wantedUserID)
		.then().log().all().assertThat().statusCode(200)
		.header("Server", "cloudflare").extract().response().as(GetUserPOJO.class);
		
		int pojoID = response01.getData().getId();
		String pojoFirstName = response01.getData().getFirst_name();
		
		System.out.println(pojoID);
		System.out.println(pojoFirstName);
		
		Assert.assertEquals(pojoID, userID);
		Assert.assertEquals(pojoFirstName, userFirstName);
		

	}

}
