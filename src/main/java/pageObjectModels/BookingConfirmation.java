package pageObjectModels;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingConfirmation extends BasePage 
{
	public BookingConfirmation()
	{
		PageFactory.initElements(driver, this);
		//super();
	}
	
	
	@FindBy(xpath="//input[@id='hotel_name']") 	
	WebElement hotelName;
	
	@FindBy(xpath="//input[@id='location']") 	
	WebElement location;
	
	@FindBy(xpath="//input[@id='room_type']") 	
	WebElement roomsType;
	
	@FindBy(xpath="//input[@id='arrival_date']") 	
	WebElement arrivalDate;
	
	@FindBy(xpath="//input[@id='departure_text']") 	
	WebElement departureDate;
	
	@FindBy(xpath="//input[@id='total_rooms']") 	
	WebElement numberofRooms;
	
	@FindBy(xpath="//input[@id='price_night']") 	
	WebElement priceperNight;
	
	@FindBy(xpath="//input[@id='gst']") 	
	WebElement GST  ;
	
	@FindBy(xpath="//input[@id='final_price']") 	
	WebElement finalBilledPrice;
	
	@FindBy(xpath="//input[@id='first_name']") 	
	WebElement firstName;
	
	@FindBy(xpath="//input[@id='last_name']") 	
	WebElement lastName;
	
	@FindBy(xpath="//textarea[@id='address']") 	
	WebElement billingAddress;
	
	@FindBy(xpath="//input[@id='adults_room']") 	
	WebElement adultsPerRoom;
	
	
	@FindBy(xpath="//input[@id='logout']") 	
	WebElement logoutButton;
	
	
	@FindBy(xpath="//input[@id='order_no']") 	
	WebElement orderNo;
	
	
	@FindBy(xpath="//input[@id='my_itinerary']") 	
	WebElement myItinerary;
	
	@FindBy(xpath = "//td[@class='welcome_menu']/child::a/following-sibling::a[contains(@href,'BookedItinerary.php')]")
	WebElement bookedItinerary;
	
	
	public void verifyHotelName(String value)
	{
		verifyTextPresentAsValue(hotelName, value);
	}
	public void verifyLocation(String value)
	{
		verifyTextPresentAsValue(location, value);
	}
	public void verifyRoomsType(String value)
	{
		verifyTextPresentAsValue(roomsType, value);
	}
	public void verifyArrivalDate(String value)
	{
		verifyTextPresentAsValue(arrivalDate, value);
	}
	public void verifyDepartureDate(String value)
	{
		verifyTextPresentAsValue(departureDate, value);
	}
	public void verifyNumberofRooms(String value)
	{
		verifyTextPresentAsValue(numberofRooms, value);
	}
	public void verifyFirstName(String value)
	{
		verifyTextPresentAsValue(firstName, value);
	}
	public void verifyLastName(String value)
	{
		verifyTextPresentAsValue(lastName, value);
	}
	public void verifyBillingAddress(String value)
	{
		verifyTextPresentAsValue(billingAddress, value);
	}
	public void verifyAdultsPerRoom(String value)
	{
		verifyTextPresentAsValue(adultsPerRoom, value);
	}
	public String getPriceperNight()
	{
		String value=getValue(priceperNight);
		return value;
	}
	
	public String getfinalPrice()
	{
		String value=getValue(finalBilledPrice);
		return value;
	}
	public String getArrivalDate()
	{
		String value=getValue(arrivalDate);
		return value;
	}
	public String getDepartureDate()
	{
		String value=getValue(departureDate);
		return value;
	}
	
	public String getOrderId()
	{
		String value=getValue(orderNo);
		return value;
	}
	
	
	public void logoutButton()
	{
		valueClick(logoutButton);
	}
	
	public void verifyOrderNoGenerated()
	{
		String number=getValue(orderNo);
		checkNumberGenerated(orderNo ,number);
	}
	
	public void scrollIntoViewToOrderNo()
	{
		scrollIntoView(orderNo);
	}
	
	public void myItineraryButton()
	{
		valueClick(myItinerary);
	}
	
	public String daysCalculator()
	{
		String arrivaldate=getArrivalDate();
		String departureDate=getDepartureDate();
		
		String value=daysCalculatorBasePage(arrivaldate,departureDate);
		return value;
	}
	public void verify(String text)
	{
		verifyTextPresentAsValue(GST, text);
	}
	public void clickBookedItinerary()
	{
		valueClick(bookedItinerary);
	}
	
	public void titleVerify()
	{
		verifyTitle(configProp.getProperty("BookingConfirm"));
	}
}
