package mes_testcases;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Utility.BaseClass;
import mes_actions.MES_LoginActions;

public class MES_LoginTestCases {

	public MES_LoginActions mes_loginactions;

	
	@BeforeSuite
	public void BeforeSuit() {
		BaseClass.startdriver();
		
		mes_loginactions = new MES_LoginActions();
	}
	
	@Test()
	public void ATTest() {
		mes_loginactions.mesloginmethods.ClickLoginButton();
	}
	
	
	
}
