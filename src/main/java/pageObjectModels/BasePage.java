package pageObjectModels;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import base.BaseTest;

public class BasePage extends BaseTest 
{

	private String BookingConfirmOrderId;
	
	
	public void type(WebElement element,String text)
	{
		waitForElementPresence(element);
		getHighLight(element);
		element.sendKeys(text);
		test.log(Status.INFO, "Entered text "+text+" into the textbox");
	}
	
	private void waitForElementPresence(WebElement element) 
	{
		
		WebDriverWait myWait=new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(configProp.getProperty("explicitWait"))));
		myWait.until(ExpectedConditions.visibilityOf(element));
	}

	public void click(WebElement element)
	{
		waitForElementPresence(element);
		getHighLight(element);
		element.click();
		test.log(Status.INFO, "Clicked  the button");
	}
	public void valueClick(WebElement element)
	{
		waitForElementPresence(element);
		String value=element.getAttribute("value");
		if(value==null)
		{
			value=element.getText();
		}
		getHighLight(element);
		element.click();
		test.log(Status.INFO, "Clicked  the "+value+" Button");
	}
	
	public void clickUsingJS(WebElement element)
	{
		//write code by your own
	}
	
	public void selectOptionFromDropdown(WebElement element,String option)
	{
		waitForElementPresence(element);
		getHighLight(element);
		new Select(element).selectByVisibleText(option);
	}
	
	public String getTitle()
	{
		return driver.getTitle();
	}
	
	public void verifyTextPresentAsValue(WebElement element,String text)
	{
		waitForElementPresence(element);
		Assert.assertTrue(element.getAttribute("value").contains(text));
		test.log(Status.PASS, "Given text "+text+" verified");	
	}
	public void verification(String actual,String expected)
	{
		
		Assert.assertEquals(actual, expected);
		test.log(Status.PASS, "Actual value  "+actual+"  expected value  "+expected+"  is matching");	
	}
	
	public void verifyInLIneErrors(WebElement element,String text)
	{
		String value=element.getText();
		Assert.assertEquals(value, text);
		test.log(Status.PASS, "Inline Error "+text+" Matched" );
		
	}
	
	public void verifyTitle(String expTitle)
	{    
		
		String value=getTitle();
		Assert.assertEquals(value, expTitle);
		test.log(Status.PASS, "Titles are matached... exptitle: "+expTitle+" matched with actTitle: "+value);
	}
	
	//for selecting drop down for string values
	public void dropDown(WebElement element ,String value)
	{
		Select sc=new Select(element);
		getHighLight(element);
		sc.selectByValue(value);
		
		test.log(Status.INFO, "Selected "+value+" from dropdown");
		
	}
	
	public void dropDownNum(WebElement element ,int value)
	{
		Select sc=new Select(element);
		getHighLight(element);
		sc.selectByIndex(value);
		
		
		test.log(Status.INFO, "Selected "+value+" from dropdown");
		
		
		
	}
	
	//this method will sendkeys after clearing the placeholders
	public void ClearType(WebElement element,String text)
	{
		waitForElementPresence(element);
		getHighLight(element);
		element.clear();
		element.sendKeys(text);
		test.log(Status.INFO, "Entered text "+text+" into the textbox");
	}
	
	
	public String getValue(WebElement element)
	{
		waitForElementPresence(element);
		String value=element.getAttribute("value");
		
		return value;
	}
	
	public void getHighLight(WebElement element)

	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.border='2px solid red' ", element);
		
	}
	
	public void priceCalcBasePage(String numberofRooms,String totalDays,String pricePerNight,int finalPricevthOutGst)
	{
		
		String numberofRooms1=numberofRooms.replaceAll("[^0-9]", "");
		String totalDays1=totalDays.replaceAll("[^0-9]", "");
		String pricePerNight1=pricePerNight.replaceAll("[^0-9]", "");
	
		
		int total_price=(Integer.parseInt(pricePerNight1)*Integer.parseInt(numberofRooms1)*Integer.parseInt(totalDays1));
		

		if(total_price==finalPricevthOutGst)
		{
		test.log(Status.PASS, "Total price ("+finalPricevthOutGst+")  and calculated price ("+total_price+")  is matching");
	    }
		else
		{
			test.log(Status.FAIL, "Total price ("+finalPricevthOutGst+")  and calculated price ("+total_price+")  is not matching");
		}
	}
		
		public void finalBillCalcBasePage(String numberofRooms,String totalDays,String pricePerNight,String finalPrice)
		{
			
			String numberofRooms1=numberofRooms.replaceAll("[^0-9]", "");
			String totalDays1=totalDays.replaceAll("[^0-9]", "");
			String pricePerNight1=pricePerNight.replaceAll("[^0-9]", "");
			int finalPrice1=Integer.parseInt(finalPrice.replaceAll("[^0-9]", ""));
			
		
			
			double price=(Integer.parseInt(pricePerNight1)*Integer.parseInt(numberofRooms1)*Integer.parseInt(totalDays1));
			double percentage=0.1*price;
			double totalPrice=price+percentage;
			

			if(totalPrice==finalPrice1)
			{
			test.log(Status.PASS, "Total price ("+finalPrice1+")  and calculated price ("+totalPrice+")  is matching");
		    }
			else
			{
				test.log(Status.FAIL, "Total price ("+finalPrice1+")  and calculated price ("+totalPrice+")  is not matching");
			}
	}
	
public void checkNumberGenerated(WebElement element, String number)
{
	
	 getHighLight(element);
	if(number.isEmpty())
	{
		test.log(Status.FAIL, "Order number is not generated");
	}
	else
	{
		test.log(Status.PASS, "Order number is generated");
	}
}



public void scrollIntoView(WebElement element)
{
	JavascriptExecutor js= (JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true);", element);
}

public void scrollby()
{
	JavascriptExecutor js= (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,1000)");
}


public String daysCalculatorBasePage(String checkInDate, String checkOutDate)
{
    String start = checkInDate;
    String end = checkOutDate;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    LocalDate startDate = LocalDate.parse(start, formatter);
    LocalDate endDate = LocalDate.parse(end, formatter);

    long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
    
    String value=String.valueOf(daysBetween);
    return value;
}

public void setBookingConfirmOrderId(WebElement element )
{
	BookingConfirmOrderId=element.getAttribute("value");
}
public String getBookingConfirmOrderId( )
{
	return BookingConfirmOrderId;
}

public void alertsHandlingAccept()
{
	Alert al=driver.switchTo().alert();
	al.accept();
}
public void verifyTextPresentAsText(WebElement element,String text)
{
	waitForElementPresence(element);
	Assert.assertTrue(element.getText().contains(text));
	test.log(Status.PASS, "Given text "+text+" verified");	
}
}
