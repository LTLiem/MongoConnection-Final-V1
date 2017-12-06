package ups.mongo.repository;

import java.util.List;

public interface ReconRepository<T extends Object> {

	public List<T> findByReportId(String reportId);

	public List<T> findByReportIdAndReportingDate(String reportId, String reportingDate);

	public void saveToMongoDB(T t);

}
