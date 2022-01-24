package org.qaautomation;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.qaautomation.PageObjects.*;
import org.qaautomation.PageComponents.*;

public class post_add extends base_methods {

	private postadd_path add_path;

	@BeforeClass
	public void obj_init() {
		add_path = new postadd_path(driver);
	}

	@Test
	public void validate_add_form_heading() {

		Assert.assertEquals(add_path.heading().getText(), add_path.page_heading);
		Assert.assertEquals(add_path.sub_heading().getText(), add_path.page_sub_heading);
	}

	@Test
	public void blank_add_form_validate() throws Throwable {
		// scroll();
		add_path.save_btn().click();
		Thread.sleep(2000);
		List<WebElement> li = add_path.validation_fields();
		System.out.println(li.size());
		Validate_err_msg(li, add_path.err_Validation);
	}

	@Test(priority = 5)
	public void add_post() throws Throwable {

		insertdata(add_path.ad_title, "Quality", add_path.padd);

		add_path.category().click();
		List<WebElement> category = add_path.category_options();
		System.out.println("Category " + category.size());
		add_path.select_category_option(category, "Amit");

		add_path.sub_category().click();
		List<WebElement> sub_category = add_path.sub_category_options();
		System.out.println("Category " + sub_category.size());
		add_path.select_category_option(sub_category, "Ashish");

		add_path.sub_category1().click();
		List<WebElement> sub_category1 = add_path.sub_category_options();
		System.out.println("Category " + sub_category1.size());
		add_path.select_category_option(sub_category1, "test");

		select_specific_field_err_msg("VIP", add_path.fea_vip(), add_path.label());

		/*
		 * List<WebElement> feature_vip_options = add_path.fea_vip();
		 * System.out.println("Vip" + feature_vip_options.size());
		 * add_path.select_feature_vip_option(feature_vip_options, "featured");
		 */

		insertdata(add_path.price, "15000", add_path.padd);

		insertdata(add_path.desc, "we can choose the file we wish to upload from our machine.", add_path.padd);

		driver.findElement(add_path.formatted_address).sendKeys("Jaipur");
		Thread.sleep(2000);
		driver.findElement(add_path.formatted_address).sendKeys(Keys.chord(Keys.ARROW_DOWN),
				Keys.chord(Keys.BACK_SPACE), Keys.ENTER);
		Thread.sleep(500);

		add_path.main_img().sendKeys(path + "\\src\\test\\resources\\3.jpg");
		add_path.more_img().sendKeys(path + "\\src\\test\\resources\\3.jpg");

		add_path.save_btn().click();

	}
	
	@AfterSuite
	public void close_browser() {
		driver.quit();
	}

}
