package steps;

import org.openqa.selenium.WebDriver;

public class LoginSteps extends BaseStep {

	public LoginSteps(WebDriver driver) {
		super(driver);
	}

	public LoginSteps givenIAmOnLoginPage() {
		System.out.println("givenIAmOnLoginPage");
		return this;
	}

	public LoginSteps whenILogin(String usernameText, String passwordText) {
		System.out.println("whenILogin");
		return this;
	}

	public LoginSteps thenIShouldSeeDashboardPage() {
		System.out.println("thenIShouldSeeDashboardPage");
		return this;
	}
}