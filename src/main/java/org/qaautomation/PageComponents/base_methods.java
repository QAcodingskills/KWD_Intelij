package org.qaautomation.PageComponents;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

//import org.apache.logging.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import org.qaautomation.PageObjects.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class base_methods {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static WebElement ele;
    public static key_chord kc = new key_chord();
    public static Actions act;
    public static JavascriptExecutor js;

    // All Path pages objects
    public Profile_path p_path;
    public postadd_path add_path;
    public Login_path LP;
    public Home_path HP;
    public OTP_path ot;
    public registration_path rp;
    public static String path;
    // Some Global Variable.
    public static String email;
    public static By breadcrumbs = By.xpath("//div[@class='breadcrumb_panel']/div/ol/li");
    //public static Logger log =
    // open browser method start
    public static void open_browser(String browsername, String url) {
        try {
            path = System.getProperty("user.dir");
            if (browsername.equalsIgnoreCase("Mozilla")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            } else if (browsername.equalsIgnoreCase("Chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.get(url);
            driver.manage().window().maximize();
            wait = new WebDriverWait(driver, 50);
            js = (JavascriptExecutor) driver;

        } catch (Exception e) {
            System.out.println("Exception is : " + e);
        }
    }// Open browser method End

    // Validate error message via assert when we have multiple validation on a page
    // on a single click.
    public static void assertmultivalidate(WebElement ele1, By path, String[] expectedmessage) throws Exception {
        try {
            List<WebElement> actualmessage = ele1.findElements(path);
            String[] expectedmsg = expectedmessage;
            int x = actualmessage.size();
            System.out.println(x);
            int i = 0;
            for (WebElement mymessage : actualmessage) {
                if (mymessage.getText().equals("")) {
                    continue;
                } else {
                    Assert.assertTrue(mymessage.getText().equals(expectedmsg[i]));
                    System.out.println("assert passed - " + mymessage.getText());
                    i++;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void init_email(String data) {
        email = data;
        System.out.println(email);
    }

    // Select the radio button method Start.
    public static void select_radio(WebElement ele1, By path, String expectedmessage) {
        // WebElement elemnts = ele1.findElement(path);
        List<WebElement> radio = ele1.findElements(path);
        for (int i = 0; i < radio.size(); i++) {
            if (radio.get(i).findElement(By.tagName("label")).getText().equalsIgnoreCase(expectedmessage)) {
                radio.get(i).findElement(By.name("gender")).click();
            }
        }
    }

    public static String get_selected_options(Select sele) {
        WebElement option = sele.getFirstSelectedOption();
        String defaultItem = option.getText();
        return defaultItem;
    }

    public static ArrayList get_all_options(Select sele) {
        List<WebElement> li = sele.getOptions();
        ArrayList list = new ArrayList();
        for (int i = 0; i < li.size(); i++) {
            list.add(list.get(i));
        }
        return list;

    }

    public static boolean isUrlValid(String url) {
        URL obj;
        try {
            obj = new URL(url);
            obj.toURI();
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            return false;
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            return false;
        }
        return true;
    }

    public static void Broken_links() throws Throwable {
        String web_URL = driver.getCurrentUrl();
        List<WebElement> links = driver.findElements(By.tagName("a"));

        int respCode = 200;
        int broken_link = 0;
        int valid_link = 0;
        Iterator<WebElement> it = links.iterator();
        while (it.hasNext()) {
            String link_URL = it.next().getAttribute("href");
            if (isUrlValid(link_URL)) {
                if ((link_URL.contentEquals("javascript:void(0)") || link_URL == null || link_URL.isEmpty())) {

                    System.out.println(link_URL
                            + " URL is either not configured for anchor tag or it is empty or javascript Void");
                    continue;
                }
                /*
                 * if (!link_URL.startsWith(web_URL)) {
                 * System.out.println(link_URL+" URL belongs to another domain, skipping it.");
                 * continue; }
                 */
                try {

                    HttpURLConnection huc = (HttpURLConnection) (new URL(link_URL).openConnection());
                    huc.setRequestMethod("HEAD");
                    huc.connect();
                    respCode = huc.getResponseCode();
                    if (respCode >= 400) {
                        System.out.println(link_URL + " is a broken link");
                        broken_link += 1;
                    } else {
                        System.out.println(link_URL + " is a valid link");
                        valid_link += 1;
                    }

                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } else {
                System.out.println("URL is not Valid");
            }
        }

        System.out.println("Total Links: " + links.size());
        System.out.println("Broken Links: " + broken_link);
        System.out.println("Valid Links: " + valid_link);
    }

    public static void waiting(By elements) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(elements));
    }

    public static void waiting_for_hide(By elements) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(elements));
    }

    public static void Validate_err_msg(List<WebElement> ele1, String[] expectedmessage) throws Exception {
        String[] expectedmsg = expectedmessage;
        int i = 0;
        for (WebElement mymessage : ele1) {
            if (mymessage.getText().equals("") || mymessage.getText().equals(" ")) {
                // System.out.println("Blank");
                continue;
            } else {
                Assert.assertTrue(mymessage.getText().equals(expectedmsg[i]));
                System.out.println("assert passed - " + mymessage.getText());
                i++;
            }
        }
    }

    public static void Validate_specific_field_err_msg(String fieldname, List<WebElement> ele1, List<WebElement> ele2,
                                                       String expectedmessage) throws Exception {
        int i = 0, j = 0;

        for (WebElement mymessage : ele2) {

            System.out.println(mymessage);
            System.out.println(ele1.get(j).getText());
            String label = mymessage.getAttribute("for");

            if (label.equalsIgnoreCase(fieldname)) {
                Assert.assertTrue(ele1.get(j).getText().equals(expectedmessage));
                System.out.println("assert passed - " + ele1.get(j).getText());
                i++;
                break;
            }
            j++;
        }
        Assert.assertEquals(i, 1);
    }

    public static void select_specific_field_err_msg(String fieldname, List<WebElement> ele1, List<WebElement> ele2)
            throws Exception {
        int i = 0, j = 0;

        for (WebElement mymessage : ele2) {

            String label = mymessage.getAttribute("for");

            if (label.equalsIgnoreCase(fieldname)) {
                mymessage.click();

                // ele1.get(j).findElement(null).click();
                i++;
                break;
            }
        }
        Assert.assertEquals(i, 1);
    }

    public void drop_down_select(By path, String value) {
        Select sele = new Select(driver.findElement(path));
        sele.selectByValue(value);
    }

    public static void window_handel(String winHandleBefore) throws Exception {
        // List.get(k).sendKeys(Keys.chord(Keys.CONTROL, Keys.ENTER));
        String title = null;
        for (String winHandle : driver.getWindowHandles()) {
            title = driver.switchTo().window(winHandle).getTitle();
            System.out.println(title);
            // System.out.println(ttl);

        }

        Thread.sleep(1000);
        driver.close();
        driver.switchTo().window(winHandleBefore);

    }

    //  Insert data into the element.
    public void insertdata(By path, String data, WebDriver driver) throws IOException, InterruptedException {
        try {
            driver.findElement(path).clear();
            // Creating array of string length
            char[] ch = new char[data.length()];
            // Copy character by character into array
            for (int i = 0; i < data.length(); i++) {
                ch[i] = data.charAt(i);
                driver.findElement(path).sendKeys(Character.toString(ch[i]));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void scroll() throws Throwable {

        driver.findElement(By.xpath("//body[@dir='ltr']")).sendKeys(kc.end_key);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//body[@dir='ltr']")).sendKeys(kc.end_key);
        Thread.sleep(2000);

    }

    public static void scroll2(int round) {
        for (int i = 0; i < round; i++) {
            js.executeScript("window.scrollBy(0,5000)");
        }
    }

    public static void moveing(WebElement element) {
        act = new Actions(driver);
        act.moveToElement(element).build().perform();
    }

    public static String breadcrumbs_string() {
        List<WebElement> li = breadcrumbs();
        String breadcrumbs_string = "";
        for(int i=0; i<li.size();i++) {
            breadcrumbs_string = breadcrumbs_string + li.get(i).getText() ;
            if(i<(li.size()-1)) {
                breadcrumbs_string = breadcrumbs_string +"/";
            }
        }
        return breadcrumbs_string;
    }

    public static List<WebElement> breadcrumbs() {
        return driver.findElements(breadcrumbs);
    }

}
