package org.qaautomation.PageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OTP_path {
	public WebDriver otp;
	public By btn = By.xpath("//button[@type='submit']");
	public  By otp_field = By.xpath("//input[@formcontrolname='otp']");
	public  By otp_validate_field = By.xpath("//div[@class='error-block-form ng-star-inserted']");

	public String msg = "You have entered incorrect OTP, please enter correct OTP.";

	public OTP_path(WebDriver driver) {
		otp = driver;
	}

	public WebElement btn() {
		return otp.findElement(btn);
	}

	public WebElement otp_validate_field() {
		return otp.findElement(otp_validate_field);
	}

	public WebElement otp_field() {
		return otp.findElement(otp_field);
	}

}
