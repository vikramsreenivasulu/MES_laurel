package mes_actions;

import Utility.BaseClass;
import mes_locators.RoomMaintenance_MESLocators;

public class RoomMaintenance_MESActions {

	public Menu menu;
	public RoomMaintenanceTab roommaintenancetab;

	RoomMaintenance_MESLocators roommaintenance_meslocators = new RoomMaintenance_MESLocators();

	public RoomMaintenance_MESActions() {
		menu = new Menu();
		roommaintenancetab = new RoomMaintenanceTab();
	}

	public class Menu {

		public void ClickMenuButton() {
			roommaintenance_meslocators.menu.MenuButton.click();
		}

	}// Menu

	public class RoomMaintenanceTab {

		public RoomDetails roomdetails;
		public RoomMaintenanceTab() {
			roomdetails= new RoomDetails();
		}
		public void ClickRoomMaintenanceTab() {
			roommaintenance_meslocators.roommaintenancetab.RoomMaintenance.click();
		}

		public class RoomDetails{
			
			public void ClickRoomDetails() {
				roommaintenance_meslocators.roommaintenancetab.roomdetails.RoomDetailsTab.click();
			}
			
			public void AddRommDetails() {
				roommaintenance_meslocators.roommaintenancetab.roomdetails.AddRoomDetails.click();
			}
			
			public void SelectBlockCode(String BlockCode) throws InterruptedException {
				BaseClass.selectDropdown(roommaintenance_meslocators.roommaintenancetab.roomdetails.BlockCode, BlockCode);
				
				//roommaintenance_meslocators.roommaintenancetab.roomdetails.BlockCode.click();
				
			}
			
		}//RommDetails
		
	}// RoomMaintenanceTab

}// RoomMaintenance_MESActions
