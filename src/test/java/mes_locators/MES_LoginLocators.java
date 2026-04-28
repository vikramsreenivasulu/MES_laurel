package mes_locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.BaseClass;

public class MES_LoginLocators {

	public PM_Login pm_login;
	
	
	public MES_LoginLocators() {
		
		pm_login = new PM_Login();
	}
	
	public class PM_Login{
		
		public PM_Login() {
			PageFactory.initElements(BaseClass.driver, this);
		}
		
		@FindBy(id="loginForm:submit")
		public WebElement LoginButton;
		
	}
}
