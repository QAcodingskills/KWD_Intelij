package org.qaautomation.PageObjects;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class postadd_path {
	public WebDriver padd;

	// Page Element's Xpaths
	public By heading = By.xpath("//div[@class='heading-inner']/h1"); //
	public By sub_heading = By.xpath("//div[@class='heading-inner']/p"); // Lorem Ipsum is simply dummy text of the printing
																	// and typesetting industry
//	public By save_btn = By.xpath("//form[@id='postAd']//div[@class='btn-group']/button[contains(@class,'btn-primary')]");
	public By save_btn = By.xpath("//button[@type='submit']");
	public By validation_fields = By.xpath("//control-messages/div");
	public By main_img = By.xpath("//div[@class='upload_button']//input[@type='file']");
	public By more_img = By.xpath("//input[@id='fileDropRef']");
	public By ad_title = By.xpath("//input[@id='ad_title']");
	public By price = By.xpath("//input[@id='price']");
	public By desc = By.xpath("//div[@class='row featuredBox']//textarea[@id='description']");
	public By formatted_address = By.xpath("//input[@id='formated_address']");
	public By fea_vip = By.xpath("//div[@class='planBox']/div[@class='row']");

	// div[@class='planBox']/div[@class='row']//span
	public By label = By.xpath("//div[contains(@class,'styled-selectors exclusive_check')]/label");

	// public By checkbox = By.xpath("//input[@type='checkbox']");
	public By category = By.xpath("//input[@id='category']");
	public By category_options = By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']/div/div/span");
	public By sub_category = By.xpath("//input[@id='sub_category']");
	public By sub_category_options = By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']/div/div/span");
	public By sub_category1 = By.xpath("//input[@id='sub_category1']");
	public By sub_category1_options = By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']/div/div/span");

	// String Data
	public String page_heading = "Submit a Free Classified Ad";
	public String page_sub_heading = "Lorem Ipsum is simply dummy text of the printing and typesetting industry";
	public String[] err_Validation = { "Ad title is required.", "Category is required.", "Price is required.",
			"Description is required.", "Find location on map is required.", "Main image is required.",
			"More Images is required." };

	public postadd_path(WebDriver driver) {
		padd = driver;
	}

	public WebElement heading() {
		return padd.findElement(heading);
	}

	public WebElement sub_heading() {
		return padd.findElement(sub_heading);
	}

	public WebElement save_btn() {
		return padd.findElement(save_btn);
	}

	public WebElement formatted_address() {
		return padd.findElement(formatted_address);
	}

	public WebElement more_img() {
		return padd.findElement(more_img);
	}

	public WebElement main_img() {
		return padd.findElement(main_img);
	}

	public List<WebElement> validation_fields() {
		return padd.findElements(validation_fields);
	}

	public WebElement category() {
		return padd.findElement(category);
	}

	public List<WebElement> category_options() {
		return padd.findElements(category_options);
	}

	public WebElement sub_category() {
		return padd.findElement(sub_category);
	}

	public List<WebElement> sub_category_options() {
		return padd.findElements(sub_category_options);
	}

	public WebElement sub_category1() {
		return padd.findElement(sub_category1);
	}

	public List<WebElement> sub_category1_options() {
		return padd.findElements(sub_category1_options);
	}

	public List<WebElement> fea_vip() {
		return padd.findElements(fea_vip);
	}

	public List<WebElement> label() {
		return padd.findElements(label);
	}

	public void select_category_option(List<WebElement> li, String cat_option) throws Throwable {
		// TODO Auto-generated method stub
		int i = 0;
		for (; i < li.size(); i++) {

			String opt = li.get(i).getText();
			if (cat_option.equalsIgnoreCase(opt)) {
				li.get(i).click();
				break;
			}
		}
		System.out.println(i);
	}

}
