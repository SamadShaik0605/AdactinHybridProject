package pageObjectModels;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangePasswordPage extends BasePage
{
	public ChangePasswordPage()
	{
		PageFactory.initElements(driver, this);
		//super();
	}
	
	@FindBy(xpath = "//td[@class='welcome_menu']/child::a/following-sibling::a/following-sibling::a[contains(@href,'ChangePassword.php')]/following-sibling::a[contains(@href,'Logout.php')]")
	WebElement LogOut;
	
	public void titleVerify()
	{
		verifyTitle(configProp.getProperty("ChangePassword"));
	}
	
	public void logOut()
	{
		valueClick(LogOut);
	}
}
