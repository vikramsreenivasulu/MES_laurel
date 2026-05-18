package mes_locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.BaseClass;

public class PlantInformation_MESLocators {

	public Menu menu;
	public PlantInformation plantinformation;

	public PlantInformation_MESLocators() {

		menu = new Menu();
		plantinformation = new PlantInformation();
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

		public PlantInformation() {
			PageFactory.initElements(BaseClass.driver, this);
		}

		@FindBy(xpath = "//a[normalize-space(text())='Plant Information']")
		public WebElement PlantInformationTab;

		@FindBy(xpath = "//a[normalize-space(text())='Plant Details']")
		public WebElement plantDetails;

		@FindBy(xpath = "//span[normalize-space(text())='Add Plant Info']")
		public WebElement AddplantDetails;

	}

}// PlantInformation_MESLocators