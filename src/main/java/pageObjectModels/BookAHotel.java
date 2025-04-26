package pageObjectModels;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookAHotel extends BasePage
{
	public BookAHotel()
	{
		PageFactory.initElements(driver, this);
		//super();
	}
	
	
	//xpath locators
	@FindBy(xpath = "//input[@id='hotel_name_dis']")
	WebElement hotelName;
	
	@FindBy(xpath = "//input[@id='location_dis']")
	WebElement location;
	
	@FindBy(xpath = "//input[@id='room_type_dis']")
	WebElement roomType;
	
	@FindBy(xpath = "//input[@id='room_num_dis']")
	WebElement numberofRooms;
	
	@FindBy(xpath = "//input[@id='total_days_dis']")
	WebElement totalDays ;
	
	@FindBy(xpath = "//input[@id='price_night_dis']")
	WebElement pricePerNight;
	
	@FindBy(xpath = "//input[@id='gst_dis']")
	WebElement gst;
	
	@FindBy(xpath = "//input[@id='final_price_dis']")
	WebElement finalBilledPrice;
	
	@FindBy(xpath = "//input[@id='first_name']")
	WebElement firstName;
	
	@FindBy(xpath = "//input[@id='last_name']")
	WebElement lastName;
	
	@FindBy(xpath = "//textarea[@id='address']")
	WebElement billingAddress;
	
	@FindBy(xpath = "//input[@id='cc_num']")
	WebElement creditCardNo;
	
	@FindBy(xpath = "//select[@id='cc_type']")
	WebElement creditCardType;
	
	@FindBy(xpath = "//select[@id='cc_exp_month']")
	WebElement expiryDateMonth;
	
	@FindBy(xpath = "//select[@id='cc_exp_year']")
	WebElement expiryDateYear;
	
	@FindBy(xpath = "//input[@id='cc_cvv']")
	WebElement cVVNumber;
	
	@FindBy(xpath = "//input[@id='book_now']")
	WebElement bookNowButtons;
	
	
	
	//webelements actions
	public void verifyHotelName(String value)
	{
		verifyTextPresentAsValue(hotelName, value);
	}
	public void verifyLocation(String value)
	{
		verifyTextPresentAsValue(location, value);
	}
	public void verifyRoomType(String value)
	{
		verifyTextPresentAsValue(roomType, value);
	}

	
	public String getNumberofRooms()
	{
		String totalRooms=getValue(numberofRooms);
		return totalRooms;
	}
	public void verifyNumberofRooms(String value)
	{
		verifyTextPresentAsValue(numberofRooms, value);
	}
	
	public String getTotalDays()
	{
		String daysTotal=getValue(totalDays);
		return daysTotal;
	}
	public String daysCalculator(String checkInDate, String checkOutDate)
	{
		String days=daysCalculatorBasePage(checkInDate,checkOutDate);
		
		return days;
	}
	
	public void verifyTotalDays(String value)
	{
		verifyTextPresentAsValue(totalDays, value);
	}

	
	public String getPricePerNight()
	{
		String perNightPrice=getValue(pricePerNight);
		return perNightPrice;
	}
	public String getGst()
	{
		String goodsServiceTax=getValue(gst);
		return goodsServiceTax;
	}
	public String getFinalBilledPrice()
	{
		String final_billed_price=getValue(finalBilledPrice);
		return final_billed_price;
	}
	
	public void firstName(String text)
	{
		type(firstName,text );
	}
	public void lastName(String text)
	{
		type(lastName,text );
	}
	
	public void billingAddress(String text)
	{
		type(billingAddress,text );
	}
	
	public void creditCardNo(String text)
	{
		type(creditCardNo,text );
	}
	
	public void creditCardType(String value)
	{
		dropDown(creditCardType,value );
	}
	
	public void expiryDateMonth(String value)
	{
		dropDown(expiryDateMonth,value );
	}
	
	public void expiryDateYear(String value)
	{
		dropDown(expiryDateYear,value );
	}
	
	public void cVVNumber(String text)
	{
		type(cVVNumber,text );
	}
	public void bookNowButtons()
	{
		valueClick(bookNowButtons);
	}
	
	
	
	
	public int getPriceWithOutGst(String gst,String finalBilledPrice)
	{
		String gst1=gst.replaceAll("[^0-9]", "");
		String finalBilledPrice1=finalBilledPrice.replaceAll("[^0-9]", "");
		
		int priceWithOutGst=(Integer.parseInt(finalBilledPrice1)-Integer.parseInt(gst1));
		return priceWithOutGst;
		
	}
	
	public void priceCalculator(String numberofRooms,String totalDays,String pricePerNight,int finalPriceWithOutGst)
	{
		priceCalcBasePage(numberofRooms, totalDays, pricePerNight, finalPriceWithOutGst);
	}
	
	public void finalBillCalc(String numberofRooms,String totalDays,String pricePerNight,String finalPrice)
	{
		finalBillCalcBasePage(numberofRooms,totalDays,pricePerNight,finalPrice);
	}
	
	public void titleVerify()
	{
		verifyTitle(configProp.getProperty("BookAHotelPage"));
	}
}
