package mes_locators;

import java.util.List;

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
		
		@FindBy(xpath="//span[@class='ui-growl-title']")
		public List<WebElement> VerifyToastedMsg;
		
		@FindBy(xpath="//div[@class='Wid100 OvHidden BigTopics Fs15']")
		public WebElement PM;
		
		@FindBy(id="loginForm:j_idt25")
		public WebElement LoginIssue;
		
		@FindBy(xpath="//input[@id='loginIssueForm:username']")
		public WebElement UserName;
		
		@FindBy(xpath="//input[@id='loginIssueForm:firstname']")
		public WebElement FirstName;
		
		@FindBy(xpath="//input[@id='loginIssueForm:lastname']")
		public WebElement LastName;
		
		@FindBy(xpath="//div[@id='loginIssueForm:issuetype']")
		public WebElement IssueType;
		
		@FindBy(xpath="//table[@id='loginIssueForm:part1']/tbody[1]/tr[5]/td[3]/textarea[1]")
		public WebElement Discription;
		
	}//PM_Login
	
	
}//MES_LoginLocators
