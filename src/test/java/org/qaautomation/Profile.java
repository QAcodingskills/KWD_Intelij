package org.qaautomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
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
		String profile_email = driver.findElement(p_path.user_profile_email).getText();
		String inserted_email = email;
		Assert.assertEquals(profile_email, inserted_email);
		}
	
	
	@AfterClass
	public void open_add_post_form() throws Throwable {
		Thread.sleep(4000);
		p_path.post_an_add_btn().click();
	}
	/**/
}
