package com.employeeapi.testcase;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.employeeapi.base.Testbase;
import com.employeeapi.utilities.RestUtils;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TC004_Put_Employee_Record extends Testbase{
	String empName = RestUtils.empName();
	String empSalary = RestUtils.empSal();
	String empAge = RestUtils.empAge();

	@BeforeMethod
	void createEmployee() throws InterruptedException, NullPointerException {
		logger.info("********** Started TC004_Put_Employee Record *************");
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();

		JSONObject requestparams = new JSONObject();
		requestparams.put("name", empName);
		requestparams.put("salary", empSalary);
		requestparams.put("age", empAge);

		httpRequest.header("Content-Type", "application/json"); // Created
																// header

		// Add the JSON to the body of the request
		httpRequest.body(requestparams.toJSONString());

		// POST Request
		response = httpRequest.request(Method.PUT, "/update/"+empID);

		Thread.sleep(5000);
	}

	@Test
	void checkResponseBody() {
		try {
			System.out.println("Hi");
			logger.info("********** Checking Response Body*************");
			String responseBody = response.getBody().asString();
			logger.info("Respponse Body: " + responseBody);
			Assert.assertTrue(responseBody.contains("success"));
		}
		catch(Exception e)
		{
			System.out.println("HandledNullPointerException");
		}

			}
	
	@Test
	void checkStatuCode() {
		try{
		logger.info("********** Checking Status Code*************");
		int statusCode = response.getStatusCode();
		logger.info("Status Code" + statusCode);
		Assert.assertEquals(200, statusCode);
		}
		catch(Exception e)
		{
			System.out.println("HandledNullPointerException");
		}
	}
	

	@Test
	void checkResponseTime() {
		try{
		logger.info("********** Checking Response Time*************");
		long responseTime = response.getTime();
		logger.info("Response Time: " + responseTime);
		Assert.assertTrue(responseTime > 500);
			}
	catch(Exception e)
		{
		System.out.println("Handled NullPointerException");
		}
	}
	
	@Test
	void checkStatusLine() {
	try{
		logger.info("********** Checking Status Line*************");
		String statusLine = response.getStatusLine();
		logger.info("Status Line: " + statusLine);
		Assert.assertEquals("HTTP/1.1 200 OK", statusLine);
	}
catch(Exception e)
	{
	System.out.println("Handled NullPointerException");
	}
	}
	
	@Test
	void checkContentType() {
		try{
		logger.info("********** Checking Content-Type*************");
		String contenttype = response.getHeader("Content-Type");
		logger.info("Content-Type: " + contenttype);
		Assert.assertEquals("application/json;charset=utf-8", contenttype);
	}
catch(Exception e)
		{
	System.out.println("Handled NullPointerException");
	}
		}
	@Test
	void checkContentEncoding() {
	try{
		logger.info("********** Checking Content-Encoding*************");
		String contentencoding = response.getHeader("Content-Encoding");
		logger.info("Content-Encoding: " + contentencoding);
		Assert.assertEquals(contentencoding, null);
	}
	catch(Exception e)
	{
		System.out.println("Handled NullPointerException");
	}}
	@Test
	void checkServerType() {
	try{
		logger.info("********** Checking Server Type*************");
		String servertype = response.getHeader("Server-Type");
		logger.info("Servert Type: " + servertype);
		
		Assert.assertTrue(servertype==null);
	}
	catch(Exception e)
	{
		System.out.println("Handled NullPointerException");
	}
	}
	
	@Test
	void checkContentLength() {
	try{
		logger.info("********** Checking Content Length*************");
		String contentlength = response.getHeader("Content-Length");
		int contentlengthint=Integer.parseInt(contentlength);
		logger.info("Content Length: " + contentlength);
	Assert.assertTrue(contentlengthint>10);
	}
	catch(Exception e)
	{
		System.out.println("Handled NullPointerException");
	}
	}
	@AfterClass
	void tearDown(){
		logger.info("********** Finished TC004_Put_Employee_Record *************");
	}

}
