package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartList {
	
	public WebDriver driver;
	
	public CartList(WebDriver driver) {
		this.driver = driver;
	}

	
	By cartlist = By.cssSelector("span[class='fa-layers-counter shopping_cart_badge']");
	By Trolley = By.cssSelector("[class='svg-inline--fa fa-shopping-cart fa-w-18 fa-3x ']");
	By checkoutbtn = By.cssSelector("a[class='btn_action checkout_button']");
	
	By continueshopingBtn = By.cssSelector("a[class='btn_secondary']");
	By removeSourceBackLab = By.cssSelector("div:nth-child(3) > div.cart_item_label > div.item_pricebar > button");
	By removeBikeLight = By.cssSelector("div:nth-child(4) > div.cart_item_label > div.item_pricebar > button");
	By removeTShirt = By.cssSelector("div:nth-child(5) > div.cart_item_label > div.item_pricebar > button");
	By removeFleeceJacket = By.cssSelector("div:nth-child(6) > div.cart_item_label > div.item_pricebar > button");
	
	By notItemsInCart = By.cssSelector("div[class='removed_cart_item']");
	By CartHeader = By.cssSelector("div[class='subheader']");
	
	
	public WebElement getCartItems()
	{
		return driver.findElement(cartlist);
	}
	

	
	public WebElement ClickTrolley()
	{
		return driver.findElement(Trolley);
	}
	
	public WebElement removeBackPack() {
		
		return driver.findElement(removeSourceBackLab);
	}
	
	public WebElement removeBikeLight() {

		return driver.findElement(removeBikeLight);
	}
	
	public WebElement removeTshirt()
	{
		return driver.findElement(removeTShirt);
	}
	
	public WebElement removeFleeceJacket()
	{
		return driver.findElement(removeFleeceJacket);
	}
	
	public WebElement checkOutBtn() {
		
		return driver.findElement(checkoutbtn);
	}
	
	public WebElement continueShoping() {
		
		return driver.findElement(continueshopingBtn);
	}
	
	public WebElement NotItemsInCart() {
		
		return driver.findElement(notItemsInCart);
	}
	
	public WebElement CartHeader() {
		
		return driver.findElement(CartHeader);
	}
}
