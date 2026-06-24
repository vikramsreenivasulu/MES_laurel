package mes_actions;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility.BaseClass;
import Utility.Verify;
import mes_locators.PlantInformation_MESLocators;
import mes_locators.PlantInformation_MESLocators.BlockInformation.AddBlockDetails;

public class PlantInformation_MESActions {

	public PlantInformationMethods plantinformationmethods;

	public BlockInformationMethods blockinformationmethods;
	public PlantInformation_MESLocators plantInformation_meslocators = new PlantInformation_MESLocators();

	public PlantInformation_MESActions() {

		plantinformationmethods = new PlantInformationMethods();
		blockinformationmethods = new BlockInformationMethods();

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
					BaseClass.Dropdown(plantInformation_meslocators.plantinformation.addplantdetails.PlantCountry,
							Country);
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

					WebElement message = wait.until(ExpectedConditions.visibilityOf(
							plantInformation_meslocators.plantinformation.addplantdetails.afterClickingSave));

					if (message.isDisplayed()) {
						plantInformation_meslocators.plantinformation.addplantdetails.CancelButton.click();
						System.out.println("Data already saved. Cancel button clicked.");
					}
				}

			}// AddPlantdetails

		}// PlantInforamtion

	}// PlantInformationMethods

	public class BlockInformationMethods {

		public BlockInformation blockinformation;

		public BlockInformationMethods() {

			blockinformation = new BlockInformation();

		}

		public class BlockInformation {

			public AddBlockDetails addblockdetails;

			public BlockInformation() {
				addblockdetails = new AddBlockDetails();
			}

			public void ClickBlockDetails() {
				plantInformation_meslocators.blockinformation.PlantBlockTab.click();
			}

			public void ClickAddBlockDetails() {
				plantInformation_meslocators.blockinformation.AddBlockDetails.click();
			}
		}

		public class AddBlockDetails {

			public void EnterplantCode(String PlantCode) throws InterruptedException {
				BaseClass.selectDropdown(plantInformation_meslocators.blockinformation.addblockdetails.Plantcode,
						PlantCode);
			}

			public void EnterBlockDetailsDiscrp(String Discrp) {
				plantInformation_meslocators.blockinformation.addblockdetails.BlockDetailsDiscrp.sendKeys(Discrp);
			}

			public void EnterBlockCode(String blockCode) {
				plantInformation_meslocators.blockinformation.addblockdetails.BlockCode.sendKeys(blockCode);
			}

			public void EnterBlockName(String blockName) {
				plantInformation_meslocators.blockinformation.addblockdetails.BlockName.sendKeys(blockName);
			}

			public void SelectBlockStatus(String status) throws InterruptedException {
				BaseClass.selectDropdown(plantInformation_meslocators.blockinformation.addblockdetails.BlockStatus, status);
			}

			public void SelectCommissioningDate(String date) throws InterruptedException {
				plantInformation_meslocators.blockinformation.addblockdetails.CommissioningDate.sendKeys(date,Keys.ENTER);

			}

			public void saveOrCancel() {

				plantInformation_meslocators.blockinformation.addblockdetails.SaveButton.click();

				
				WebDriverWait wait = new WebDriverWait(BaseClass.driver, Duration.ofSeconds(5));

				WebElement message = wait.until(ExpectedConditions.visibilityOf(
						plantInformation_meslocators.blockinformation.addblockdetails.afterClickingSave));

				if (message.isDisplayed()) {
					plantInformation_meslocators.blockinformation.addblockdetails.CancelButton.click();
					System.out.println("Data already saved. Cancel button clicked.");
				}
				
				
//				WebDriverWait wait = new WebDriverWait(BaseClass.driver, Duration.ofSeconds(5));
//
//				String actualmessage = wait.until(ExpectedConditions.visibilityOf(
//						plantInformation_meslocators.blockinformation.addblockdetails.afterClickingSave)).getText();
//				System.out.println(actualmessage);
//				
//				String expectedmessage = actualmessage;
//				
//				if (actualmessage.equals(expectedmessage)) {
//					plantInformation_meslocators.blockinformation.addblockdetails.CancelButton.click();
//					System.out.println("Data already saved. Cancel button clicked.");
//				}
			}
			
		}//AddBlockDetails

	}// BlockInformationMethods

}// PlantInformation_MESActions
