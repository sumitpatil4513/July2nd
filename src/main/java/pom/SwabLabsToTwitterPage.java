package pom;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwabLabsToTwitterPage {
	@FindBy (xpath = "//div[@id='react-root']")private WebElement twitter;
	
	public SwabLabsToTwitterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public boolean isTwitterPageDisplayed(WebDriver driver,boolean a) {
		Set<String> handles= driver.getWindowHandles();
		Iterator <String> i = handles.iterator();
		
		while (i.hasNext()) {
			
			String handle = i.next();
			driver.switchTo().window(handle);
			String currenttitle = driver.getCurrentUrl();
			
			if(currenttitle.equals("https://twitter.com/saucelabs")){
				 a = twitter.isDisplayed();
			}}
		return a;
	}

}
