package org.qaautomation;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.qaautomation.PageComponents.*;
import org.testng.Assert;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import org.qaautomation.PageObjects.*;


public class sign_up extends base_methods {

	@BeforeClass
	public void init_odj() throws Throwable {
		rp = new registration_path(driver);
		driver.findElement(rp.signup_link).click();
		ot = new OTP_path(driver);
	}

	@Test(priority = 1)
	public void heading_validate() {
		String heading = rp.heading().getText();
		String sub_heading = rp.sub_heading().getText();
		Assert.assertEquals(heading, rp.heading_title);
		Assert.assertEquals(sub_heading, rp.sub_heading_title);
	}

	@Test(priority = 2)
	public void blank_data_validate() throws Throwable {
		rp.sign_up_btn().click();
		Thread.sleep(2000);
		List<WebElement> li = rp.validation_fields();
		System.out.println(li.size());
		Validate_err_msg(li, rp.err_Validation);
	}

	@Test(priority = 3)
	public void invalid_email() throws Throwable {
		rp.email_field().sendKeys("indra");
		List<WebElement> li = rp.validation_specific_field();
		List<WebElement> li1 = rp.validation_fields();
		Validate_specific_field_err_msg("email", li1, li, rp.email_field_error);
	}

	@Test(priority = 4)
	public void invalid_password() throws Throwable {
		rp.password_field().sendKeys("123");
		List<WebElement> li = rp.validation_specific_field();
		List<WebElement> li1 = rp.validation_fields();
		Validate_specific_field_err_msg("password", li1, li, rp.password_field_error);
	}

	@Test(priority = 5)
	public void valid_data() throws Throwable {
		
		
		insertdata(rp.first_name_field, "Quality", rp.RBD);
		insertdata(rp.last_name_field, "Check", rp.RBD);
		insertdata(rp.email_field, "amit28134@mailinator.com", rp.RBD);
		insertdata(rp.mobile_number_field, "85995886647", rp.RBD);
		insertdata(rp.password_field, "System@123", rp.RBD);
		insertdata(rp.cnf_password_field, "System@123", rp.RBD);
		Thread.sleep(20600);
		rp.sign_up_btn().click();
		
	}
	
	
	@Test(priority = 6)
	public void OTP_verification_err() throws Throwable {
		Thread.sleep(4000);
		ot.otp_field().click();
		insertdata(ot.otp_field, "1234", ot.otp);
		ot.btn().click();
		Thread.sleep(1000);
		Assert.assertEquals(ot.otp_validate_field().getText(), ot.msg);		
	}
	
	
	@Test(priority = 7)
	public void OTP_verification() throws Throwable {
		Thread.sleep(20000);
		ot.btn().click();
			
	}

	
}
