package org.qaautomation;

import java.util.List;


import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.qaautomation.PageObjects.*;
import org.qaautomation.PageComponents.*;

public class Profile extends base_methods {
	
	@BeforeClass
	public void obj_init() throws Throwable {
		p_path = new Profile_path(driver);
		Thread.sleep(4000);
	}
	
	@Test(priority = 1)
	public void verify_user_profile() throws Throwable {
		scroll2(2);
		String profile_email = p_path.get_profile_email().getText();
		String inserted_email = email;
		Assert.assertEquals(profile_email, inserted_email);
		}

	@Test(priority = 2)
	public void open_change_password() throws Throwable {
		p_path.change_password_link().click();
		String change_password_title = driver.findElement(p_path.change_password_title).getText();
		Assert.assertEquals(change_password_title, "Change Password");
	}

	@Test(priority = 3)
	public void verify_blank_password_validation() throws Throwable {
		p_path.password_save_btn().click();
		Thread.sleep(2000);
		List<WebElement> li = p_path.password_error_field();
		System.out.println(li.size());
		Validate_err_msg(li, p_path.err_Validation);
	}


	@Test(priority = 4)
	public void verify_wrong_new_password_validation() throws Throwable {
		insertdata(p_path.new_password, "1234", p_path.p_path);
		Thread.sleep(2000);
		List<WebElement> li = p_path.validation_specific_field();
		List<WebElement> li1 = p_path.password_error_field();
		Validate_specific_field_err_msg("password", li1, li, p_path.err_new_password_Validation);
	}

	@Test(priority = 5)
	public void verify_wrong_confirm_password_validation() throws Throwable {
		insertdata(p_path.confirm_password, "321", p_path.p_path);
		Thread.sleep(2000);
		List<WebElement> li = p_path.validation_specific_field();
		List<WebElement> li1 = p_path.password_error_field();
		Validate_specific_field_err_msg("confirm_password", li1, li, p_path.err_confirm_password_Validation);
	}

	@Test(priority = 6)
	public void verify_wrong_old_password_error() throws Throwable {
		insertdata(p_path.current_password, "System@321", p_path.p_path);
		insertdata(p_path.new_password, "System@123", p_path.p_path);
		insertdata(p_path.confirm_password, "System@123", p_path.p_path);
		p_path.password_save_btn().click();
		Thread.sleep(2000);
		String error = p_path.wrong_old_password_error().getText();
		Assert.assertEquals(error, "Please enter correct old password.");
	}

	@Test(priority = 7)
	public void verify_valid_password_change() throws Throwable {
		insertdata(p_path.current_password, "System@123", p_path.p_path);
		insertdata(p_path.new_password, "System@1239", p_path.p_path);
		insertdata(p_path.confirm_password, "System@1239", p_path.p_path);
		p_path.password_save_btn().click();
		Thread.sleep(2000);
		String error = p_path.wrong_old_password_error().getText();
		Assert.assertEquals(error, "Password has been changed successfully.");
	}


	@AfterClass
	public void open_add_post_form() throws Throwable {
		Thread.sleep(4000);
		p_path.post_an_add_btn().click();
	}
	/**/
}
