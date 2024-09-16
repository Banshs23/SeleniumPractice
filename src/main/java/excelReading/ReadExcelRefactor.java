package excelReading;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelRefactor {

	public static void main(String[] args) throws InvalidFormatException, IOException {

		XSSFWorkbook workbook = new XSSFWorkbook(new File(System.getProperty("user.dir") + "/testdata/AccountDetails.xlsx"));

		String value = workbook.getSheet("Login").getRow(1).getCell(1).getStringCellValue();

		System.out.println(value);

		workbook.close();

	}

}
