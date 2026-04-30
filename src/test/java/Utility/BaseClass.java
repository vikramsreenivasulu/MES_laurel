package Utility;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


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
	
	public  static void  Sleep() throws InterruptedException {
		Thread.sleep(3000);
	}
	
}
