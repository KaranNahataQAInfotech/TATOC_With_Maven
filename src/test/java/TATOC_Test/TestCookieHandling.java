package TATOC_Test;

import org.testng.annotations.Test;

import TATOC_Page.CookieHandling;
import TATOC_Page.ErrorPage;
import TATOC_Page.FinishPage;
import TATOC_Page.FrameDungeon;
import TATOC_Page.PopUpWindow;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

public class TestCookieHandling {
	WebDriver driver;
	CookieHandling cookie;
	String url;

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
	}

	@BeforeMethod
	public void beforeMethod() {
		driver.get("http://10.0.1.86/tatoc");
		driver.findElement(By.linkText("Basic Course")).click();
		driver.findElement(By.className("greenbox")).click();
		PopUpWindow popUp = new FrameDungeon(driver).isDragAroungPageOpened().popUpPageHit();
		cookie = popUp.cookieHandlingWithLaunching();
	}

	@Test
	public void TC_1_proceedWithoutGeneratingToken() {
		Class expectedClass = ErrorPage.class;
		Assert.assertTrue(expectedClass.isInstance(cookie.errorPageGenerated()));
	}

	@Test
	public void TC_2_proceedWithGeneratingTokenButWithoutCreatingCookie() {
		Class expectedClass = ErrorPage.class;
		Assert.assertTrue(expectedClass.isInstance(cookie.cookieNotCreated()));
	}

	@Test
	public void TC_3_proceedWithGeneratingTokenWithCreatingCookie() {
		Class expectedClass = FinishPage.class;
		Assert.assertTrue(expectedClass.isInstance(cookie.cookieCreated()));
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
