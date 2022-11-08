package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwabLabsCheckoutComplete {
	@FindBy (xpath = "(//button[@class='btn btn_primary btn_small'])")private WebElement backHome;
	@FindBy (xpath = "//span[text()='Checkout: Complete!']")private WebElement checkoutComplete;
	
    public SwabLabsCheckoutComplete(WebDriver driver) {
    	PageFactory.initElements(driver, this);
    }
    public void clickOnBackHome() {
    	backHome.click();
    }
    public boolean isCheckOutCompletePageDisplayed() 
    {
    	return checkoutComplete.isDisplayed();
    }
}
