package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SouceLabsPage {
	
	public WebDriver driver;
	
	public SouceLabsPage(WebDriver driver) {
		
		this.driver = driver;
	}
	

	By title = By.cssSelector("div.reference-container > div > h1");
	
	public WebElement title() {
		
		return driver.findElement(title);
	}
}
