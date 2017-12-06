package ups.mongo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import ups.mongo.repository.ReconRepository;

public abstract class AbstractReconService<T extends Object> {

	@Autowired
	protected ReconRepository<T> reconRepository;

	public List<T> getByReportId(String reportId) {
		return (List<T>) reconRepository.findByReportId(reportId);
	}

	public List<T> getByReportIdAndReportingDate(String reportId, String reportingDate) {
		return (List<T>) reconRepository.findByReportIdAndReportingDate(reportId, reportingDate);
	}

	public void saveToMongoDB(T t) {
		reconRepository.saveToMongoDB(t);
	}
}
