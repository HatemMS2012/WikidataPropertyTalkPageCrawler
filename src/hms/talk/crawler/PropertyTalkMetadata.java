package hms.talk.crawler;

public class PropertyTalkMetadata {

	
	private String propertyID;
	private String description;
	private String represents;
	private String dataType;
	private String domain;
	private String allowedValues;
	private String examples;
	public String getPropertyID() {
		return propertyID;
	}
	public void setPropertyID(String propertyID) {
		this.propertyID = propertyID;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRepresents() {
		return represents;
	}
	public void setRepresents(String represents) {
		this.represents = represents;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getAllowedValues() {
		return allowedValues;
	}
	public void setAllowedValues(String allowedValues) {
		this.allowedValues = allowedValues;
	}
	public String getExamples() {
		return examples;
	}
	public void setExamples(String examples) {
		this.examples = examples;
	}
	
	@Override
	public String toString() {
	
		return "P:"+propertyID + "\nDesc:" + description + "\nRepresents:" 
		+ represents + "\nData Type: " + dataType + "\nDomain: " + domain 
		+ "\nAllowed Values: "+allowedValues + "\nExamples:" + examples;
	}
	
	
	
}
