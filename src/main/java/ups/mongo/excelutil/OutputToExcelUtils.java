package ups.mongo.excelutil;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ups.mongo.model.ClusterOutput;

public class OutputToExcelUtils {

	public static void clusterOutToExcel(ClusterOutput clusterObject, String outputPath) {

		XSSFWorkbook workbook = new XSSFWorkbook();
		
		// Trade
		createSheet(workbook, clusterObject.getTrades(), "Trades");
		// Weights - prciple categories
		createSheet(workbook, clusterObject.getWeightPrinciple(), "Weights - prciple categories");
		// Weights - all categories
		createSheet(workbook, clusterObject.getWeightAll(), "Weights - all categories");
		// LR Weights - prciple categories
		createSheet(workbook, clusterObject.getLrWeightPrinciple(), "LR Weights - prciple categories");
		// LR Weights - all categories
		createSheet(workbook, clusterObject.getLrWeightAll(), "LR Weights - all categories");
		// Variances
		createSheet(workbook, clusterObject.getVariance(), "Variances");
		// Distances
		createSheet(workbook, clusterObject.getDistance(), "Distances");
		// Comparison to RC
		createSheet(workbook, clusterObject.getComparisonRC(), "Comparison to RC");
		
		try {
			FileOutputStream outputStream = new FileOutputStream(outputPath);
			workbook.write(outputStream);
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void createSheet(XSSFWorkbook workbook, List<String> data, String sheetName) {		
		
		int rowNum = 0;
		XSSFSheet sheet = workbook.createSheet(sheetName);
		for (String line : data) {
			int colNum = 0;
			// Split into value of cell
			List<String> valuesOfLine = new ArrayList<String>(Arrays.asList(line.split("!")));
			Row row = sheet.createRow(rowNum++);

			for (String valueOfCell : valuesOfLine) {
				Cell cell = row.createCell(colNum++);
				cell.setCellValue(valueOfCell);
			}
		}
	}
}
