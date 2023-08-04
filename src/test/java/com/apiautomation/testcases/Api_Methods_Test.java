package com.apiautomation.testcases;
import org.testng.annotations.Test;
import com.apiautomation.methods.ApiMethods_Validations;


public class Api_Methods_Test {
	@Test
	public void test_GetUserDetails() {
		ApiMethods_Validations getValidations = new ApiMethods_Validations();
		getValidations.getMethod();
		
	}
	
	@Test
	public void test_POSTUserDetails() {
		ApiMethods_Validations postValidations = new ApiMethods_Validations();
		postValidations.postMethod();
	}
	
	@Test
	public void put_ApiUsers() {
		ApiMethods_Validations putValidations = new ApiMethods_Validations();
		putValidations.putMethod();		
	}
	@Test
	public void delete_ApiUsers() {
		ApiMethods_Validations deleteValidations = new ApiMethods_Validations();
		deleteValidations.deleteMethod();		
		
	}
}
