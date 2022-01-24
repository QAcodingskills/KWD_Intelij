package org.qaautomation.PageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login_path {
	public WebDriver driver;

	// Elements Locators
	public By email_address = By.xpath("//input[@id='email']");
	public By pass_address = By.xpath("//input[@id='password']");
	public By submit = By.xpath("//button[@type='submit']");
	public By err_msg = By.xpath("//div[@class='login-form signup_page postad_form']//control-messages");
	//By user_profile_email = By.xpath("//body[@dir='ltr']/app-root[@ng-version='11.2.2']/app-profilesummary/div[@class='main_content']/div[@class='accoutn_section']/div[@class='container']/div[@class='account_content']/div[@class='account_right']/div[@class='dashboard_form']/div[@class='profile_summary_info']/div[@class='profile_summary_content']/ul[@class='summary_list']/li[4]/span");
	// Expected Error messages
	public String[] exp_blank_err = { "Email is required.", "Password is required." };
	public String[] exp_invalid_email_err = {"Please enter valid email id here.", "Password is required." };
	public String[] exp_invalid_password_err = {"Please enter valid email id here.", "Password length should be minimum 8 characters with atleast 1 capital, 1 small and 1 special character." };
	
	
	
	public Login_path(WebDriver driver) {
		this.driver = driver;
	}

	// Insert Data in Email field.
	public void email_address(String email) {
		driver.findElement(email_address).sendKeys(email);
	}

	// INsert data in Password Field.
	public void password(String pass) {
		driver.findElement(pass_address).sendKeys(Keys.chord(Keys.CONTROL + "a"), pass);
	}
	
	
	
	

}

//