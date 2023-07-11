package Com.Maven_Project;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class Base_All {
	
	public static WebDriver driver;

//  1.	Browser launch()
	public static WebDriver browserLaunch(String opt)
	{
		try {
			
			if(opt.equalsIgnoreCase("Chrome"))
			{
				System.setProperty("webdriver.chrome.driver", 
						"C:\\Users\\punit\\eclipse-workspace\\Maven-Project\\Driver\\chromedriver.exe");
				
				driver= new ChromeDriver();
			}
			
		}
		catch(Exception e) {
			
		}
		return driver;
	}
//	2.	Close()
	public static void driverClose()
	{
		driver.close();
	}
//	3.	Quit()
	public static void driverQuit()
	{
		driver.quit();
	}
//	4.	Navigate to()
    public static void navigateTo(String url)
    {
    	driver.navigate().to(url);
    }
//	5.	Navigate back()
    public static void navigateBack()
    {
    	driver.navigate().back();
    }
//	6.	Navigate forward ()
    public static void navigateForward()
    {
    	driver.navigate().forward();
    }
//	7.	Navigate refresh()
    public static void navigateRefresh()
    {
    	driver.navigate().refresh();
    }
//	8.	Get()
    public static void urlLaunch(String url)
	{
		driver.get(url);
	}
//	9.	Alert()
    public static void alertMethod(String option)
    {
    	switch(option.toLowerCase()) {
    	case "accept":
    		driver.switchTo().alert().accept();
    		break;
    	case "dismiss":
    		driver.switchTo().alert().dismiss();
    		break;
    	default:
    		System.out.println("Invalid option");
    		break; 		
    	}  	 	
    }
    public static void alertSendKeys(String keys)
    {
    	driver.switchTo().alert().sendKeys(keys);
    }
//	10.	Action(All methods from action class)
    public static void actionMethods(String option,WebElement ele)
    {
    	Actions act = new Actions(driver);
    	switch(option.toLowerCase())
    	{
    	case "click":
    		act.click(ele).build().perform();
    		break;
    	case "contextclick":
    		act.contextClick(ele).build().perform();
    		break;
    	case "doubleclick":
    		act.doubleClick(ele).build().perform();
    		break;
    	case "movetoelement":
    		act.moveToElement(ele).build().perform();
    		break;
    	case "clickandhold":
    		act.moveToElement(ele).build().perform();
    		break;
    	case "release":
    		act.release(ele).build().perform();
    		break;
    	default:
    		System.out.println("Invalid input");
    		break;
    	} 	
    }
    public static void actionDragandDrop(WebElement src,WebElement dest)
    {
    	Actions act = new Actions(driver);
    	act.dragAndDrop(src, dest);
    }
//	11.	Frames()
    public static void frameIndex(int index)
    {
    	driver.switchTo().frame(index);
    }
    public static void frameName(String name)
    {
    	driver.switchTo().frame(name);
    }
    public static void frameWebElement(WebElement ele)
    {
    	driver.switchTo().frame(ele);
    }
//	12.	Robot()
    public static void robot(String option) throws AWTException {
     Robot r = new Robot();
     
    if (option.equalsIgnoreCase("Enter")) {
    	 
        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);
     }
    else if (option.equalsIgnoreCase("down")) {
       r.keyPress(KeyEvent.VK_DOWN);
       r.keyRelease(KeyEvent.VK_DOWN);
    }
     else if (option.equalsIgnoreCase("up")) {
     r.keyPress(KeyEvent.VK_UP);
     r.keyRelease(KeyEvent.VK_UP);
     }
     else if (option.equalsIgnoreCase("left")) {
     r.keyPress(KeyEvent.VK_LEFT);
     r.keyRelease(KeyEvent.VK_LEFT);
    }
     else if (option.equalsIgnoreCase("Right")) {
     r.keyPress(KeyEvent.VK_RIGHT);
     r.keyRelease(KeyEvent.VK_RIGHT);
     }
    }

//	13.	Window handles()
    public static String getWindowHandle()
    {
    	return driver.getWindowHandle();
    }
    public static Set<String> getWindowsHandles()
    {
    	return driver.getWindowHandles();
    }
//	14.	Drop down ()
    public static void dropDownMethods(Select sel,String option, String args)
    {
    	switch(option.toLowerCase())
    	{
    	case "index":
    		sel.selectByIndex(Integer.parseInt(args));
    		break;
    	case "value":
    		sel.selectByValue(args);
    		break;
    	case "visibletext":
    		sel.selectByVisibleText(args);
    		break;
    	default:
    		System.out.println("Invalid op[tion");
    		break; 			  		
    	} 
    	
    }
 // 30.	Is multiple()
    public static boolean isMultiple(Select sel)
    {
    	return sel.isMultiple();
    }
//	15.	Check box()
    public static void checkBox(WebElement ele)
    {
    	ele.click();
    }
    public static boolean checkBoxMethods(WebElement ele,String option)
    {
    
    	boolean bool= false;
    	int i ;
    	switch(option.toLowerCase())
    	{
//    	18.	Is selected()
    	case "isselected":
    	  bool = ele.isSelected();
    	  break;
//    	17.	Is displayed()
    	case "isdisplayed":
    		bool = ele.isDisplayed();
    		break;
//    		16.	Is enable()
    	case "isenabled":
    		bool=ele.isEnabled();
    		break;
    	default:
    		System.out.println("Invalid option");
    		break;		
    	}
		return bool;
    }

    public static List<WebElement> getOptions(Select sel,String option)
    {
    	List<WebElement>options= null;
    	switch(option.toLowerCase())
    	{
//    	19.	Get options()
    	case "getoptions":
    		options = sel.getOptions();
    		break;
    	// 29.	Get all selected options()
    	case "getallselectedoptions":
    		options=sel.getAllSelectedOptions();
    		break;
    	default:
    		System.out.println("Invalid option");
    		break;		
    	}
		return options;  	
    }
    //28.getFirstSelectedOption
    public static WebElement getFirstSelectedOption(Select sel)
    {
    	return sel.getFirstSelectedOption();  	
    }
//	20.	Get title()
    public static String getTitle()
    {
    	return driver.getTitle();
    }
//	21.	Get current url()
    public static String getCurrentURL()
    {
    	return driver.getCurrentUrl();
    }
//	22.	Get text()
    public static String getText(WebElement ele)
    {
    	return ele.getText();
    }
//	23.	Get attribute()
    public static String getAttribute(WebElement ele,String name)
    {
    	return ele.getAttribute(name);
    }
//	24.	Wait()
    public static void waitImplicit(long sec)
    {
    	driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
    }
//	25.	Take screenshot()
    public static void screenShotMethod(String name) throws IOException
    {
    	TakesScreenshot sShot = (TakesScreenshot)driver;
    	File src = sShot.getScreenshotAs(OutputType.FILE);
    	File dest = new File("C:\\Users\\punit\\eclipse-workspace\\Maven-Project\\ScreenShot\\"+name+"");
    	FileHandler.copy(src, dest);   	
    }
//	26.	Scroll up and down()
//	27.	Sendkeys()
    public static void sendkeysMethod(WebElement ele,String arguments)
    {
    	ele.sendKeys(arguments);  	
    }
 // 31.	Click()
    public static void clickMethod(WebElement ele)
    {
    	ele.click();
    }
 // 32.RadioButton()
    public static void radioButton(WebElement ele) 
    {
    	ele.click();
    }
    //33.Maximise
    public static void maximize()
    {
    	driver.manage().window().maximize();
    }
  
    //Scroll page By pixels
    public static void ScrollByAxis(int x, int y) {
   
     JavascriptExecutor js=(JavascriptExecutor) driver;
     js.executeScript("window.scrollBy(x,y);");
     }
    //Scroll page by the visibility of Element
     public static void ScrollByElement(WebElement ele) {
     JavascriptExecutor js=(JavascriptExecutor) driver;
     js.executeScript("arguments[0].scrollIntoView();",ele);
     }
     
     //Scroll page and click
    public static void ScrollAndClick(WebElement ele) {
    JavascriptExecutor js=(JavascriptExecutor) driver;
     js.executeScript("arguments[0].click();", ele);
    }
    //Scroll page until the bottom of the page
     public static void scrollToEnd() {
    JavascriptExecutor js=(JavascriptExecutor) driver;
    js.executeScript("window.scrollTo(0,document.body.scrollHeight);","");
    }



}
