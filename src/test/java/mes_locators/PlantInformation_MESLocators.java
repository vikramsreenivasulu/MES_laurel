
package mes_locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.BaseClass;

public class PlantInformation_MESLocators {

	public Menu menu;
	public PlantInformation plantinformation;

	public BlockInformation blockinformation;

	public PlantInformation_MESLocators() {

		menu = new Menu();
		plantinformation = new PlantInformation();
		blockinformation = new BlockInformation();
	}

	public class Menu {

		public Menu() {
			PageFactory.initElements(BaseClass.driver, this);
		}

		@FindBy(xpath = "(//div[@id='layout-topbar']//a)[1]")
		public WebElement menubutton;

		@FindBy(xpath = "(//span[@class = 'ui-menuitem-text'])[2]")
		public WebElement breadCrumb;

	}// Menu

	public class PlantInformation {

		public AddPlantDetails addplantdetails;

		public PlantInformation() {

			addplantdetails = new AddPlantDetails();
			PageFactory.initElements(BaseClass.driver, this);
		}

		@FindBy(xpath = "//a[normalize-space(text())='Plant Information']")
		public WebElement PlantInformationTab;

		@FindBy(xpath = "//a[normalize-space(text())='Plant Details']")
		public WebElement plantDetails;

		@FindBy(xpath = "//span[normalize-space(text())='Add Plant Info']")
		public WebElement Clickaddplantdetails;

		public class AddPlantDetails {

			public AddPlantDetails() {
				PageFactory.initElements(BaseClass.driver, this);
			}

			@FindBy(xpath = "//table/tbody/tr/td/input[@id='plantDialogForm:j_idt295']")
			public WebElement PlantName;

			@FindBy(xpath = "//table[@id='plantDialogForm:j_idt289']/tbody[1]/tr[2]/td[2]/input[1]")
			public WebElement PlantCode;

			@FindBy(xpath = "//table[@id='plantDialogForm:j_idt289']/tbody[1]/tr[3]/td[2]/input[1]")
			public WebElement PlantAddress;

			@FindBy(xpath = "//table[@id='plantDialogForm:j_idt289']/tbody[1]/tr[5]/td[2]/input[1]")
			public WebElement PlantCity;

			@FindBy(xpath = "//table[@id='plantDialogForm:j_idt289']/tbody[1]/tr[5]/td[4]/input[1]")
			public WebElement PlantState;

			@FindBy(xpath = "(//div[contains(@class,'ui-selectonemenu ui-widget')])[2]")
			public WebElement PlantCountry;

			@FindBy(xpath = "//table[@id='plantDialogForm:j_idt289']/tbody[1]/tr[6]/td[2]/input[1]")
			public WebElement PlantPinCode;

			@FindBy(xpath = "//table[@id='plantDialogForm:j_idt289']/tbody[1]/tr[6]/td[4]/input[1]")
			public WebElement PlantPhone;

			@FindBy(xpath = "//table[@id='plantDialogForm:j_idt289']/tbody[1]/tr[6]/td[6]/input[1]")
			public WebElement PlantFax;

			@FindBy(xpath = "//button[@id='plantDialogForm:savePlantBtn']//span[1]")
			public WebElement SaveButton;

			@FindBy(xpath = "//button[@name='plantDialogForm:j_idt362']//span[1]")
			public WebElement CancelButton;

			@FindBy(xpath = "//span[text()='Please enter unique plant code.']")
			public WebElement afterClickingSave;
		}// AddPlantDetails

	}// PlantInformation

	public class BlockInformation {

		public AddBlockDetails addblockdetails;

		public BlockInformation() {

			addblockdetails = new AddBlockDetails();
			PageFactory.initElements(BaseClass.driver, this);
		}

		@FindBy(xpath = "//a[normalize-space(text())='Block Details']")
		public WebElement PlantBlockTab;

		@FindBy(xpath = "(//span[@class='ui-button-text ui-c'])[1]")
		public WebElement AddBlockDetails;

		public class AddBlockDetails {

			public AddBlockDetails() {
				PageFactory.initElements(BaseClass.driver, this);
			}

			@FindBy(xpath = "(//span[@class='ui-icon ui-icon-triangle-1-s ui-c'])[1]")
			public WebElement Plantcode;

			@FindBy(xpath = "//table[@id='blockDialogForm:j_idt106']/tbody[1]/tr[1]/td[4]/input[1]")
			public WebElement BlockCode;

			@FindBy(xpath = "//table[@id='blockDialogForm:j_idt106']/tbody[1]/tr[2]/td[2]/input[1]")
			public WebElement BlockName;

			@FindBy(xpath = "//table[@id='blockDialogForm:j_idt106']/tbody[1]/tr[2]/td[4]/div[1]/div[3]/span[1]")
			public WebElement BlockStatus;

			@FindBy(xpath = "//table[@id='blockDialogForm:j_idt106']/tbody[1]/tr[3]/td[2]/span[1]/input[1]")
			public WebElement CommissioningDate;

			@FindBy(xpath = "//textarea[@id='blockDialogForm:descIpAreaBox']")
			public WebElement BlockDetailsDiscrp;

			@FindBy(xpath = "//table[@class='Fright']/tbody[1]/tr[1]/td[1]/button[1]/span[1]")
			public WebElement SaveButton;

			@FindBy(xpath = "//table[@class='Fright']/tbody[1]/tr[1]/td[1]/button[2]/span[1]")
			public WebElement CancelButton;

			@FindBy(xpath = "//div[@id='growl_container']")
			public WebElement afterClickingSave;

			@FindBy(xpath = "//input[@id='blockMainForm:blockTableId:globalFilter']")
			public WebElement BlockDetailsSearch;

			@FindBy(xpath = "//table/tbody/tr/td/div[@class='ui-radiobutton ui-widget']")
			public WebElement SelectBlockDetails;

			@FindBy(xpath = "//table[@class='panelGridB']/tbody[1]/tr[1]/td[1]/button[2]/span[1]")
			public WebElement BlockDetailsEditButton;
			
			@FindBy(xpath="//div[@aria-hidden='false']//span[@class='ui-dialog-title']")
			public WebElement VerifyEditBlockDetails;

		}// AddBlockDetails

	}// BlockInformation

}// PlantInformation_MESLocators