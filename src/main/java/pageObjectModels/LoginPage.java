package pageObjectModels;
/*
 * This is for Login or Home Page 
 * 
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage 
{
	
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
		//super();
	}

	
//variables to findelements with xpath
	@FindBy(xpath="//input[@name='username']") 	
	WebElement usernameTextbox;
	
	@FindBy(xpath="//input[@name='password']") 	
	WebElement passwordTextbox;
	
	@FindBy(xpath="//input[@name='login']") 	
	WebElement loginButton;
	
	@FindBy(xpath="//a[text()='Forgot Password?']") 	
	WebElement forgotPasswordLink;
	
	public void usernameTextbox(String text)
	{
	
		type(usernameTextbox, text);
	}
	
	public void passwordTextbox(String text)
	{

		type(passwordTextbox, text);
	}
	
	public void loginButton()
	{

		valueClick(loginButton);
	}
    
	public void titleVerify()
	{
		verifyTitle(configProp.getProperty("LoginPageTitle"));
	}
	

}
