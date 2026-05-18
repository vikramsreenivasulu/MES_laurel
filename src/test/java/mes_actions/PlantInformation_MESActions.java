package mes_actions;

import Utility.Verify;
import mes_locators.PlantInformation_MESLocators;

public class PlantInformation_MESActions {

	public PlantInformationMethods plantinformationmethods;

	public PlantInformation_MESLocators plantInformation_meslocators = new PlantInformation_MESLocators();

	public PlantInformation_MESActions() {

		plantinformationmethods = new PlantInformationMethods();
	}

	public class PlantInformationMethods {

		public Menu menu;
		public PlantInforamtion plantinforamtion;

		public PlantInformationMethods() {
			menu = new Menu();
			plantinforamtion = new PlantInforamtion();
		}

		public class Menu {

			public void ClickMenuBotton() {
				plantInformation_meslocators.menu.menubutton.click();
			}

			public void verifyPlandDetailsBreadcrumbShown() {
				String locatorText = plantInformation_meslocators.menu.breadCrumb.getText().trim();
				Verify.verifyEquals(locatorText, "Plant Details");
			}
		}// Menu

		public class PlantInforamtion {

			public void ClickPlantInformation() {
				plantInformation_meslocators.plantinformation.PlantInformationTab.click();
			}

			public void ClickPlantDetails() {
				plantInformation_meslocators.plantinformation.plantDetails.click();
			}

			public void ClickAddPlantDetails() {
				plantInformation_meslocators.plantinformation.AddplantDetails.click();
			}

		}// PlantInforamtion

	}// PlantInformation

}// PlantInformation_MESActions
