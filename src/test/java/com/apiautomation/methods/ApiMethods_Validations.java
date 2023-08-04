package com.apiautomation.methods;

import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.JSONObject;
import org.junit.Test;
import org.testng.Assert;
import org.testng.Reporter;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiMethods_Validations 
{
	public void getMethod() {
	try {
	RestAssured.baseURI ="https://reqres.in"; 
	//Request object
	RequestSpecification httpRequest = RestAssured.given();
	
	//Response object
	Response response = httpRequest.request(Method.GET, "/api/users/2");
	
	//print response in console window
	String responseBody = response.getBody().asString();
	System.out.println("Response Body is:"+responseBody);
	
	//status code validation
	int statusCode = response.getStatusCode();
	System.out.println("Status code is:"+statusCode);
	
	Assert.assertEquals(statusCode, 200);
	//status line verification
	
	String statusLine = response.getStatusLine();
	System.out.println("Status line is :"+statusLine);
	Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}catch(Exception e){
		Reporter.log(e.getMessage());
		Assert.fail();
		
	}
	}
	
	public void postMethod() {
		try {
		RestAssured.baseURI ="https://reqres.in"; 
		//Request object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Request payload sending along with post request
		JSONObject requestParams = new JSONObject();
		
		requestParams.put("name", "Revathi");
		requestParams.put("job", "testAutomation");
		
		httpRequest.header("Content-Type","application/json");
		
		httpRequest.body(requestParams.toJSONString());
		//Response object
		Response response = httpRequest.request(Method.POST, "/api/users");
		
		//print response in console window
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is:"+responseBody);
		
		//status code validation
		int statusCode = response.getStatusCode();
		System.out.println("Status code is:"+statusCode);
		
		Assert.assertEquals(statusCode, 201);
		//status line verification
		
		String name = response.jsonPath().get("name");	
		Assert.assertEquals(name, "Revathi");
		}catch(Exception e){
			Reporter.log(e.getMessage());
			Assert.fail();
			
		}
	}
	public void putMethod() {
		try {
		RestAssured.baseURI ="https://reqres.in"; 
		RequestSpecification httpPutRequest = RestAssured.given();
		httpPutRequest.header("content-type","application/json");
		JSONObject putRequestParams = new JSONObject();
		
		
		String generatedString = RandomStringUtils.randomAlphanumeric(10);

		System.out.println("GeneratedString!!!"+generatedString);
		
		putRequestParams.put("name", generatedString);
		putRequestParams.put("job", "testAutomation");
		
		httpPutRequest.body(putRequestParams.toJSONString());
		System.out.println(putRequestParams.toJSONString());
		Response response = httpPutRequest.request(Method.PUT, "/api/users/2");
		System.out.println(response);
		int code = response.getStatusCode();
		Assert.assertEquals(code, 200);
		//print response in console window
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is:"+responseBody);
				
		//status code validation
		int statusCode = response.getStatusCode();
		System.out.println("Status code is:"+statusCode);
				
		Assert.assertEquals(statusCode, 200);
		//status line verification
				
		String name = response.jsonPath().get("name");	
		Assert.assertEquals(name,generatedString);	
		}catch(Exception e){
			Reporter.log(e.getMessage());
			Assert.fail();
			
		}

	}
	public void deleteMethod() {
		try {
		RestAssured.baseURI ="https://reqres.in"; 
		RequestSpecification httpDeleteRequest = RestAssured.given();
		
		httpDeleteRequest.header("content-type","application/json");
	
		
		Response response = httpDeleteRequest.request(Method.DELETE, "/api/users/2");
		System.out.println(response);
		int code = response.getStatusCode();
		System.out.println("Status code is:"+code);
		Assert.assertEquals(code, 204);
		}catch(Exception e){
			Reporter.log(e.getMessage());
			Assert.fail();
			
		}
	}
}
