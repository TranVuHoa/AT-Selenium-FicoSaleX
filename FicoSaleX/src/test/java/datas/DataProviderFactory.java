package datas;

import org.testng.annotations.DataProvider;

import utils.ExcelUtils;

public class DataProviderFactory {

	static String text1 = "text";
	static String text2 = "text2";

	@DataProvider(name = "dataProviderToDoSomething")
	public Object[][] dataProviderToDoSomething() {
		return new Object[][] { { text1, text2 } };
	}

	@DataProvider(name = "dataProviderToDoSomething2")
	public Object[][] dataProviderToDoSomething2() {
		String excelPath = "./src/test/resources/DataInput/Data.xlsx";
		String sheetName = "Report";
		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();
		Object[][] data = new Object[rowCount][colCount];
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				data[i][j] = excel.getCellData(i, j);
			}
		}
		return data;
	}
}