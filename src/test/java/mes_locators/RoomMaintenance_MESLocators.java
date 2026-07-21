package mes_locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.BaseClass;

public class RoomMaintenance_MESLocators {

	public Menu menu;
	public RoomMaintenanceTab roommaintenancetab;

	public RoomMaintenance_MESLocators() {
		menu = new Menu();
		roommaintenancetab = new RoomMaintenanceTab();
	}

	public class Menu {

		public Menu() {
			PageFactory.initElements(BaseClass.driver, this);
		}

		@FindBy(xpath = "(//div[@id='layout-topbar']//a)[1]")
		public WebElement MenuButton;

	}// Menu

	public class RoomMaintenanceTab {

		public RoomDetails roomdetails;
		public RoomMaintenanceTab() {
			roomdetails = new RoomDetails();
			PageFactory.initElements(BaseClass.driver, this);
		}

		@FindBy(xpath = "//a[normalize-space(text())='Room Maintenance']")
		public WebElement RoomMaintenance;

		public class RoomDetails{
			
		
			public RoomDetails() {
				
				PageFactory.initElements(BaseClass.driver, this);
			}
			
			@FindBy(xpath="//a[normalize-space(text())='Room Details']")
			public WebElement RoomDetailsTab;
			
			@FindBy(xpath="(//table[@class='panelGridB']//span[@class=\"ui-button-text ui-c\"])[1]")
			public WebElement AddRoomDetails;
			
			@FindBy(id="roomDialogForm:j_idt112_label")
			public WebElement BlockCode;
			
			@FindBy(id="roomDialogForm:j_idt121")
			public WebElement RoomCode;
			
			@FindBy(id="roomDialogForm:j_idt129")
			public WebElement RoomName;
			
			@FindBy(id="roomDialogForm:roomArea_input")
			public WebElement RoomArea;
			
			@FindBy(id="roomDialogForm:usageTyp_label")
			public WebElement UsageType;
			
			@FindBy(id="roomDialogForm:j_idt162")
			public WebElement Description;
			
			@FindBy(id="roomDialogForm:saveroomDetailsBtn")
			public WebElement SaveButton;
			
			@FindBy(id="roomDialogForm:j_idt165")
			public WebElement CancelButton;
			
			@FindBy(xpath = "//span[text()='Please enter unique room code.']") 
			public WebElement afterClickingSave;
			
			@FindBy(xpath="//span[@class='ui-growl-title']")
			public WebElement Gettext;
			
		}//RoomDetails
		
	}// RoomMaintenanceTab

}// RoomMaintenance_MESLocators
