package pom;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwabLabsToFaceBook {
	@FindBy (xpath = "(//div[@class='x9f619 x1n2onr6 x1ja2u2z'])[1]")private WebElement facebook;
	
	public SwabLabsToFaceBook(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public boolean isFacebookPageIsDisplayed (WebDriver driver,boolean b) {
		Set<String> handles =driver.getWindowHandles();
		Iterator<String>i= handles.iterator();
		
		while(i.hasNext()) {
			String handle =i.next();
			driver.switchTo().window(handle);
			String currentUrl = driver.getCurrentUrl();
			if(currentUrl == "https://www.facebook.com/saucelabs") {
				b=facebook.isDisplayed();
			}
		}
		return b;
		
		
	}

}
