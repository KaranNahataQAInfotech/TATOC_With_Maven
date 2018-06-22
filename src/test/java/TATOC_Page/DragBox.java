package TATOC_Page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragBox {
	WebDriver driver;

	private WebElement getProceed() {
		return driver.findElement(By.linkText("Proceed"));
	}

	private WebElement getDropBox() {
		return driver.findElement(By.id("dropbox"));
	}

	private WebElement getDragBox() {
		return driver.findElement(By.id("dragbox"));
	}

	private void dragToDropBox() {
		Actions act = new Actions(driver);
		act.dragAndDrop(getDragBox(), getDropBox()).build().perform();
	}

	public DragBox(WebDriver driver) {
		this.driver = driver;

	}

	public ErrorPage errorPageHit() {
		getProceed().click();
		String title = driver.getTitle();
		if (title.contains("Error")) {
			Assert.assertTrue(true);
			driver.navigate().back();
			return new ErrorPage();
		}
		return null;
	}

	public PopUpWindow popUpPageHit() {
		dragToDropBox();
		getProceed().click();
		if (driver.getTitle().contains("Windows")) {
			Assert.assertTrue(true);
			return new PopUpWindow(driver);
		}
		return null;
	}

}
