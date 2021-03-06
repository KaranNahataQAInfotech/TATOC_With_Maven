package TATOC_Page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CookieHandling {
	WebDriver driver;

	private WebElement getProceed() {
		return driver.findElement(By.linkText("Proceed"));
	}

	private WebElement getGenerateToken() {
		return driver.findElement(By.linkText("Generate Token"));
	}

	public CookieHandling(WebDriver driver) {
		this.driver = driver;
	}

	public ErrorPage cookieNotCreated() {
		getGenerateToken().click();
		if (driver.getTitle().contains("Error")) {
			Assert.assertTrue(true);
			driver.navigate().back();
			return new ErrorPage();
		}
		return null;
	}

	public FinishPage cookieCreated() {
		getGenerateToken().click();
		String str = driver.findElement(By.id("token")).getText();
		driver.manage().addCookie(new Cookie("Token", str.substring(7)));
		getProceed().click();
		if (driver.getTitle().contains("End")) {
			Assert.assertTrue(true);
			return new FinishPage();
		}
		return null;
	}

	public ErrorPage errorPageGenerated() {
		getProceed().click();
		if (driver.getTitle().contains("Error")) {
			Assert.assertTrue(true);
			driver.navigate().back();
			return new ErrorPage();
		}

		return null;
	}

}
