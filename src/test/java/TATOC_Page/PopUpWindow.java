package TATOC_Page;

import java.util.ArrayList;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PopUpWindow {
	WebDriver driver;

	private WebElement getProceed() {
		return driver.findElement(By.linkText("Proceed"));
	}

	private WebElement getLaunchPopUpWindow() {
		return driver.findElement(By.linkText("Launch Popup Window"));
	}

	private WebElement getSubmit() {
		return driver.findElement(By.id("submit"));
	}

	public PopUpWindow(WebDriver driver) {
		this.driver = driver;
	}

	public ErrorPage errorPageHitWithoutLaunching() {
		getProceed().click();
		if (driver.getTitle().contains("Error")) {
			Assert.assertTrue(true);
			driver.navigate().back();
			return new ErrorPage();
		}
		return null;
	}

	public ErrorPage errorPageHitWithLaunching() {
		getLaunchPopUpWindow().click();
		switchingBetweenWindows(1);
		getSubmit().click();
		switchingBetweenWindows(0);
		getProceed().click();
		if (driver.getTitle().contains("Error")) {
			Assert.assertTrue(true);
			driver.navigate().back();
			return new ErrorPage();
		}
		return null;
	}

	private void switchingBetweenWindows(int i) {
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(i));
	}

	public CookieHandling cookieHandlingWithLaunching() {
		getLaunchPopUpWindow().click();
		switchingBetweenWindows(1);
		driver.findElement(By.id("name")).sendKeys("Karan");
		getSubmit().click();
		switchingBetweenWindows(0);
		getProceed().click();
		if (driver.getTitle().contains("Cookie")) {
			Assert.assertTrue(true);
			return new CookieHandling(driver);
		}
		return null;
	}

}
