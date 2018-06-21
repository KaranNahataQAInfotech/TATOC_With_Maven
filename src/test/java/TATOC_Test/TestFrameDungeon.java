package TATOC_Test;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import TATOC_Page.DragBox;
import TATOC_Page.ErrorPage;
import TATOC_Page.FrameDungeon;

public class TestFrameDungeon {
	WebDriver driver;
	 FrameDungeon framedungeon;
	 
	 @BeforeClass
	  public void initialize() {
		  driver = new ChromeDriver();
	  }
	 
	 @BeforeMethod
	 public void beforeTest() {
		  driver.get("http://10.0.1.86/tatoc");
		  driver.findElement(By.linkText("Basic Course")).click();
		  driver.findElement(By.className("greenbox")).click();
		  framedungeon = new FrameDungeon(driver);
	 }
	  @Test
	  public void proceedIfBothBoxAreOfDifferentColour() throws InterruptedException {
		  Class expectedClass = ErrorPage.class;
		  Assert.assertTrue(expectedClass.isInstance(framedungeon.isErrorPageOpened()));
	  }
	  @Test 
	  public void proceedIfBothBoxAreOfSameColour() {
		  Class expectedClass = DragBox.class;
		  Assert.assertTrue(expectedClass.isInstance(framedungeon.isDragAroungPageOpened()));
	  }
	  
	  
	  @AfterClass
	  public void afterTest() {
		  driver.close();
	  }
}
