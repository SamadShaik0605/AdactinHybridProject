package regression;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import base.BaseTest;
import pageObjectModels.LoginPage;
import pageObjectModels.SearchHotelPage;

public class ValidateLoginUsingPOM extends BaseTest {
	
	
	@Test
	public void  validateLoginTest()
	{
		//Page Initialize  -- Login Page 
		
		LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
		
		loginPage.usernameTextbox("reyaz0806");
		
		loginPage.passwordTextbox("reyaz123");
		
		loginPage.loginButton();
		
		SearchHotelPage searchHotelPage=PageFactory.initElements(driver, SearchHotelPage.class);
		
		searchHotelPage.verifyTitle("Adactin.com - Search Hotel");
		
		searchHotelPage.helloUsernameText("reyaz0806");
		
	}

}
