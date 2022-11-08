package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwabLabsCheckoutYourInformation {
	@FindBy (xpath = "//button[@class='btn btn_action btn_medium checkout_button']")private WebElement checkout;
	@FindBy (xpath = "(//input[@class='input_error form_input'])[1]")private WebElement firstName;
	@FindBy (xpath = "(//input[@class='input_error form_input'])[2]")private WebElement lastName;
	@FindBy (xpath = "(//input[@class='input_error form_input'])[3]")private WebElement zipCode;
	@FindBy (xpath = "//input[@id='continue']")private WebElement continues;
	@FindBy (xpath = "//button[@class='btn btn_secondary back btn_medium cart_cancel_link']")private WebElement cancle;
	@FindBy (xpath = "//span[text()='Checkout: Your Information']")private WebElement yourInfo;
	
	
	
	
	public SwabLabsCheckoutYourInformation(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void clickOnCheckout() {
		checkout.click();
	}
	public void enterFirstName(String firstnam) {
		firstName.sendKeys(firstnam);
    }
	public void enterLastName(String lastnam) {
		lastName.sendKeys(lastnam);
    }
	public void enterZipCode(String Zip) {
		zipCode.sendKeys(Zip);
    }
	public void clickOnContinue() {
		continues.click();
    }
	public void clickOnCancle() {
		cancle.click();
    }
	public boolean isCheckoutYourInformationPageDisplayed() {
		return yourInfo.isDisplayed();
	}

}
