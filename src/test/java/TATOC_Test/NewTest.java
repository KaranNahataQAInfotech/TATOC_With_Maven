package TATOC_Test;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import TATOC_Page.BasicGridGate;
import TATOC_Page.CookieHandling;
import TATOC_Page.DragBox;
import TATOC_Page.ErrorPage;
import TATOC_Page.FinishPage;
import TATOC_Page.FrameDungeon;
import TATOC_Page.PopUpWindow;
import TATOC_Page.WelcomePage;

public class NewTest {
	WebDriver driver;
	WelcomePage welcomePage;
	BasicGridGate gridGate;
	ErrorPage errorPage;
	FrameDungeon frame;
	DragBox dragBox;
	PopUpWindow popUp;
	CookieHandling cookie;
	FinishPage finish;

	@BeforeClass
	public void start() {
		driver = new ChromeDriver();
		driver.get("http://10.0.1.86/tatoc");
		welcomePage = new WelcomePage(driver);
	}

	@Test(priority = 0)
	public void basicCourseOnClickOperation() {
		gridGate = welcomePage.basicCourseOpeningNextPage();
	}

	@Test(priority = 1)
	public void errorPageOnClickingGreenGrid() {
		errorPage = gridGate.isErrorPageOpened();
	}

	@Test(priority = 2)
	public void framePageOnClickingRedGrid() {
		frame = gridGate.isDungeonPageOpened();
	}

	@Test(priority = 3)
	public void proceedIfBothBoxAreOfDifferentColour() throws InterruptedException {
		errorPage = frame.isErrorPageOpened();
	}

	@Test(priority = 4)
	public void proceedIfBothBoxAreOfSameColour() {
		dragBox = frame.isDragAroungPageOpened();
	}

	@Test(priority = 5)
	public void proceedIfNotDragedDragMe() {
		errorPage = dragBox.errorPageHit();
	}

	@Test(priority = 6)
	public void proceedIfDragedDragMe() {
		popUp = dragBox.popUpPageHit();
	}

	@Test(priority = 7)
	public void proceedingWithoutLaunchingPopUpWindow() {
		errorPage = popUp.errorPageHitWithoutLaunching();
	}

	@Test(priority = 8)
	public void proceedingWithLaunchingPopUpWindowButWithBlankText() {
		popUp.errorPageHitWithLaunching();
	}

	@Test(priority = 9)
	public void proceedingWithLaunchingPopUpWindowButWithoutBlankText() {
		cookie = popUp.cookieHandlingWithLaunching();
	}

	@Test(priority = 10)
	public void proceedWithoutGeneratingToken() {
		cookie.errorPageGenerated();
	}

	@Test(priority = 11)
	public void proceedWithGeneratingTokenButWithoutCreatingCookie() {
		cookie.cookieNotCreated();
	}

	@Test(priority = 12)
	public void proceedWithGeneratingTokenAfterCreatingCookie() {
		finish = cookie.cookieCreated();
	}

	@AfterClass
	public void quit() {
		driver.quit();
	}
}
