

package GlobalKinetic.saucedemo;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.LoginPage;
import junit.framework.Assert;

public class LoginTest extends Base {

	public WebDriver driver;
	private static Logger log =
	 LogManager.getLogger(LoginTest.class.getName());
	
	@BeforeTest
	public void getUrl() throws IOException {
		driver = initializeDriver();

	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void LockedUser() {

		driver.get(prop.getProperty("URL"));

		LoginPage loginp = new LoginPage(driver);
		loginp.getEmail().sendKeys("locked_out_user");
		loginp.getPassword().sendKeys("secret_sauce");
		loginp.HitLoginbutton().click();
		
		System.out.println(loginp.lockedUser().getText());
		Assert.assertEquals("Epic sadface: Sorry, this user has been locked out.", loginp.lockedUser().getText());
		
		log.info("Locker test executed");
	}
	
	
	@AfterTest
	public void closeTest() {

		driver.close();
	}
}
