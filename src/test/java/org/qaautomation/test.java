import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;


public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://the-internet.herokuapp.com/upload");
		
		driver.findElement(By.xpath("//input[@id='file-upload']")).sendKeys("E:\\\\New folder\\\\testing images\\\\img.jfif");
		driver.findElement(By.xpath("//input[@id='file-submit']")).click();
		
		//submit();
		/*try {
		StringSelection stringSelection = new StringSelection("E:\\New folder\\testing images\\abc.txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		// native key strokes for CTRL, V and ENTER keys
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	} catch (Exception exp) {
		exp.printStackTrace();
	}*/
		
		/*
		 * WebElement ele = driver.findElement(By.xpath("//body/div[5]"));
		 * List<WebElement> allSuggestion =
		 * ele.findElements(By.xpath("//div[@class='pac-item']")); int count =
		 * allSuggestion.size(); allSuggestion.get(0).click();
		 * driver.findElement(By.className("save_location_btn")).click();
		 */
		
		
	}

}
