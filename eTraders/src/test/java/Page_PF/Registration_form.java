package Page_PF;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Registration_form {

	WebDriver driver;

	@FindBy(id = "cutitel")
	WebElement txt_title;

	@FindBy(id = "distric")
	WebElement dropdown_distric;

	@FindBy(id = "city")
	WebElement dropdown_city;


	public Registration_form(WebDriver driver){

		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,30);
		PageFactory.initElements(factory, this);
	}

	public void select_title(String title) {

		Select Title = new Select(txt_title);
		Title.selectByValue(title);
	}

	public void select_distric(String distric) {

		Select Distric = new Select(dropdown_distric);
		Distric.selectByIndex(4);
	}
	public void select_city(String city) {

		try {
		Select City = new Select(dropdown_city);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Adjust timeout as needed
        wait.until(ExpectedConditions.visibilityOfAllElements(City.getOptions()));
        
		List<WebElement> options = City.getOptions();
        System.out.println("Dropdown Options: " + options);
		City.selectByValue(city);
		System.out.println("Selected city: " + city);
		}
		catch(NoSuchElementException e){
			 System.err.println("Option with value " + city + " not found in dropdown");
	            e.printStackTrace();
		}
	}
	}
