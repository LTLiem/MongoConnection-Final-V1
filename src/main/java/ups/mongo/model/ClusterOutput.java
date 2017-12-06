package ups.mongo.model;

import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * 
 * @author Liem Le Dec 6, 2017-1:55:56 PM
 */
@Document(collection = "ClusterOutput")
public class ClusterOutput {

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

	/**
	 * Params needed to run the algo
	 */
	@Field(value = "vigilance_criterion")
	private double vigilanceCriterion;

	@Field(value = "merger_rate")
	private double mergerRate;

	@Field(value = "irrelevant_columns")
	private List<String> irrelevantColumns;

	/**
	 * Each property indicate for a sheet in the excel ouput file
	 */
	@Field(value = "trades")
	private List<String> trades; // Trades

	@Field(value = "weight_principle")
	private List<String> weightPrinciple; // Weights - prciple categories

	@Field(value = "weight_all")
	private List<String> weightAll; // Weights - all categories

	@Field(value = "lr_weight_principle")
	private List<String> lrWeightPrinciple; // LR Weights - prciple categories

	@Field(value = "lr_weight_all")
	private List<String> lrWeightAll; // LR Weights - all categories

	@Field(value = "variance")
	private List<String> variance; // Variances

	@Field(value = "distance")
	private List<String> distance; // Distances

	@Field(value = "comparison_rc")
	private List<String> comparisonRC; // Comparison to RC

	public ClusterOutput() {
		super();
	}

	public ClusterOutput(String reportId, String reportName, String reportingDate, Date generatedDate,
			double vigilanceCriterion, double mergerRate, List<String> irrelevantColumns, List<String> trades,
			List<String> weightPrinciple, List<String> weightAll, List<String> lrWeightPrinciple,
			List<String> lrWeightAll, List<String> variance, List<String> distance, List<String> comparisonRC) {
		super();
		this.reportId = reportId;
		this.reportName = reportName;
		this.reportingDate = reportingDate;
		this.generatedDate = generatedDate;
		this.vigilanceCriterion = vigilanceCriterion;
		this.mergerRate = mergerRate;
		this.irrelevantColumns = irrelevantColumns;
		this.trades = trades;
		this.weightPrinciple = weightPrinciple;
		this.weightAll = weightAll;
		this.lrWeightPrinciple = lrWeightPrinciple;
		this.lrWeightAll = lrWeightAll;
		this.variance = variance;
		this.distance = distance;
		this.comparisonRC = comparisonRC;
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

	public double getVigilanceCriterion() {
		return vigilanceCriterion;
	}

	public void setVigilanceCriterion(double vigilanceCriterion) {
		this.vigilanceCriterion = vigilanceCriterion;
	}

	public double getMergerRate() {
		return mergerRate;
	}

	public void setMergerRate(double mergerRate) {
		this.mergerRate = mergerRate;
	}

	public List<String> getIrrelevantColumns() {
		return irrelevantColumns;
	}

	public void setIrrelevantColumns(List<String> irrelevantColumns) {
		this.irrelevantColumns = irrelevantColumns;
	}

	public List<String> getTrades() {
		return trades;
	}

	public void setTrades(List<String> trades) {
		this.trades = trades;
	}

	public List<String> getWeightPrinciple() {
		return weightPrinciple;
	}

	public void setWeightPrinciple(List<String> weightPrinciple) {
		this.weightPrinciple = weightPrinciple;
	}

	public List<String> getWeightAll() {
		return weightAll;
	}

	public void setWeightAll(List<String> weightAll) {
		this.weightAll = weightAll;
	}

	public List<String> getLrWeightPrinciple() {
		return lrWeightPrinciple;
	}

	public void setLrWeightPrinciple(List<String> lrWeightPrinciple) {
		this.lrWeightPrinciple = lrWeightPrinciple;
	}

	public List<String> getLrWeightAll() {
		return lrWeightAll;
	}

	public void setLrWeightAll(List<String> lrWeightAll) {
		this.lrWeightAll = lrWeightAll;
	}

	public List<String> getVariance() {
		return variance;
	}

	public void setVariance(List<String> variance) {
		this.variance = variance;
	}

	public List<String> getDistance() {
		return distance;
	}

	public void setDistance(List<String> distance) {
		this.distance = distance;
	}

	public List<String> getComparisonRC() {
		return comparisonRC;
	}

	public void setComparisonRC(List<String> comparisonRC) {
		this.comparisonRC = comparisonRC;
	}

}
