package com.example;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.io.FileUtils;
import java.io.File;
//import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;
//import io.github.bonigarcia.wdm.ChromeDriverManager;

public class GGSearch {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;
  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\tridq\\eclipse-workspace\\chromedriver-win64\\chromedriver.exe");
//  WebDriverManager.chromedriver().setup();
//  ChromeDriverManager.getInstance().setup();
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testGGSearch() throws Exception {
    driver.get(baseUrl + "chrome://newtab/");
    driver.get("https://www.google.com/");
    driver.findElement(By.id("APjFqb")).click();
    driver.findElement(By.id("APjFqb")).clear();
    driver.findElement(By.id("APjFqb")).sendKeys("in28minutes");
    driver.findElement(By.id("APjFqb")).sendKeys(Keys.ENTER);
  }

  @After
  public void tearDown() throws Exception {
	  if (driver != null) {
	        driver.quit();
	    }
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
