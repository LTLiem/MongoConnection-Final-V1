package ups.mongo.model;

import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "AutoTagOutput")
public class AutoTagOutput {

	@Id
	private ObjectId id;

	@Field(value = "report_id")
	@Indexed
	private String reportId;

	@Field(value = "report_name")
	private String reportName;

	@Field(value = "reporting_date")
	private String reportingDate;

	@Field(value = "generated_date")
	private Date generatedDate;

	// The second line in the output
	@Field(value = "headers")
	private List<String> headers;

	// The rest
	@Field(value = "rows")
	private List<String> rows;

	public AutoTagOutput() {
		super();
	}

	public AutoTagOutput(String reportId, String reportName, String reportingDate, Date generatedDate,
			List<String> headers, List<String> rows) {
		super();
		this.reportId = reportId;
		this.reportName = reportName;
		this.reportingDate = reportingDate;
		this.generatedDate = generatedDate;
		this.headers = headers;
		this.rows = rows;
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

	public String getReportingDate() {
		return reportingDate;
	}

	public void setReportingDate(String reportingDate) {
		this.reportingDate = reportingDate;
	}

	public Date getGeneratedDate() {
		return generatedDate;
	}

	public void setGeneratedDate(Date generatedDate) {
		this.generatedDate = generatedDate;
	}

	public List<String> getHeaders() {
		return headers;
	}

	public void setHeaders(List<String> headers) {
		this.headers = headers;
	}

	public List<String> getRows() {
		return rows;
	}

	public void setRows(List<String> rows) {
		this.rows = rows;
	}
}
