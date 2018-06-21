package TATOC_Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragBox {
	WebDriver driver;
	String url;
	
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
		this.driver=driver;
		url=driver.getCurrentUrl();
	}
	public ErrorPage errorPageHit() {
		getProceed().click();
		String title = driver.getTitle();
		if(title.contains("Error")) {
			driver.get(url);
			return new ErrorPage();
		}
		return null;
	}
	
	public PopUpWindow popUpPageHit() {
		dragToDropBox();
		getProceed().click();
		if(driver.getTitle().contains("Windows"))
			return new PopUpWindow(driver);
		return null;
	}

}
