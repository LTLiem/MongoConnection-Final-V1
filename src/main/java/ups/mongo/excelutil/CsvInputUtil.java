package ups.mongo.excelutil;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Liem Le
 * Using when user want to import 2 reconciliation input (CSV) to MongoDB
 */

public class CsvInputUtil {
	
	private static final Character SPLITTER = '!';
	
	public static String getHeaders(String fileName, char csvSplitter) {

		BufferedReader br = null;
		String line = "";
        
        try {
			br = new BufferedReader(new FileReader(fileName));
			line = br.readLine().replace(csvSplitter, SPLITTER);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
		return line;
	}

	public static List<String> getDataRows(String fileName, char csvSplitter) {
		
		List<String> result = new ArrayList<String>();
		BufferedReader br = null;
		String line = "";
		
        try {
			br = new BufferedReader(new FileReader(fileName));
			br.readLine(); //To ignore the header (1st line)
			while((line = br.readLine()) != null) {
				result.add(line.replace(csvSplitter, SPLITTER));
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
		return result;
	}
}
