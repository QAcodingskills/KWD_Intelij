package org.qaautomation.PageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Profile_path {
	public WebDriver p_path;

	// Elements Locators

	public By user_profile_title = By.xpath("//div[@class='title_row title_row_edit_profile']/h2");
	public By user_profile_email = By.xpath(
			"//div[@class='title_row title_row_edit_profile']/parent::div[contains(@class,'profile_summary_content')]/ul/li[4]/span");
	public By post_an_add_btn = By.xpath("//a[@class='btn btn-secondary']");
//	By user_profile_email = By.xpath("//ul[@class='summary_list']/li[4]/span");

	// Global Variables.
	public String email;

	public Profile_path(WebDriver driver) {
		p_path = driver;
	}

	public void get_title() {
		System.out.println(p_path.findElement(user_profile_title).getText());
	}

	public WebElement get_profile_email() {
		return p_path.findElement(user_profile_email);
	}

	public WebElement post_an_add_btn() {
		return p_path.findElement(post_an_add_btn);
	}

}

//