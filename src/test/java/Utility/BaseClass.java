package Utility;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;


public class BaseClass {

	public static String url = "http://10.106.100.177:8081/MES/PM/login.jsf#";
	public static WebDriver driver;
	
	
	public static void startdriver() {
		
		driver = new ChromeDriver(getChromeOptions()); 
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		
	}

	public static ChromeOptions getChromeOptions(){
		
		//chrome browser automated by pop
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);
        
        //dress pop
    	options.addArguments("--disable-autofill");
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--disable-notifications");
		options.addArguments("--ignore-ssl-errors=yes");
		options.addArguments("--ignore-certificate-errors");
		options.addArguments("disable-infobars");
		options.addArguments("--disable-translate");
        
        //
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);
        return options; 
    }
	
	public static void selectDate(String date) {

	    String[] dateParts = date.split("/");

	    String day = dateParts[0];
	    String month = dateParts[1];
	    String year = dateParts[2];

	    // Year select
	    new Select(driver.findElement(By.className("ui-datepicker-year")))
	            .selectByVisibleText(year);

	    // Month select (June = 5 because index starts from 0)
	    new Select(driver.findElement(By.className("ui-datepicker-month")))
	            .selectByValue(String.valueOf(Integer.parseInt(month) - 1));

	    // Day select
	    driver.findElement(By.xpath("//td[@data-handler='selectDay']/a[text()='" + day + "']")).click();
	}

	public static void Dropdown(WebElement dropdown, String value) throws InterruptedException {
	    dropdown.click();
	    Thread.sleep(1000);
	    WebElement element = driver.findElement(By.xpath("(//li[@data-label='" + value + "'])[2]"));   //(//li[@data-label='India'])[2]
	    element.click();
	}
	
	
	public static void selectDropdown(WebElement dropdown, String value) throws InterruptedException {
	    dropdown.click();
	    Thread.sleep(1000);
	    
	    WebElement element = driver.findElement(By.xpath("//ul/li[normalize-space()='" + value + "']"));
	    element.click();
	    Thread.sleep(1000);
	}
	
	
	public static  void StopDriver() {
		
		driver.quit();
	}
	
	public  static void  Sleep(){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void Popupclick() {
		List<WebElement> popup = driver.findElements(By.xpath("//button[text()='Yes']"));

		if (popup.size() > 0) {

		    popup.get(0).click();
		    System.out.println("Popup handled");

		} else {

		    System.out.println("Popup not present");
		}
	}//Popupclick
	

	
	
	
}
