package HR;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	WebDriver driver;
	public void start() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\vinay\\OneDrive\\Desktop\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();	
	}
	
	
}
