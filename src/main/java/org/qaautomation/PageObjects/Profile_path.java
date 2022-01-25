package org.qaautomation.PageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Profile_path {
	public WebDriver p_path;

	// Elements Locators

	public By user_profile_title = By.xpath("//div[@class='title_row title_row_edit_profile']/h2");
	public By change_password_title = By.xpath("//div[@class='title_row']/h1");
	public By user_profile_email = By.xpath(
			"//div[@class='title_row title_row_edit_profile']/parent::div[contains(@class,'profile_summary_content')]/ul/li[4]/span");
	public By post_an_add_btn = By.xpath("//a[@class='btn btn-secondary']");
	public By validation_specific_field = By
		.xpath("//div[contains(text(),'.')]//../parent::div[contains(@class,'form-group')]/label");
	public By change_password_link = By.xpath("//a[@routerlink='/change-password']");
	public By current_password = By.xpath("//span[@id='old_password']//input[@type='password']");
	public By new_password = By.xpath("//input[@placeholder='New Password']");
	public By confirm_password = By.xpath("//input[@placeholder='Confirm Password']");
	public By password_save_btn = By.xpath("//div[@class='save-btn']/button");
	public By password_error_field = By.xpath("//div[contains(text(),'.')]");
	public By wrong_old_password_error = By.xpath("//div[@id='toast-container']/div/div");

	// Global Variables.
	public String email;
	public String[] err_Validation = { "Current password is required.", "New password is required.", "Confirm password is required." };
	public String err_new_password_Validation = "Password length should be minimum 8 characters with atleast 1 capital, 1 small and 1 special character.";
	public String err_confirm_password_Validation = "Passwords do not match.";

	public Profile_path(WebDriver driver) {
		p_path = driver;
	}

	public WebElement get_profile_email() {
		return p_path.findElement(user_profile_email);
	}

	public WebElement post_an_add_btn() {
		return p_path.findElement(post_an_add_btn);
	}

	public List<WebElement> password_error_field() {
		return p_path.findElements(password_error_field);
	}

	public WebElement password_save_btn() {
		return p_path.findElement(password_save_btn);
	}

	public WebElement change_password_link() {
		return p_path.findElement(change_password_link);
	}

	public WebElement wrong_old_password_error() {
		return p_path.findElement(wrong_old_password_error);
	}

	public List<WebElement> validation_specific_field() {
		return p_path.findElements(validation_specific_field);
	}
}

//