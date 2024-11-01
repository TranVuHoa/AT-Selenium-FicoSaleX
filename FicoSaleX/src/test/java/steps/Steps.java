package steps;

import org.openqa.selenium.WebDriver;

public class Steps {

	public LoginSteps loginSteps;
	public TestSteps testSteps;

	public Steps(WebDriver driver) {
		this.loginSteps = new LoginSteps(driver);
		this.testSteps = new TestSteps(driver);
	}
}