package mes_testcases;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Utility.BaseClass;
import Utility.Report;
import Utility.Verify;
import mes_actions.MES_LoginActions;
import mes_actions.PlantInformation_MESActions;

public class PlantInformation_MESTestcases {

	public MES_LoginActions mes_loginactions;
	public PlantInformation_MESActions plantinformation_mesactions;

	@BeforeSuite
	public void BeforeSuit() {
		BaseClass.startdriver();
		Verify.restAssertion();
		Report.startReport();
		plantinformation_mesactions = new PlantInformation_MESActions();
		mes_loginactions = new MES_LoginActions();
	}

	@Test()
	public void Attest() throws InterruptedException {

		Report.createTest("🧪 Laurel PM");
		Report.createNode("Login Page abc");
		mes_loginactions.mesloginmethods.insideloginissue.UserID("AUTO_VS_PMMGR");
		mes_loginactions.mesloginmethods.insideloginissue.UserPassword("Asdf@123");
		mes_loginactions.mesloginmethods.ClickLoginButton();

		plantinformation_mesactions.plantinformationmethods.menu.verifyPlandDetailsBreadcrumbShown();
		Report.logInfo("Verified Bread Crumb");
		plantinformation_mesactions.plantinformationmethods.menu.ClickMenuBotton();
		plantinformation_mesactions.plantinformationmethods.plantinforamtion.ClickPlantInformation();
		plantinformation_mesactions.plantinformationmethods.plantinforamtion.ClickPlantDetails();
		plantinformation_mesactions.plantinformationmethods.plantinforamtion.ClickAddPlantDetails();

//		mes_loginactions.mesloginmethods.ClickLogOutButton();
//		mes_loginactions.mesloginmethods.verifyLoginPageisShown("http://10.106.100.177:8081/MES/PM/pmplantDetails");
//		Report.logInfo("Verified Login URL ");

	}

//	@AfterMethod()
//	public void Aftersuit(ITestResult result) {
//		BaseClass.StopDriver();
//		Report.getResult(result);
//		Report.flush();
//	}

}// PlantInformation_MESTestcases
