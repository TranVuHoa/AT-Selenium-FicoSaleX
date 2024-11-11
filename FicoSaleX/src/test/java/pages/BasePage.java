package pages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	protected WebDriver driver;
	protected WebDriverWait wait;
	protected int timeout = 20;
	protected Actions actions;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, timeout);
		this.actions = new Actions(driver);
	}

	protected BasePage(WebDriver driver, int time) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, time);
		this.actions = new Actions(driver);
	}

	public void openURL(String url) throws Exception {
		if (!(url.startsWith("http://") || url.startsWith("https://"))) {
			throw new Exception("Invalid URL format!");
		}
		driver.get(url);
	}

	protected void clickElement(By locator) {
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}

	protected String getTextElement(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
	}

	protected List<WebElement> getListElement(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return driver.findElements(locator);
	}

	protected void sendKeyElement(By locator, String text) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.clear();
		element.sendKeys(text);
	}

	protected void sendKeyElementByAction(By locator, String text) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		actions.sendKeys(driver.findElement(locator), text).perform();
	}

	protected void switchNewWindow() {
		String MainWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			if (!MainWindow.equals(window)) {
				driver.switchTo().window(window);
			}
		}
	}

	protected void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}