package pom;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwabLabsToLinkedIn {
@FindBy (xpath= "//div[@class='focus-page']")private WebElement linkedIn;

	public SwabLabsToLinkedIn(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}
	
	public boolean isLinkedInLoginPageDisplayed(WebDriver driver,boolean c) {
		Set<String> handles=driver.getWindowHandles();
		Iterator<String> i = handles.iterator();
		
		while(i.hasNext()) {
			String handle= i.next();
			driver.switchTo().window(handle);
			String url = driver.getCurrentUrl();
			if(url=="") {
				c = linkedIn.isDisplayed();
			}
		}
		return c;
	}

}
