package smoke;

import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BaseTest;
import pageObjectModels.LoginPage;
import pageObjectModels.SearchHotelPage;
import pageObjectModels.SelectHotelPage;
import utils.UtilKit;

public class TC_104 extends BaseTest
{
	@Test(dataProvider = "getTestData")
	public void verifySelectHotelLocationTC104(HashMap<String, String> data)
	{
		//for login page
       test.log(Status.INFO,"Login Page");
		LoginPage loginpage=new LoginPage();
		loginpage.usernameTextbox(data.get("username"));
		loginpage.passwordTextbox(data.get("password"));
		loginpage.loginButton();
		
	      //for search hotel page 
		 test.log(Status.INFO, "search hotel page");
		SearchHotelPage searchHotelPage=new SearchHotelPage();
		searchHotelPage.location(data.get("location"));
		searchHotelPage.hotels(data.get("hotels"));
		searchHotelPage.roomType(data.get("roomType"));
		int noOfRooms=Integer.parseInt(data.get("numberOfRooms"));
		searchHotelPage.numberOfRooms(noOfRooms);
		searchHotelPage.checkInDate(data.get("checkInDate"));
		searchHotelPage.checkOutDate(data.get("checkOutDate"));
		searchHotelPage.search();

		//for Select Hotel Page
		test.log(Status.INFO, "Select Hotel Page");
		SelectHotelPage selectHotelPage=new SelectHotelPage();
		selectHotelPage.verifyLocation(data.get("location"));
	
		
	}
	
	
	@DataProvider
	public Object[][] getTestData()
	{
		
		Object[][] data=new Object[1][1];
		
		data[0][0]=UtilKit.getTestDataFromExcel("TC-104");
		
		return data;
		
	}
}
