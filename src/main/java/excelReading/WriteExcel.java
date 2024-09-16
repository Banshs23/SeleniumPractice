package excelReading;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {

	public static void main(String[] args) throws InvalidFormatException {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("How many records you want to save?");
			int records = sc.nextInt();

			System.out.println("How many columns you want to save?");
			int columns = sc.nextInt();
			sc.nextLine();

			File src = new File(System.getProperty("user.dir") + "/testdata/AccountDetail.xlsx");
			FileInputStream finput = new FileInputStream(src);
			XSSFWorkbook workbook = new XSSFWorkbook(finput);
			
			XSSFSheet sheet = workbook.getSheet("StudentInfo");
			if(sheet == null)
			{
				 sheet = workbook.createSheet("StudentInfo");
			}
			
			int lastrow = sheet.getLastRowNum();
			//ternary operator
			int startrow = lastrow ==0?0: lastrow +1; 
			
			
			
			for (int i = 0; i < startrow + records; i++) {
				XSSFRow row = sheet.getRow(i) == null ?  sheet.createRow(i) : sheet.getRow(i);
				
				/*
				 * if (sheet.getRow(i) == null) { row = sheet.createRow(i); } else
				 * if(sheet.getRow(i) != null) { row = sheet.getRow(i); }
				 */

				for (int j = 0; j < columns; j++) {
					System.out.println("Enter Name");
					String names = sc.nextLine();

					System.out.println("Enter Address");
					String address = sc.nextLine();

					System.out.println("Enter Skill");
					String skill = sc.nextLine();

					row.createCell(0).setCellValue(names);
					row.createCell(1).setCellValue(address);
					row.createCell(2).setCellValue(skill);
				}
			}

			FileOutputStream foutput;
			try {
				foutput = new FileOutputStream(src);
				workbook.write(foutput);
				System.out.println("Date has been added");
			} finally {
				workbook.close();
			}
		}
		catch (IOException e) {
			// TODO: handle exception
		}
		finally {
			sc.close();
		}
	}
}
