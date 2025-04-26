package smoke;

import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BaseTest;
import pageObjectModels.LoginPage;
import utils.UtilKit;

public class TC_101 extends BaseTest
{
	
	@Test(dataProvider="getTestData")
public void validLoginDetailsTC101(HashMap<String, String> data)
{

    LoginPage tc=new LoginPage();
    test.log(Status.INFO, "Login page");
	tc.usernameTextbox(data.get("username"));
	tc.passwordTextbox(data.get("password"));
	tc.loginButton();
}
	
	
	
	@DataProvider
	public Object[][] getTestData()
	{
		
		Object[][] data=new Object[1][1];
		
		data[0][0]=UtilKit.getTestDataFromExcel("TC-101");
		
		return data;
		
	}
}
