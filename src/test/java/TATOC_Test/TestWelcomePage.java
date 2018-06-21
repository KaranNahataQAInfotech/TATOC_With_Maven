package TATOC_Test;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import TATOC_Page.BasicGridGate;
import TATOC_Page.WelcomePage;

public class TestWelcomePage {
	WebDriver driver;
	WelcomePage welcomePage;
	@BeforeClass
	public void start() {
		driver = new ChromeDriver();
		driver.get("http://10.0.1.86/tatoc");
		welcomePage = new WelcomePage(driver);
	}
	@Test
	public void basicCourseOnClickOperation() {
		Class expectedClass = BasicGridGate.class;
		Assert.assertTrue(expectedClass.isInstance(welcomePage.basicCourseOpeningNextPage()));
	}

	

}
