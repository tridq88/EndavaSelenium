package unittest;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstSeleniumJUnitTest {

	WebDriver webDriver;

	@Before
	public void before() {
		// Execute the Code

		// Download the Web Driver Executable
		// Set the path to Web Driver Executable
		WebDriverManager.chromedriver().setup();

		// Create an instance of WebDriver

		webDriver = new ChromeDriver();

	}

	@Test
	public void testGoogleDotCom() throws Exception {

		// WebDriver - Launch up http://www.google.com
		webDriver.get("http://www.google.com");
		Thread.sleep(2000);//Add sleep to see the webpage

		String actualTitle = webDriver.getTitle();

		String expectedTitle = "Google";

		// Check the output
		// WebDriver - Title is Google
		assertEquals(expectedTitle, actualTitle);

	}

	@Test
	public void testFacebookDotCom() throws Exception {

		webDriver.get("http://www.facebook.com");
		Thread.sleep(2000);//Add sleep to see the webpage

		String actualTitle = webDriver.getTitle();

		String expectedTitle = "Facebook – log in or sign up";

		// Check the output
		assertEquals(expectedTitle, actualTitle);

	}

	@Test
	public void testSomeErrorScenarioCom() throws Exception {

		webDriver.get("com");
		Thread.sleep(2000);//Add sleep to see the webpage

		String actualTitle = webDriver.getTitle();

		String expectedTitle = "Facebook – log in or sign up";

		// Check the output
		assertEquals(expectedTitle, actualTitle);

	}

	@After
	public void after() {
		System.out.println("I'm, Executed");
		webDriver.quit();
	}

}
