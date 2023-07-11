package Com.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Payment {
	
	public static WebDriver driver;
	
	public Payment(WebDriver driver) {
		
		this.driver= driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(xpath="//button[contains(text(),\" Continue as a guest\")]")
	private WebElement guestCheckout;
	
	@FindBy(id = "shipping-form-email-input")
	private WebElement emailInput;
	
	@FindBy(id = "shipping-form-email-confirmation")
	private WebElement confirmationEmailInput;
	
	@FindBy(name = "name")
	private WebElement customerName;
	
	@FindBy(name = "first_line")
	private WebElement firstLineAddress;
	
	@FindBy(name = "city")
	private WebElement cityName;
	
	@FindBy(name="zip")
	private WebElement postCode;
	
	@FindBy(xpath="//span[text()=\"Continue to payment\"]")
	private WebElement paymentEntry;
	
	@FindBy(xpath = "//button[contains(text(),\"Continue as guest\")]")
	private WebElement continueAsGuest;
	
	@FindBy(xpath = "//input[@id=\"cc-radio--paymentstep\"]")
	private WebElement ccPaymentStep;
	
	@FindBy(id = "cc-name--paymentstep")
	private WebElement namePaymentStep;
	
	@FindBy(id="cc-num--paymentstep")
	private WebElement cardNumber;
	
	@FindBy(name = "card[exp_mon]")
	private WebElement expiryMonth;
	
	@FindBy(name="card[ccv]")
	private WebElement ccv;
	
	@FindBy(name="payment_submit")
	private WebElement paymentSubmit;
	
	public WebElement getPaymentSubmit() {
		return paymentSubmit;
	}

	public WebElement getCcv() {
		return ccv;
	}

	public WebElement getExpiryYear() {
		return expiryYear;
	}

	@FindBy(name="card[exp_year]")
	private WebElement expiryYear;
	
	public WebElement getExpiryMonth() {
		return expiryMonth;
	}

	public WebElement getCardNumber() {
		return cardNumber;
	}

	public WebElement getNamePaymentStep() {
		return namePaymentStep;
	}

	public WebElement getCCPaymentStep() {
		return ccPaymentStep;
	}

	public WebElement getContinueAsGuest() {
		return continueAsGuest;
	}

	public WebElement getPaymentEntry() {
		return paymentEntry;
	}

	public WebElement getPostCode() {
		return postCode;
	}

	public WebElement getCityName() {
		return cityName;
	}

	public WebElement getFirstLineAddress() {
		return firstLineAddress;
	}

	public WebElement getCustomerName() {
		return customerName;
	}

	public WebElement getConfirmationEmailInput() {
		return confirmationEmailInput;
	}

	public WebElement getEmailInput() {
		return emailInput;
	}

	public WebElement getGuestCheckout() {
		return guestCheckout;
	}

	@FindBy(partialLinkText = "View basket & check out")
	private WebElement viewBasket;
	
	public WebElement getCheckOut() {
		return checkOut;
	}

	@FindBy(xpath = "//span[text()=\"Proceed to checkout\"]")
	private WebElement checkOut;

	public WebElement getViewBasket() {
		return viewBasket;
	}

}
