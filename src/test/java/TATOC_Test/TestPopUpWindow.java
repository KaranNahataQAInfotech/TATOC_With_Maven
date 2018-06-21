package TATOC_Test;

import TATOC_Page.CookieHandling;
import TATOC_Page.DragBox;
import TATOC_Page.ErrorPage;
import TATOC_Page.FrameDungeon;
import TATOC_Page.PopUpWindow;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

public class TestPopUpWindow {
	WebDriver driver;
	PopUpWindow popUp ;
	 @BeforeClass
	  public void beforeClass() {
		  driver = new ChromeDriver(); 
	  }
	 @BeforeMethod
	 public void beforeTest() {
		 driver.get("http://10.0.1.86/tatoc");
		  driver.findElement(By.linkText("Basic Course")).click();
		  driver.findElement(By.className("greenbox")).click() ;
		  popUp = new FrameDungeon(driver).isDragAroungPageOpened().popUpPageHit();
	 }
  @Test
  public void proceedingWithoutLaunchingPopUpWindow() {
	  Class expectedObject = ErrorPage.class;
	  Assert.assertTrue(expectedObject.isInstance(popUp.errorPageHitWithoutLaunching()));
  }
  @Test 
  public void proceedingWithLaunchingPopUpWindowButWithBlankText() {
	  Class expectedObject = ErrorPage.class;
	  Assert.assertTrue(expectedObject.isInstance(popUp.errorPageHitWithLaunching()));
  }
  @Test 
  public void proceedingWithLaunchingPopUpWindowButWithoutBlankText() {
	  Class expectedObject = CookieHandling.class;
	  Assert.assertTrue(expectedObject.isInstance(popUp.cookieHandlingWithLaunching()));
  }
 

  @AfterClass
  public void afterTest() {
	  driver.close();
  }

}
