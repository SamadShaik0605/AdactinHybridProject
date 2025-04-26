package smoke;

import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BaseTest;
import pageObjectModels.BookAHotel;
import pageObjectModels.LoginPage;
import pageObjectModels.SearchHotelPage;
import pageObjectModels.SelectHotelPage;
import pageObjectModels.BookAHotel;
import utils.UtilKit;

public class TC_111 extends BaseTest
{
	@Test(dataProvider = "getTestData")
public void verifyBookAHotelPageTC111(HashMap<String, String> data)
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
			 BookAHotel bah=new BookAHotel();
			 bah.verifyHotelName(data.get("hotels"));
			 bah.verifyLocation(data.get("location"));
			 bah.verifyRoomType(data.get("roomType"));
			 bah.verifyNumberofRooms(data.get("numberOfRooms"));
			String valueDays=bah.daysCalculator(data.get("checkInDate"), data.get("checkOutDate"));
			 bah.verifyTotalDays(valueDays);
			 String numberofRooms=bah.getNumberofRooms();
			 String totalDays=bah.getTotalDays();
			 String pricePerNight=bah.getPricePerNight();
			String gst= bah.getGst();
			String finalBilledPrice=bah.getFinalBilledPrice();
		   int finalPriceWithoutGst=bah.getPriceWithOutGst(gst, finalBilledPrice);
		   bah.priceCalculator(numberofRooms,totalDays,pricePerNight,finalPriceWithoutGst);   
			
			
			
			
			
			
		
			
          
}
	
	
	@DataProvider
	public Object[][] getTestData()
	{
		
		Object[][] data=new Object[1][1];
		
		data[0][0]=UtilKit.getTestDataFromExcel("TC-111");
		
		return data;
		
	}
}
