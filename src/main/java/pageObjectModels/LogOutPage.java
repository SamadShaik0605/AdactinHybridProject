package pageObjectModels;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage extends BasePage
{
	public LogOutPage()
	{
		PageFactory.initElements(driver, this);
		//super();
	}
	
  public void LogOutTitleVerify()
  {
	  String title=getTitle();
	  verification("Adactin.com - Logout", title);
  }
  
  public void titleVerify()
	{
		verifyTitle(configProp.getProperty("LogOutPage"));
	}
}
