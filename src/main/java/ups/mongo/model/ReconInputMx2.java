package ups.mongo.model;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection = "ReconInputMx2")
public class ReconInputMx2 {

	@Id	
	private ObjectId id;
	
	@Field(value="report_id")
	@Indexed
	private String reportId;
	
	@Field(value="report_name")
	private String reportName;
	
	private String source = "Mx2";
	
	@Field(value="reporting_date")
	private String reportingDate;
	
	@Field(value="importing_time")
	private Date importingTime;
	
	private String headers;
	
	private List<String> rows;

	protected ReconInputMx2() {
	}
	
	public ReconInputMx2(String reportId, String reportName, String reportingDate, Date importingTime,
			String headers, List<String> rows) {
		super();
		this.reportId = reportId;
		this.reportName = reportName;
		this.reportingDate = reportingDate;
		this.importingTime = importingTime;
		this.headers = headers;
		this.rows = rows;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getReportId() {
		return reportId;
	}

	public void setReportId(String reportId) {
		this.reportId = reportId;
	}

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getReportingDate() {
		return reportingDate;
	}

	public void setReportingDate(String reportingDate) {
		this.reportingDate = reportingDate;
	}

	public Date getImportingTime() {
		return importingTime;
	}

	public void setImportingTime(Date importingTime) {
		this.importingTime = importingTime;
	}

	public String getHeaders() {
		return headers;
	}

	public void setHeaders(String headers) {
		this.headers = headers;
	}

	public List<String> getRows() {
		return rows;
	}

	public void setRows(List<String> rows) {
		this.rows = rows;
	}
	
}
