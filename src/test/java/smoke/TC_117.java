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

public class TC_117 extends BaseTest

{ 
	
	
	@Test(dataProvider = "getTestData")
public void verifyBookedItinerarySearchBarTC117(HashMap<String, String> data)
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
			searchHotelPage.clickBookedItinerary();
			 
			 
			 //Booked Itinerary page
			 BookedItinerary bookedItinerary=new BookedItinerary();
			 bookedItinerary.searchOrderIdtext(data.get("OrderId"));
			 bookedItinerary.clickGo();
			 bookedItinerary.verifyOrderId(data.get("OrderId"));
	
			 

			 
 
}
	
	
	@DataProvider
	public Object[][] getTestData()
	{
		
		Object[][] data=new Object[1][1];
		
		data[0][0]=UtilKit.getTestDataFromExcel("TC-117");
		
		return data;
		
	}
}
