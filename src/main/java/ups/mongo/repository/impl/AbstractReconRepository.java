package ups.mongo.repository.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import ups.mongo.repository.ReconRepository;

public abstract class AbstractReconRepository<T extends Object> implements ReconRepository<T> {

	@Autowired
	private MongoTemplate mongoTemplate;

	private Class<T> domainClass;

	@SuppressWarnings("unchecked")
	private Class<T> getDomainClass() {
		if (domainClass == null) {
			ParameterizedType thisType = (ParameterizedType) getClass().getGenericSuperclass();
			this.domainClass = (Class<T>) thisType.getActualTypeArguments()[0];
		}
		return domainClass;
	}

	@SuppressWarnings("unused")
	private String getDomainClassName() {
		return this.getDomainClass().getName();
	}

	public List<T> findByReportId(String reportId) {
		List<T> reconInputList = null;
		Query searchUserQuery = new Query(Criteria.where("report_id").is(reportId));
		reconInputList = mongoTemplate.find(searchUserQuery, getDomainClass());
		return reconInputList;
	}

	public List<T> findByReportIdAndReportingDate(String reportId, String reportingDate) {
		List<T> reconInputList = null;
		Query searchUserQuery = new Query(
				Criteria.where("report_id").is(reportId).and("reporting_date").is(reportingDate));
		reconInputList = mongoTemplate.find(searchUserQuery, getDomainClass());
		return reconInputList;
	}

	public void saveToMongoDB(T t) {
		mongoTemplate.save(t);
	}
}
