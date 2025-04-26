package pageObjectModels;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectHotelPage extends BasePage
{
	public SelectHotelPage()
	{
		PageFactory.initElements(driver, this);
		//super();
	}
	
	//hotelName
	@FindBy(xpath ="//input[@id='hotel_name_0']s" ) 
	WebElement hotelName;
	
	//location 
	@FindBy(xpath ="//input[@id='location_0']" ) 
	WebElement location;
	
	//rooms
   @FindBy(xpath ="	//input[@id='rooms_0']" ) 
    WebElement rooms;
   
     //arrivalDate
 	@FindBy(xpath ="//input[@id='arr_date_0']" ) 
 	WebElement arrivalDate;
 	
 	//	departureDate
 	@FindBy(xpath ="//input[@id='dep_date_0']" ) 
	WebElement departureDate;
	
 	//noOfDays
	@FindBy(xpath ="//input[@id='no_days_0']" ) 
	WebElement noOfDays;
	
	//roomsType
	@FindBy(xpath ="	//input[@id='room_type_0']" ) 
	WebElement roomType;
	
	//pricePerNight
	@FindBy(xpath ="//input[@id='price_night_0']" ) 
	WebElement pricePerNight;
	
	//totalPrice
	@FindBy(xpath ="//input[@id='total_price_0']" ) 
	WebElement totalPrice;
	
	@FindBy(xpath ="//input[@id='radiobutton_0']" ) 
	WebElement selectRadioButton;
	
	@FindBy(xpath ="//input[@id='continue']" ) 
	WebElement continueButton;
	
	
	
	
	public void verifyHotelName(String value)
	{
		verifyTextPresentAsValue(hotelName, value);
	}

	public void verifyLocation(String value)
	{
		verifyTextPresentAsValue(location, value);
	}
	public void getLocation(String value)
	{
		verifyTextPresentAsValue(location, value);
	}
	public void verifyRooms(String value)
	{
		verifyTextPresentAsValue(rooms, value);
	}
	public void verifyArrivalDate(String value)
	{
		verifyTextPresentAsValue(arrivalDate, value);
	}
	public void verifyDepartureDate(String value)
	{
		verifyTextPresentAsValue(departureDate, value);
	}

	public void verifyNoOfDays(String value)
	{
		verifyTextPresentAsValue(noOfDays, value);
	}
	public void verifyRoomType(String value)
	{
		verifyTextPresentAsValue(roomType, value);
	}
	public void verifyPricePerNight(String value)
	{
		verifyTextPresentAsValue(pricePerNight, value);
	}
	public void verifyTotalPrice(String value)
	{
		verifyTextPresentAsValue(totalPrice, value);
	}
	
	public String getPricePerNight()
	{
	String price_per_night=	getValue(pricePerNight);
		
		return price_per_night;
	}
	public String getNoOfDays()
	{
	String No_of_nights=getValue(noOfDays);
		
		return No_of_nights;
	}
	public String getrooms()
	{
	String no_of_rooms=	getValue(rooms);
		
		return no_of_rooms;
	}
	
	public String getTotalPrice()
	{
	String total_Price=	getValue(totalPrice);
		
		return total_Price;
	}
	
	public void selectRadioButton()
	{
		click(selectRadioButton);
	}
	public void continueButton()
	{
		valueClick(continueButton);
	}
	
	public void titleVerify()
	{
		verifyTitle(configProp.getProperty("SelectHotelPage"));
	}
}
