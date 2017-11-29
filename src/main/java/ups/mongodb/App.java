package ups.mongodb;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Color;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoOperations;

import ups.mongo.configuration.SpringMongoConfig;
import ups.mongo.excelutil.CsvInputUtil;
import ups.mongo.excelutil.ExcelUtilsIn;
import ups.mongo.excelutil.ExcelUtilsOut;
import ups.mongo.fileprocess.MongoDataUtil;
import ups.mongo.model.AutoTagOutput;
import ups.mongo.model.ReconInputMx2;
import ups.mongo.model.ReconInputMx3;
import ups.mongo.model.ReconOutput;
import ups.mongo.service.AutoTagService;
import ups.mongo.service.ReconInputServiceMx2;
import ups.mongo.service.ReconInputServiceMx3;
import ups.mongo.service.ReconOutputService;
import ups.mongo.service.impl.ReconInputServiceMx2Impl;

public class App {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// ApplicationContext ctx = new
		// AnnotationConfigApplicationContext(SpringMongoConfig.class);
		// ApplicationContext ctx = new AnnotationConfigApplicationContext("ups.mongo");
		// MongoOperations mongoOperation =
		// (MongoOperations)ctx.getBean("mongoTemplate");

		// MongoCollection<Document> test = mongoOperation.getCollection("ReconInput");
		// List<Document> testList = test.find().into(new ArrayList<Document>());

		// List<ReconInput> mx2Data = mongoOperation.findAll(ReconInput.class);

		/*
		 * System.out.println(mx2Data.get(0).getReportId());
		 * System.out.println(mx2Data.get(0).getReportName());
		 * System.out.println(mx2Data.get(0).getSource());
		 * System.out.println(mx2Data.get(0).getReportingDate());
		 * System.out.println(mx2Data.get(0).getImportingTime()); for (String s :
		 * mx2Data.get(0).getHeaders()) { System.out.println(s); } for (String s :
		 * mx2Data.get(0).getRows()) { System.out.println(s); }
		 */

		// ReconInputServiceMx2 reconInputService =
		// (ReconInputServiceMx2)ctx.getBean(ReconInputServiceMx2.class);
		// System.out.println(reconInputService.getByReportId("R320").get(0).getRows().size());

		// reconInputService.saveToMongoMx2("R320", "Sale Today", "2017 Sep 20",
		// "FXD10_DYN_MX2.xlsx");

		// ((ConfigurableApplicationContext)ctx).close();

		// System.out.println(MongoDataUtilMx2.getByReportIdAndReportingDateMx2("R320",
		// "2017 Sep 20").get(0).getRows().size());

		//@SuppressWarnings("rawtypes")
		//MongoDataUtil service = new MongoDataUtil(ReconOutputService.class);
		/*ReconInputMx2 reconInputMx2 = new ReconInputMx2("R315", "Prorata", "2017 Sep 30", new Date(), CsvInputUtil.getHeaders("FXD10_DYN_MX2.csv", ';'),
				CsvInputUtil.getDataRows("FXD10_DYN_MX2.csv", ';'));
		service.saveToMongoDB(reconInputMx2);*/
		
		//List<ReconOutput> reconOutputList = new ArrayList<ReconOutput>();
		//reconOutputList = service.getByReportId("FXD10");
		//System.out.println(reconOutputList.get(0).getReportName());
		
		//List<ReconInputMx2> result = service.getByReportId("R315");
		//System.out.println(result.get(0).getReportName());
		/*
		 * ( String reportId, 
		 * String reportName, 
		 * String reportingDate,
		 *  Date reconTime,
		 * List<String> columnDiff,
		 *  List<String> missingMx2, 
		 *  List<String> missingMx3,
		 * List<String> keys, 
		 * List<String> headers, 
		 * List<String> rows)
		 */
//
		//List<String> keys = Arrays.asList("NB", "Buy/Sell");
		
/*		ReconOutput reconOutput = new ReconOutput("FXD10", "Fowrad Spot Today", "2017 Sep 30", new Date(),
				ExcelUtilsOut.getColumnDifference("FXD10_DYN_MX2__20171106_161817.xlsx"), 
				ExcelUtilsOut.getMissingMx2("FXD10_DYN_MX2__20171106_161817.xlsx"),
				ExcelUtilsOut.getMissingMx3("FXD10_DYN_MX2__20171106_161817.xlsx"), 
				keys, 
				ExcelUtilsOut.getHeaders("FXD10_DYN_MX2__20171106_161817.xlsx", 2),
				ExcelUtilsOut.getDataRows("FXD10_DYN_MX2__20171106_161817.xlsx", 2)
				);*/
		
		//service.saveToMongoDB(reconOutput);

		

		//List<String> result = ExcelUtilsOut.getDataRows("FXD10_DYN_MX2__20171106_161817.xlsx",2);
		//System.out.println(result.size());
		
		//System.out.println(result.get(0));
		

		
	//21-11


/*		FileInputStream excelFile = null;
		Workbook workbook;
		
		List<String> result = new ArrayList<String>();
		DataFormatter formatter = new DataFormatter();

		try {
			excelFile = new FileInputStream(new File("FXD10_DYN_MX2__20171106_161817.xls"));
			workbook = WorkbookFactory.create(excelFile);
			int numberOfSheet = workbook.getNumberOfSheets();
			
			// For each sheet
			for (int sheetCount = 2; sheetCount < numberOfSheet; sheetCount++) {

				Sheet datatypeSheet = workbook.getSheetAt(sheetCount);
				int numberOfRow = datatypeSheet.getLastRowNum();
				
				if (numberOfRow == 0) return;
				
				//int numberOfColumn = datatypeSheet.getRow(0).getLastCellNum();

				// For each row in sheet: Header will be ignored!
				for (int rowCount = 1; rowCount < numberOfRow; rowCount++) {
					String line = "";
					Color color = null;
					int numberOfColumn = datatypeSheet.getRow(rowCount).getLastCellNum();
					// For each column in row
					System.out.println("Number of col :" + numberOfColumn);
					
					String format = "";
					for (int columnCount = 0; columnCount < numberOfColumn; columnCount++) {
						
						//Format: to get the contain of cell only (exactly what showing in cell of excel file) regardless string or number
						//String cellStringVal = formatter
						//		.formatCellValue(datatypeSheet.getRow(rowCount).getCell(columnCount));
						//line += cellStringVal + '!';
						
						//CellStyle backgroundStyle = workbook.createCellStyle();
						//backgroundStyle.setFillBackgroundColor(IndexedColors.LEMON_CHIFFON.getIndex());	
						//datatypeSheet.getRow(rowCount).getCell(columnCount).setCellStyle(backgroundStyle);
						
						
						
						format += "--" + datatypeSheet.getRow(rowCount).getCell(columnCount).getCellStyle().getFillForegroundColor();
						
					}
					System.out.println("Row: " + rowCount);
					System.out.println(format);
					//System.out.println(color);
					//result.add(line.substring(0, line.length() - 1));
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
		*/
		
		MongoDataUtil service = new MongoDataUtil(AutoTagService.class);
		
		//Save and object to mongondb
/*		AutoTagOutput ao = new AutoTagOutput();
		ao.setReportId("R111");
		ao.setReportName("Fx Sale");
		//... more data
		service.saveToMongoDB(ao);*/
		
		//Try to load the object just saved
		System.out.println(service.getByReportId("R111").size());
	}
}
