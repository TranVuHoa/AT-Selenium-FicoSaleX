package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	By usernameInput = By.id("username");
	By passwordInput = By.id("password");
	By loginButton = By.cssSelector(".login-form-button");

	public void login(String username, String password) {
		sendKeyElement(usernameInput, username);
		sendKeyElement(passwordInput, password);
		clickElement(loginButton);
	}

	By titlePage = By.cssSelector("span[class='title']");

	public void check() {
		String title = getTextElement(titlePage);
		Assert.assertEquals(title, "Create Report");
	}
}