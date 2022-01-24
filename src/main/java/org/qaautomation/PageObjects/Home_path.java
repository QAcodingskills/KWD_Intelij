package org.qaautomation.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.qaautomation.PageComponents.base_methods;

public class Home_path extends base_methods {
    WebDriver driver;

    // Elements path Variables for Home page.
    public By location_field = By.id("location_formated_address");
    public By location_save_btn = By.className("save_location_btn");

    public By success_msg = By.xpath("//div[@id='toast-container']/div[contains(@style,'opacity: 1')]");
    public By success_msg_close = By.xpath("//div[@id='toast-container']/div/button");
    public By login_link = By.xpath("//div[@class='user_right']/a");

    //Constructor for initialize Driver locally.
    public Home_path(WebDriver driver) {
        this.driver = driver;
    }

    // Method for set Location
    public void set_location(String location) throws Throwable {
        driver.findElement(location_field).sendKeys(location);
        Thread.sleep(2000);
        driver.findElement(location_field).sendKeys(Keys.chord(Keys.ARROW_DOWN), Keys.chord(Keys.BACK_SPACE),
                Keys.ENTER);
        Thread.sleep(500);
        driver.findElement(location_save_btn).click();

        /*
         * String message = driver.findElement(success_msg).getText();
         * //driver.findElement(success_msg_close).click(); System.out.println(message);
         * waiting_for_hide(success_msg);
         */
    }

    public void footer() throws Throwable {
        //Thread.sleep(3000);
        //scroll();
        scroll();
        // footer_part = null;
        WebElement footer_part = driver.findElement(By.xpath("//app-root[@ng-version='11.2.2']//app-footer"));
        WebElement head_menu = footer_part
                .findElement(By.xpath("//div[contains(@class,'footer_top')]//div[contains(@class,'container')]"));
        List<WebElement> list = head_menu.findElements(By.tagName("a"));
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            String winHandleBefore1 = driver.getWindowHandle();
            WebElement ele = head_menu.findElements(By.tagName("a")).get(i);
            moveing(ele);
            String display = list.get(i).findElement(By.xpath("..//..")).getAttribute("class");
            System.out.println(display);
            String href = list.get(i).getAttribute("href");
            System.out.println(href);
            if (display.contains("play_store"))
                continue;
            else {
                list.get(i).sendKeys(kc.newtab);
            }
            window_handel(winHandleBefore1);
        }
    }
}
