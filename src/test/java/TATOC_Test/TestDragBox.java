package TATOC_Test;

import org.testng.annotations.Test;

import TATOC_Page.DragBox;
import TATOC_Page.ErrorPage;
import TATOC_Page.FrameDungeon;
import TATOC_Page.PopUpWindow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class TestDragBox {
	WebDriver driver;
	DragBox dragBox;
	 @BeforeClass
	  public void beforeClass() {
		  driver = new ChromeDriver();
		  
	  }
	 @BeforeMethod
	 public void beforeMethod() {
		 driver.get("http://10.0.1.86/tatoc");
		  driver.findElement(By.linkText("Basic Course")).click();
		  driver.findElement(By.className("greenbox")).click();
		  dragBox = new FrameDungeon(driver).isDragAroungPageOpened();
	 }
  @Test
  public void proceedIfNotDragedDragMe() {
	  Class expectedClass=ErrorPage.class;
	  Assert.assertTrue(expectedClass.isInstance(dragBox.errorPageHit()));
  }
  @Test
  public void proceedIfDragedDragMe() {
	  Class expectedClass=PopUpWindow.class;
	  Assert.assertTrue(expectedClass.isInstance(dragBox.popUpPageHit()));
  }
 
  @AfterClass
  public void afterTest() {
	  driver.close();
  }

}
