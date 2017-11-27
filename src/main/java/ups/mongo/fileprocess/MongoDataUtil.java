package ups.mongo.fileprocess;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ups.mongo.configuration.SpringMongoConfig;
import ups.mongo.service.ReconService;

public class MongoDataUtil<T extends Object> {
	
	private ApplicationContext ctx;
	ReconService<T> reconInputService;
	
	@SuppressWarnings("unchecked")
	public MongoDataUtil(Class<T> domainClass) {
		reconInputService = (ReconService<T>) this.getApplicationContext().getBean(domainClass);
	}
	
	protected ApplicationContext getApplicationContext() {
		if(ctx == null) {
			 ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		}
		return ctx;
	}
	
	public List<T> getByReportId(String reportId) {
		return this.reconInputService.getByReportId(reportId);
		
	}
	
	public List<T> getByReportIdAndReportingDate(String reportId, String reportingDate) {		
		return this.reconInputService.getByReportIdAndReportingDate(reportId, reportingDate);
	}
	
	public void saveToMongoDB(T t) {		
		this.reconInputService.saveToMongoDB(t);
	}
}
