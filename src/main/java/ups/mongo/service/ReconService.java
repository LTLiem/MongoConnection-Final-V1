package ups.mongo.service;

import java.util.List;

public interface ReconService<T extends Object> {
	
	 public List<T> getByReportId(String reportId);
	 
	 public List<T> getByReportIdAndReportingDate(String reportId, String reportingDate);
		
	 public void saveToMongoDB(T t);

}
