package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwabLabsCart {
	@FindBy (xpath = "//div[@class='cart_quantity']")private WebElement qty;
	@FindBy (xpath = "//button[text()='Remove']")private WebElement remove;
	@FindBy (xpath = "//button[@class='btn btn_action btn_medium checkout_button']")private WebElement checkout;
	@FindBy (xpath = "//button[@class='btn btn_secondary back btn_medium']")private WebElement continueShipping;
	@FindBy (xpath = "//div[text()='Sauce Labs Backpack']")private WebElement productDisplayed;
	@FindBy (xpath = "//div[@class='cart_item_label']")private WebElement product;
	@FindBy (xpath = "//span[text()='Your Cart']")private WebElement yourCart;
	
	public SwabLabsCart(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void putQuantity(String Qty) {
		qty.clear();
		qty.sendKeys(Qty);
	}
	public void clickOnRemove() {
		remove.click();
	}
	public void clickOnCheckout() {
		checkout.click();
	}
	public void clickOnContinueShipping() {
		continueShipping.click();
	}
	public boolean isProductDisplayedUnderCart() {
		return productDisplayed.isDisplayed();
	}
	public boolean isRemoveButtonDisplayed() {
		return remove.isDisplayed();
	}
	public boolean isProductDiaplayed() {
		return product.isDisplayed();
	}
	public boolean isCartpageDisplayed() {
		return yourCart.isDisplayed();
	}

}
