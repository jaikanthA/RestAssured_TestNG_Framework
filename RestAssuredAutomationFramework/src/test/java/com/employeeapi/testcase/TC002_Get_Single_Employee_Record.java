package com.employeeapi.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.employeeapi.base.Testbase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC002_Get_Single_Employee_Record extends Testbase {
	
	@BeforeMethod
	void getAllEmployees() throws InterruptedException {
		logger.info("********** Started TC002_Get_Single_Employee_Record *************");
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET, "/employee/"+empID);
		
		Thread.sleep(5000);
	}

	@Test
	void checkResponseBody() {
		try{
		logger.info("********** Checking Response Body*************");
		String responseBody = response.getBody().asString();
		logger.info("Respponse Body: " + responseBody);
		Assert.assertTrue(responseBody.contains("success"));
		}
		catch(Exception e)
		{
			System.out.println("Exception handled");
		}
	}
/*	@Test(priority=2)
	void checkStatuCode() {
		logger.info("********** Checking Status Code*************");
		int statusCode = response.getStatusCode();
		logger.info("Status Code: " + statusCode);
		Assert.assertEquals(200, statusCode);
	}

	@Test(priority=3)
	void checkStatusLine() {
		logger.info("********** Checking Status Line*************");
		String statusLine = response.getStatusLine();
		logger.info("Status Line: " + statusLine);
		Assert.assertEquals("HTTP/1.1 200 OK", statusLine);
	}

	@Test(priority=4)
	void checkContentType() {
		logger.info("********** Checking Content-Type*************");
		String contenttype = response.getHeader("Content-Type");
		logger.info("Content-Type: " + contenttype);
		Assert.assertEquals("application/json;charset=utf-8", contenttype);
	}

	@Test(priority=5)
	void checkServerType() {
		logger.info("********** Checking Server Type*************");
		String servertype = response.getHeader("Server-Type");
		logger.info("Servert Type: " + servertype);
		Assert.assertTrue(servertype = null, true);

	}
	
	@Test(priority=6)
	void checkContentEncoding() {
		logger.info("********** Checking Content-Encoding*************");
		String contentencoding = response.getHeader("Content-Encoding");
		logger.info("Content-Encoding: " + contentencoding);
		Assert.assertEquals("gzip", contentencoding);

	}
	@Test(priority=7)
	void checkContentLength() {
		logger.info("********** Checking Content Length*************");
		String contentlength = response.getHeader("Content-Length");
		int contentlengthint=Integer.parseInt(contentlength);
		logger.info("Content Length: " + contentlength);
		Assert.assertTrue(contentlengthint>100);

	}*/
	@AfterClass
	void tearDown(){
		logger.info("********** Finished TC002_Get_Single_Employee Record *************");
	}


}
