package com.employeeapi.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.employeeapi.base.Testbase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;


public class TC001_Get_All_Employees extends Testbase {

	@BeforeClass
	void getAllEmployees() throws InterruptedException {
		logger.info("********** Started TC001_Get_All_Employees *************");
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET, "/employees");
		Thread.sleep(3000);
		try{
			JsonPath jsonPathEvaluator=response.jsonPath();
			String employeeID=jsonPathEvaluator.get("[0].id");
			
			System.out.println("EmployeeID is------------------------------>"+employeeID);
	}
	catch(Exception e){
		System.out.println("Exception handled");
	}
	}

	@Test
	void checkResponseBody() {
		logger.info("********** Checking Response Body*************");
		String responseBody = response.getBody().asString();
		logger.info("Respponse Body: " + responseBody);
		Assert.assertTrue(responseBody.contains("success"));
	}

	@Test
	void checkStatuCode() {
		logger.info("********** Checking Status Code*************");
		int statusCode = response.getStatusCode();
		logger.info("Status Code" + statusCode);
		Assert.assertEquals(200, statusCode);
	}
	
	
	@Test
	void checkResponseTime() {
		logger.info("********** Checking Response Time*************");
		long responseTime = response.getTime();
		logger.info("Response Time: " + responseTime);
		Assert.assertTrue(responseTime > 50);
	}

	@Test
	void checkStatusLine() {
		logger.info("********** Checking Status Line*************");
		String statusLine = response.getStatusLine();
		logger.info("Status Line: " + statusLine);
		Assert.assertEquals("HTTP/1.1 200 OK", statusLine);
	}

	@Test
	void checkContentType() {
		logger.info("********** Checking Content-Type*************");
		String contenttype = response.getHeader("Content-Type");
		logger.info("Content-Type: " + contenttype);
		Assert.assertEquals("application/json;charset=utf-8", contenttype);
	}

	@Test
	void checkContentEncoding() {
		logger.info("********** Checking Content-Encoding*************");
		String contentencoding = response.getHeader("Content-Encoding");
		logger.info("Content-Encoding: " + contentencoding);
		Assert.assertEquals("gzip", contentencoding);

	}

	@Test
	void checkServerType() {
		logger.info("********** Checking Server Type*************");
		String servertype = response.getHeader("Server-Type");
		logger.info("Servert Type: " + servertype);
		
		Assert.assertTrue(servertype==null);

	}

	@Test
	void checkContentLength() {
		logger.info("********** Checking Content Length*************");
		String contentlength = response.getHeader("Content-Length");
		int contentlengthint=Integer.parseInt(contentlength);
		logger.info("Content Length: " + contentlength);
		Assert.assertTrue(contentlengthint>100);

	}
	@AfterClass
	void tearDown(){
		logger.info("********** Finished TC001_Get_All_Employees *************");
	}
}
