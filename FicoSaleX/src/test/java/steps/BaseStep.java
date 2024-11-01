package steps;

import org.openqa.selenium.WebDriver;

import pages.LoginPage;

public class BaseStep {

	protected LoginPage loginPage;

	public BaseStep(WebDriver driver) {
		loginPage = new LoginPage(driver);
	}
}