package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.BasePage;
import steps.Steps;

public class BaseTest {

	public WebDriver driver;
	protected Steps steps;
	protected BasePage basePage;

	private String baseURL = "";
	private String username = "";
	private String password = "";

	@BeforeMethod()
	public void setup() throws Exception {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		steps = new Steps(driver);
		basePage = new BasePage(driver);

		basePage.openURL(baseURL);

		steps.loginSteps.givenIAmOnLoginPage().whenILogin(username, password).thenIShouldSeeDashboardPage();
	}

	@AfterMethod()
	public void teardown() throws InterruptedException {
		if (driver != null) {
			driver.quit();
		}
	}
}