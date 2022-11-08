package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwabLabsCheckoutOverview {
	@FindBy (xpath = "(//div[@class='cart_quantity'])")private WebElement qty;
	@FindBy (xpath = "(//button[@class='btn btn_action btn_medium cart_button'])")private WebElement finish;
	@FindBy (xpath = "(//button[@class='btn btn_secondary back btn_medium cart_cancel_link'])")private WebElement cancle;
	@FindBy (xpath = "//span[text()='Checkout: Overview']")private WebElement overView;
    public SwabLabsCheckoutOverview(WebDriver driver) {
	PageFactory.initElements(driver, this);
    }
    public void putQty(String Qty) {
    	qty.clear();
    	qty.sendKeys(Qty);
    }
    public void clickOnFinish() {
    	finish.click();
    }
    public void clickOnCancle() {
    	cancle.click();
    }
    public boolean isOverviewDisplayed() {
    	return overView.isDisplayed();
    }
}
