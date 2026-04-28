package mes_actions;

import mes_locators.MES_LoginLocators;

public class MES_LoginActions {

	public MESLoginMethods mesloginmethods;
	
	public MES_LoginLocators mes_loginlocators = new MES_LoginLocators();
	
	public MES_LoginActions() {
		
		mesloginmethods = new MESLoginMethods();
	}
	
	public class MESLoginMethods{
		
		public void ClickLoginButton() {
			mes_loginlocators.pm_login.LoginButton.click();
		}
		
		
		
		
		
		
	}//MESLoginMethods
	
	
	
	
	
}//MES_LoginActions
