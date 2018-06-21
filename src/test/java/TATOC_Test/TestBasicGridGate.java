package TATOC_Test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import TATOC_Page.BasicGridGate;
import TATOC_Page.ErrorPage;
import TATOC_Page.FrameDungeon;
import TATOC_Page.WelcomePage;

public class TestBasicGridGate {
  WebDriver driver;
  BasicGridGate gridGate;
  @BeforeClass
  public void start() {
	  driver = new ChromeDriver();
	    }
  @BeforeMethod
	public void beforeMethod() {
	  driver.get("http://10.0.1.86/tatoc");
	  driver.findElement(By.linkText("Basic Course")).click();
	  gridGate = new BasicGridGate(driver);

	}
	@Test
	  public void errorIfGreenGrid() {
		Class expectedClass = FrameDungeon.class;
			Assert.assertTrue(expectedClass.isInstance(gridGate.isDungeonPageOpened()));
	  }
	@Test
	  public void nextWindiowOnRedGrid() {
		Class expectedClass = ErrorPage.class;
		Assert.assertTrue(expectedClass.isInstance(gridGate.isErrorPageOpened()));
	  }
	@AfterClass
	public void afterClass() {
		driver.close();
	}
}
