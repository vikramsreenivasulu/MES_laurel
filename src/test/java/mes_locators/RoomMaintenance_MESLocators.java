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
			
			@FindBy(xpath="(//span[@class='ui-icon ui-icon-triangle-1-s ui-c'])[1]")
			public WebElement BlockCode;
			
//			@FindBy()
//			public WebElement aaa;
			
		}//RoomDetails
		
	}// RoomMaintenanceTab

}// RoomMaintenance_MESLocators
