package regression;

import java.util.HashMap;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pageObjectModels.LoginPage;
import pageObjectModels.SearchHotelPage;
import utils.UtilKit;

public class ValidateLoginUsingPOMDataProvider extends BaseTest {
	
	
	@Test(dataProvider = "getTestData")
	public void  validateLoginTest(HashMap<String, String>  dataMap)
	{
		//Page Initialize  -- Login Page 
		
		//LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
		
		LoginPage loginPage=new LoginPage();
		
		loginPage.usernameTextbox(dataMap.get("username"));
		
		loginPage.passwordTextbox(dataMap.get("password"));
		
		loginPage.loginButton();
		
		//SearchHotelPage searchHotelPage=PageFactory.initElements(driver, SearchHotelPage.class);
		
		SearchHotelPage searchHotelPage=new SearchHotelPage();
		
		searchHotelPage.verifyTitle(dataMap.get("expTitle"));
		
		searchHotelPage.helloUsernameText(dataMap.get("username"));
		
	
		
	}
	
	@DataProvider
	public Object[][] getTestData()
	{
		
		Object[][] data=new Object[1][1];
		
		data[0][0]=UtilKit.getTestDataFromExcel("TC-001");
		
		System.out.println(data[0][0]);
		
		return data;
		
	}

}
