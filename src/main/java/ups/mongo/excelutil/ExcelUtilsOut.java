package ups.mongo.excelutil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author Liem Le
 * Sep-2017
 */
public class ExcelUtilsOut extends ExcelUtilsIn {
	
	public static List<String> getColumnDifference(String fileName) {

		FileInputStream excelFile = null;
		Workbook workbook;
		
		List<String> result = new ArrayList<String>();

		try {
			excelFile = new FileInputStream(new File(fileName));
			workbook = WorkbookFactory.create(excelFile);  //XLS. For XLSX use XSSF 
			
			Sheet datatypeSheet = workbook.getSheetAt(0);
			int numberOfRow = datatypeSheet.getLastRowNum();
			
			for (int rowCount = 0; rowCount <= numberOfRow; rowCount++) {
				result.add(datatypeSheet.getRow(rowCount).getCell(0).toString());
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		}
		finally {
			try {
				excelFile.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public static List<String> getMissingMx2(String fileName) {

		FileInputStream excelFile = null;
		Workbook workbook;
		DataFormatter formatter = new DataFormatter();
		List<String> result = new ArrayList<String>();

		try {
			excelFile = new FileInputStream(new File(fileName));
			workbook = WorkbookFactory.create(excelFile); 
			
			Sheet datatypeSheet = workbook.getSheetAt(1);
			int numberOfRow = datatypeSheet.getLastRowNum();
			
			for (int rowCount = 0; rowCount <= numberOfRow; rowCount++) {				
				String temp = formatter.formatCellValue(datatypeSheet.getRow(rowCount).getCell(0));
				//In case column missing mx2 and mx3 have number of line is different
				if(temp.isEmpty()) break;
				result.add(temp);			
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		}
		finally {
			try {
				excelFile.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public static List<String> getMissingMx3(String fileName) {

		FileInputStream excelFile = null;
		Workbook workbook;
		DataFormatter formatter = new DataFormatter();
		List<String> result = new ArrayList<String>();

		try {
			excelFile = new FileInputStream(new File(fileName));
			workbook = WorkbookFactory.create(excelFile); 
			
			Sheet datatypeSheet = workbook.getSheetAt(1);
			int numberOfRow = datatypeSheet.getLastRowNum();
			
			for (int rowCount = 0; rowCount <= numberOfRow; rowCount++) {
				String temp = formatter.formatCellValue(datatypeSheet.getRow(rowCount).getCell(1));
				//In case column missing mx2 and mx3 have number of line is different
				if(temp.isEmpty()) break;
				result.add(temp);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		}
		finally {
			try {
				excelFile.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}

	
	
