package Com.Runner;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import Com.Maven_Project.Base_All;
import Com.POM.Launch_URL;
import Com.POM.Payment;
import Com.POM.SelectProduct;

public class ProjectClass extends Base_All{
	
	public static WebDriver driver;

	public static void main(String[] args) throws IOException, InterruptedException {
		try {
		
			//Launch url method
		driver = browserLaunch("Chrome");
		Launch_URL url = new Launch_URL();
	    urlLaunch(url.getURL());
	    maximize();
	    waitImplicit(20);
	    screenShotMethod("HomePage");
	    
	    //select product POM class
	    SelectProduct sp = new SelectProduct(driver);
	    //Accept cookies
	    clickMethod( sp.getAccept());
	    //Select Jewellery
	    actionMethods("movetoelement", sp.getJewellery());
	    screenShotMethod("Bag");
	    //select bags
	    clickMethod(sp.getBags());
	    //Select ShoulderBags
	    clickMethod(sp.getShoulderBags());
	    //Select Minimalist
	    clickMethod(sp.getMinimalist());
	    screenShotMethod("ListBags");
	    
	    //Select the bag by name
	    clickMethod(sp.getBagName());
	    
	    Set<String>allWindows= getWindowsHandles();
	    String currentWindow = getWindowHandle();
	    for(String win: allWindows)
		   {
			   if(!win.equals(currentWindow))
			   {
				   driver.switchTo().window(win);
				   break;
			   }
		   }
	    screenShotMethod("BagSelect");
	    Thread.sleep(2000);
	    
	    Select sel = new Select(sp.getSelectColour());
	    dropDownMethods(sel, "value", "1846486014");
	    Thread.sleep(1000);
        clickMethod(sp.getAddToBasket());
        screenShotMethod("Basket");
        
        Payment p = new Payment(driver);
        clickMethod(p.getViewBasket());
        clickMethod(p.getCheckOut());
        clickMethod(p.getGuestCheckout());
        sendkeysMethod(p.getEmailInput(), "Punitha123@gmail.com");
        sendkeysMethod(p.getConfirmationEmailInput(), "Punitha123@gmail.com");
        sendkeysMethod(p.getCustomerName(), "Punitha");
        sendkeysMethod(p.getFirstLineAddress(), "18/1, Steads place");
        sendkeysMethod(p.getCityName(), "Edinburgh");
        sendkeysMethod(p.getPostCode(), "EH72DS");
        screenShotMethod("Address");
        clickMethod(p.getPaymentEntry());
        Thread.sleep(10000);
        clickMethod(p.getContinueAsGuest());
        Thread.sleep(10000);
        actionMethods("click",p.getCCPaymentStep());
        System.out.println("done click");
        sendkeysMethod(p.getNamePaymentStep(), "Punithavathi");
        sendkeysMethod(p.getCardNumber(), "534567891234");
        Select sel1 = new Select(p.getExpiryMonth());
        dropDownMethods(sel1, "value", "7");
        dropDownMethods(new Select(p.getExpiryYear()), "value", "2024");
        sendkeysMethod(p.getCcv(), "123");
        clickMethod(p.getPaymentSubmit());
        screenShotMethod("Payment");
        Thread.sleep(10000);
        driverQuit();
		}
		catch(Exception e) {
			System.out.println(e);
			
		}
        
	    

	}

}
