package mes_actions;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility.BaseClass;
import Utility.Verify;
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
		public Object plantInformation_meslocators;
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
			
			public void EnterRoomCode(String roomcode) {
				roommaintenance_meslocators.roommaintenancetab.roomdetails.RoomCode.sendKeys(roomcode);
			}
			
			public void EnterRoomName(String roomname) {
				roommaintenance_meslocators.roommaintenancetab.roomdetails.RoomName.sendKeys(roomname);
			}
			
			public void EnterRoomArea(String roomarea) {
				roommaintenance_meslocators.roommaintenancetab.roomdetails.RoomArea.sendKeys(roomarea);
			}
			
			public void SelectUsageType(String type) throws InterruptedException {
				BaseClass.selectDropdown(roommaintenance_meslocators.roommaintenancetab.roomdetails.UsageType, type);
			}
			
			public void EnterDiscription(String Discrition) {
				roommaintenance_meslocators.roommaintenancetab.roomdetails.Description.sendKeys(Discrition);
			}
				
			public void VerifyRoomDetails() {
				try {
					BaseClass.Sleep();
				    String actual = roommaintenance_meslocators.roommaintenancetab.roomdetails.Gettext.getText();
				    Verify.verifyEquals(actual, "Please enter unique room code.");
				} catch (Exception e) {
				    Verify.verifyTrue(false, "Toast msg not appears");
				    e.printStackTrace();

				}
				
				
				}
			
			public void saveOrCancel() {

				roommaintenance_meslocators.roommaintenancetab.roomdetails.SaveButton.click();

				WebDriverWait wait = new WebDriverWait(BaseClass.driver, Duration.ofSeconds(5));

				WebElement message = wait.until(ExpectedConditions.visibilityOf(
						roommaintenance_meslocators.roommaintenancetab.roomdetails.afterClickingSave));

				if (message.isDisplayed()) {
					roommaintenance_meslocators.roommaintenancetab.roomdetails.CancelButton.click();
					System.out.println("Data already saved. Cancel button clicked.");
				}
			}
			
		}//RommDetails
		
	}// RoomMaintenanceTab

}// RoomMaintenance_MESActions
