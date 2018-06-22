package TATOC_Page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasicGridGate {
	WebDriver driver;
	private String url;

	private WebElement getGreenGrid() {
		return driver.findElement(By.className("greenbox"));
	}

	private WebElement getRedGrid() {
		return driver.findElement(By.className("redbox"));
	}

	public BasicGridGate(WebDriver driver) {
		this.driver = driver;
		url = driver.getCurrentUrl();
	}

	public ErrorPage isErrorPageOpened() {
		getRedGrid().click();
		String title = driver.getTitle();
		if (title.contains("Error")) {
			Assert.assertTrue(true);
			driver.navigate().back();
			return new ErrorPage();
		}

		return null;
	}

	public FrameDungeon isDungeonPageOpened() {
		getGreenGrid().click();
		String title = driver.getTitle();
		if (title.contains("Frame")) {
			Assert.assertTrue(true);
			return new FrameDungeon(driver);
		}

		return null;
	}

}
