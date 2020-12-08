package POM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.hcl.gim.util.WebActionUtil;

/* * Description: This class implements the methods for accessing elements of Home page 
					 * 
					 * @author Abhilash b
					 * 
					 */
public class Home_Page{

public WebDriver driver;
	public WebActionUtil WebActionUtil;
	public long ETO = 10;
public Home_Page(WebDriver driver, long ETO, WebActionUtil WebActionUtil) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.WebActionUtil = WebActionUtil;
		this.ETO = ETO;
	}
/* Menu Drop Down */
	@FindBy(xpath= "//span[@class='icon-menu3 glb-pnl-localNav-ico']/parent::a")
	private WebElement ddMenu;

/* Logout */
	@FindBy(xpath= "//span[text()='LOGOUT ']/parent::a")
	private WebElement btnLogout;

/* Home */
	@FindBy(xpath= "//a[text()='Home']")
	private WebElement lnkHome;
	
/* previous records*/
	@FindBy(xpath= "//a[text()='Previous Records']")
	private WebElement lnkPreviousRecords;

/* Profile Drop Down */
	@FindBy(xpath= "//a[@class='dropdown-toggle glb-pnl-userInf-box1-pic']")
	private WebElement ddProfile;

/* Select Role */
	public WebElement selectRole(String var) {
		String xpath = "//a[text()='"+var+"']";
		return driver.findElement(By.xpath(xpath));
	}



/* Child Education Allowance */
	@FindBy(xpath= "//p[text()='Child Education Allowance']/parent::div")
	private WebElement btnChildEducationAllowance;

///* child Education Allowance Pop Close Button */
//	@FindBy(xpath= "//h4[text()='Select Input Type']/preceding-sibling::button")
//	private WebElement btnChildEducationAllowancePopupClose;

/* New Request */
	@FindBy(xpath= "//button[contains(text(),'RAISE NEW')]")
	private WebElement btnRaiseNewRequest;

/* Search Filter */
	@FindBy(xpath= "//a[@class='searhFilter']/i")
	private WebElement btnSearchFilter;
	
/* Search Button */
	@FindBy(id= "//input[@id='searchbox']/parent::li")
	private WebElement btnSearch;

/* Search Box */
	@FindBy(id= "searchbox")
	private WebElement txtSearchBox;

/* Close Button of pop up */
	@FindBy(xpath= "//h4[text()='HR Partner Manual']/../button")
	private WebElement btnClosePopUp;
	
	
/* Yes Button of Logout pop up  */
	@FindBy(xpath= "//button[text()='YES']")
	private WebElement btnYes;
	
///* Cancel Button of Logout pop up */
//	@FindBy(xpath= "//button[text()='NO']")
//	private WebElement btnNo;
	
/* Selects the Edit button of claim  */
	public WebElement selectEditButton(int claimID) {
		String xpath = "//a[@id='viewClaim']/u[text()='"+claimID+"']/../../..//i[@class='iRem-edit disablePointer']/parent::button";
		return driver.findElement(By.xpath(xpath));
	}
/* Selects the cancel button of claim  */
	public WebElement selectCancelButton(int claimID) {
		String xpath = "//a[@id='viewClaim']/u[text()='"+claimID+"']/../../..//i[@class='icon-close']/parent::button";
		return driver.findElement(By.xpath(xpath));
	}
/* Selects the HIstory button of claim  */
	public WebElement selectHistoryButton(int claimID) {
		String xpath = "//a[@id='viewClaim']/u[text()='"+claimID+"']/../../..//i[@class='iRem-history']/parent::button";
		return driver.findElement(By.xpath(xpath));
	}
	
/* Selects the claim ID  */
	public WebElement selectClaimID(int claimID) {
		String xpath = "//a[@id='viewClaim']/u[text()='"+claimID+"']/parent::a";
		return driver.findElement(By.xpath(xpath));
	}
	
	
/* Home Menu */
	public WebElement clkHomeMenu(String homeMenuOption) {
		String xpath = "//a[contains(text(),'+homeMenuOption+')]";
		return driver.findElement(By.xpath(xpath));
	}

/* RatingValue */
	public WebElement clkRatingValue(String ratingValue) {
		String xpath = "//a[@data-rating-value='+ratingValue+']";
		return driver.findElement(By.xpath(xpath));
	}

/* Initiate on behalf of employee */
	@FindBy(xpath= "//p[text()='Initiate behalf of Employee']")
	private WebElement btnInitiateOnBehalfOfEmployee;
	
/* page length */
	@FindBy(name="myTable_length")
	private WebElement ddTableLength;
		
/* pagination next */
	@FindBy(id="myTable_next")
	private WebElement btnPaginationNext;
	
/* pagination previous */
	@FindBy(id="myTable_previous")
	private WebElement btnPaginationPrevious;
	
/* HR Partner Manual */
	@FindBy(xpath="//h4[text()='HR Partner Manual']")
	private WebElement txtHRPartnerManual;
	
/* HR Partner Manual */
	@FindBy(xpath="//label[text()='   My Claims  ']")
	private WebElement txtMyClaims;
	
/* Select Input type */
	@FindBy(xpath="//h4[text()='Select Input Type']")
	private WebElement txtSelectInputType;
	
/* Select Input type */
	@FindBy(xpath="//h3[text()='Claim request for Child Education Allowance ']")
	private WebElement txtChildEducationAllowance;
	
    @FindBy(xpath="//label[contains(text(),'Claim Number')]")
	private WebElement lblHistoryPopUpClaimNo;
	
	public synchronized void fetchHistoryDetail(int claimID)
	{
		List<String[]> lstHistoryValues =new ArrayList<>();
		
		try {
			
			WebElement lnkHistory =selectHistoryButton(claimID);

			WebActionUtil.clickOnElement(lnkHistory, "History Link","Unable to click on History link");
			
			List<WebElement> lstClaimsHistory =driver.findElements(By.xpath("//div[@class='historyDeatil']/parent::div/descendant::li"));
			
		
			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfAllElements(lstClaimsHistory));
			
			
			
			String strClaimNo=lblHistoryPopUpClaimNo.getText();
			String[] arrClaimNoSplit=strClaimNo.split(":");
			String[] arrClaimNo = new String[2];
			System.out.println(arrClaimNoSplit[0].trim().replaceAll("[(]",""));
			System.out.println(arrClaimNoSplit[1].trim().replaceAll("[)]",""));
			arrClaimNo[0]=arrClaimNoSplit[0].trim().replaceAll("[(]","");
			arrClaimNo[1]=arrClaimNoSplit[1].trim().replaceAll("[)]","");
			lstHistoryValues.add(arrClaimNo);
			
			for(WebElement eachHistory:lstClaimsHistory)
			{
				String strHistory = eachHistory.getText().trim();
				String employeeId =strHistory.substring(strHistory.indexOf("(")+1, strHistory.indexOf(")"));
				String[] history =strHistory.replaceAll("\\s", " ").split(" ");
				System.out.println(history[3]+" "+history[5]+" "+employeeId);
				lstHistoryValues.add(new String[] {history[3],history[5],employeeId});
			}
			for(String[] arrHistoryValue:lstHistoryValues)
			{
				System.out.println(Arrays.toString(arrHistoryValue));
			}
			
		} catch (Exception e) {
			WebActionUtil.fail("Unable to click on the History link");
			Assert.fail("Unable to click on Validate History");
		}
	}
	
	
	/**
	 * Description:This Method implements to close the HCL Banner
	 * 
	 * @author Abhilash
	 */
	public synchronized void closeHCLBannerPopUp()
	{
		try {
			
		
            WebActionUtil.validateisElementDisplayed(btnClosePopUp, "Close button on HCL Banner","Log in is successfull","Failed to Log in");
            WebActionUtil.validatetext("HR Partner Manual", txtHRPartnerManual, "HR partner manual", "HR partner manual is displayed", "HR partner manual is not displayed");
			WebActionUtil.clickOnElement(btnClosePopUp, "Close button on HCL Banner","Unable to click on close button");
			WebActionUtil.validateisElementDisplayed(txtMyClaims, "My claims", "My claim page is displayed", "My claim page is not displayed");
			
		} catch (Exception e) {
			WebActionUtil.fail("Unable to click on the close button");
			Assert.fail("Unable to close pop up");
		}
	}
	
	/**
	 * Description:This Method implements to change the role
	 * 
	 * @author Abhilash
	 * @param role
	 */
	public synchronized void changeRole(String role)
	{
		try {
			WebActionUtil.actionMouseOver(ddProfile,"profile");
			WebActionUtil.clickOnElement(selectRole(role),"Role Link","Unable to click on"+role+"link" );
			
		} catch (Exception e) {
			WebActionUtil.fail("Unable to select the Role");
			Assert.fail("Unable to select the Role");
		}
		
	}
	/**
	 * Description:This Method implements navigation to the home page
	 * 
	 * @author Abhilash
	 */
	public synchronized void goToHome()
	{
		try {
			WebActionUtil.actionMouseOver(ddMenu,"Menu");
			WebActionUtil.clickOnElement(lnkHome,"Home","Unable to click on Home link");
			
		} catch (Exception e) {
			WebActionUtil.fail("Unable to go to the Home page");
			Assert.fail("Unable to go to the Home page");
		}
	
	}
	/**
	 * Description:This Method implements navigation to the Previous records page
	 * 
	 * @author Abhilash
	 */
	public synchronized void goToPreviousRecords()
	{
		try {
			WebActionUtil.actionMouseOver(ddMenu,"Menu");
			WebActionUtil.clickOnElement(lnkPreviousRecords,"Home","Unable to click on Prvious Records");
			
		} catch (Exception e) {
			WebActionUtil.fail("Unable to go to the Previous Records page");
			Assert.fail("Unable to go to the Previous Records page");
		}
	
	}
	
	/**
	 * Description:This Method implements to log out of the application
	 * 
	 * @author Abhilash
	 */
	public synchronized void logout()
	{
		try {
			WebActionUtil.actionMouseOver(ddProfile,"Profile");
			WebActionUtil.clickOnElement(btnLogout,"Logout","unable to click on logout button");
			WebActionUtil.waitForElement(btnYes, "Yes");
			Thread.sleep(3000);
			WebActionUtil.clickOnElement(btnYes, "Yes", "Unable to click on Yes button of logout pop up");
			WebActionUtil.pass("Logged out from the application is successful");
			
		} catch (Exception e) {
			WebActionUtil.fail("Unable to Log out from the application");
			Assert.fail("Unable to Log out from the Application");
		}
		
	}
	
	/**
	 * Description:This Method implements to Raise New Request
	 * 
	 * @author Abhilash
	 */
	public synchronized void raiseNewRequest()
	{
		try {
			WebActionUtil.clickOnElement(btnRaiseNewRequest,"New Request","Unable to click on Raise New Request Button");
			WebActionUtil.validateisElementDisplayed(txtSelectInputType, "Select Input Type", "Select Input Type pop up is displayed", "Select Input Type pop up is not displayed");
			WebActionUtil.clickOnElement(btnChildEducationAllowance,"Child Education Allowance","unable to click on Child Education Allowance");
			WebActionUtil.validateisElementDisplayed(txtChildEducationAllowance, "Child Education Allowance", "Child Education Allowance Page is displayed", "Child Education Allowance Page is not displayed");
		} catch (Exception e) {
			WebActionUtil.fail("Unable to Raise new Request for Child Education Allowance");
			Assert.fail("Unable to Raise new Request for Child Education Allowance");
			
		}
			}
	/**
	 * Description:This Method searches the applied claims
	 * 
	 * @author Abhilash
	 * @param value
	 */
	public synchronized void searchClaims(String value )
	{
		try {
			WebActionUtil.clickOnElement(btnSearch, "Search Button", "Unable to click on Search Button");
			WebActionUtil.typeText(txtSearchBox,value,"Search Box");
			
		} catch (Exception e) {
			WebActionUtil.fail("Unable to Search claims");
			Assert.fail("Unable to Search claims");
		}
		
	}
	
	/**
	 * Description:This Method implements to provide the feedback 
	 * 
	 * @author  Vikas
	 * @param rating
	 */
	public synchronized void setFeedbackRating(String rating )
	{
		try {
			WebActionUtil.clickOnElement(clkRatingValue(rating), "Rating Button", "Unable to click on Rating Button");
	
			
		} catch (Exception e) {
			WebActionUtil.fail("Unable to  Set the rating in the feedback");
			Assert.fail("Unable to  Set the rating in the feedback");
		}
		
	}

	/**
	 * Description:This Method implements to provide the feedback 
	 * @author  Vikas
	 * @param homemenu
	 */
	public synchronized void setHomeMenu(String homemenu )
	{
		try {
			WebActionUtil.actionMouseOver(ddMenu, "Main Menu");
			WebActionUtil.clickOnElement(clkHomeMenu(homemenu), homemenu+" Link", "Unable to click on "+homemenu +"Link");
	
			
		} catch (Exception e) {
			WebActionUtil.fail("Unable to  set the home link ");
			Assert.fail("Unable to  Set the rating in the feedback");
		}
		
	}

	
	/**
	 * Description:This Method implements to click on Initiate On Behalf Of Employee
	 * @author  Vikas
	 * @param homemenu
	 */
	public synchronized void clkInitiateOnBehalfOfEmployee( )
	{
		try {
			WebActionUtil.clickOnElement(btnInitiateOnBehalfOfEmployee,"Initiate On Behalf Of Employee Buttton ", "Unable to click on Initiate On Behalf Of Employee Buttton");
	
			
		} catch (Exception e) {
			WebActionUtil.fail("Unable to click on Initiate On Behalf Of Employee Buttton");
			Assert.fail("Unable to click on Initiate On Behalf Of Employee Buttton");
		}
		
	}
	
	/**
	 * Description:This Method implements to display the last page
	 * @author  Abhilash
	
	 */
	public synchronized void gotoLastpage( )
	{
		
		try {
			Select s=new Select(ddTableLength);
			s.deselectByValue("100");
	
			while(btnPaginationNext.isEnabled())
			{
			WebActionUtil.clickOnElement(btnPaginationNext,"Pagination Next ", "Unable to click on Pagination Next");
			}
			
		} catch (Exception e) {
			WebActionUtil.fail("Unable to click on Pagination Next");
			Assert.fail("Unable to click on Pagination Next");
		}
	}
	
	/**
	 * Description:This Method implements to click on edit claim
	 * @author  Abhilash
	
	 */
		
		public synchronized void clickEditClaim( )
		{
			
			try {
				gotoLastpage();
				List<WebElement> claimIds = driver.findElements(By.xpath("//a[@id='viewClaim']/u"));
				ArrayList<Integer> claimIDs=new ArrayList<Integer>();
				for(WebElement claimID:claimIds)
				{
					claimIDs.add(Integer.parseInt(claimID.getText()));
				}
				Collections.sort(claimIDs,Collections.reverseOrder());
				WebActionUtil.clickOnElement(selectEditButton(claimIDs.get(0)), "Edit button", "unable to click on edit button");
				WebActionUtil.info("clicked on edit button");
				
				}
				
			catch (Exception e) {
				WebActionUtil.fail("unable to click on edit button");
				Assert.fail("unable to click on edit button");
			}
		
	}
		
		/**
		 * Description:This Method implements to click on cancel claim
		 * @author  Abhilash
		
		 */
		public synchronized void clickCancelClaim( )
		{
			
			try {
				gotoLastpage();
				List<WebElement> claimIds = driver.findElements(By.xpath("//a[@id='viewClaim']/u"));
				ArrayList<Integer> claimIDs=new ArrayList<Integer>();
				for(WebElement claimID:claimIds)
				{
					claimIDs.add(Integer.parseInt(claimID.getText()));
				}
				Collections.sort(claimIDs,Collections.reverseOrder());
				WebActionUtil.clickOnElement(selectCancelButton(claimIDs.get(0)), "Cancel button", "unable to click on Cancel button");
				WebActionUtil.info("clicked on cancel button");
				
				}
				
			catch (Exception e) {
				WebActionUtil.fail("unable to click on cancel button");
				Assert.fail("unable to click on cancel button");
			}
		
	}
	
		/**
		 * Description:This Method implements to click on claim History
		 * @author  Abhilash
		
		 */
		public synchronized void clickClaimHistory( )
		{
			
			try {
				gotoLastpage();
				List<WebElement> claimIds = driver.findElements(By.xpath("//a[@id='viewClaim']/u"));
				ArrayList<Integer> claimIDs=new ArrayList<Integer>();
				for(WebElement claimID:claimIds)
				{
					claimIDs.add(Integer.parseInt(claimID.getText()));
				}
				Collections.sort(claimIDs,Collections.reverseOrder());
				WebActionUtil.clickOnElement(selectHistoryButton(claimIDs.get(0)), "History button", "unable to click on History button");
				WebActionUtil.info("clicked on History button");
				
				}
				
			catch (Exception e) {
				WebActionUtil.fail("unable to click on History button");
				Assert.fail("unable to click on History button");
			}
		
	}
	
		/**
		 * Description:This Method implements to view claim
		 * @author Abhilash
		 * @param homemenu
		 */
		public synchronized void clkviewClaim( )
		{
			try {
				gotoLastpage();
				List<WebElement> claimIds = driver.findElements(By.xpath("//a[@id='viewClaim']/u"));
				ArrayList<Integer> claimIDs=new ArrayList<Integer>();
				for(WebElement claimID:claimIds)
				{
					claimIDs.add(Integer.parseInt(claimID.getText()));
				}
				Collections.sort(claimIDs,Collections.reverseOrder());
				WebActionUtil.clickOnElement(selectClaimID(claimIDs.get(0)), "view claim button", "unable to click on View claim button");
				WebActionUtil.info("clicked on view claim button");
				
				}
				
			catch (Exception e) {
				WebActionUtil.fail("unable to click on view claim button");
				Assert.fail("unable to click on view claim button");
			}
			
		}
		/**
		 * Description:This Method implements to return claim ID
		 * @author Abhilash
		 * @param homemenu
		 */
		public synchronized String retrieveClaimId( )
		{       String claID=null;
			try {
				gotoLastpage();
				List<WebElement> claimIds = driver.findElements(By.xpath("//a[@id='viewClaim']/u"));
				ArrayList<Integer> claimIDsInt=new ArrayList<Integer>();
				for(WebElement claimID:claimIds)
				{
					claimIDsInt.add(Integer.parseInt(claimID.getText()));
				}
				Collections.sort(claimIDsInt,Collections.reverseOrder());
				claID=""+claimIDsInt.get(0);
				WebActionUtil.info("claim ID is retrieved ");
				
				}
				
			catch (Exception e) {
				WebActionUtil.fail("unable to retrieve claim ID");
				Assert.fail("unable to retrieve claim ID");
			}
			return claID;
		}
	
	
}