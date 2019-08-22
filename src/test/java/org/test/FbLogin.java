package org.test;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import junit.framework.Assert;

public class FbLogin {

	static WebDriver driver;

	@Given("user should be in FB login page")
	public void user_should_be_in_FB_login_page() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sundar\\eclipse-workspace\\sundar\\Telecom\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
	}

	@When("user enter the username")
	public void user_enter_the_username() {
		driver.findElement(By.id("email")).sendKeys("sundar");
	}

	@When("user enter the password")
	public void user_enter_the_password() {
		driver.findElement(By.id("pass")).sendKeys("@123");
	}

	@When("user select login button")
	public void user_select_login_button() {
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
	}

	@Then("user should get an error message")
	public void user_should_get_an_error_message() {
		Assert.assertTrue("Error Message",
				driver.findElement(By.xpath("//a[text()='Forgotten password?']")).isDisplayed());
	}

	@Then("user should be directed to FB login page")
	public void user_should_be_directed_to_FB_login_page() {
		driver.findElement(By.xpath("//i[@class='fb_logo img sp_FiyLgvsJymR sx_f2b656']")).click();
	}

	@When("user enter valid username")
	public void user_enter_valid_username(DataTable loginData) {
		List<String> data = loginData.asList(String.class);
		driver.findElement(By.id("email")).sendKeys(data.get(0));
	}

	@When("user enter invalid password")
	public void user_enter_valid_password(DataTable loginData) {
		List<String> data = loginData.asList(String.class);
		driver.findElement(By.id("pass")).sendKeys(data.get(0));
	}

	@When("user enter an valid username")
	public void user_enter_an_valid_username(DataTable td) {
		Map<String, String> d = td.asMap(String.class, String.class);
		driver.findElement(By.id("email")).sendKeys(d.get("uname"));
	}

	@When("user enter an invalid password")
	public void user_enter_an_valid_password(DataTable td) {
		Map<String, String> d = td.asMap(String.class, String.class);
		driver.findElement(By.id("pass")).sendKeys(d.get("pass"));
	}

	@When("user enter an invalid username and password <{string}>,<{string}>")
	public void user_enter_an_invalid_username_and_password(String userName, String pass) {
		driver.findElement(By.id("email")).sendKeys(userName);
		driver.findElement(By.id("pass")).sendKeys(pass);
	}
}
