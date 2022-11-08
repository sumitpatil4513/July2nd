package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SwabLabsHomePage {
	@FindBy (xpath = "//div[@class='header_secondary_container']")private WebElement productPage;
  @FindBy (xpath = "//button[@id='react-burger-menu-btn']")private WebElement pageOptions;
  @FindBy (xpath = "//div[@class='bm-menu-wrap']")private WebElement listOfOptions;
  @FindBy (xpath = "//a[@id='inventory_sidebar_link']")private WebElement allItems;
  @FindBy (xpath = "//a[@id='about_sidebar_link']")private WebElement about;
  @FindBy (xpath = "//a[@id='logout_sidebar_link']")private WebElement logout;
  @FindBy (xpath = "//a[@id='reset_sidebar_link']")private WebElement resetAppState;
  @FindBy (xpath = "//button[@id='react-burger-cross-btn']")private WebElement closeButton;
  @FindBy (xpath = "//a[@class='shopping_cart_link']")private WebElement cartLogo;
  
  @FindBy (xpath = "//select[@class='product_sort_container']")private WebElement filter;
  @FindBy (xpath = "(//div[@id='inventory_container'])[2]")private WebElement highToLow;
  
  @FindBy (xpath = "//button[text()='Add to cart']")private List<WebElement> addToCart;
  @FindBy (xpath = "//button[text()='Remove']")private List<WebElement> remove;
  @FindBy (xpath = "//div[text()='Sauce Labs Backpack']")private WebElement product;
  @FindBy (xpath = "//button[text()='Add to cart']")private WebElement productAddToCart;
  
  
  @FindBy (xpath = "//a[@href='https://twitter.com/saucelabs']")private WebElement twitter;
  @FindBy (xpath = "//a[@href='https://www.facebook.com/saucelabs']")private WebElement facebook;
  @FindBy (xpath = "//a[@href='https://www.linkedin.com/company/sauce-labs/']")private WebElement linkedIn;
  
  public SwabLabsHomePage(WebDriver driver) {
	  PageFactory.initElements(driver, this);
  }
  public void clickOnOptions() {
	  pageOptions.click();
  }
  public void clickOnAllItems() {
	  allItems.click();
  }
  public void clickOnAbout() throws InterruptedException {
	  about.click();
	  Thread.sleep(2000);
	WebDriver driver = new ChromeDriver();
	  driver.navigate().back();
  }
  public void clickOnLogout() {
	  logout.click();
  }
  public void clickOnResetAppState() {
	  resetAppState.click();
  }
  public void clickOnCloseButton() {
	closeButton.click();
  }
  public void clickOnCartLogo() {
	  cartLogo.click();
  }
  public void selectFilter(int index) {
	  Select select = new Select(filter);
	select.selectByIndex(index);
	
		
	}
  public void clickOnAddToCart(int product) {
	  addToCart.get(product).click();
  }
  public void clickOnRemove(int product) {
	  remove.get(product).click();
  }
  
  public void openTwitterPage() {
	  twitter.click();
	  
  }
  public void openFacebookPage() {
	  facebook.click();
  }
  public void openLinkedInPage() {
	  linkedIn.click();
  }
  public boolean isRemovedButtonDisplayed(int product) {
	  return remove.get(product).isDisplayed();
  }
  public void addMultipaleProductsToCart(int size) {
	 
	  for(int i=addToCart.size()-1;i>=0;i--) 
	  {
		  addToCart.get(i).click();
		  
	  }  
  }
  public int getNumberOfAddToCartButton() {
	  return addToCart.size();
  }
  public int getNumberOfRemoveButton() {
	  return remove.size();  
  }
  
  public void removeMultipleProductsFromCart(int size) {
	  for(int i=remove.size()-1;i>=0;i--) 
	  {
		  remove.get(i).click();
	  }
  }
  public boolean isAddToCartButtonDisplayed(int product) {
	  return addToCart.get(product).isDisplayed();
  }
  public void selectProduct() {
	  product.click();
  }
  public void addProductToCart() {
	  productAddToCart.click();
  }
  public boolean isListOfOptionDisplayed() {
	  boolean value = listOfOptions.isDisplayed();
	  return value;
  }
  public void selectFilter1By1() 
  {
	  Select select = new Select(filter);
	  for(int i = 0;i<4;i++) 
	  {
		 select.selectByIndex(i);
	  }
  }
  public boolean isHighToLowPriceInventoryListDisplayed() {
	  return highToLow.isDisplayed();
  }
 public boolean isProductPageIsDisplayed() {
	 return productPage.isDisplayed();
 }
  
  
}

