package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutOverView {
	
	public WebDriver driver;
	
	public CheckOutOverView(WebDriver driver) {
		
		this.driver = driver;
	}
	
	By CheckoutOverViewHeader = By.cssSelector("div[id='contents_wrapper'] > div.subheader");
	By concelOverView = By.cssSelector(" a.cart_cancel_link.btn_secondary");
	By finishBtn = By.cssSelector("a.btn_action.cart_button");
	
	public WebElement getOverViewHeader() {
		
		return driver.findElement(CheckoutOverViewHeader);
	}
	
	public WebElement cancelBtnOverView() {

		return driver.findElement(concelOverView);
	}

	
	public WebElement getFinishBtn() {

		return driver.findElement(finishBtn);
	}
}
