package dataProvider;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class CustomDataProvider {

	@DataProvider(name = "login")
	public static Object[][] testDataProvider() throws IOException, InvalidFormatException {
		
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
	
	
	@DataProvider(name = "teams")
	public static Object[][] teamsDataProvider() throws IOException, InvalidFormatException {
		
		XSSFWorkbook workbook=new XSSFWorkbook(new File(System.getProperty("user.dir")+"/testdata/AccountDetail.xlsx")); 
	 	int rows=workbook.getSheet("TeamsUpdate").getPhysicalNumberOfRows();
	 	int columns=workbook.getSheet("TeamsUpdate").getRow(0).getPhysicalNumberOfCells();
	 	
	 	Object[][] arr = new Object[rows][columns];		
	 	
	 	for(int i=1;i<rows;i++)
	 	{
	 		for(int j=1;j<columns;j++)
	 		{
	 			arr[i][j] = workbook.getSheet("TeamsUpdate").getRow(i).getCell(j).getStringCellValue();
	 		}
	 	}
		
	 	System.out.println("Test data completed");
	 	workbook.close();
		return arr;
	}
	
}
