package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutYourInfo {
	
	public WebDriver driver;
	
	public CheckOutYourInfo(WebDriver driver) {
		
		this.driver = driver;
	}

	
	By FirstName = By.id("first-name");
	By LastName = By.id("last-name");
	By PostalCode = By.id("postal-code");
	By CheckOutHeading = By.xpath("//*[@id=\"contents_wrapper\"]/div[2]");
	By CancelBtn = By.cssSelector("div.checkout_buttons > a");
	By Continue = By.cssSelector("input[class='btn_primary cart_button']");
	By errorMessage = By.cssSelector("div[id='checkout_info_container'] > div > form > h3");
	
	public WebElement Clickcontinue() {
		
		return driver.findElement(Continue);
	}
	
	public WebElement getFirstName() {
		
		return driver.findElement(FirstName);
	}
	
	public WebElement getLastName() {
		
		return driver.findElement(LastName);
	}
	
	public WebElement getPostalCode() {
		
		return driver.findElement(PostalCode);
	}
	
	public WebElement getCheckOutHeading() {
		
		return driver.findElement(CheckOutHeading);
	}
	
	public WebElement cancelBtn() {
		
		return driver.findElement(CancelBtn);
	}
	
	public WebElement errorMessage() {
		
		return driver.findElement(errorMessage);
	}
	
	
}
