package mes_testcases;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Utility.BaseClass;
import Utility.Report;
import Utility.Verify;
import mes_actions.MES_LoginActions;
import mes_actions.RoomMaintenance_MESActions;

public class RoomMaintenance_TestCases {

	public MES_LoginActions mes_loginactions;
	public RoomMaintenance_MESActions roommaintenance_mesactions;

	@BeforeSuite
	public void beforeSuite() {
		Report.startReport();
	}

	@BeforeMethod(alwaysRun = true)
	public void BeforeSuit() {
		BaseClass.startdriver();
		Verify.restAssertion();
		roommaintenance_mesactions = new RoomMaintenance_MESActions();
		mes_loginactions = new MES_LoginActions();
	}

	@Test()
	public void ATtestRoomMaintenance() {

		Report.createTest("🧪 RoomMaintenance Details");
		Report.createNode("Login Page ");
		mes_loginactions.mesloginmethods.insideloginissue.UserID("AUTO_VS_PMMGR");
		mes_loginactions.mesloginmethods.insideloginissue.UserPassword("Asdf@123");
		mes_loginactions.mesloginmethods.ClickLoginButton();

		BaseClass.Sleep();
		roommaintenance_mesactions.menu.ClickMenuButton();
		roommaintenance_mesactions.roommaintenancetab.ClickRoomMaintenanceTab();
		roommaintenance_mesactions.roommaintenancetab.roomdetails.ClickRoomDetails();

	}

	@AfterMethod(alwaysRun = true)
	public void AfterMethod(ITestResult result) {

		Report.getResult(result);
		 //BaseClass.StopDriver();
	}

	@AfterSuite
	public void afterSuite() {
		Report.flush();
	}

}// RoomMaintenance_TestCases
