package TATOC_Page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WelcomePage {
	WebDriver driver;

	private WebElement getBasicCourse() {
		return driver.findElement(By.linkText("Basic Course"));
	}

	private WebElement getAdvancedCourse() {
		return driver.findElement(By.linkText("Advanced Course"));
	}

	public WelcomePage(WebDriver driver) {
		this.driver = driver;
	}

	public BasicGridGate basicCourseOpeningNextPage() {
		getBasicCourse().click();
		String title = driver.getTitle();
		if (title.contains("Grid Gate")) {
			Assert.assertTrue(true);
			return new BasicGridGate(driver);
		}

		return null;
	}

}
