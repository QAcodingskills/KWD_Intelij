package org.qaautomation;

import org.qaautomation.PageComponents.*;
import org.qaautomation.PageObjects.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
		HP.footer();
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
