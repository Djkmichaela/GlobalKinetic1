package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FinishPage {
	public WebDriver driver;
	
	public FinishPage(WebDriver driver)
	{
		this.driver =driver;
	}
	
	By finishbtn  = By.cssSelector("div[id='contents_wrapper'] > div.subheader");
	
	public WebElement finishTitle() {
		
		return driver.findElement(finishbtn);	}

}
