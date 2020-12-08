package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.hcl.gim.util.WebActionUtil;
/**
					 * Description: This class implements the methods to claim child education allowance 
					 * 
					 * @author Abhilash B
					 * 
					 */
public class ChildEducationAllowance_Page{

public WebDriver driver;
	public WebActionUtil WebActionUtil;
	public long ETO = 10;
public ChildEducationAllowance_Page(WebDriver driver, long ETO, WebActionUtil WebActionUtil) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.WebActionUtil = WebActionUtil;
		this.ETO = ETO;
	}
/* One time registration */
	@FindBy(id= "btnOT")
	private WebElement btnOneTimeRegistration;

/* Tuition fees */
	@FindBy(id= "btnTF")
	private WebElement btnTuitionFees;

/* child name drop down */
	@FindBy(xpath= "//label[text()='Child Name ']/..//a[text()='Select']")
	private WebElement ddChildname;

/* select academic year */
	public WebElement SelectAcademicYear(String var) {
		String xpath = "//button[text()='"+var+"']";
		return driver.findElement(By.xpath(xpath));
	}

/* select child name */
	public WebElement SelectChildName(String var) {
		String xpath = "//li[text()='"+var+"']";
		return driver.findElement(By.xpath(xpath));
	}

/* From date */
	@FindBy(id= "fromDate")
	private WebElement txtFromDate;
	
/* From date ID*/
	private String FromDateID="fromDate";

/* To date */
	@FindBy(id= "toDate")
	private WebElement txtToDate;
/* To date ID*/	
	private String ToDateID="toDate";

/* class/grade drop down */
	@FindBy(xpath= "//label[text()='Class/Grade ']/..//a[text()='Select']")
	private WebElement ddClass;

/* select class/grade */
	public WebElement SelectGrade(String var) {
		String xpath = "//li[text()='"+var+"']";
		return driver.findElement(By.xpath(xpath));
	}

/* Claim amount */
	@FindBy(id= "Amount")
	private WebElement txtAmount;

/* school name */
	@FindBy(id= "SchoolName")
	private WebElement txtSchoolName;

/* Remarks */
	@FindBy(id= "ChildEducationRemarks")
	private WebElement txtRemarks;

/* upload button */
	@FindBy(id= "dropzone1")
	private WebElement btnAttachDocument;

/* add claim Button */
	@FindBy(id= "showClaimListBtn")
	private WebElement btnAddClaim;
	
/* Download template link */
	@FindBy(xpath="//a[text()='Download template  ']")
	private WebElement lnkDownloadTemplate;	
	
/*initiate claim button */
	@FindBy(id= "btnInitiateClaim")
	private WebElement btnInitiateClaim;	
	
/*confirm and initiate button */
	@FindBy(xpath="//button[text()=' CONFIRM AND INITIATE']")
	private WebElement btnConfirmAndInitiate;
	
/*confirm and initiate close button */
	@FindBy(xpath="//h4[text()='Please Confirm']/..//button[@class='close icon-close']")
	private WebElement btnConfirmAndInitiateclose;	
	
/*added request actions button */
	@FindBy(xpath="//a[@class='popoverDataSmall iRem-more']")
	private WebElement btnAddedRequestActions;	
	
/*added request edit button */
	@FindBy(xpath="//i[@class='iRem-edit']/parent::button")
	private WebElement btnEditRequest;	
	
/*added request delete button */
	@FindBy(xpath="//i[@class='iRem-delete']/parent::button")
	private WebElement btnDeleteRequest;
	
/*Requests added */
	@FindBy(xpath="//h3[contains(text(),'Requests added')]")
	private WebElement txtRequestAdded;
	
	
	
	/**
	 * Description: This method implements add one time registration claim
	 * 
	 * @author:Abhilash B
	 * @param :ChildName
	 * @param :Academic Year
	 * @param :From Date 
	 * @param :To Date
	 * @param :Class/Grade
	 * @param :Amount
	 * @param :School name
	 * @param :filelocation
	 * @param :Remarks
	 */
	
	public synchronized void applyoneTimeRegistration(String ChildName,String AcademicYear,String FromDate,String ToDate,String grade,String Amount,String SchoolName,String Remarks,String filelocation)
	{
		
		try {
		
		WebActionUtil.validateAttribute(btnOneTimeRegistration, "class", "btn active", "one time registration","OneTimeRegistration is selected by default","OneTimeRegistration is not selected by default");
		
		WebActionUtil.clickOnElement(ddChildname,"Child name", "Unable to click on child name dropdown");
		WebActionUtil.clickOnElement(SelectChildName(ChildName),"ChildName","Unable to select ChildName");
		WebActionUtil.validateAttribute(SelectChildName(ChildName), "class", "selected", "ChildName","Child Name is Selected","Child Name is not Selected");
		
		WebActionUtil.clickOnElement(SelectAcademicYear(AcademicYear),"AcademicYear","unble to select Academic Year");
		WebActionUtil.validateAttribute(SelectAcademicYear(AcademicYear), "class", "btn active", "Academic year", "Academic Period is selected", "Academic Period is not selected");
		
		WebActionUtil.selectGIM_CalendarDate(FromDateID, FromDate, "From Date");
		WebActionUtil.selectGIM_CalendarDate(ToDateID, ToDate, "To Date");
		
		WebActionUtil.clickOnElement(ddClass,"class/grade drop down","unble to click on class/grade dropdown");
		WebActionUtil.clickOnElement(SelectGrade(grade),"class/grade", "Unable to select class/grade");
		WebActionUtil.validateAttribute(SelectGrade(grade), "class", "selected", "class/Grade", "Class/Grade is selected", "Class/Grade is not selected");
	
		WebActionUtil.typeText(txtAmount,Amount,"Amount");
		WebActionUtil.typeText(txtSchoolName,SchoolName,"School name");
		WebActionUtil.typeText(txtRemarks,Remarks,"Remarks");
		
		WebActionUtil.clickOnElement(lnkDownloadTemplate, "Download Template", "Unable to click on Download Template");
		WebActionUtil.clickOnElement(btnAttachDocument,"Attach document Button", "Unable to click on Attach Document Button");
		
		WebActionUtil.upload(filelocation);
		WebActionUtil.validateAttribute(btnAttachDocument, "class", "dz-clickable dropzone dz-started", "Attach document", "Document is uploaded", "Document is not uploaded");
		
		WebActionUtil.clickOnElement(btnAddClaim,"Add Claim", "Unable to click on Add Claim");
		WebActionUtil.validateisElementDisplayed(txtRequestAdded, "Request Added", "Adding claim of One Time Registration is successfull", "Failed to add Claim of One Time Registration");
		WebActionUtil.validateisElementDisplayed(btnInitiateClaim, "Initiate claim", "Initiate claim Button is displayed", "Initiate claim Button is not displayed");

		}
		catch (Exception e) {
			WebActionUtil.fail("Unable to add claim of One Time Registration type ");
			WebActionUtil.error("Unable to add claim of One Time Registration type ");
			Assert.fail("Unable to add claim of One Time Registration type ");
		}
		
	}
	/**
	 * Description: This method implements add tuition fees claim
	 * 
	 * @author:Abhilash B
	 * @param filelocation 
	 * @param :ChildName
	 * @param :Academic Year
	 * @param :From Date 
	 * @param :To Date
	 * @param :Class/Grade
	 * @param :Amount
	 * @param :School name
	 * @param :Remarks
	 * @param :filelocation
	 */
	public synchronized void applytuitionFees(String ChildName,String AcademicYear,String FromDate,String ToDate,String grade,String Amount,String SchoolName,String Remarks, String filelocation)
	{
		try {
		WebActionUtil.clickOnElement(btnTuitionFees,"Tution Fees", "Unable click on Tution fees");
		WebActionUtil.validateAttribute(btnTuitionFees, "class", "btn active", "Tuition Fees","Tuition Fees is selected","Tuition Fees is not selected");
		WebActionUtil.clickOnElement(ddChildname,"Child name", "Unable to click on child name dropdown");
		WebActionUtil.clickOnElement(SelectChildName(ChildName),"ChildName","Unable to select ChildName");
		WebActionUtil.validateAttribute(SelectChildName(ChildName), "class", "selected", "ChildName","Child Name is Selected","Child Name is not Selected");
		
		WebActionUtil.clickOnElement(SelectAcademicYear(AcademicYear),"AcademicYear","unble to select Academic Year");
		WebActionUtil.validateAttribute(SelectAcademicYear(AcademicYear), "class", "btn active", "Academic year", "Academic Period is selected", "Academic Period is not selected");
		
		WebActionUtil.selectGIM_CalendarDate(FromDateID, FromDate, "From Date");
		WebActionUtil.selectGIM_CalendarDate(ToDateID, ToDate, "To Date");
		
		WebActionUtil.clickOnElement(ddClass,"class/grade drop down","unble to click on class/grade dropdown");
		WebActionUtil.clickOnElement(SelectGrade(grade),"class/grade", "Unable to select class/grade");
		WebActionUtil.validateAttribute(SelectGrade(grade), "class", "selected", "class/Grade", "Class/Grade is selected", "Class/Grade is not selected");
	
		WebActionUtil.typeText(txtAmount,Amount,"Amount");
		WebActionUtil.typeText(txtSchoolName,SchoolName,"School name");
		WebActionUtil.typeText(txtRemarks,Remarks,"Remarks");
		
		WebActionUtil.clickOnElement(lnkDownloadTemplate, "Download Template", "Unable to click on Download Template");
		WebActionUtil.clickOnElement(btnAttachDocument,"Attach document Button", "Unable to click on Attach Document Button");
		
		WebActionUtil.upload(filelocation);
		WebActionUtil.validateAttribute(btnAttachDocument, "class", "dz-clickable dropzone dz-started", "Attach document", "Document is uploaded", "Document is not uploaded");
		
		WebActionUtil.clickOnElement(btnAddClaim,"Add Claim", "Unable to click on Add Claim");
		WebActionUtil.validateisElementDisplayed(txtRequestAdded, "Request Added", "Adding claim of Tuition Fees is successfull", "Failed to add Claim of Tuition Fees");
		WebActionUtil.validateisElementDisplayed(btnInitiateClaim, "Initiate claim", "Initiate claim Button is displayed", "Initiate claim Button is not displayed");
		}
		catch (Exception e) {
			WebActionUtil.fail("Unable to add claim of Tuition Fees type ");
			WebActionUtil.error("Unable to add claim of Tuition Fees type ");
			Assert.fail("Unable to add claim of Tuition Fees type ");
		}
		
	}
	
	/**
	 * Description: This method implements  initiate claim
	 *
	**/
	public synchronized void clickInitiateClaim()
	{
		
		try {
			WebActionUtil.clickOnElement(btnInitiateClaim, "Initiate claim", "unable to click on initiate claim");
			WebActionUtil.info("clicked on initiate claim");
			WebActionUtil.validateisElementDisplayed(btnConfirmAndInitiate, "confirm and Initiate", "Confirm and initiate pop up is displayed", "Confirm and initiate pop up is not displayed");
		} catch (Exception e) {
			WebActionUtil.error("unable to click on initiate claim");
			Assert.fail("unable to click on initiate claim");
		}
	}

	/**
	 * Description: This method implements to confirm and initiate claim
	 *
	**/
	public synchronized void clickConfirmAndInitiate()
	{
		try {
			WebActionUtil.clickOnElement(btnConfirmAndInitiate, "confirm and initiate", "unable to click on confirm and initiate ");
			WebActionUtil.info("clicked on confirm and initiate claim");
		} catch (Exception e) {
			WebActionUtil.error("unable to click on confirm and initiate ");
			Assert.fail("unable to click on confirm and initiate ");
		}
		
	}
	
	/**
	 * Description: This method implements  to edit added claim request
	 *
	**/
	public synchronized void clickEditRequest()
	{
		
		try {
			WebActionUtil.clickOnElement(btnAddedRequestActions, "Added Request Actions", "unable to click on added request actions button");
			WebActionUtil.clickOnElement(btnEditRequest, "Edit Request", "unable to click on edit request button");
			WebActionUtil.info("clicked on Edit Request button");
		} catch (Exception e) {
			WebActionUtil.error("unable to click on edit request button ");
			Assert.fail("unable to click on edit request button");
		}
	}
	
	
	/**
	 * Description: This method implements  to delete added claim request
	 *
	**/
	public synchronized void clickDeleteRequest()
	{
		
		try {
			WebActionUtil.clickOnElement(btnAddedRequestActions, "Added Request Actions", "unable to click on added request actions button");
			WebActionUtil.clickOnElement(btnDeleteRequest, "Delete Request", "unable to click on Delete request button");
			WebActionUtil.info("clicked on delete request button");
		} catch (Exception e) {
			WebActionUtil.error("unable to click on delete request button");
			Assert.fail("unable to click on delete  request button");
		}
	}


}