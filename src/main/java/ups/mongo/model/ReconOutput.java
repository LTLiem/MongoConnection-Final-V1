package ups.mongo.model;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "ReconOutput")
public class ReconOutput {
	
	@Id	
	private ObjectId id;
	
	@Field(value = "report_id")
	@Indexed
	private String reportId;
	
	@Field(value = "report_name")
	private String reportName;
	
	@Field(value = "reporting_date")
	private String reportingDate;
	
	@Field(value = "recon_time")
	private Date reconTime;
	
	@Field(value = "column_difference")
	private List<String> columnDiff;
	
	@Field(value = "missing_mx2")
	private List<String> missingMx2;
	
	@Field(value = "missing_mx3")
	private List<String> missingMx3;
	
	@Field(value = "keys")
	private List<String> keys;
	
	@Field(value = "headers")
	private List<String> headers;
	
	@Field(value = "rows")
	private List<String> rows;
	
	public ReconOutput() {
		
	}

	public ReconOutput(String reportId, String reportName, String reportingDate, Date reconTime,
			List<String> columnDiff, List<String> missingMx2, List<String> missingMx3, List<String> keys,
			List<String> headers, List<String> rows) {
		super();
		this.reportId = reportId;
		this.reportName = reportName;
		this.reportingDate = reportingDate;
		this.reconTime = reconTime;
		this.columnDiff = columnDiff;
		this.missingMx2 = missingMx2;
		this.missingMx3 = missingMx3;
		this.keys = keys;
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

	public Date getReconTime() {
		return reconTime;
	}

	public void setReconTime(Date reconTime) {
		this.reconTime = reconTime;
	}

	public List<String> getColumnDiff() {
		return columnDiff;
	}

	public void setColumnDiff(List<String> columnDiff) {
		this.columnDiff = columnDiff;
	}

	public List<String> getMissingMx2() {
		return missingMx2;
	}

	public void setMissingMx2(List<String> missingMx2) {
		this.missingMx2 = missingMx2;
	}

	public List<String> getMissingMx3() {
		return missingMx3;
	}

	public void setMissingMx3(List<String> missingMx3) {
		this.missingMx3 = missingMx3;
	}

	public List<String> getKeys() {
		return keys;
	}

	public void setKeys(List<String> keys) {
		this.keys = keys;
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
