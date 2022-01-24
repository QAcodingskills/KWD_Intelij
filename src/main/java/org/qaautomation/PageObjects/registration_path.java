package org.qaautomation.PageObjects;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class registration_path {
	// Global Veriables for this class file
	public WebDriver RBD;
	public JavascriptExecutor js;

	// Sign_up page Elements Xpath
	public By heading = By.xpath("//h1[@class='heading_title']");
	public By sub_heading = By.xpath("//div[@class='heading-inner']/p");
	public By sign_up_btn = By.xpath("//button[@type='submit']");
	public By validation_fields = By.xpath("//div[contains(text(),'.')]");
	// public By validation_specific_field =
	// By.xpath("//div[contains(text(),'.')]/parent::div[@class =
	// 'form-group']/label");
	public By validation_specific_field = By
			.xpath("//div[contains(text(),'.')]//../parent::div[contains(@class,'form-group')]/label");
	public By email_field = By.xpath("//input[@id='email']");
	public By password_field = By.xpath("//input[@id='password']");
	public By cnf_password_field = By.xpath("//input[@id='confirm_password']");
	public By first_name_field = By.xpath("//input[@id='first_name']");
	public By last_name_field = By.xpath("//input[@id='last_name']");
	public By mobile_number_field = By.xpath("//input[@id='mobile_number']");
	public By signup_link = By.xpath("//a[@routerlink='/signup']");

	// Validation error messages list.
	public String[] err_Validation = { "First name is required.", "Last name is required.", "Email is required.",
			"Please select dial code and enter valid mobile number.", "Password is required.",
			"Confirm password is required.", "Recaptcha is required." };
	public String heading_title = "Create Account";
	public String sub_heading_title = "To keep connected with us, sign up with your personal info";
	public String email_field_error = "Please enter valid email id here.";
	public String password_field_error = "Password length should be minimum 8 characters with atleast 1 capital, 1 small and 1 special character.";

	public registration_path(WebDriver driver) {
		RBD = driver;
		js = (JavascriptExecutor) driver;
	}

	public WebElement heading() {
		return RBD.findElement(heading);
	}

	public WebElement sub_heading() {
		return RBD.findElement(sub_heading);
	}

	public WebElement sign_up_btn() {
		return RBD.findElement(sign_up_btn);
	}

	public WebElement email_field() {
		return RBD.findElement(email_field);
	}

	public WebElement password_field() {
		return RBD.findElement(password_field);
	}

	public WebElement first_name_field() {
		return RBD.findElement(first_name_field);
	}

	public WebElement last_name_field() {
		return RBD.findElement(last_name_field);
	}

	public WebElement cnf_password_field() {
		return RBD.findElement(cnf_password_field);
	}

	public WebElement mobile_number_field() {
		return RBD.findElement(mobile_number_field);
	}

	public List<WebElement> validation_fields() {
		return RBD.findElements(validation_fields);
	}

	public List<WebElement> validation_specific_field() {
		return RBD.findElements(validation_specific_field);
	}

}
