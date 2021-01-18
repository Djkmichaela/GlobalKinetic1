package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LandingPage {
 
	public WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	
	By addTocartOne = By.cssSelector(" div > div:nth-child(1) > div.pricebar > button");
	By addTocartTwo = By.cssSelector(" div > div:nth-child(2) > div.pricebar > button");
	By addTocartThree = By.cssSelector(" div > div:nth-child(3) > div.pricebar > button");
	By addTocartFour = By.cssSelector(" div > div:nth-child(4) > div.pricebar > button");
	By addTocartFive = By.cssSelector(" div > div:nth-child(5) > div.pricebar > button");
	By addTocartSix = By.cssSelector(" div > div:nth-child(6) > div.pricebar > button");
	By addTocartSeven = By.cssSelector(" div > div:nth-child(7) > div.pricebar > button");
	By addTocartEight = By.cssSelector(" div > div:nth-child(8) > div.pricebar > button");
	
	By dropdownselect = By.className("product_sort_container");
	By productHeader = By.cssSelector("div[class='product_label']");
	
	By MenuBtn = By.className("bm-burger-button");
	By Menuframe = By.className("bm-menu-wrap");
	By logout = By.cssSelector("a[id='logout_sidebar_link']");
	By about = By.cssSelector("#about_sidebar_link");
	By AllItems = By.cssSelector("a[id='inventory_sidebar_link']");
	
	public WebElement AllItems()
	{
		return driver.findElement(AllItems);
	}

	public WebElement LogoutBtn()
	{
		return driver.findElement(logout);
	}
	
	public WebElement aboutbtn()
	{
		return driver.findElement(about);
	}
	
	public WebElement MenuFrame()
	{
		return driver.findElement(Menuframe);
	}
	
	public WebElement clickMenuBtn()
	{
		return driver.findElement(MenuBtn);
	}
	
	public WebElement getAddtTocartOne() {
		
		return driver.findElement(addTocartOne);
	}
	
	public WebElement getAddtTocartTwo() {

		return driver.findElement(addTocartTwo);
	}

	public WebElement getAddtTocartThree() {

		return driver.findElement(addTocartThree);
	}

	public WebElement getAddtTocartFour() {

		return driver.findElement(addTocartFour);
	}

	public WebElement getAddtTocartFive() {

		return driver.findElement(addTocartFive);
	}

	public WebElement getAddtTocartSix() {

		return driver.findElement(addTocartSix);
	}

	public WebElement getAddtTocartSeven() {

		return driver.findElement(addTocartSeven);
	}

	public WebElement getAddtTocartEight() {

		return driver.findElement(addTocartEight);
		
	}

	public WebElement getProductHeader() {
		
		return driver.findElement(productHeader);
	}
	
	public WebElement getDropdown() {
		
		return driver.findElement(dropdownselect);
	}
	
}
