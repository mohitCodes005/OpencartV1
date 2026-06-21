package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {
		String path = ".//testData//logintest.xlsx";
		ExcelUtility util = new ExcelUtility(path);
		int totalrows = util.getRowCount("Sheet1");
		int totalcells = util.getCellCount("Sheet1", 1);
		String logindata[][] = new String[totalrows][totalcells];
		for (int i = 1; i <= totalrows; i++) {
			for (int j = 0; j < totalcells; j++) {

				logindata[i - 1][j] = util.getCellData("Sheet1", i, j);

			}
		}

		return logindata;
	}

}
