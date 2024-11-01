package pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class ReportPage extends BasePage {

	public ReportPage(WebDriver driver) {
		super(driver);
	}

	public void inputField(String date, String project) throws Exception {
		By dateInput = By.cssSelector(".ant-input");
		clickElement(dateInput);

		By monthSelect = By.cssSelector(".ant-calendar-month-select");
		String monthText = getTextElement(monthSelect);
		boolean check = date.contains(monthText);
		while (check == false) {
			By previousMonthButton = By.cssSelector(".ant-calendar-prev-month-btn");
			clickElement(previousMonthButton);
			monthText = getTextElement(monthSelect);
			check = date.contains(monthText);
		}
		By dateCalendar = By.cssSelector("td[title='" + date + "']");
		clickElement(dateCalendar);

		String[] strArray = project.split(", ");
		for (String s : strArray) {
			sleep(2000);

			By projectInput = By.cssSelector(".ant-select-enabled");
			clickElement(projectInput);
			sendKeyElementByAction(projectInput, s);

			By firstOption = By.cssSelector(".ant-select-dropdown-menu>li");
			sleep(2000);
			clickElement(firstOption);
		}
	}

	By submitButton = By.cssSelector(".div-table-button>.ant-btn");

	public void submit() {
		clickElement(submitButton);
	}

	By viewButton = By.cssSelector(".ant-result-extra .ant-btn-primary");
	By dateList = By.cssSelector(".ant-list-item .ant-tabs-tab");

	public void check(String date, String project) {
		clickElement(viewButton);

		List<WebElement> list = getListElement(dateList);
		String dateText = "";
		if (!list.isEmpty()) {
			dateText = list.get(0).getText();
		}

		SimpleDateFormat inputDateFormat = new SimpleDateFormat("MMMM dd, yyyy");
		SimpleDateFormat outputDateFormat = new SimpleDateFormat("EEE dd-MM-yyyy");
		String outputDate = "";
		try {
			Date dateOut = inputDateFormat.parse(date);
			outputDate = outputDateFormat.format(dateOut);
		} catch (ParseException e) {
			System.out.println("Định dạng ngày không hợp lệ: " + e.getMessage());
		}
		Assert.assertEquals(dateText, outputDate);
	}

}
