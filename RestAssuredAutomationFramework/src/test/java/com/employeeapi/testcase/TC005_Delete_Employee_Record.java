package com.employeeapi.testcase;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.Testbase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;

public class TC005_Delete_Employee_Record extends Testbase {
	@BeforeClass
	void deleteEmployees() throws InterruptedException {
		logger.info("********** Started TC005_Delete_Employee_Record *************");
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET, "/employees");
		Thread.sleep(3000);
		try{
			JsonPath jsonPathEvaluator=response.jsonPath();
			String employeeID=jsonPathEvaluator.get("[0].id");
			
			System.out.println("EmployeeID is------------------------------>"+employeeID);
			response = httpRequest.request(Method.DELETE, "/delete/"+employeeID);
	}
	catch(Exception e){
		System.out.println("Exception handled");
	}
		
	}

	@Test
	void checkResponseBody()
	{
		logger.info("********** Checking Response Body*************");
		String responseBody = response.getBody().asString();
		logger.info("Respponse Body: " + responseBody);
		Assert.assertTrue(responseBody.contains("success"));
	}

}
