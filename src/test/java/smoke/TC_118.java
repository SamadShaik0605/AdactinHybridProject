package smoke;

import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BaseTest;
import pageObjectModels.BookAHotel;
import pageObjectModels.BookedItinerary;
import pageObjectModels.BookingConfirmation;
import pageObjectModels.LoginPage;
import pageObjectModels.SearchHotelPage;
import pageObjectModels.SelectHotelPage;
import pageObjectModels.BookAHotel;
import utils.UtilKit;

public class TC_118 extends BaseTest

{ 

	public String bookingConfirmationOrderId;
	public String bookingConfirmationpriceperNight;
	public String bookingConfirmationtotalPrice;
	public String bookingConfirmationNoOfDays;
	
	@Test(dataProvider = "getTestData")
public void verifyBookedItineraryTC118(HashMap<String, String> data)
{
		//for login page
	       test.log(Status.INFO,"Login Page");
			LoginPage loginpage=new LoginPage();
			loginpage.usernameTextbox(data.get("username"));
			loginpage.passwordTextbox(data.get("password"));
			loginpage.loginButton();
			

		      //for search hotel page 
			 test.log(Status.INFO, "Landed on search hotel page");
			SearchHotelPage searchHotelPage=new SearchHotelPage();
			searchHotelPage.location(data.get("location"));
			searchHotelPage.hotels(data.get("hotels"));
			searchHotelPage.roomType(data.get("roomType"));
			int noOfRooms=Integer.parseInt(data.get("numberOfRooms"));
			searchHotelPage.numberOfRooms(noOfRooms);
			searchHotelPage.checkInDate(data.get("checkInDate"));
			searchHotelPage.checkOutDate(data.get("checkOutDate"));
			searchHotelPage.adultsPerRoom(data.get("adultsPerRoom"));
			searchHotelPage.search();
			
			
			//select hotel page
			test.log(Status.INFO, "Landed on Select Hotel Page");
			SelectHotelPage selectHotelPage=new SelectHotelPage();
			selectHotelPage.selectRadioButton();
			selectHotelPage.continueButton();
		    
			
			//Book_a_hotel_page
			test.log(Status.INFO, "Book A hotel page");
			 BookAHotel bookAHotelObj=new BookAHotel();
			 bookAHotelObj.firstName(data.get("FirstName"));
			 bookAHotelObj.lastName(data.get("LastName"));
			 bookAHotelObj.billingAddress(data.get("BillingAddress"));
			 bookAHotelObj.creditCardNo(data.get("CreditCardNo"));
			 bookAHotelObj.creditCardType(data.get("CreditCardType"));
			 bookAHotelObj.expiryDateMonth(data.get("ExpiryDateMonth"));
			 bookAHotelObj.expiryDateYear(data.get("ExpiryDateYear"));
			 bookAHotelObj.cVVNumber(data.get("CVVNumber"));
			 bookAHotelObj.bookNowButtons();
			 
			 //Booking confirmation page
			 test.log(Status.INFO, "Booking confirmation page");
			 BookingConfirmation bookconfirm=new BookingConfirmation();
			 bookingConfirmationOrderId=bookconfirm.getOrderId();
			 bookingConfirmationpriceperNight=bookconfirm.getPriceperNight();
			 bookingConfirmationtotalPrice=bookconfirm.getfinalPrice();
			 bookingConfirmationNoOfDays=bookconfirm.daysCalculator();
			 bookconfirm.clickBookedItinerary();

			 
			 
			 //Booked Itinerary page
			 BookedItinerary bookedItinerary=new BookedItinerary();
			 bookedItinerary.searchOrderIdtext(bookingConfirmationOrderId);
             bookedItinerary.clickGo();
             bookedItinerary.verifyOrderId(bookingConfirmationOrderId);
             bookedItinerary.verifyHotelName(data.get("hotels"));
             bookedItinerary.verifyLocation(data.get("location"));
             bookedItinerary.verifyNumberofRooms(data.get("numberOfRooms"));
             bookedItinerary.verifyFirstName(data.get("FirstName"));
             bookedItinerary.verifyLastName(data.get("LastName"));
             bookedItinerary.verifyArrivalDate(data.get("checkInDate"));
             bookedItinerary.verifyDepartureDate(data.get("checkOutDate"));
             bookedItinerary.verifyNoofDays(bookingConfirmationNoOfDays);
             bookedItinerary.verifyRoomsType(data.get("roomType"));
             bookedItinerary.verifyPriceperNight(bookingConfirmationpriceperNight);
             bookedItinerary.verifyTotalPrice(bookingConfirmationtotalPrice);

			 

			 
 
}
	
	
	@DataProvider
	public Object[][] getTestData()
	{
		
		Object[][] data=new Object[1][1];
		
		data[0][0]=UtilKit.getTestDataFromExcel("TC-118");
		
		return data;
		
	}
}
