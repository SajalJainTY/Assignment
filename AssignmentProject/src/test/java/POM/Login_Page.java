package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hcl.gim.util.WebActionUtil;

/**
 * Description: This class implements the methods for Login
 * 
 * @author Shreya U
 * 
 */
public class Login_Page {

	public WebDriver driver;
	public WebActionUtil WebActionUtil;
	public long ETO = 10;

	public Login_Page(WebDriver driver, long ETO, WebActionUtil WebActionUtil) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.WebActionUtil = WebActionUtil;
		this.ETO = ETO;
	}

	/* Login Text Box */
	@FindBy(id = "EmployeeID")
	private WebElement txtUserID;

	/* Password Text Box */
	@FindBy(id = "Password")
	private WebElement txtPassword;

	/* Login Button */
	@FindBy(xpath = "//input[@value='Log in']")
	private WebElement btnLogin;

	/* Close Icon */
	@FindBy(xpath = "//h4[text()='HR Partner Manual']/../button")
	private WebElement btnClosePopUp;
	
	/* Log In text */
	@FindBy(xpath="//h2[text()='Log in.']")
	private WebElement txtLogin;

	
	/**
	 * Description: This method implements login to the application
	 * 
	 * @author:Abhilash B
	 * @param :userId
	 * @param : password
	 */
	public synchronized void loginToApplication(String userId,String password)
	{
		try {

			WebActionUtil.validationinfo("The URL is : "+ driver.getCurrentUrl());
			WebActionUtil.validatetext("Log in.", txtLogin, "Log In","Log In page is displayed", "Log In page is not displayed");
			WebActionUtil.typeText(txtUserID, userId, "User Id text box");
			WebActionUtil.typeText(txtPassword, password , "Password text box");
			WebActionUtil.clickOnElement(btnLogin, "Login button", "unable to click on login button");
			WebActionUtil.waitForAngularPageload();
			
			
		} catch (Exception e) {
			WebActionUtil.fail("Unable to Sign In to the application");
			Assert.fail("Unable to Sign In To Application");
		}
	}
}