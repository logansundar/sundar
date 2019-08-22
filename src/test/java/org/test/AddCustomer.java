package org.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddCustomer {

	static WebDriver driver;

	@Given("the user should be in telecom homepage")
	public void the_user_should_be_in_telecom_homepage() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sundar\\eclipse-workspace\\sundar\\Cucumber\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/telecom/");
	}

	@Given("then user click on add customer button")
	public void then_user_click_on_add_customer_button() {
		driver.findElement(By.xpath("(//a[text()='Add Customer'])[1]")).click();
	}

	@When("user enter all details")
	public void user_enter_all_details() {
		driver.findElement(By.xpath("//label[text()='Done']")).click();
		driver.findElement(By.id("fname")).sendKeys("sundar");
		driver.findElement(By.id("lname")).sendKeys("vel");
		driver.findElement(By.name("emailid")).sendKeys("logansundar@gmail.com");
		driver.findElement(By.id("message")).sendKeys("chennai");
		driver.findElement(By.id("telephoneno")).sendKeys("7401074919");

	}

	@When("user click on submit button")
	public void user_click_on_submit_button() {
		driver.findElement(By.name("submit")).click();

	}

	@Then("user should be able to view the customer id")
	public void user_should_be_able_to_view_the_customer_id() {
		String id = driver.findElement(By.xpath("(//td[@align='center'])[2]")).getText();
		System.out.println(id);
	}

}
