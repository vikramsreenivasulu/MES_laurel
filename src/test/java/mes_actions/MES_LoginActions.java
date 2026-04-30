package mes_actions;

import org.openqa.selenium.Dimension;
import org.testng.Assert;

import Utility.BaseClass;
import Utility.Verify;
import mes_locators.MES_LoginLocators;

public class MES_LoginActions {

	public MESLoginMethods mesloginmethods;
	
	
	public MES_LoginLocators mes_loginlocators = new MES_LoginLocators();
	
	public MES_LoginActions() {
		
		mesloginmethods = new MESLoginMethods();
		
	}
	
	public class MESLoginMethods{
		
		public InsideLoginIssue insideloginissue;
		public MESLoginMethods() {
			insideloginissue = new InsideLoginIssue();
		}
		
		public void ClickLoginButton() {
			mes_loginlocators.pm_login.LoginButton.click();
		}
		
		
		public void VerifyToastedMsg(String textOne,String textTwo) {
			String text1 = mes_loginlocators.pm_login.VerifyToastedMsg.get(0).getText();
			System.out.println(text1);
			
			String text2 = mes_loginlocators.pm_login.VerifyToastedMsg.get(1).getText();
			System.out.println(text2);
			
			
//			Assert.assertEquals(text1, "UserID Required!","issue comes here");		
//			Assert.assertEquals(text2, "Password Required!","issue comes here");
			
			
			Verify.verifyEquals(text1, textOne);
			Verify.verifyEquals(text2, textTwo);
			
		}//VerifyToastedMsg
		
		public void PM(String expected) {
			String actual = mes_loginlocators.pm_login.PM.getText();
			System.out.println("text:"+actual);
			
			Verify.verifyEquals(actual, expected);
		}
		
		public void ClickLoginIssue() {
			mes_loginlocators.pm_login.LoginIssue.click();
		}
		
		public class InsideLoginIssue{
			
			
			public void UserName(String UserName) {
				mes_loginlocators.pm_login.UserName.sendKeys(UserName);
			}
			
			public void FirstName(String FirstName) {
				mes_loginlocators.pm_login.FirstName.sendKeys(FirstName);
			}
			
			public void LastName(String LastName) {
				mes_loginlocators.pm_login.LastName.sendKeys(LastName);
			}
			
			public void ClickIssueType(String issuetype) throws InterruptedException {
				
//				mes_loginlocators.pm_login.IssueType.click();
				BaseClass.selectDropdown(mes_loginlocators.pm_login.IssueType, issuetype);
			}
			
			public void Discription(String Discri) {
				mes_loginlocators.pm_login.Discription.sendKeys(Discri);
			}
			
		}//InsideLoginIssue
		
		
	}//MESLoginMethods
		

		

	
}//MES_LoginActions
