package steps;

import org.openqa.selenium.WebDriver;

public class TestSteps extends BaseStep {

	public TestSteps(WebDriver driver) {
		super(driver);
	}

	public TestSteps givenIAmOnLoginPage() {
		System.out.println("givenIAmOnLoginPage");
		return this;
	}

	public TestSteps whenILogin(String usernameText, String passwordText) {
		System.out.println("whenILogin: " + usernameText + "-" + passwordText);
		loginPage.login(usernameText, passwordText);
		return this;
	}

	public TestSteps thenIShouldSeeReportPage() {
		System.out.println("thenIShouldSeeReportPage");
		loginPage.check();
		return this;
	}
}