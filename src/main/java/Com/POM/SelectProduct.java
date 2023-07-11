package Com.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectProduct {
	
	public static WebDriver driver;
	public SelectProduct(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[contains(text(),\"Accept\")]")
	private WebElement accept;
	
	@FindBy(xpath="//span[contains(text(),\"Jewellery & Accessories\")]")
	private WebElement jewellery;
	
	@FindBy(xpath="(//span[contains(text(),\"Bags & Purses\")])[1]")
	private WebElement bags;
	
	@FindBy(partialLinkText = "Shoulder Bags")
	private WebElement shoulderBags;
	
	@FindBy(xpath="//p[contains(text(),\"Minimalist\")]")
	private WebElement minimalist;
	
	@FindBy(partialLinkText ="Black Crossbody Linen bag, Natural Shopping bag, "
			+ "Handmade Linen Shoulder bag, Minimalist Eco Reusable Grocery Bag, Various Colors")
	private WebElement bagName;
	
	@FindBy(xpath = "//select[@id=\"variation-selector-0\"]")
	private WebElement selectColour;
	
	@FindBy(xpath="//button[contains(text(),\"Add to basket\")]")
	private WebElement addToBasket;
	

	public WebElement getAddToBasket() {
		return addToBasket;
	}

	public WebElement getSelectColour() {
		return selectColour;
	}

	public WebElement getBagName() {
		return bagName;
	}

	public WebElement getMinimalist() {
		return minimalist;
	}

	public WebElement getShoulderBags() {
		return shoulderBags;
	}

	public WebElement getBags() {
		return bags;
	}

	public WebElement getJewellery() {
		return jewellery;
	}

	public WebElement getAccept() {
		return accept;
	}
	

}
