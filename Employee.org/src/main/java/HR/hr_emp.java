package HR;
import java.text.Normalizer.Form;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import HR.Helper;
public class hr_emp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Helper d = new Helper();
		d.start();
		//d.driver.get("https://accounts.lambdatest.com/login");
		d.driver.get("https://s2.demo.opensourcecms.com/orangehrm/symfony/web/index.php/auth/login");
		d.driver.manage().window().maximize();
		d.login();
		
		//d.driver.findElement(By.xpath("//input[@name=\"email\"]//parent::div[1]/")).sendKeys("email@gmail.com");
		
		
		
		//d.employeeInfo();
		
		//d.Admin_GeneralInfo();
		//d.leaveperiod();
		d.admin_location();
		//d.PIM_Customfield();
	}

}
