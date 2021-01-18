package GlobalKinetic.saucedemo;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.CartList;
import PageObjects.CheckOutOverView;
import PageObjects.CheckOutYourInfo;
import PageObjects.FinishPage;
import PageObjects.LandingPage;
import PageObjects.LoginPage;
import PageObjects.SouceLabsPage;
//import PageObjects.Select;
import junit.framework.Assert;

import org.openqa.selenium.support.ui.Select;

@SuppressWarnings("deprecation")
public class HomePageTest extends Base {

	public WebDriver driver;
	 private static Logger log =
	 LogManager.getLogger(HomePageTest.class.getName());

	@BeforeTest
	public void getUrl() throws IOException {
		driver = initializeDriver();
		
		log.info("driver initialized ");
	}

	@SuppressWarnings("deprecation")

	@Test
	public void viewCartList() {

		driver.get(prop.getProperty("URL"));

		LoginPage loginp = new LoginPage(driver);
		loginp.getEmail().sendKeys("standard_user");
		loginp.getPassword().sendKeys("secret_sauce");
		loginp.HitLoginbutton().click();

		LandingPage landpage = new LandingPage(driver);
		landpage.getAddtTocartOne().click();
		landpage.getAddtTocartTwo().click();
		landpage.getAddtTocartSix().click();
		landpage.getAddtTocartFour().click();

		CartList cartl = new CartList(driver);
		cartl.getCartItems().click();
		System.out.print(cartl.getCartItems().getText());

		Assert.assertEquals("4", cartl.getCartItems().getText());

		 log.info("viewCartList Executed");

	}

	@SuppressWarnings("deprecation")

	@Test
	public void RemoveItemsFromCartList() {

		driver.get(prop.getProperty("URL"));

		LoginPage loginp = new LoginPage(driver);
		loginp.getEmail().sendKeys("standard_user");
		loginp.getPassword().sendKeys("secret_sauce");
		loginp.HitLoginbutton().click();

		LandingPage landpage = new LandingPage(driver);
		landpage.getAddtTocartOne().click();
		landpage.getAddtTocartTwo().click();
		landpage.getAddtTocartSix().click();
		landpage.getAddtTocartFour().click();

		CartList cartl = new CartList(driver);

		cartl.getCartItems().click();
		cartl.removeBackPack().click();
		cartl.removeBikeLight().click();
		cartl.removeFleeceJacket().click();
		cartl.removeTshirt().click();

		System.out.println(cartl.NotItemsInCart().isEnabled());
		Assert.assertEquals(true, cartl.NotItemsInCart().isEnabled());
		
		 log.info("RemoveItemsFromCartList Executed ");
	}

	@SuppressWarnings("deprecation")

	@Test
	public void continueShopping() {

		driver.get(prop.getProperty("URL"));

		LoginPage loginp = new LoginPage(driver);
		loginp.getEmail().sendKeys("standard_user");
		loginp.getPassword().sendKeys("secret_sauce");
		loginp.HitLoginbutton().click();

		LandingPage landpage = new LandingPage(driver);
		landpage.getAddtTocartOne().click();
		landpage.getAddtTocartTwo().click();

		CartList cartl = new CartList(driver);

		cartl.getCartItems().click();
		cartl.removeBackPack().click();
		cartl.removeBikeLight().click();
		cartl.continueShoping().click();

		System.out.println(landpage.getProductHeader().getText());
		Assert.assertEquals("Products", landpage.getProductHeader().getText());
		 log.info("continueShopping Executed ");
	}

	@Test
	public void sortAtoZ() {
		driver.get(prop.getProperty("URL"));

		LoginPage loginp = new LoginPage(driver);
		loginp.getEmail().sendKeys("standard_user");
		loginp.getPassword().sendKeys("secret_sauce");
		loginp.HitLoginbutton().click();

		LandingPage landpage = new LandingPage(driver);
		Select dropdown = new Select(landpage.getDropdown());

		dropdown.selectByIndex(0);

		System.out.println(dropdown.getFirstSelectedOption().getText());

		List<WebElement> invetorylist = driver
				.findElements(By.xpath("//div[@class='inventory_container']/div/div/div[2]/a/div"));

		for (int i = 0; i < invetorylist.size(); i++) {
			if (invetorylist.get(0).getText().equalsIgnoreCase("Sauce Labs Backpack")) {
				System.out.println(invetorylist.get(0).getText());
				Assert.assertEquals(true, true);
				break;
			}

		}
		
		 log.info("sortAtoZ Executed ");
	}

	@Test
	public void sortZtoA() {
		driver.get(prop.getProperty("URL"));

		LoginPage loginp = new LoginPage(driver);
		loginp.getEmail().sendKeys("standard_user");
		loginp.getPassword().sendKeys("secret_sauce");
		loginp.HitLoginbutton().click();

		LandingPage landpage = new LandingPage(driver);
		Select dropdown = new Select(landpage.getDropdown());

		dropdown.selectByIndex(1);

		System.out.println(dropdown.getFirstSelectedOption().getText());

		List<WebElement> invetorylist = driver
				.findElements(By.xpath("//div[@class='inventory_container']/div/div/div[2]/a/div"));

		for (int i = 0; i < invetorylist.size(); i++) {
			if (invetorylist.get(0).getText().equalsIgnoreCase("Test.allTheThings() T-Shirt (Red)")) {
				System.out.println(invetorylist.get(0).getText());
				Assert.assertEquals(true, true);
				break;
			}

		}
		log.info("sortZtoA Executed ");
	}

	@Test
	public void sortLowtoHigh() {
		driver.get(prop.getProperty("URL"));

		LoginPage loginp = new LoginPage(driver);
		loginp.getEmail().sendKeys("standard_user");
		loginp.getPassword().sendKeys("secret_sauce");
		loginp.HitLoginbutton().click();

		LandingPage landpage = new LandingPage(driver);
		Select dropdown = new Select(landpage.getDropdown());

		dropdown.selectByIndex(2);

		System.out.println(dropdown.getFirstSelectedOption().getText());

		List<WebElement> invetorylist = driver.findElements(By.xpath("//div[@class='pricebar'] / div"));

		for (int i = 0; i < invetorylist.size(); i++) {
			if (invetorylist.get(0).getText().equalsIgnoreCase("$7.99")) {
				System.out.println(invetorylist.get(0).getText());
				Assert.assertEquals(true, true);
				break;
			}

		}
		
		log.info("sortLowtoHigh Executed ");
	}

	@Test
	public void sortHighToLow() {
		driver.get(prop.getProperty("URL"));

		LoginPage loginp = new LoginPage(driver);
		loginp.getEmail().sendKeys("standard_user");
		loginp.getPassword().sendKeys("secret_sauce");
		loginp.HitLoginbutton().click();

		LandingPage landpage = new LandingPage(driver);
		Select dropdown = new Select(landpage.getDropdown());

		dropdown.selectByIndex(3);

		System.out.println(dropdown.getFirstSelectedOption().getText());

		List<WebElement> invetorylist = driver.findElements(By.cssSelector("div[class='pricebar'] > div"));

		for (int i = 0; i < invetorylist.size(); i++) {
			if (invetorylist.get(0).getText().equalsIgnoreCase("$49.99")) {
				System.out.println(invetorylist.get(0).getText());
				Assert.assertEquals(true, true);
				break;
			}

		}
		
		log.info("sortHighToLow Executed ");
	}

	@Test
	public void CancelButton() {

		driver.get(prop.getProperty("URL"));

		LoginPage loginp = new LoginPage(driver);
		loginp.getEmail().sendKeys("standard_user");
		loginp.getPassword().sendKeys("secret_sauce");
		loginp.HitLoginbutton().click();

		LandingPage landpage = new LandingPage(driver);
		landpage.getAddtTocartOne().click();
		landpage.getAddtTocartTwo().click();
		landpage.getAddtTocartSix().click();
		landpage.getAddtTocartFour().click();

		CartList cartl = new CartList(driver);
		
		cartl.ClickTrolley().click();

		cartl.checkOutBtn().click();

		CheckOutYourInfo checkout = new CheckOutYourInfo(driver);
		checkout.cancelBtn().click();

		System.out.println(cartl.CartHeader().getText());
		Assert.assertEquals("Your Cart", cartl.CartHeader().getText());
           
		log.info("cancel button test");
	}

	
	@Test
	public void Checkout() {

		driver.get(prop.getProperty("URL"));

		LoginPage loginp = new LoginPage(driver);
		loginp.getEmail().sendKeys("standard_user");
		loginp.getPassword().sendKeys("secret_sauce");
		loginp.HitLoginbutton().click();

		LandingPage landpage = new LandingPage(driver);
		landpage.getAddtTocartOne().click();
		landpage.getAddtTocartTwo().click();
		landpage.getAddtTocartSix().click();
		landpage.getAddtTocartFour().click();

		CartList cartl = new CartList(driver);

	

		cartl.ClickTrolley().click();

		cartl.checkOutBtn().click();

		CheckOutYourInfo checkout = new CheckOutYourInfo(driver);
		System.out.println(checkout.getCheckOutHeading().getText());

		landpage.clickMenuBtn().click();

		
		landpage.LogoutBtn().click();

		Assert.assertEquals(true, loginp.getLoginCredentials().isDisplayed());
		
		log.info("Checkout Executed ");
	}
	
	@Test
	public void About() {

		driver.get(prop.getProperty("URL"));

		LoginPage loginp = new LoginPage(driver);
		loginp.getEmail().sendKeys("standard_user");
		loginp.getPassword().sendKeys("secret_sauce");
		loginp.HitLoginbutton().click();

		LandingPage landpage = new LandingPage(driver);
	

		landpage.clickMenuBtn().click();

		
		landpage.aboutbtn().click();
		
		SouceLabsPage source = new SouceLabsPage(driver);
		
	    System.out.println(source.title().getText());

		Assert.assertEquals("CONTINUOUS TESTING CLOUD", source.title().getText());
		
		log.info("About Executed ");
	}
	
	@Test
	public void AllItems() {

		driver.get(prop.getProperty("URL"));

		LoginPage loginp = new LoginPage(driver);
		loginp.getEmail().sendKeys("standard_user");
		loginp.getPassword().sendKeys("secret_sauce");
		loginp.HitLoginbutton().click();

		LandingPage landpage = new LandingPage(driver);
	

		landpage.clickMenuBtn().click();

		
		landpage.AllItems().click();
		
		
		
	  

		Assert.assertEquals("Products", landpage.getProductHeader().getText());
		
		log.info("All Items Executed ");
	}


	@Test
	public void ContinueWitoutDetails() {

		driver.get(prop.getProperty("URL"));

		LoginPage loginp = new LoginPage(driver);
		loginp.getEmail().sendKeys("standard_user");
		loginp.getPassword().sendKeys("secret_sauce");
		loginp.HitLoginbutton().click();

		LandingPage landpage = new LandingPage(driver);
		landpage.getAddtTocartOne().click();
		landpage.getAddtTocartTwo().click();
		landpage.getAddtTocartSix().click();
		landpage.getAddtTocartFour().click();

		CartList cartl = new CartList(driver);
		cartl.ClickTrolley().click();

		cartl.checkOutBtn().click();

		CheckOutYourInfo checkout = new CheckOutYourInfo(driver);
		checkout.Clickcontinue().click();

		Assert.assertEquals(true, checkout.errorMessage().isDisplayed());

		log.info("ContinueWitoutDetails Executed ");
	}

	@Test
	public void ContinueWithDetails() {

		driver.get(prop.getProperty("URL"));

		LoginPage loginp = new LoginPage(driver);
		loginp.getEmail().sendKeys("standard_user");
		loginp.getPassword().sendKeys("secret_sauce");
		loginp.HitLoginbutton().click();

		LandingPage landpage = new LandingPage(driver);
		landpage.getAddtTocartOne().click();
		landpage.getAddtTocartTwo().click();
		landpage.getAddtTocartSix().click();
		landpage.getAddtTocartFour().click();

		CartList cartl = new CartList(driver);
		cartl.ClickTrolley().click();

		cartl.checkOutBtn().click();

		CheckOutYourInfo checkout = new CheckOutYourInfo(driver);

		checkout.getFirstName().sendKeys("Michael");
		checkout.getLastName().sendKeys("Djamba");
		checkout.getPostalCode().sendKeys("7780");
		checkout.Clickcontinue().click();
		CheckOutOverView overView = new CheckOutOverView(driver);
		System.out.println(overView.getOverViewHeader().getText());

		 Assert.assertEquals(true, overView.getOverViewHeader().isDisplayed());
		 
		 log.info("ContinueWithDetails Executed ");
	}
	
	@Test
	public void CancelOverView() {

		driver.get(prop.getProperty("URL"));

		LoginPage loginp = new LoginPage(driver);
		loginp.getEmail().sendKeys("standard_user");
		loginp.getPassword().sendKeys("secret_sauce");
		loginp.HitLoginbutton().click();

		LandingPage landpage = new LandingPage(driver);
		landpage.getAddtTocartOne().click();
		landpage.getAddtTocartTwo().click();
		landpage.getAddtTocartSix().click();
		landpage.getAddtTocartFour().click();

		CartList cartl = new CartList(driver);
		cartl.ClickTrolley().click();

		cartl.checkOutBtn().click();

		CheckOutYourInfo checkout = new CheckOutYourInfo(driver);

		checkout.getFirstName().sendKeys("Michael");
		checkout.getLastName().sendKeys("Djamba");
		checkout.getPostalCode().sendKeys("7780");
		checkout.Clickcontinue().click();
		CheckOutOverView overView = new CheckOutOverView(driver);
		System.out.println(overView.getOverViewHeader().getText());

		overView.cancelBtnOverView().click();
		Assert.assertEquals("Products", landpage.getProductHeader().getText());
		
		 log.info("CancelOverView Executed ");
	}

	
	@Test
	public void FinishOrder() {

		driver.get(prop.getProperty("URL"));

		LoginPage loginp = new LoginPage(driver);
		loginp.getEmail().sendKeys("standard_user");
		loginp.getPassword().sendKeys("secret_sauce");
		loginp.HitLoginbutton().click();

		LandingPage landpage = new LandingPage(driver);
		landpage.getAddtTocartOne().click();
		landpage.getAddtTocartTwo().click();
		landpage.getAddtTocartSix().click();
		landpage.getAddtTocartFour().click();

		CartList cartl = new CartList(driver);
		cartl.ClickTrolley().click();

		cartl.checkOutBtn().click();

		CheckOutYourInfo checkout = new CheckOutYourInfo(driver);

		checkout.getFirstName().sendKeys("Michael");
		checkout.getLastName().sendKeys("Djamba");
		checkout.getPostalCode().sendKeys("7780");
		checkout.Clickcontinue().click();
		CheckOutOverView overView = new CheckOutOverView(driver);
		System.out.println(overView.getOverViewHeader().getText());

		overView.getFinishBtn().click();
		
		FinishPage finishpage = new FinishPage(driver);
		
		Assert.assertEquals("Finish", finishpage.finishTitle().getText());
		 log.info("Finish Order Executed ");
	}
	
	
	
	
	
	
	@AfterTest
	public void closeTest() {

		driver.close();
	}
}
