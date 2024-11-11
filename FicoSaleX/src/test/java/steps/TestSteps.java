package steps;

import org.openqa.selenium.WebDriver;

public class TestSteps extends BaseStep {

	public TestSteps(WebDriver driver) {
		super(driver);
	}

	public TestSteps givenIAmOnSomewherePage() {
		System.out.println("givenIAmOnSomeWherePage");
		return this;
	}

	public TestSteps whenIDoSomething() {
		System.out.println("whenIDoSomething");
		return this;
	}

	public TestSteps thenIShouldSeeOtherPage() {
		System.out.println("whenIDoSomething");
		return this;
	}
}