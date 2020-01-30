package HR;

import java.awt.event.ActionEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		
		
		hidden("ORG123",driver.findElement(By.xpath("//input[@name=\"organization[name]\"]")));

		hidden("taxID123",driver.findElement(By.xpath("//input[@name = \"organization[taxId]\"]")));
		hidden("reg123",driver.findElement(By.id("organization_registraionNumber")));
		hidden("12345",driver.findElement(By.id("organization_phone")));
		hidden("000123",driver.findElement(By.id("organization_fax")));
		hidden("employee@gmail.com",driver.findElement(By.id("organization_email")));
		
		
	}
	public void hidden(String txt, WebElement wb) {
		
		String s = "arguments[0].setAttribute('value','"+txt+"')";
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		
		js2.executeScript(s, wb);
	}
	
	public void leaveperiod() {
		
		Actions action = new Actions(driver);
		WebElement main_menu = driver.findElement(By.id("leave"));
		action.moveToElement(main_menu);
		action.click().build().perform();
		
		driver.switchTo().frame("rightMenu");
		driver.findElement(By.id("leaveperiod_cmbStartMonth")).click();
		dropbox(By.id("leaveperiod_cmbStartMonth"), "March");
		dropbox(By.id("leaveperiod_cmbStartDate"), "4");
		driver.findElement(By.className("savebutton")).click();
	}
	
	public void admin_location() {

		
		//mousehoover(driver.findElement(By.id("admin")), driver.findElement(By.xpath("//*[@onclick=\"menuclicked(this);\"]")), driver.findElement(By.xpath("//*[@href=\"./symfony/web/index.php/admin/viewLocations\"]")));
		mousehoover("Admin","Organization", "Locations");
		
		driver.switchTo().frame("rightMenu");
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchLocation_name")));
		hidden("location1",driver.findElement(By.id("searchLocation_name")));
		hidden("city1",driver.findElement(By.id("searchLocation_city")));
		dropbox(By.id("searchLocation_country"), "India");
		//driver.findElement(By.id("searchLocation_name")).sendKeys("location1");
	}
	
	public void PIM_Customfield() {
		
		
		//mousehoover(driver.findElement(By.id("pim")), driver.findElement(By.xpath("//li[@class=\"l2\"]//a[@class=\"l2_link parent configure\"]//span")), driver.findElement(By.xpath("//li[@class=\"l3\"]//a[@href=\"./symfony/web/index.php/pim/listCustomFields\"]//span")));
		driver.switchTo().frame("rightMenu");
			
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buttonAdd")));
		driver.findElement(By.id("buttonAdd")).click();
		
		hidden("field1234",driver.findElement(By.xpath("//*[@name=\"customField[name]\"]")));
		
		dropbox(By.id("customField_screen"), "Salary");
		dropbox(By.id("customField_type"),"Text or Number");
		
		//driver.findElement(By.id("btnSave")).click();
		
	}
	
	public void mousehoover(String main_menu,String mid_menu,String sub_menu) {
		
		Actions action = new Actions(driver);
		
		WebElement m1 = searchList(By.xpath("//*[@class=\"l1\"]"), main_menu);
		action.moveToElement(m1).build().perform();
		
		WebElement m2 = searchList(By.xpath("li[@class=\"l2\"]"), mid_menu);
		action.moveToElement(m2).perform();
		
		WebElement m3 = searchList(By.xpath("//*[@id=\""+main_menu+"\"]//li[@class = \"l2\"]//li[@class = \"l3\"]"), sub_menu);
		m3.click();
		//action.moveToElement(mid_menu).perform();
		
		//sub_menu.click();
	}
	
	public WebElement searchList(By path, String txt) {
		System.out.println(txt);
		List<WebElement> mm = driver.findElements(path);
		for(WebElement menu:mm) {
			System.out.println(menu.getText());
			if(menu.getText().contains(txt)) {
				
				//WebElement m1 = driver.findElement(By.xpath(path+"[@id=\"+txt+"\"]"));
				//action.moveToElement(m1).perform();
				return menu;
			}
			
	}
		return null;
}
	}
