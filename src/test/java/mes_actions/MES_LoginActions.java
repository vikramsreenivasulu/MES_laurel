package mes_actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		
		public void ClickLogOutButton() throws InterruptedException {
			mes_loginlocators.pm_login.LogoutButton.click();
			
		}
			
//			public void ClickLogOutButton() {
//
//			    WebDriverWait wait = new WebDriverWait(BaseClass.driver, Duration.ofSeconds(20));
//
//			    // Wait until overlay disappears
//			    wait.until(ExpectedConditions.invisibilityOf(mes_loginlocators.pm_login.LogoutButton));
//
//			    WebElement logout = wait.until(
//			            ExpectedConditions.elementToBeClickable(
//			                    By.xpath("(//a[@class='menulink Animated05'])[3]")));
//
//			    logout.click();
//			}
		
		
		public void verifyLoginPageisShown(String expectedUrl) {
			
			//String expectedUrl = "http://10.106.100.177:8081/MES/PM/login#";
			String actualUrl = BaseClass.driver.getCurrentUrl();
		
			Verify.verifyEquals(actualUrl, expectedUrl);
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
			
			public void ClickResetButton() {
				mes_loginlocators.pm_login.ResetButton.click();
			}
			
			public void ClickBacktoLogin() {
				mes_loginlocators.pm_login.BacktoLoginButton.click();
			}
			
			public void UserID(String userid) {
				mes_loginlocators.pm_login.UserID.sendKeys(userid);
			}
			
			
			public void UserPassword(String userpassword ) {
				mes_loginlocators.pm_login.UserPassword.sendKeys(userpassword);
			}

		

			
			
			
		}//InsideLoginIssue
		
		
	}//MESLoginMethods
		

		

	
}//MES_LoginActions
