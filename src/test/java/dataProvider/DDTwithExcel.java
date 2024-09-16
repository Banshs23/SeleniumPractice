package dataProvider;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDTwithExcel {

	@Test(dataProvider = "login")
	public void fetchData(String fname, String lname, String Cname) {
		System.out.println("======================");
		System.out.println(fname);
		System.out.println(lname);
		System.out.println(Cname);
		System.out.println("======================");
	}

	@DataProvider(name = "login")
	public Object[][] testDataProvider() throws IOException, InvalidFormatException {
		
		XSSFWorkbook workbook=new XSSFWorkbook(new File(System.getProperty("user.dir")+"/testdata/AccountDetail.xlsx")); 
	 	int rows=workbook.getSheet("CountryDetails").getPhysicalNumberOfRows();
	 	int columns=workbook.getSheet("CountryDetails").getRow(0).getPhysicalNumberOfCells();
	 	
	 	Object[][] arr = new Object[rows][columns];

		
	 	
	 	for(int i=0;i<rows;i++)
	 	{
	 		for(int j=0;j<columns;j++)
	 		{
	 			arr[i][j] = workbook.getSheet("CountryDetails").getRow(i).getCell(j).getStringCellValue();
	 		}
	 	}
		
	 	System.out.println("Test data completed");
	 	workbook.close();
		return arr;
	}
	
}
