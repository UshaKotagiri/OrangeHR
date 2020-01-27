package HR;

import java.awt.event.ActionEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Helper extends Base{

	public void login() {
		driver.findElement(By.id("txtUsername")).sendKeys("opensourcecms");
		driver.findElement(By.id("txtPassword")).sendKeys("opensourcecms");
		driver.findElement(By.id("btnLogin")).click();
	}
	
	public void employeeInfo() {
		
		driver.switchTo().frame("rightMenu");
		driver.findElement(By.name("empsearch[employee_name][empName]")).sendKeys("Emp1");
		driver.findElement(By.id("empsearch_id")).sendKeys("123");
		
		dropbox(By.id("empsearch_employee_status"),"All");
		
		dropbox(By.id("empsearch_termination"), "Past Employees Only");
		
		driver.findElement(By.id("empsearch_supervisor_name")).sendKeys("Sup1");
		
		dropbox(By.id("empsearch_job_title"), "All");
		
		dropbox(By.id("empsearch_sub_unit"),"All");
		
		driver.findElement(By.id("searchBtn")).click();
		
	}
	
	public void dropbox(By path,String txt) {
		driver.findElement(path).click();
		Select drplist = new Select(driver.findElement(path));
		drplist.selectByVisibleText(txt);
		
	}
	
	public void Admin_GeneralInfo(){
		
		driver.findElement(By.id("admin")).click();
		driver.switchTo().frame("rightMenu");
		driver.findElement(By.xpath("//input[@name=\"organization[name]\"]")).sendKeys("Org1");
		
		//driver.findElement(By.xpath("//form/div[@class=\"leftDiv\"]/input[@id=\"organization_name\"]")).sendKeys("Org1");
		/*WebElement formele = driver.findElement(By.id("frmGenInfo"));
		formele.findElement(By.id("organization_name")).sendKeys("Org1");*/
		
		driver.findElement(By.id("organization_taxId")).sendKeys("TaxId123");
		driver.findElement(By.id("organization_phone")).sendKeys("12345678");
		driver.findElement(By.id("organization_fax")).sendKeys("000123");
		driver.findElement(By.id("organization_email")).sendKeys("email@gmail.com");
		
	}
	
	public void leaveperiod() {
		//driver.findElement(By.id("leave")).click();
		Actions action = new Actions(driver);
		//action.moveToElement(driver.findElement(By.id("leave"))).moveToElement(driver.findElement(By.className("leaveperiod"))).click().build().perform();
		WebElement main_menu = driver.findElement(By.id("leave"));
		action.moveToElement(main_menu);
		
		/*WebElement mid_menu = driver.findElement(By.xpath("//*[@class=\"l2_link parent leavesummary\"]"));
		action.moveToElement(mid_menu);
		
		WebElement sub_menu = driver.findElement(By.className("leaveperiod"));
		action.moveToElement(sub_menu);*/
		action.click().build().perform();
		
		driver.switchTo().frame("rightMenu");
		driver.findElement(By.id("leaveperiod_cmbStartMonth")).click();
		dropbox(By.id("leaveperiod_cmbStartMonth"), "March");
		dropbox(By.id("leaveperiod_cmbStartDate"), "4");
		driver.findElement(By.className("savebutton")).click();
	}
	
	public void admin_location() {
		Actions action = new Actions(driver);
		WebElement main_menu = driver.findElement(By.id("admin"));
		action.moveToElement(main_menu).perform();
		
		WebElement mid_menu = driver.findElement(By.xpath("//*[@onclick=\"menuclicked(this);\"]"));
		action.moveToElement(mid_menu).perform();
		
		WebElement sub_menu = driver.findElement(By.xpath("//*[@href=\"./symfony/web/index.php/admin/viewLocations\"]"));
		//action.moveToElement(sub_menu);
		
		sub_menu.click();
		
		
		//action.clickAndHold();
		System.out.println("After click");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.switchTo().frame("rightMenu");
		
		driver.findElement(By.id("searchLocation_name")).sendKeys("location1");
	}
	
	public void PIM_Customfield() {
		Actions action = new Actions(driver);
		WebElement main_menu = driver.findElement(By.id("pim"));
		action.moveToElement(main_menu).perform();
		
		WebElement mid_menu = driver.findElement(By.xpath("//li[@class=\"l2\"]//a[@class=\"l2_link parent configure\"]//span"));
		action.moveToElement(mid_menu).perform();
		
		WebElement sub_menu = driver.findElement(By.xpath("//li[@class=\"l3\"]//a[@href=\"./symfony/web/index.php/pim/listCustomFields\"]//span"));
		//action.moveToElement(sub_menu);
		
		sub_menu.click();
		//driver.switchTo().frame("rightMenu");
		//driver.findElement(By.xpath("//form[@name=\"frmCustomField\"]//input[@id=\"customField_name\"]")).sendKeys("field12");
		
		//driver.findElement(By.id("customField_name")).sendKeys("Field12");
		dropbox(By.id("customField_screen"), "Salary");
		
	}
}
