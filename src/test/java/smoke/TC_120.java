package smoke;

import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BaseTest;
import pageObjectModels.BookAHotel;
import pageObjectModels.BookedItinerary;
import pageObjectModels.BookingConfirmation;
import pageObjectModels.ChangePasswordPage;
import pageObjectModels.LogOutPage;
import pageObjectModels.LoginPage;
import pageObjectModels.SearchHotelPage;
import pageObjectModels.SelectHotelPage;
import utils.UtilKit;

public class TC_120 extends BaseTest{

	@Test(dataProvider = "getTestData")
	public void ToVerifyAllPagesTitlesTC120(HashMap<String, String> data) throws InterruptedException
	{
	       test.log(Status.INFO,"Login Page");
			LoginPage loginpage=new LoginPage();
			loginpage.titleVerify();   //to verify title in LoginPage
			loginpage.usernameTextbox(data.get("username"));
			loginpage.passwordTextbox(data.get("password"));
			loginpage.loginButton();
			
			
			   //for search hotel page 
			 test.log(Status.INFO, "Landed on search hotel page");
			SearchHotelPage searchHotelPage=new SearchHotelPage();
			Thread.sleep(2000);
			searchHotelPage.titleVerify();    //to verify title in search Hotel page
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
			Thread.sleep(2000);
			selectHotelPage.titleVerify(); //to verify Title on Select Hotel Page
			selectHotelPage.selectRadioButton();
			selectHotelPage.continueButton();
			
			
			//Book_a_hotel_page
			test.log(Status.INFO, "Book A hotel page");
			 BookAHotel bookAHotelObj=new BookAHotel();
			 Thread.sleep(2000);
			 bookAHotelObj.titleVerify(); //to verify title on Book A Hotel Page
			 bookAHotelObj.firstName(data.get("FirstName"));
			 bookAHotelObj.lastName(data.get("LastName"));
			 bookAHotelObj.billingAddress(data.get("BillingAddress"));
			 bookAHotelObj.creditCardNo(data.get("CreditCardNo"));
			 bookAHotelObj.creditCardType(data.get("CreditCardType"));
			 bookAHotelObj.expiryDateMonth(data.get("ExpiryDateMonth"));
			 bookAHotelObj.expiryDateYear(data.get("ExpiryDateYear"));
			 bookAHotelObj.cVVNumber(data.get("CVVNumber"));
			 bookAHotelObj.bookNowButtons();
			 
			 test.log(Status.INFO, "Booking confirmation page");
			 BookingConfirmation bookconfirm=new BookingConfirmation();
			 Thread.sleep(5000);
			 bookconfirm.titleVerify(); //to verify title on Booking confirmation Page
			 bookconfirm.clickBookedItinerary();
			 
			 
			 //Booked Itinerary page
			 test.log(Status.INFO, "Booked Itinerary Page");
			 BookedItinerary bookedItinerary=new BookedItinerary();
			 Thread.sleep(5000);
			 bookedItinerary.titleVerify(); //to verify title on Booked Itinerary Page
			 bookedItinerary.clickChangePassword();
			 
			 
			 //Change password page
			 test.log(Status.INFO, "Change password Page");
			 ChangePasswordPage changepasswordpage=new ChangePasswordPage();
			 Thread.sleep(2000);
			 changepasswordpage.titleVerify();
			 changepasswordpage.logOut();
			 
			 //Change password page
			 test.log(Status.INFO, "LogOut Page");
			 LogOutPage logout=new LogOutPage();
			 Thread.sleep(2000);
			 logout.titleVerify();
			 
			 
			 
	}
	
	
	
	@DataProvider
	public Object[][] getTestData()
	{
		
		Object[][] data=new Object[1][1];
		
		data[0][0]=UtilKit.getTestDataFromExcel("TC-120");
		
		return data;
		
	}
}
