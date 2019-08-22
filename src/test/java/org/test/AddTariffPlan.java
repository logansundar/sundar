package org.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class AddTariffPlan {
	static WebDriver driver;
	
	@Given("the user should be in the telecom homepage")
	public void the_user_should_be_in_the_telecom_homepage() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sundar\\eclipse-workspace\\sundar\\Cucumber\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/telecom/");		
	}

	@Given("then user click on add tariff plan button")
	public void then_user_click_on_add_tariff_plan_button() {
		driver.findElement(By.xpath("//a[text()='Add Tariff Plan']")).click();
	}

	@When("user enter all the details")
	public void user_enter_all_the_details() {
		driver.findElement(By.id("rental1")).sendKeys("599");
		driver.findElement(By.id("local_minutes")).sendKeys("1000");
		driver.findElement(By.id("inter_minutes")).sendKeys("500");
		driver.findElement(By.id("sms_pack")).sendKeys("100");
		driver.findElement(By.id("minutes_charges")).sendKeys("1");
		driver.findElement(By.id("inter_charges")).sendKeys("5");
		driver.findElement(By.id("sms_charges")).sendKeys("1");		
	}

	@When("user click on the submit button")
	public void user_click_on_the_submit_button() {
		driver.findElement(By.name("submit")).click();
	}

	@Then("user should be able to view the sucess message - congratulation you add tarrif plan")
	public void user_should_be_able_to_view_the_sucess_message_congratulation_you_add_tarrif_plan() {
		Assert.assertTrue("verify the message",driver.findElement(By.xpath("//h2[text()='Congratulation you add Tariff Plan']")).isDisplayed());
	}


}
