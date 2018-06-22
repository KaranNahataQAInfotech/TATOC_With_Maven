package TATOC_Page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameDungeon {
	WebDriver driver;
	private String url;

	private void shiftToMainFrame() {
		driver.switchTo().frame("main");
	}

	private void shiftToChildFrame() {
		driver.switchTo().frame("child");
	}

	private String getColorOfBox1() {
		return driver.findElement(By.id("answer")).getAttribute("class");
	}

	private String getColorOfBox2() {
		return driver.findElement(By.id("answer")).getAttribute("class");
	}

	private WebElement getProceed() {
		return driver.findElement(By.linkText("Proceed"));
	}

	private WebElement getRepaintBox2() {
		return driver.findElement(By.linkText("Repaint Box 2"));
	}

	public FrameDungeon(WebDriver driver) {
		this.driver = driver;
		url = driver.getCurrentUrl();
	}

	public void makeBothBoxSameColour() {
		while (!isBothBoxAreOfSameColour()) {
			driver.switchTo().parentFrame();
			getRepaintBox2().click();
			driver.switchTo().parentFrame();
		}
	}

	public DragBox isDragAroungPageOpened() {
		makeBothBoxSameColour();
		driver.switchTo().parentFrame();
		getProceed().click();
		String title = driver.getTitle();
		if (title.contains("Drag")) {
			Assert.assertTrue(true);
			return new DragBox(driver);
		}
		return null;
	}

	public ErrorPage isErrorPageOpened() throws InterruptedException {
		if (!isBothBoxAreOfSameColour()) {
			driver.switchTo().parentFrame();
			getProceed().click();
			String title = driver.getTitle();
			if (title.contains("Error")) {
				Assert.assertTrue(true);
				driver.navigate().back();
				return new ErrorPage();
			}
		}
		return null;
	}

	public boolean isBothBoxAreOfSameColour() {
		shiftToMainFrame();
		String box1Colour = getColorOfBox1();
		shiftToChildFrame();
		String box2Colour = getColorOfBox2();
		if (box1Colour.equals(box2Colour))
			return true;
		return false;
	}
}
