package org.qaautomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.qaautomation.PageComponents.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.qaautomation.PageObjects.*;


public class Login extends base_methods {

	
	
	//String email;
	
	@BeforeClass
	public void init_odj() throws Throwable {
		
		//HP = new Home_path(driver);
		Thread.sleep(1000);
		//driver.findElement(HP.login_link).click();
		
		
		
		LP = new Login_path(driver);
	}

	@Test(priority = 1)
	public void Validate_Blank_fields() throws Throwable {
		waiting(LP.submit);
		driver.findElement(LP.submit).click();
		List<WebElement> ele_list = driver.findElements(LP.err_msg);
		System.out.println(ele_list.size());
		
		Validate_err_msg(ele_list, LP.exp_blank_err);
		/*
		 * for (int i = 0; i < ele_list.size(); i++) {
		 * Assert.assertEquals(ele_list.get(i).getText(), LP.exp_blank_err[i]);
		 * System.out.println(ele_list.get(i).getText() + " Passed"); }
		 */
	}
	
	@Test(priority = 2)
	public void Invalid_email_field() throws Throwable {
		//LP.email_address("amit");
		insertdata(LP.email_address, "indra", LP.driver);
		System.out.println("Email Address info :- "+driver.findElement(LP.email_address).getText());
		driver.findElement(LP.pass_address).click();
		List<WebElement> ele_list = driver.findElements(LP.err_msg);
		System.out.println(ele_list.size());
		Validate_err_msg(ele_list, LP.exp_invalid_email_err);
	}
	
	@Test(priority = 3)
	public void Invalid_password_field() throws Throwable {
		
		insertdata(LP.pass_address, "indra", LP.driver);
		List<WebElement> ele_list = driver.findElements(LP.err_msg);
		System.out.println(ele_list.size());
		Validate_err_msg(ele_list, LP.exp_invalid_password_err);
	}
	
	@Test(priority = 4)
	public void valid_field() throws Throwable {
		init_email("indra26031@mailinator.com");
		//LP.email = "";
		insertdata(LP.email_address, email, LP.driver);
		insertdata(LP.pass_address, "System@123", LP.driver);
		driver.findElement(LP.submit).click();
		}
}
