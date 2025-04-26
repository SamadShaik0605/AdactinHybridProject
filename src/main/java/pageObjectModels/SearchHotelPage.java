package pageObjectModels;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotelPage extends BasePage {
	
	public SearchHotelPage()
	{
		PageFactory.initElements(driver, this);
		//super();
	}
	
	
	@FindBy(xpath = "//input[@id='username_show']")
	WebElement helloUsernameText;
	
	@FindBy(xpath="//select[@id='location']") 
	WebElement location;
	
	@FindBy(xpath="//select[@id='hotels']") 
	WebElement hotels;
	
	@FindBy(xpath="//select[@id='room_type']") 
	WebElement roomType;
	
	@FindBy(xpath="//select[@id='room_nos']") 
	WebElement numberOfRooms;
	
	@FindBy(xpath="//input[@id='datepick_in']") 
	WebElement checkInDate;
	
	@FindBy(xpath="//input[@id='datepick_out']") 
	WebElement checkOutDate;
	
	@FindBy(xpath="//input[@id='Submit']") 
	WebElement searchButton;
	
	
	@FindBy(xpath = "//span[@id='checkin_span']")
	WebElement checkInError;
	
	@FindBy(xpath = "//span[@id='checkout_span']")
	WebElement checkOutError;
	
	@FindBy(xpath = "//select[@id='adult_room']")
	WebElement adultsPerRoom;
	
	@FindBy(xpath = "//td[@class='welcome_menu']/child::a/following-sibling::a[contains(@href,'BookedItinerary.php')]")
	WebElement bookedItinerary;
	
	
	public void helloUsernameText(String username)
	{
		verifyTextPresentAsValue(helloUsernameText,username);
	}

	public void location(String value)
	{
		dropDown(location, value);
	}
	public void hotels(String value)
	{
		dropDown(hotels, value);
	}
	public void roomType(String value)
	{
		dropDown(roomType, value);
	}
	public void numberOfRooms(int value)
	{
		dropDownNum(numberOfRooms, value);
	}
	public void checkInDate(String date)
	{
		ClearType(checkInDate, date);
	}
	public void checkOutDate(String date)
	{
		ClearType(checkOutDate, date);
	}
	public void adultsPerRoom(String value)
	{
		dropDown(adultsPerRoom, value);
	}
	public void search()
	{
		valueClick(searchButton);
	}
	
	public void checkInError(String error)
	{
		verifyInLIneErrors(checkInError,error);
	
	}
	public void checkOutError(String error)
	{
		verifyInLIneErrors(checkOutError,error);
	}
	public void clickBookedItinerary()
	{
		valueClick(bookedItinerary);
	}
	public String getPageTitle()
	{
		String Pagetitle=getTitle(); 
		return Pagetitle;
	}
	
	public void titleVerify()
	{
		verifyTitle(configProp.getProperty("SearchHotelPage"));
	}
}
