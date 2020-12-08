package scripts;

import org.testng.annotations.Test;

import com.hcl.gim.baseutil.BaseTest;
import com.hcl.gim.baseutil.InitializePages;

public class TYSS_GIM_0764 extends BaseTest{
//	@DataProviderFile(file = "/data/Data.xlsx", sheet = "testScript")
	@Test//(dataProvider = "data", dataProviderClass = DataProviderFactory.class)
	public void testScript() throws Exception {
String un="40136083";
String pwd="GIM@123#";
String claimtype="Exgratia - Language allowance";
String variableclaimtyperadio="Through the Form";
String fromDate="08-19-2020";
String toDate="08-19-2020";
String empCode="40132390";
String countryCode="13";
String companyCode="7000";
String amount="103.1";
String remarks="Test1";
String numberOfInstallments="2";
String rate="R2";
String filePath="C:\\Users\\sajal.j\\Pictures\\Capture.PNG";
String fileNameWithExtension="Capture.PNG";
String approveRemark="Approved";
InitializePages pages = new InitializePages(driver, ETO, WebActionUtil);
/*Login to application*/
pages.loginpage.loginToApplication(un, pwd);
/*validate Hr Partner manual popup displayed*/
pages.homePage.validateHrPartnerManual();
/*Click Close Button in HCL Banner Popup*/
pages.homePage.closeHCLBannerPopUp();
/*validate home page displayed*/
pages.homePage.validateHomePage();
/*Click Initiate on behalf of Employee*/
pages.homePage.clkInitiateOnBehalfOfEmployee();
/*validate initiate claim page displayed*/
pages.initiateClaimPage.validateInitiateClaimsPage();
/*Click Option in select claim type drop down*/
pages.initiateClaimPage.clkSelectClaimtypeDropdown(claimtype);
/*click claim type radio button*/
pages.initiateClaimPage.clkClaimtypeRadioButton(variableclaimtyperadio);
/*Set field in Through the form page*/
pages.throughTheFormPage.commonForm(fromDate, toDate, empCode, countryCode, companyCode, amount, remarks);
/*Set field in Through the form page*/
pages.throughTheFormPage.setNoOfInstallmentsAndRate(numberOfInstallments, rate);
/*Upload the file*/
pages.throughTheFormPage.uploadFile(filePath);
/*validate file uploaded*/
pages.throughTheFormPage.validateFileUpload(fileNameWithExtension);
/*Click submit button*/
pages.throughTheFormPage.clkThroughFormSubmitButton();
/*validate Are you sure you want to proceed popup displayed*/
pages.throughTheFormPage.validateAreYouSurePopup();
/*Click Yes button in popup*/
pages.throughTheFormPage.clkYesButton();
/*validate Data has been saved sucessfully message displayed*/

/*Navigate to menu and click on initiate claims*/
pages.homePage.setHomeMenu("Initaite Claims");
/*validate list of all claims displayed*/

/*Click submit button under actions tab*/
pages.initiateClaimsPage.clkSubmit();
/*validate submit popup displayed*/

/*set remarks*/
pages.initiateClaimsPage.setApproveRemark(approveRemark);
/*Click submit button*/
pages.initiateClaimsPage.clkApproveSubmit();
/*validate Are you sure you want to proceed popup displayed*/

/*Click Yes button*/
pages.initiateClaimsPage.clkApproveYes();
/*line 15 expected condition need to cross verify with shreya*/

	}

}
