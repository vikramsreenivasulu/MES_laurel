package mes_testcases;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Utility.BaseClass;
import Utility.Verify;
import mes_actions.MES_LoginActions;

public class MES_LoginTestCases {

	public MES_LoginActions mes_loginactions;

	
	@BeforeSuite
	public void BeforeSuit() {
		BaseClass.startdriver();
		Verify.restAssertion();
		mes_loginactions = new MES_LoginActions();
	}
	
	@Test()
	public void ATTest() throws InterruptedException {
		mes_loginactions.mesloginmethods.ClickLoginButton();
		mes_loginactions.mesloginmethods.VerifyToastedMsg("UserID Required!","Password Required!");
		mes_loginactions.mesloginmethods.PM("Plant Maintenance");
		mes_loginactions.mesloginmethods.ClickLoginIssue();
		mes_loginactions.mesloginmethods.insideloginissue.UserName("Auto_VS");
		mes_loginactions.mesloginmethods.insideloginissue.FirstName("Auto");
		mes_loginactions.mesloginmethods.insideloginissue.LastName("VS");
		mes_loginactions.mesloginmethods.insideloginissue.ClickIssueType("Password Reset");
		mes_loginactions.mesloginmethods.insideloginissue.Discription("the issue is my password was expired");
		
		
		
		
		Verify.assertAll();
	}	
}
