package smoke;

import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BaseTest;
import pageObjectModels.LoginPage;
import pageObjectModels.SearchHotelPage;
import utils.UtilKit;

public class TC_103 extends BaseTest
{
	@Test(dataProvider = "getTestData")
	public void verifyPastDatesTC103(HashMap<String, String> data)
	{
		//for login 
		LoginPage loginpage=new LoginPage();
		loginpage.usernameTextbox(data.get("username"));
		loginpage.passwordTextbox(data.get("password"));
		loginpage.loginButton();
		
	      //for search hotel page 
		 test.log(Status.INFO, "search hotel page");
		SearchHotelPage obj=new SearchHotelPage();
		obj.location(data.get("location"));
		obj.hotels(data.get("hotels"));
		obj.roomType(data.get("roomType"));
		int noOfRooms=Integer.parseInt(data.get("numberOfRooms"));
		obj.numberOfRooms(noOfRooms);
		obj.checkInDate(data.get("checkInDate"));
		obj.checkOutDate(data.get("checkOutDate"));
		obj.search();
		obj.checkInError(data.get("checkInError"));
	
		
	}
	
	@DataProvider
	public Object[][] getTestData()
	{
		
		Object[][] data=new Object[1][1];
		
		data[0][0]=UtilKit.getTestDataFromExcel("TC-103");
		
		return data;
		
	}
}
