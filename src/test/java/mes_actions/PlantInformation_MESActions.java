package mes_actions;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility.BaseClass;
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

			public AddPlantdetails addplantdetails;

			public PlantInforamtion() {
				addplantdetails = new AddPlantdetails();
			}

			public void ClickPlantInformation() {
				plantInformation_meslocators.plantinformation.PlantInformationTab.click();
			}

			public void ClickPlantDetails() {
				plantInformation_meslocators.plantinformation.plantDetails.click();
			}

			public void ClickAddPlantDetails() {
				plantInformation_meslocators.plantinformation.Clickaddplantdetails.click();
			}

			public class AddPlantdetails {

				public void PlantName(String plantname) {
					WebDriverWait wait = new WebDriverWait(BaseClass.driver, Duration.ofSeconds(20));

					WebElement plantName = wait.until(ExpectedConditions.elementToBeClickable(
							plantInformation_meslocators.plantinformation.addplantdetails.PlantName));

					plantName.sendKeys(plantname);

				}
				
				public void PlantCode(String plantcode) {
					WebDriverWait wait = new WebDriverWait(BaseClass.driver, Duration.ofSeconds(20));

					WebElement plantName = wait.until(ExpectedConditions.elementToBeClickable(
							plantInformation_meslocators.plantinformation.addplantdetails.PlantCode));

					plantName.sendKeys(plantcode);
				}
				
				public void PlantAddress(String PlantAddress) {
					WebDriverWait wait = new WebDriverWait(BaseClass.driver, Duration.ofSeconds(20));

					WebElement plantName = wait.until(ExpectedConditions.elementToBeClickable(
							plantInformation_meslocators.plantinformation.addplantdetails.PlantAddress));

					plantName.sendKeys(PlantAddress);
				}
				
				public void PlantCity(String PlantCity) {
					WebDriverWait wait = new WebDriverWait(BaseClass.driver, Duration.ofSeconds(20));

					WebElement plantName = wait.until(ExpectedConditions.elementToBeClickable(
							plantInformation_meslocators.plantinformation.addplantdetails.PlantCity));

					plantName.sendKeys(PlantCity);
				}
				
				public void PlantState(String PlantState) {
					WebDriverWait wait = new WebDriverWait(BaseClass.driver, Duration.ofSeconds(20));

					WebElement plantName = wait.until(ExpectedConditions.elementToBeClickable(
							plantInformation_meslocators.plantinformation.addplantdetails.PlantState));

					plantName.sendKeys(PlantState);
				}
				
				public void PlantCountry(String Country) throws InterruptedException {
					BaseClass.Dropdown(plantInformation_meslocators.plantinformation.addplantdetails.PlantCountry, Country);
				}
				public void PlantPinCode(String PlantPinCode) {
					WebDriverWait wait = new WebDriverWait(BaseClass.driver, Duration.ofSeconds(20));

					WebElement plantName = wait.until(ExpectedConditions.elementToBeClickable(
							plantInformation_meslocators.plantinformation.addplantdetails.PlantPinCode));

					plantName.sendKeys(PlantPinCode);
				}
				
				public void PlantPhone(String PlantPhone) {
					WebDriverWait wait = new WebDriverWait(BaseClass.driver, Duration.ofSeconds(20));

					WebElement plantName = wait.until(ExpectedConditions.elementToBeClickable(
							plantInformation_meslocators.plantinformation.addplantdetails.PlantPhone));

					plantName.sendKeys(PlantPhone);
				}
				
				public void PlantFax(String PlantFax) {
					WebDriverWait wait = new WebDriverWait(BaseClass.driver, Duration.ofSeconds(20));

					WebElement plantName = wait.until(ExpectedConditions.elementToBeClickable(
							plantInformation_meslocators.plantinformation.addplantdetails.PlantFax));

					plantName.sendKeys(PlantFax);
				}
				
				public void saveOrCancel() {
				    
					plantInformation_meslocators.plantinformation.addplantdetails.SaveButton.click();

					
					WebDriverWait wait = new WebDriverWait(BaseClass.driver, Duration.ofSeconds(5));

					WebElement message = wait.until(
					        ExpectedConditions.visibilityOf(
					                plantInformation_meslocators.plantinformation.addplantdetails.afterClickingSave));

					
					if (message.isDisplayed()) {
						plantInformation_meslocators.plantinformation.addplantdetails.CancelButton.click();
					    System.out.println("Data already saved. Cancel button clicked.");
					}
				}
				
			}// AddPlantdetails

		}// PlantInforamtion

	}// PlantInformationMethods

}// PlantInformation_MESActions
