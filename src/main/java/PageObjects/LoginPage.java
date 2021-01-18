package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	

	
	By email = By.id("user-name");
	By password =By.id("password");
	By loginButton =By.cssSelector("input[id='login-button']");
	By logincredentials = By.cssSelector("div[id='login_credentials']");
	By Errormessage = By.cssSelector("div[id='login_button_container'] > div > form > h3");
	
	public WebElement getLoginCredentials() {

		return driver.findElement(logincredentials);
	}
	public WebElement getEmail() {
		
		return driver.findElement(email);
	}
	
	public WebElement lockedUser() {
		
		return driver.findElement(Errormessage);
	}
	
	
	public WebElement getPassword() {
		
		return driver.findElement(password);
	}
	
	public WebElement HitLoginbutton() {
		
		return driver.findElement(loginButton);
	}

}
