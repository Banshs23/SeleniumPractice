package excelReading;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args) throws InvalidFormatException, IOException {

		File src = new File(System.getProperty("user.dir") + "/testdata/AccountDetails.xlsx");

		System.out.println("File path: " + src.getAbsolutePath());

		XSSFWorkbook wb = new XSSFWorkbook(src);

		XSSFSheet sh = wb.getSheet("Login");

		XSSFRow rw = sh.getRow(1);

		XSSFCell cw = rw.getCell(1);

		String value = cw.getStringCellValue();

		System.out.println(value);

		wb.close();

	}

}
