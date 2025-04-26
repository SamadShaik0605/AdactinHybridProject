package pageObjectModels;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookedItinerary extends BasePage
{
	public BookedItinerary()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//input[contains(@id,'order_id_') and @class='select_text']")
	WebElement orderId;
	
	@FindBy(xpath = "//input[contains(@id,'hotel_name_') and @class='select_text']")
	WebElement hotelName;
	
	@FindBy(xpath = "//input[contains(@id,'location_') and @class='select_text']")
	WebElement location;
	
	@FindBy(xpath = "//input[contains(@id,'rooms_') and @class='select_text']")
	WebElement numberofRooms;
	
	@FindBy(xpath = "//input[contains(@id,'first_name_') and @class='select_text']")
	WebElement firstName;
	
	@FindBy(xpath = "//input[contains(@id,'last_name_') and @class='select_text']")
	WebElement lastName;
	
	@FindBy(xpath ="//input[contains(@id,'arr_date_') and @class='select_text']") 
 	WebElement arrivalDate;
	
	@FindBy(xpath ="//input[contains(@id,'dep_date_') and @class='select_text']") 
	WebElement departureDate;
	
	@FindBy(xpath ="//input[contains(@id,'no_days_') and @class='select_text']") 
	WebElement noofDays;
	
	@FindBy(xpath ="//input[contains(@id,'room_type_') and @class='select_text']") 
	WebElement roomsType;
	
	@FindBy(xpath ="//input[contains(@id,'price_night_') and @class='select_text']") 
	WebElement priceperNight;
	
	@FindBy(xpath ="//input[contains(@id,'total_price_') and @class='select_text']") 
	WebElement totalPrice;
	
	
	@FindBy(xpath ="//input[@id='order_id_text']" ) 
	WebElement searchOrderId;
	
	@FindBy(xpath ="//input[@id='search_hotel_id']" ) 
	WebElement goButton;
	
	@FindBy(xpath = "//input[contains(@id,'btn_id_') and @type='button' and contains(@value,'Cancel')]")
	WebElement cancelOrderButton;
	
	@FindBy(xpath ="//label[@id='search_result_error']")
	WebElement resultZero;
	
	@FindBy(xpath = "//td[@class='welcome_menu']/child::a/following-sibling::a/following-sibling::a[contains(@href,'ChangePassword.php')]")
	WebElement changePassword;
	
	public void clearOrderId(String text)
	{
		ClearType(orderId, text);
	}
	public void verifyOrderId(String value)
	{
		verifyTextPresentAsValue(orderId, value);
	}
	public void clearHotelName(String text)
	{
		ClearType(hotelName, text);
	}
	public void verifyHotelName(String value)
	{
		verifyTextPresentAsValue(hotelName, value);
	}
	public void clearLocation(String text)
	{
		ClearType(location, text);
	}
	public void verifyLocation(String value)
	{
		verifyTextPresentAsValue(location, value);
	}

	public void clearNumberofRooms(String text)
	{
		ClearType(numberofRooms, text);
	}
	public void verifyNumberofRooms(String value)
	{
		verifyTextPresentAsValue(numberofRooms, value);
	}
	
	public void clearFirstName(String text)
	{
		ClearType(firstName, text);
	}
	public void verifyFirstName(String value)
	{
		verifyTextPresentAsValue(firstName, value);
	}
	public void clearLastName(String text)
	{
		ClearType(lastName, text);
	}
	public void verifyLastName(String value)
	{
		verifyTextPresentAsValue(lastName, value);
	}
	public void clearArrivalDate(String text)
	{
		ClearType(arrivalDate, text);
	}
	public void verifyArrivalDate(String value)
	{
		verifyTextPresentAsValue(arrivalDate, value);
	}
	public void clearDepartureDate(String text)
	{
		ClearType(departureDate, text);
	}
	public void verifyDepartureDate(String value)
	{
		verifyTextPresentAsValue(departureDate, value);
	}
	public void clearNoofDays(String text)
	{
		ClearType(noofDays, text);
	}
	public void verifyNoofDays(String value)
	{
		verifyTextPresentAsValue(noofDays, value);
	}
	public void clearRoomsType(String text)
	{
		ClearType(roomsType, text);
	}
	public void verifyRoomsType(String value)
	{
		verifyTextPresentAsValue(roomsType, value);
	}
	public void clearPriceperNight(String text)
	{
		ClearType(priceperNight, text);
	}
	public void verifyPriceperNight(String value)
	{
		verifyTextPresentAsValue(priceperNight, value);
	}
	public void clearTotalPrice(String text)
	{
		ClearType(totalPrice, text);
	}
	public void verifyTotalPrice(String value)
	{
		verifyTextPresentAsValue(totalPrice, value);
	}
	
	public void searchOrderIdtext(String text) 
	{
		type(searchOrderId,text);
	}
	public void clickGo()
	{
		valueClick(goButton);
	}
	
	public void clickCancelOrderButton()
	{
		valueClick(cancelOrderButton);
	}
	public void verifyCancelled(String value)
	{
		verifyTextPresentAsText(resultZero, value);
	}
	public void verifyResultZero(String value)
	{
		verifyTextPresentAsText(resultZero, value);
	}
	public void titleVerify()
	{
		verifyTitle(configProp.getProperty("BookedItinerary"));
	}
	public void clickChangePassword()
	{
		valueClick(changePassword);
	}
	
	
}
