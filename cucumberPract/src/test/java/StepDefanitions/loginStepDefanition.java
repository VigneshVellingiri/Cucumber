package StepDefanitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginStepDefanition {
	static WebDriver driver;
	
	
	@Given("User in login page")
	public void user_in_login_page() {
	    // Write code here that turns the phrase above into concrete actions
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/v1/");
	}

	@When("User enter valid User name and password")
	public void user_enter_valid_user_name_and_password() {
	    
		WebElement User_name = driver.findElement(By.xpath("//input[@id='user-name']"));
		User_name.sendKeys("standard_user");
		WebElement Password = driver.findElement(By.xpath("//input[@id='password']"));
		Password.sendKeys("secret_sauce");
		}

	@And("Click Login Button")
	public void click_login_button() {
	    WebElement Login = driver.findElement(By.xpath("//input[@id='login-button']"));
	    Login.click();		
	}

	@Then("User is navigated to Home page")
	public void user_is_navigated_to_home_page() {
	   Assert.assertTrue(driver.findElements(By.xpath("//div[@class='app_logo']")).size()>0,"User is navigated to Home page");
	}

	@And("close browser")
	public void close_browser() {
	   driver.quit();
	}
	
	
	@Given("User in Login Page")
	public void User_in_Login_Page() {
		
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/v1/");
	}
	
	@When("User Enter valid User Name and Invalid Password")
	public void Loggin_invalid_credantial() {
		WebElement User_name = driver.findElement(By.xpath("//input[@id='user-name']"));
		User_name.sendKeys("standard_user");
		WebElement Password = driver.findElement(By.xpath("//input[@id='password']"));
		Password.sendKeys("invalid");
		}
	@And("Click loggin button")
	public void Click_login () {
		WebElement Login = driver.findElement(By.xpath("//input[@id='login-button']"));
	    Login.click();
	}
	@Then("User get error message")
	public void errorMessage() {
		String expected = "Username and password do not match any user in this service";
		String Actual = driver.findElement(By.xpath("//button[@class='error-button']")).getText();
		
		Assert.assertEquals(expected, Actual);
	
	}
		
}




















