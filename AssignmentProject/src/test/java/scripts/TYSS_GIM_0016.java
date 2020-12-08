package scripts;

import java.util.Map;

import org.testng.annotations.Test;

import com.hcl.gim.baseutil.BaseTest;
import com.hcl.gim.baseutil.InitializePages;
import com.hcl.gim.dataprovider.DataProviderFactory;
import com.hcl.gim.dataprovider.DataProviderFile;

/**
 * Description: Verify that On Site Employee Can Re-initiate the Child Education
 * Claim rejected by ES2 for One Time Registration - exception case
 * 
 * @author Sajal Jain
 * 
 */
public class TYSS_GIM_0016 extends BaseTest {
String claimid="24";
	@DataProviderFile(file = "./data/GimTestData.xlsx" , sheet = "TYSS_GIM_0016")
	@Test(dataProvider = "data", dataProviderClass = DataProviderFactory.class)
	public synchronized void TYSS_GIM_0016(String empCode,String ChildName,String AcademicYear,String FromDate,String ToDate,String grade,String Amount,String SchoolName,String Remarks,String fileFormat,String expectedStatusRMLogin,String expectedStatusL2Login,String expectedStatusGeoHrLogin,String expectedStatusES1Login,String expectedStatusES2Login) {
	Map<String, String> loginDetails = WebActionUtil.getLoginDetailsForAllRoles(empCode);
	InitializePages pages = new InitializePages(driver, ETO, WebActionUtil);
	/*Login to Application as employee*/
//	pages.loginpage.loginToApplication(loginDetails.get("EmpCode"), loginDetails.get("Password"));
	/*Click Close Button*/
//	pages.homePage.closeHCLBannerPopUp();
//	/*Click Raise New Request button than click on Child education allowance*/
//	pages.homePage.raiseNewRequest();
//	/*Fill the Child allowance form*/
//	pages.childEducationAllowancePage.applyoneTimeRegistration(ChildName, AcademicYear, FromDate, ToDate, grade, Amount, SchoolName, Remarks, WebActionUtil.getSampleFilePath(fileFormat));
//	/*Click initiate claim button*/
//	pages.childEducationAllowancePage.clickInitiateClaim();
//	/*Click confirm and initiate button*/
//	pages.childEducationAllowancePage.clickConfirmAndInitiate();
//	pages.homePage.goToHome();
//	claimid = pages.homePage.retrieveClaimId();
	/*logout from application*/
//	pages.homePage.logout();
	
	/*Login to Application as RM*/
	pages.loginpage.loginToApplication(loginDetails.get("RM"), loginDetails.get("Password"));
	/*Click Close Button*/
	pages.homePage.closeHCLBannerPopUp();
	/*Click Pending for approval tab*/
	pages.pendingActionsPage.pendingAprovelbtn();
	/*CLick on Approve button*/
	pages.pendingActionsPage.referApproveClaim(claimid);
	/*Click Submit button*/
	pages.pendingActionsPage.clickOnSubmitButton();
	/*Click Yes button*/
	pages.pendingActionsPage.clickOnYesButton();
	/*Click previous records in Menu drop down*/
	pages.homePage.goToPreviousRecords();
	/*Validate status of claim*/
	pages.previousRecordsPage.validateStatusApproveTxt(empCode, expectedStatusRMLogin);
	/*Logout from application*/
	pages.homePage.logout();
	/*Login to Application as L2*/
	pages.loginpage.loginToApplication(loginDetails.get("L2"), loginDetails.get("Password"));
	/*Click Close Button*/
	pages.homePage.closeHCLBannerPopUp();
	/*Click Pending for approval tab*/
	pages.pendingActionsPage.pendingAprovelbtn();
	/*CLick on Approve button*/
	pages.pendingActionsPage.referApproveClaim(claimid);
	/*Click Submit button*/
	pages.pendingActionsPage.clickOnSubmitButton();
	/*Click Yes button*/
	pages.pendingActionsPage.clickOnYesButton();
	/*Click previous records in Menu drop down*/
	pages.homePage.goToPreviousRecords();
	/*Validate status of claim*/	
	pages.previousRecordsPage.validateStatusApproveTxt(empCode, expectedStatusL2Login);
	/*Logout from application*/
	pages.homePage.logout();
	/*Login to Application as Geo HR*/
	pages.loginpage.loginToApplication(loginDetails.get("GeoHR"), loginDetails.get("Password"));
	/*Click Close Button*/
	pages.homePage.closeHCLBannerPopUp();
	/*Click Pending for approval tab*/
	pages.pendingActionsPage.pendingAprovelbtn();
	/*CLick on Approve button*/


	pages.pendingActionsPage.referApproveClaim(claimid);
	/*Click Submit button*/
	pages.pendingActionsPage.clickOnSubmitButton();
	/*Click Yes button*/
	pages.pendingActionsPage.clickOnYesButton();
	/*Click previous records in Menu drop down*/
	pages.homePage.goToPreviousRecords();
	/*Validate status of claim*/
	pages.previousRecordsPage.validateStatusApproveTxt(empCode, expectedStatusGeoHrLogin);
	/*Logout from application*/
	pages.homePage.logout();
	/*Login to Application as ES-1*/
	pages.loginpage.loginToApplication(loginDetails.get("ES1"), loginDetails.get("Password"));
	/*Click Close Button*/
	pages.homePage.closeHCLBannerPopUp();
	/*Click Pending for approval tab*/
	pages.pendingActionsPage.pendingAprovelbtn();
	/*CLick on Approve button*/
	

	pages.pendingActionsPage.referApproveClaim(claimid);
	/*Click Submit button*/
	pages.pendingActionsPage.clickOnSubmitButton();
	/*Click Yes button*/
	pages.pendingActionsPage.clickOnYesButton();
	/*Click previous records in Menu drop down*/
	pages.homePage.goToPreviousRecords();
	/*Validate status of claim*/
	pages.previousRecordsPage.validateStatusApproveTxt(empCode, expectedStatusES1Login);
	/*Logout from application*/
	pages.homePage.logout();
	
	/*Login to Application as ES2*/
	pages.loginpage.loginToApplication(loginDetails.get("ES2"), loginDetails.get("Password"));
	/*Click Close Button*/
	pages.homePage.closeHCLBannerPopUp();
	/*Click Pending for approval tab*/
	pages.pendingActionsPage.pendingAprovelbtn();
	/*CLick on Refer back button*/
	pages.pendingActionsPage.referBackClaim(claimid);
	/*Set Remark*/
	pages.pendingActionsPage.setReferBackRemarksTextAreafield(Remarks);
	/*Click submit Button*/
	pages.pendingActionsPage.clickOnSubmitReferBackButton();
	/*Logout from application*/
	pages.homePage.logout();
	/*Login to Application as employee*/
	pages.loginpage.loginToApplication(loginDetails.get("EmpCode"), loginDetails.get("Password"));
	/*Click Close Button*/
	pages.homePage.closeHCLBannerPopUp();	






	/*Click on Menu*/
	pages.homePage.goToHome();


	/*Logout from application*/
	pages.homePage.logout();
	
	/*Login to Application as RM*/
	pages.loginpage.loginToApplication(loginDetails.get("RM"), loginDetails.get("Password"));
	/*Click Close Button*/
	pages.homePage.closeHCLBannerPopUp();
	/*Click Pending for approval tab*/
	pages.pendingActionsPage.pendingAprovelbtn();
	/*CLick on Approve button*/
	pages.pendingActionsPage.referApproveClaim(claimid);
	/*Click Submit button*/
	pages.pendingActionsPage.clickOnSubmitButton();
	/*Click Yes button*/
	pages.pendingActionsPage.clickOnYesButton();
	/*Click previous records in Menu drop down*/
	pages.homePage.goToPreviousRecords();
	/*Validate status of claim*/
	pages.previousRecordsPage.validateStatusApproveTxt(empCode, expectedStatusRMLogin);
	/*Logout from application*/
	pages.homePage.logout();
	/*Login to Application as L2*/
	pages.loginpage.loginToApplication(loginDetails.get("L2"), loginDetails.get("Password"));
	/*Click Close Button*/
	pages.homePage.closeHCLBannerPopUp();
	/*Click Pending for approval tab*/
	pages.pendingActionsPage.pendingAprovelbtn();
	/*CLick on Approve button*/
	pages.pendingActionsPage.referApproveClaim(claimid);
	/*Click Submit button*/
	pages.pendingActionsPage.clickOnSubmitButton();
	/*Click Yes button*/
	pages.pendingActionsPage.clickOnYesButton();
	/*Click previous records in Menu drop down*/
	pages.homePage.goToPreviousRecords();
	/*Validate status of claim*/	
	pages.previousRecordsPage.validateStatusApproveTxt(empCode, expectedStatusL2Login);
	/*Logout from application*/
	pages.homePage.logout();
	/*Login to Application as Geo HR*/
	pages.loginpage.loginToApplication(loginDetails.get("GeoHR"), loginDetails.get("Password"));
	/*Click Close Button*/
	pages.homePage.closeHCLBannerPopUp();
	/*Click Pending for approval tab*/
	pages.pendingActionsPage.pendingAprovelbtn();
	/*CLick on Approve button*/


	pages.pendingActionsPage.referApproveClaim(claimid);
	/*Click Submit button*/
	pages.pendingActionsPage.clickOnSubmitButton();
	/*Click Yes button*/
	pages.pendingActionsPage.clickOnYesButton();
	/*Click previous records in Menu drop down*/
	pages.homePage.goToPreviousRecords();
	/*Validate status of claim*/
	pages.previousRecordsPage.validateStatusApproveTxt(empCode, expectedStatusGeoHrLogin);
	/*Logout from application*/
	pages.homePage.logout();
	/*Login to Application as ES-1*/
	pages.loginpage.loginToApplication(loginDetails.get("ES1"), loginDetails.get("Password"));
	/*Click Close Button*/
	pages.homePage.closeHCLBannerPopUp();
	/*Click Pending for approval tab*/
	pages.pendingActionsPage.pendingAprovelbtn();
	/*CLick on Approve button*/
	

	pages.pendingActionsPage.referApproveClaim(claimid);
	/*Click Submit button*/
	pages.pendingActionsPage.clickOnSubmitButton();
	/*Click Yes button*/
	pages.pendingActionsPage.clickOnYesButton();
	/*Click previous records in Menu drop down*/
	pages.homePage.goToPreviousRecords();
	/*Validate status of claim*/
	pages.previousRecordsPage.validateStatusApproveTxt(empCode, expectedStatusES1Login);
	/*Logout from application*/
	pages.homePage.logout();
	
	/*Login to Application as ES2*/
	pages.loginpage.loginToApplication(loginDetails.get("ES2"), loginDetails.get("Password"));
	/*Click Close Button*/
	pages.homePage.closeHCLBannerPopUp();
	/*Click Pending for approval tab*/
	pages.pendingActionsPage.pendingAprovelbtn();
	/*CLick on Approve button*/
	pages.pendingActionsPage.referApproveClaim(claimid);	
	/*Click Submit button*/
	pages.pendingActionsPage.clickOnSubmitButton();
	/*Click Yes button*/
	pages.pendingActionsPage.clickOnYesButton();
	/*Click previous records in Menu drop down*/
	pages.homePage.goToPreviousRecords();
	/*Validate status of claim*/
	pages.previousRecordsPage.validateStatusApproveTxt(empCode,expectedStatusES2Login);
	/*Logout from application*/
	pages.homePage.logout();
	/*Login to Application as Employee*/
	pages.loginpage.loginToApplication(loginDetails.get("EmpCode"), loginDetails.get("Password"));
	/*Click Close Button*/
	pages.homePage.closeHCLBannerPopUp();


}
}