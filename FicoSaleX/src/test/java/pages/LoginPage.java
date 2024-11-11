package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	By button = By.cssSelector("");

	public void login(String username, String password) {

	}

	public void verifyIAmOnDashboardPage() {

	}
}