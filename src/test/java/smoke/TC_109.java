package smoke;

import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BaseTest;
import pageObjectModels.BookAHotel;
import pageObjectModels.BookingConfirmation;
import pageObjectModels.LogOutPage;
import pageObjectModels.LoginPage;
import pageObjectModels.SearchHotelPage;
import pageObjectModels.SelectHotelPage;
import pageObjectModels.BookAHotel;
import utils.UtilKit;

public class TC_109 extends BaseTest
{
	@Test(dataProvider = "getTestData")
public void logoutCheckTC109(HashMap<String, String> data)
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
			 bookconfirm.verifyHotelName(data.get("hotels"));
			 bookconfirm.verifyLocation(data.get("location"));
			 bookconfirm.verifyRoomsType(data.get("roomType"));
			 bookconfirm.verifyArrivalDate(data.get("checkInDate"));
			 bookconfirm.verifyDepartureDate(data.get("checkOutDate"));
			 bookconfirm.verifyNumberofRooms(data.get("numberOfRooms"));
			 bookconfirm.verifyAdultsPerRoom(data.get("adultsPerRoom"));
			 bookconfirm.verifyFirstName(data.get("FirstName"));
			 bookconfirm.verifyLastName(data.get("LastName"));
			 bookconfirm.verifyBillingAddress(data.get("BillingAddress"));
			 bookconfirm.logoutButton();
			 
			 
			 test.log(Status.INFO, "LogOut page");
			 LogOutPage logout=new LogOutPage();
			 logout.LogOutTitleVerify();
 
}
	
	
	@DataProvider
	public Object[][] getTestData()
	{
		
		Object[][] data=new Object[1][1];
		
		data[0][0]=UtilKit.getTestDataFromExcel("TC-109");
		
		return data;
		
	}
}
