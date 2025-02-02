package stepDefinition;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Page_PF.Registration_form;
//import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class dropDown_registration {

	WebDriver driver = null;
	Registration_form registration;
	
	@Before
	public void browser_Steup() {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdrive.chrome.driver", projectPath+"/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver ();
	}
	
//	@After
//	public void tear_Down() {
//		driver.quit();
//	}
	
	@Given("user is on registration page")
	public void user_is_on_registration_page() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.get("https://etraders.lk/customerregistration");
		driver.manage().window().maximize();
	}

	@When("^user is select (.*) and (.*) and (.*)$")
	public void user_is_select_mrs_and_colombo_and_kaduwela(String t, String distric, String city) throws InterruptedException {
		
		registration = new Registration_form(driver);
		registration.select_title(t);
		registration.select_distric(distric);
		registration.select_city(city);
		Thread.sleep(4000);
	}

	@Then("The values are selected correctly")
	public void the_values_are_selected_correctly() {
	}
}
