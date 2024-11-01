package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.BasePage;
import steps.Steps;
import utils.ExcelUtils;

public class BaseTest {

	public WebDriver driver;
	public String baseURL = "https://xxx";
	protected Steps steps;
	protected BasePage basePage;

	@BeforeMethod()
	public void setup() throws Exception {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		steps = new Steps(driver);
		basePage = new BasePage(driver);

		String excelPath = "./src/test/resources/DataInput/Data.xlsx";
		String sheetName = "Login";
		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);

		basePage.openURL(baseURL);

		String username = excel.getCellData(0, 0) + "";
		String password = excel.getCellData(0, 1) + "";
		steps.loginSteps.givenIAmOnLoginPage().whenILogin(username, password).thenIShouldSeeReportPage();
	}

	@AfterMethod()
	public void teardown() throws InterruptedException {
		if (driver != null) {
			driver.quit();
		}
	}
}