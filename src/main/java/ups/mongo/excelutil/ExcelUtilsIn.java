package ups.mongo.excelutil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author Liem Le
 * Sep-2017
 */
public class ExcelUtilsIn {

	protected static final Character SPLITTER = '!';

	/**	 
	 * @param fileName
	 * @param sheet
	 * @return The header of excel's sheet
	 */
	public static List<String> getHeaders(String fileName, int sheet) {

		FileInputStream excelFile = null;
		Workbook workbook;
		
		List<String> headers = new ArrayList<String>();

		try {
			excelFile = new FileInputStream(new File(fileName));
			workbook = WorkbookFactory.create(excelFile);
			Sheet datatypeSheet = workbook.getSheetAt(sheet);

			Row headerRow = datatypeSheet.getRow(0);
			for (Cell cell : headerRow) {
				headers.add(cell.toString());
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
		return headers;

	}

	/**
	 * 
	 * @param headers
	 * @return concat all header column, seperate by SPLITTER
	 */
	public static String formatHeader(List<String> headers) {
		String result = "";
		for (String string : headers) {
			result += string + SPLITTER;
		}
		return result.substring(0, result.length() - 1);
	}

	/**
	 * For input file, it begin with 0. And it's two for the output (The 1st sheet is Column In Value Difference 
	 * and the 2nd sheet is Missing Key)
	 * 
	 * @param fileName
	 * @param sheetBegin
	 * @return Data rows in excel file
	 */
	public static List<String> getDataRows(String fileName, int sheetBegin) {

		FileInputStream excelFile = null;
		Workbook workbook;
		
		List<String> result = new ArrayList<String>();
		DataFormatter formatter = new DataFormatter();

		try {
			excelFile = new FileInputStream(new File(fileName));
			workbook = WorkbookFactory.create(excelFile);
			int numberOfSheet = workbook.getNumberOfSheets();

			//To make sure sheet is not out of range
			if(sheetBegin > numberOfSheet) {
				System.out.println("The value is out of range. Begin point should be <= number of sheet");
				return null;
			}
			
			// For each sheet
			for (int sheetCount = sheetBegin; sheetCount < numberOfSheet; sheetCount++) {

				Sheet datatypeSheet = workbook.getSheetAt(sheetCount);
				int numberOfRow = datatypeSheet.getLastRowNum();
				
				//Check if sheet contain data or not
				if(numberOfRow == 0) return result;
				
				int numberOfColumn = datatypeSheet.getRow(0).getLastCellNum();

				// For each row in sheet: Header will be ignored!
				for (int rowCount = 1; rowCount <= numberOfRow; rowCount++) {
					String line = "";
					// For each column in row
					for (int columnCount = 0; columnCount < numberOfColumn; columnCount++) {
						
						//Format: to get the contain of cell only (exactly what showing in cell of excel file) regardless string or number
						String cellStringVal = formatter
								.formatCellValue(datatypeSheet.getRow(rowCount).getCell(columnCount));
						line += cellStringVal + SPLITTER;
					}
					result.add(line.substring(0, line.length() - 1));
				}
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
