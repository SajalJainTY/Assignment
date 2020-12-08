package POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.hcl.gim.util.WebActionUtil;

/**
 * Description: This class implements the methods for Previous Records Page
 * 
 * @author Sajal jain
 */
public class PreviousRecords_Page {

	public WebDriver driver;
	public WebActionUtil WebActionUtil;
	public long ETO = 10;

	public PreviousRecords_Page(WebDriver driver, long ETO, WebActionUtil WebActionUtil) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.WebActionUtil = WebActionUtil;
		this.ETO = ETO;
	}

	/* Search Filter Button */
	@FindBy(xpath = "//a[@class='searhFilter']/i")
	private WebElement btnSearchFilter;

	/* Search Text Box */
	@FindBy(id = "searchbox")
	private WebElement txtSearchBox;

	/* Irem Filter Button */
	@FindBy(xpath = "//a/i[@class='iRem-filter']")
	private WebElement btnIremFilter;

	/* Employee Name Text Box */
	@FindBy(xpath = "//input[@class='form-control employeeIdName']")
	private WebElement txtEmployeeName;

	/* Claim Id Text Box */
	@FindBy(xpath = "//input[contains(@class,'form-control claimId numberAndCommaOnly')]")
	private WebElement txtClaimIDInIremFilter;

	/* Country Drop down */
	@FindBy(xpath = "(//a[@class='selecty-selected'])[1]")
	private WebElement ddCountry;

	/* Option in Country Drop down */
	public WebElement selectCountry(String countryName) {
		String xpath = "//ul[@class='selecty-options active']//li[text()='" + countryName + "']";
		return driver.findElement(By.xpath(xpath));
	}

	/* Input Type Drop down */
	@FindBy(xpath = "(//a[@class='selecty-selected'])[2]")
	private WebElement ddInputType;

	/* Option Input Type Drop down */
	public WebElement selectInputType(String inputType) {
		String xpath = "//ul[@class='selecty-options active']//li[text()='" + inputType + "']";
		return driver.findElement(By.xpath(xpath));
	}

	/* Period Drop down */
	@FindBy(xpath = "//label[text()='Period']/following-sibling::input")
	private WebElement ddPeriod;

	/* Status Drop down */
	@FindBy(xpath = "(//a[@class='selecty-selected'])[3]")
	private WebElement ddStatus;

	/* Option Status Drop down */
	public WebElement selectStatus(String status) {
		String xpath = "//ul[@class='selecty-options active']//li[text()='" + status + "']";
		return driver.findElement(By.xpath(xpath));
	}

	/* Apply Button */
	@FindBy(xpath = "//button[text()='APPLY']")
	private WebElement btnAPPLY;

	/* Reset Button */
	@FindBy(xpath = "//button[text()='RESET']")
	private WebElement btnRESET;

	/* Close Button in Filter Popup */
	@FindBy(xpath = "//span[@class=' icon-close filter-close']")
	private WebElement btnCloseFilterPopup;

	/* Click History */
	public WebElement clkHistory(String claimID) {
		String xpath = "//a[text()='" + claimID + "']/parent::td/following-sibling::td[@class=' action']/descendant::i";
		return driver.findElement(By.xpath(xpath));
	}

	/* Fetch History Popup Text */
	@FindBys({ @FindBy(xpath = "//div[contains(@class,'history')]/ul/li") })
	private List<WebElement> txtHistoryPopup;

	/* History Popup Close Button */
	@FindBy(xpath = "//h4[contains(text(),'History')]/preceding-sibling::button")
	private WebElement btnCloseHistoryPopup;

	/* Click View Documents */
	public WebElement clkViewDocuments(String claimID) {
		String xpath = "//a[text()='" + claimID
				+ "']/parent::td/following-sibling::td[@class=' text-center']/descendant::i";
		return driver.findElement(By.xpath(xpath));
	}

	/* View Documents Popup Text */
	@FindBys({ @FindBy(xpath = "//a[contains(@id,'Anch')]") })
	private List<WebElement> txtViewDocumentsPopup;

	/* Fetch Status Approved */
	public WebElement fetchStatusApproved(String claimID) {
		String xpath = "//a[text()='" + claimID + "']/parent::td/following-sibling::td/span[@class='pendingText']";
		return driver.findElement(By.xpath(xpath));
	}

	/* Fetch Status Rejected */
	public WebElement fetchStatusRejected(String claimID) {
		String xpath = "//a[text()='" + claimID + "']/parent::td/following-sibling::td/span[@class='referbackText']";
		return driver.findElement(By.xpath(xpath));
	}

	/* Fetch Claim ID */
	public WebElement fetchClaimID(String sapID) {
		String xpath = "//td[text()='" + sapID + "']/preceding-sibling::td/a";
		return driver.findElement(By.xpath(xpath));
	}

	/* Claim ID Popup Text */
	@FindBys({ @FindBy(xpath = "//div[@id='claimDetailBody']//td/p") })
	private List<WebElement> txtClaimIDPopup;

	/* Claim ID Popup Close Button */
	@FindBy(xpath = "//b[contains(text(),'Claim Details')]/parent::h4/preceding-sibling::button")
	private WebElement btnCloseClaimIDPopup;

	/* Page Size Drop down */
	@FindBy(name = "myTable_length")
	private WebElement ddPageSize;

	/* Next Arrow Button */
	@FindBy(id = "myTable_next")
	private WebElement btnNextArrow;

	/* Previous Arrow Button */
	@FindBy(id = "myTable_previous")
	private WebElement btnPreviousArrow;

	/*Filter Popup Text*/
	@FindBy(xpath = "//div[text()='Filter  ']")
	private WebElement txtFilter;

	/*Previous Records Text*/
	@FindBy(xpath = "//ol[@class='breadcrumb']/li[@class='active']")
	private WebElement txtPreviousRecords;

	/**
	 * Description Method to Select Period Drop down
	 * 
	 * @author Sajal jain
	 * @param date
	 */
	public synchronized void selectPeriodDD(String date) {
		try {
			WebActionUtil.waitForElement(btnIremFilter, "Irem Filter Button");
			WebActionUtil.clickOnElement(btnIremFilter, "Irem Filter Button", "Unable to click on Irem Filter Button");
			WebActionUtil.waitForElement(ddPeriod, "Period Drop down");
			WebActionUtil.clickOnElement(ddPeriod, "Period Drop down", "Unable to click Period Drop down");
			WebActionUtil.clearText(ddPeriod, "Period Drop down");
			WebActionUtil.typeText(ddPeriod, date, "Period Drop down");
			ddPeriod.sendKeys(Keys.ENTER);
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to perform action on Period Drop down");
			Assert.fail("Unable to perform action on Period Drop down");
		}
	}

	/**
	 * Description Method to Validate Text in History Popup
	 * 
	 * @author Sajal jain
	 * @param sapID
	 * @param expectedMsg
	 */
	public synchronized void validateHistoryPopupTxt(String sapID, String expectedMsg) {
		try {
			WebActionUtil.waitForElement(fetchClaimID(sapID), "Claim ID Text");
			String claimID = fetchClaimID(sapID).getText();
			WebActionUtil.clickOnElement(clkHistory(claimID), "History Button", "Unable to click History Button");
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfAllElements(txtHistoryPopup));
			int count = 0;
			for (WebElement txtHistory : txtHistoryPopup) {
				if (txtHistory.getText().contains(expectedMsg)) {
					WebActionUtil.validatePartialText(expectedMsg, txtHistory, expectedMsg + " present in History Popup");
					WebActionUtil.waitForElement(btnCloseHistoryPopup, "Close Button in History Popup");
					WebActionUtil.clickOnElement(btnCloseHistoryPopup, "Close Button in History Popup",
							"Unable to click Close Button in History Popup");
					count++;
					break;
				}
			}
			if (count == 0) {
				WebActionUtil.fail(expectedMsg + " is not present in History PopUp");
				Assert.fail(expectedMsg + " is not present in History PopUp");
			}
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to validate History Popup Text");
			Assert.fail("Unable to validate History Popup Text");
		}
	}

	/**
	 * Description Method to Validate Text in View Documents Popup
	 * 
	 * @author Sajal jain
	 * @param sapID
	 * @param expectedMsg
	 */
	public synchronized void validateViewDocumentsPopupTxt(String sapID, String expectedMsg) {
		try {
			WebActionUtil.waitForElement(fetchClaimID(sapID), "Claim ID Text");
			String claimID = fetchClaimID(sapID).getText();
			WebActionUtil.clickOnElement(clkViewDocuments(claimID), "View Documents Button",
					"Unable to click View Documents Button");
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfAllElements(txtViewDocumentsPopup));
			int count = 0;
			for (WebElement txtViewDocuments : txtViewDocumentsPopup) {
				if (txtViewDocuments.getText().contains(expectedMsg)) {
					WebActionUtil.validatePartialText(expectedMsg, txtViewDocuments, expectedMsg +" present in View Documents Popup");
					count++;
					break;
				}
			}
			if (count == 0) {
				WebActionUtil.fail(expectedMsg + " is not present in View Documents PopUp");
				Assert.fail(expectedMsg + " is not present in View Documents PopUp");
			}
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to validate View Documents Popup Text");
			Assert.fail("Unable to validate View Documents Popup Text");
		}
	}

	/**
	 * Description Method to Validate Text in Claim Id Popup Text
	 * 
	 * @author Sajal jain
	 * @param sapID
	 * @param expectedMsg
	 */
	public synchronized void validateClaimIDPopupTxt(String sapID, String expectedMsg) {
		try {
			WebActionUtil.waitForElement(fetchClaimID(sapID), "Claim ID Text");
			WebActionUtil.clickOnElement(fetchClaimID(sapID), "Claim ID Text", "Unable to click Claim ID Text");
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfAllElements(txtClaimIDPopup));
			int count = 0;
			for (WebElement txtClaimID : txtClaimIDPopup) {
				if (txtClaimID.getText().contains(expectedMsg)) {
					WebActionUtil.validatePartialText(expectedMsg, txtClaimID, expectedMsg+" present in Claim Id Popup");
					WebActionUtil.clickOnElement(btnCloseClaimIDPopup, "Close Button in Claim ID Popup",
							"Unable to click Close Button in Claim ID Popup");
					count++;
					break;
				}
			}
			if (count == 0) {
				WebActionUtil.fail(expectedMsg + " is not present in Claim ID PopUp");
				Assert.fail(expectedMsg + " is not present in Claim ID PopUp");
			}
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to validate Claim ID Popup Text");
			Assert.fail("Unable to validate Claim ID PopUp Text");
		}

	}

	/**
	 * Description Method to Validate Status Reject Text is displayed
	 * 
	 * @author Sajal jain
	 * @param sapID
	 * @param expectedStatus
	 */
	public synchronized void validateStatusRejectTxt(String sapID, String expectedStatus) {
		try {
			WebActionUtil.waitForElement(fetchClaimID(sapID), "Claim ID Text");
			String claimID = fetchClaimID(sapID).getText();
			WebActionUtil.validatetext(expectedStatus, fetchStatusRejected(claimID), "Status Reject Text",
					expectedStatus + " status is displayed", expectedStatus + " status is not displayed","blue");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail(expectedStatus + " is not displayed");
			Assert.fail(expectedStatus + " is not displayed");
		}
	}

	/**
	 * Description Method to Validate Status Approve Text is displayed
	 * 
	 * @author Sajal jain
	 * @param sapID
	 * @param expectedStatus
	 */
	public synchronized void validateStatusApproveTxt(String sapID, String expectedStatus) {
		try {
			WebActionUtil.waitForElement(fetchClaimID(sapID), "Claim ID Text");
			String claimID = fetchClaimID(sapID).getText();
			WebActionUtil.validatetext(expectedStatus, fetchStatusApproved(claimID), "Status Approved Text",
					expectedStatus + " status is displayed", expectedStatus + " status is not displayed","blue");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail(expectedStatus + " is not displayed");
			Assert.fail(expectedStatus + " is not displayed");
		}
	}

	/**
	 * Description Method to click Previous Arrow Button
	 * 
	 * @author Sajal jain
	 */
	public synchronized void clkPreviousArrowBtn() {
		try {
			WebActionUtil.waitForElement(btnPreviousArrow, "Previous Arrow Button");
			WebActionUtil.scrollToElement(btnPreviousArrow, "Previous Arrow Button");
			WebActionUtil.clickOnElement(btnPreviousArrow, "Previous Arrow Button",
					"Unable to click Previous Arrow Button");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to click Previous Arrow Button");
			Assert.fail("Unable to click Previous Arrow Button");
		}
	}

	/**
	 * Description Method to click Next Arrow Button
	 * 
	 * @author Sajal jain
	 */
	public synchronized void clkNextArrowBtn() {
		try {
			WebActionUtil.waitForElement(btnNextArrow, "Next Arrow Button");
			WebActionUtil.scrollToElement(btnNextArrow, "Next Arrow Button");
			WebActionUtil.clickOnElement(btnNextArrow, "Next Arrow Button", "Unable to click Next Arrow Button");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to click Next Arrow Button");
			Assert.fail("Unable to click Next Arrow Button");
		}
	}

	/**
	 * Description Method to Select Page Size Drop down
	 * 
	 * @author Sajal jain
	 * @param pageSize
	 */
	public void selectPageSizeDD(String pageSize) {
		try {
			WebActionUtil.waitForElement(ddPageSize, "Page Size Drop down");
			WebActionUtil.scrollToElement(ddPageSize, "Page Size Drop down");
			WebActionUtil.selectByText(ddPageSize, pageSize);
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to select Option in Page Size Drop down");
			Assert.fail("Unable to select Option in Page Size Drop down");
		}
	}

	/**
	 * Description Method to Click on Close Button in Filter
	 * 
	 * @author Sajal jain
	 */
	public synchronized void clkCloseBtn() {
		try {
			WebActionUtil.waitForElement(btnCloseFilterPopup, "Close Button in Filter");
			WebActionUtil.clickOnElement(btnCloseFilterPopup, "Close Button in Filter",
					"Unable to Click Close Button in Filter");
			WebActionUtil.waitForAngularPageload();
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to click Close Button in Filter");
			Assert.fail("Unable to click Close Button in Filter");
		}
	}

	/**
	 * Description Method to Click on Reset Button in Filter
	 * 
	 * @author Sajal jain
	 */
	public synchronized void clkResetBtn() {
		try {
			WebActionUtil.waitForElement(btnRESET, "Reset Button");
			WebActionUtil.clickOnElement(btnRESET, "Reset Button", "Unable to Click Reset Button");
			
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to click Reset Button");
			Assert.fail("Unable to click Reset Button");
		}
	}

	/**
	 * Description Method to Click on Apply Button in Filter
	 * 
	 * @author Sajal jain
	 */
	public synchronized void clkApplyBtn() {
		try {
			WebActionUtil.waitForElement(btnAPPLY, "Apply Button");
			WebActionUtil.clickOnElement(btnAPPLY, "Apply Button", "Unable to Click Apply Button");
			WebActionUtil.waitForAngularPageload();
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to click Apply Button");
			Assert.fail("Unable to click Apply Button");
		}
	}

	/**
	 * Description Method to click on Irem Filter and select Status Drop down
	 * 
	 * @author Sajal jain
	 * @param status
	 */
	public synchronized void selectStatusDD(String status) {
		try {
			WebActionUtil.waitForElement(btnIremFilter, "Irem Filter Button");
			WebActionUtil.clickOnElement(btnIremFilter, "Irem Filter Button", "Unable to click on Irem Filter Button");
			WebActionUtil.waitForElement(ddStatus, "Status Drop down");
			WebActionUtil.clickOnElement(ddStatus, "Status Drop down", "Unable to click Status Drop down");
			WebActionUtil.waitForElement(selectStatus(status), "Option in Status Drop down");
			WebActionUtil.clickOnElement(selectStatus(status), "Option in Status Drop down",
					"Unable to click Option in Status Drop down");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to perform action on Status Drop down");
			Assert.fail("Unable to perform action on Status Drop down");
		}
	}

	/**
	 * Description Method to click on Irem Filter and select Input Type Drop down
	 * 
	 * @author Sajal jain
	 * @param inputType
	 */
	public synchronized void selectInputTypeDD(String inputType) {
		try {
			WebActionUtil.waitForElement(btnIremFilter, "Irem Filter Button");
			WebActionUtil.clickOnElement(btnIremFilter, "Irem Filter Button", "Unable to click on Irem Filter Button");
			WebActionUtil.waitForElement(ddInputType, "Input Type Drop down");
			WebActionUtil.clickOnElement(ddInputType, "Input Type Drop down", "Unable to click Input Type Drop down");
			WebActionUtil.waitForElement(selectInputType(inputType), "Option in Input Type Drop down");
			WebActionUtil.clickOnElement(selectInputType(inputType), "Option in Input Type Drop down",
					"Unable to click Option in Input Type Drop down");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to perform action on Input Type Drop down");
			Assert.fail("Unable to perform action on Input Type Drop down");
		}
	}

	/**
	 * Description Method to click on Irem Filter and select Country Drop down
	 * 
	 * @author Sajal jain
	 * @param countryName
	 */
	public synchronized void selectCountryDD(String countryName) {
		try {
			WebActionUtil.waitForElement(btnIremFilter, "Irem Filter Button");
			WebActionUtil.clickOnElement(btnIremFilter, "Irem Filter Button", "Unable to click on Irem Filter Button");
			WebActionUtil.waitForElement(ddCountry, "Country Drop down");
			WebActionUtil.clickOnElement(ddCountry, "Country Drop down", "Unable to click Country Drop down");
			WebActionUtil.waitForElement(selectCountry(countryName), "Option in Country Drop down");
			WebActionUtil.clickOnElement(selectCountry(countryName), "Option in Country Drop down",
					"Unable to click Option in Country Drop Down");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to perform action on Country Drop down");
			Assert.fail("Unable to perform action on Country Drop down");
		}
	}

	/**
	 * Description Method to click on Irem Filter and Enter Claim ID Text Box
	 * 
	 * @author Sajal jain
	 * @param claimID
	 */
	public synchronized void setClaimID(String claimID) {
		try {
			WebActionUtil.waitForElement(btnIremFilter, "Irem Filter Button");
			WebActionUtil.clickOnElement(btnIremFilter, "Irem Filter Button", "Unable to click on Irem Filter Button");
			WebActionUtil.waitForElement(txtClaimIDInIremFilter, "Claim ID Text Box");
			WebActionUtil.typeText(txtClaimIDInIremFilter, claimID, "Claim ID Text Box");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to perform action on Claim ID Text Box");
			Assert.fail("Unable to perform action on ClaimID Text Box");
		}
	}

	/**
	 * Description Method to click on Irem Filter and Enter Employee Name/ sap id
	 * Text Box
	 * 
	 * @author Sajal jain
	 * @param employeeNameOrSapid
	 */
	public synchronized void setEmployeeName(String employeeNameOrSapid) {
		try {
			WebActionUtil.waitForElement(btnIremFilter, "Irem Filter Button");
			WebActionUtil.clickOnElement(btnIremFilter, "Irem Filter Button", "Unable to click on Irem Filter Button");
			WebActionUtil.waitForElement(txtEmployeeName, "Employee Name Text Box");
			WebActionUtil.typeText(txtEmployeeName, employeeNameOrSapid, "Employee Name Text Box");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to perform action on Employee Name Text Box");
			Assert.fail("Unable to perform action on Employee Name Text Box");
		}
	}

	/**
	 * Description Method to Click on Search Filter Button and type text in Search
	 * Text Box
	 * 
	 * @author Sajal jain
	 * @param search
	 */
	public synchronized void clkSearchFilterBtn(String search) {
		try {
			WebActionUtil.waitForElement(btnSearchFilter, "Search Filter Button");
			WebActionUtil.clickOnElement(btnSearchFilter, "Search Filter Button",
					"Unable to click on Search Filter Button");
			WebActionUtil.typeText(txtSearchBox, search, "Search Text Box");
			WebActionUtil.waitForAngularPageload();
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to perform action on Search Filter");
			Assert.fail("Unable to perform action on Search Filter");
		}
	}

	/**
	 * Description Method to validate Previous Records Page is displayed
	 * 
	 * @author Sajal jain
	 */
	public synchronized void validatePreviousRecordsPage() {
		try {
			WebActionUtil.waitForAngularPageload();
			WebActionUtil.waitForElement(txtPreviousRecords, "Previous Records Text");
			WebActionUtil.validatetext("Previous Records", txtPreviousRecords, "Previous Records Text",
					"Previous Records Page is displayed", "Previous Records Page is not displayed","blue");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Previous Records Page is not displayed");
			Assert.fail("Previous Records Page is not displayed");
		}
	}

}
