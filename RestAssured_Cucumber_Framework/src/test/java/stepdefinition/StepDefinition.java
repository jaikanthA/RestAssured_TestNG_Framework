package stepdefinition;

import static org.testng.Assert.assertEquals;

import org.apache.http.HttpRequest;
import org.json.simple.JSONObject;
import org.testng.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class StepDefinition {
	
	Response response;
@Given("^I Set GET Request API URI$")
public void i_Set_GET_Request_API_URI() throws Throwable {
    // Specify Base URI
	RestAssured.baseURI="https://reqres.in";
	
	
}

@When("^Send the GET HTTP Request$")
public void send_the_GET_HTTP_Request() throws Throwable {
	
	RequestSpecification httpRequest = RestAssured.given();
	//Response Object
	  response=httpRequest.request(Method.GET,"/api/users?page=2");

}

@Then("^I receive valid Response$")
public void i_receive_valid_Response() throws Throwable {
	int statusCode=response.getStatusCode();
	System.out.println("Status code is :"+statusCode);
	assertEquals(statusCode, 200);

}


/*---------------------------------------------------------------*/
RequestSpecification httpRequest;
JSONObject requestparams;

@Given("^I set POST Request API URI$")
public void i_set_POST_Request_API_URI() throws Throwable {
	//Specify Base URI
		RestAssured.baseURI="https://reqres.in";
}

@Given("^Add request parameters$")
public void add_request_parameters() throws Throwable {

	//Request Object
	 httpRequest=RestAssured.given();
	//Request parameters -->Request payload sending along with POST request ie)Body of the request 
	 requestparams=new JSONObject();
	 requestparams.put("name", "Jai");
	 requestparams.put("job", "QA");
		
}

@Given("^Adding Request object and then adding Header$")
public void adding_Request_object_and_then_adding_Header() throws Throwable,Exception {

 httpRequest.header("Content-Type","application/json");
 httpRequest.body(requestparams.toJSONString()); 
}
@When("^Send the POST Request$")
public void send_the_POST_Request() throws Throwable,Exception {

	//Response object
		 response=httpRequest.request(Method.POST,"/api/users");
		 
		 //Printing the response body in console
		 String responseBody=response.getBody().asString();
			System.out.println("The Response body is: "+responseBody);
}


@Then("^Validate the Response$")
public void validate_the_Response() throws Throwable,Exception {
	int statusCode=response.getStatusCode();
	System.out.println("Status code is :"+statusCode);
	assertEquals(statusCode, 201);
}
}
