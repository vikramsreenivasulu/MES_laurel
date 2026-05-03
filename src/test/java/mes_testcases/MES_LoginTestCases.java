package mes_testcases;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Utility.BaseClass;
import Utility.Report;
import Utility.Verify;
import mes_actions.MES_LoginActions;

public class MES_LoginTestCases {

	public MES_LoginActions mes_loginactions;

	
	@BeforeSuite
	public void BeforeSuit() {
		BaseClass.startdriver();
		Verify.restAssertion();
		Report.startReport();
		mes_loginactions = new MES_LoginActions();
	}
	
	@Test()
	public void ATTest() throws InterruptedException {
		Report.createTest("🧪 Laurel MES TestCase");
		
		//here node is declared
		Report.Createnode("Login Page");
		Report.logInfo("Test started");
		mes_loginactions.mesloginmethods.ClickLoginButton();
		mes_loginactions.mesloginmethods.VerifyToastedMsg("UserID Required!","Password Required!");
		Report.logInfo("Verified iser name & password");
		mes_loginactions.mesloginmethods.PM("Plant Maintenance");
		Report.pass("verify Plant Maintenance");
		
		//here node is declared
		Report.Createnode("Login Issue");
		mes_loginactions.mesloginmethods.ClickLoginIssue();
		mes_loginactions.mesloginmethods.insideloginissue.UserName("Auto_VS");
		mes_loginactions.mesloginmethods.insideloginissue.FirstName("Auto");
		mes_loginactions.mesloginmethods.insideloginissue.LastName("VS");
		mes_loginactions.mesloginmethods.insideloginissue.ClickIssueType("Password Reset");
		mes_loginactions.mesloginmethods.insideloginissue.Discription("the issue is my password was expired");
		Report.logInfo("In the log in issue tab enter each and every value");
		mes_loginactions.mesloginmethods.insideloginissue.ClickResetButton();
		Report.logInfo("After reset the entered values");
		mes_loginactions.mesloginmethods.insideloginissue.ClickBacktoLogin();
		Report.logInfo("Back to log in page");
		mes_loginactions.mesloginmethods.insideloginissue.UserID("AUTO_VS_PMMGR");
		mes_loginactions.mesloginmethods.insideloginissue.UserPassword("Asdf@123");
		mes_loginactions.mesloginmethods.ClickLoginButton();
		BaseClass.Sleep();
		Report.logInfo("log in page entered Successfully");
		
		
		Report.pass("All Test Cases Pass");
		Verify.assertAll();
	}	
	
	@AfterSuite()
	public void AfterSuite() throws InterruptedException {
		BaseClass.Sleep();
		BaseClass.StopDriver();
		Report.flush();
	}
}
