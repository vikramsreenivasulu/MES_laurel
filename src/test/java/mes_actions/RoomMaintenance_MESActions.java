package mes_actions;

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

		public void ClickRoomMaintenanceTab() {
			roommaintenance_meslocators.roommaintenancetab.RoomMaintenance.click();
		}

	}// RoomMaintenanceTab

}// RoomMaintenance_MESActions
