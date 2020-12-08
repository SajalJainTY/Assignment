package scripts;

import org.testng.annotations.Test;

import com.hcl.gim.baseutil.BaseTest;
import com.hcl.gim.baseutil.InitializePages;
import com.hcl.gim.dataprovider.DataProviderFactory;
import com.hcl.gim.dataprovider.DataProviderFile;

public class TYSS_GIM_0356 extends BaseTest{
//	@DataProviderFile(file = "/data/Data.xlsx", sheet = "testScript")
	@Test//(dataProvider = "data", dataProviderClass = DataProviderFactory.class)
	public void testScript() throws Exception {
String fileNameWithExtension="Capture.PNG";
String claimtype="Car parking Deduction";
String imagePath="C:\\Users\\sajal.j\\Pictures\\Capture.PNG";
String claimTypeExcelFilepath="C:\\Users\\sajal.j\\git\\GIM-App2\\data\\ClaimTypeTemplateData.xlsx";
String dataSheetName="Car_parking_Deduction";
String empCode="1190";
		InitializePages pages = new InitializePages(driver, ETO, WebActionUtil);
/*login to application*/
pages.loginpage.loginToApplication("40136083", "GIM@123#");
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
/*Validate all options displayed in Select Claim Type drop down*/
//pages.initiateClaimPage.validateAllClaimList();
/*Click Option in select claim type drop down*/
pages.initiateClaimPage.clkSelectClaimtypeDropdown(claimtype);
/*click download form template link*/
pages.initiateClaimPage.clkDownloadFormTemplateLink();
/*copy data from excel and Paste your content */
pages.initiateClaimPage.clkPasteYourContentHereText(claimTypeExcelFilepath, dataSheetName, empCode);
/*upload the file*/
pages.initiateClaimPage.clkUploadDocumentLink(imagePath);
/*validate file uploaded*/
//pages.initiateClaimPage.validateFileUpload(fileNameWithExtension);
/*click upload button*/
//pages.initiateClaimPage.clkUploadButton();
/*validate Are you sure you want to proceed popup displayed*/
//pages.initiateClaimPage.validateAreYouSurePopup();
/*Click Yes button in popup*/
////pages.initiateClaimPage.clkYesButton();
/*validate Data has been saved sucessfully message displayed*/

	}

}
