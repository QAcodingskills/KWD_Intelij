package org.qaautomation;

import org.qaautomation.PageComponents.*;
import org.qaautomation.PageObjects.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

public class Home extends base_methods {
	Home_path HP ;
	@BeforeSuite
	public void open_browser() throws Throwable {
		open_browser("Mozilla", "https://kwikdosh.stage2.demo321.com/");
	}
	
	@BeforeClass
	public void init_object() throws Throwable {
		HP = new Home_path(driver);
		HP.set_location("Jaipur");
	}

	@Test(enabled = true , priority = 1) 
	public void find_broken_links() throws Throwable {
		Broken_links();
	}

	@Test(enabled = true, priority = 2)
	public void link_handling() throws Throwable {
		scroll();
		HP.footer();
	}

	@Test(enabled = true, priority = 3)
	public void Blank_newslatter() throws Throwable {
		HP.newsletter_subscribe_btn().click();
		List<WebElement> li = HP.validation_fields();
		System.out.println(li.size());
		Validate_err_msg(li, HP.Blank_email_error);
	}

	@Test(enabled = true, priority = 4)
	public void invalid_newslatter() throws Throwable {
		insertdata(HP.email_field, "Indra", HP.driver);
		List<WebElement> li = HP.validation_fields();
		System.out.println(li.size());
		Validate_err_msg(li, HP.invalid_email_error);
	}

	@Test(enabled = true, priority = 5)
	public void already_used_newslatter_email() throws Throwable {
		insertdata(HP.email_field, "indra@gmail.com", HP.driver);
		HP.newsletter_subscribe_btn().click();
		String error = HP.success_error_message().getText();
		Thread.sleep(2000);
		Assert.assertEquals(error, "Email address already exists. Please try another.");
		HP.success_error_message().click();
		Thread.sleep(1000);
		//You have successfully subscribed for our newsletter.
	}

	@Test(enabled = true, priority = 6)
	public void valid_newslatter_email() throws Throwable {
		insertdata(HP.email_field, "indra28134@gmail.com", HP.driver);
		HP.newsletter_subscribe_btn().click();
		Thread.sleep(3000);
		String error = HP.success_error_message().getText();
		Assert.assertEquals(error, "You have successfully subscribed for our newsletter.");
		HP.success_error_message().click();
	}

	@AfterClass
	public void open_login_page() throws Throwable {
		Thread.sleep(3000);
		driver.findElement(HP.login_link).click();
		Thread.sleep(3000);
	}
	
	@Test(enabled = false) 
	public void newslatter() throws Throwable {
		HP = new Home_path(driver);
		driver.findElement(HP.location_field).sendKeys("Jaipur");
		Thread.sleep(3000);
		//WebElement ele = driver.findElement(By.xpath("//body/div[5]"));
		List<WebElement> allSuggestion = driver.findElements(By.xpath("//div[@class='pac-item']"));
		int x = allSuggestion.size();
		System.out.println(x);
		allSuggestion.get(0).click();
		Thread.sleep(3000); 
		driver.findElement(HP.location_save_btn).click();
	}
}
