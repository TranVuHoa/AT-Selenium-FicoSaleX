package tests;

import org.testng.annotations.Test;

import datas.DataProviderFactory;

public class ReportTest extends BaseTest {

	@Test(dataProvider = "dataProviderToDoSomething2", dataProviderClass = DataProviderFactory.class)
	public void login(String text1, String text2) {

	}
}