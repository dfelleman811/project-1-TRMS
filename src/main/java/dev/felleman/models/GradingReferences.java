package dev.felleman.models;

public class GradingReferences {

	private int formatId;
	private String formatType;
	private String formatDescription;

	public GradingReferences() {
		super();
	}

	public GradingReferences(String formatType, String formatDescription) {
		super();
		this.formatType = formatType;
		this.formatDescription = formatDescription;
	}

	public GradingReferences(int formatId, String formatType, String formatDescription) {
		super();
		this.formatId = formatId;
		this.formatType = formatType;
		this.formatDescription = formatDescription;
	}

	public int getFormatId() {
		return this.formatId;
	}

	public void setFormatId(int formatId) {
		this.formatId = formatId;
	}

	public String getFormatType() {
		return this.formatType;
	}

	public void setFormatType(String formatType) {
		this.formatType = formatType;
	}

	public String getFormatDescription() {
		return this.formatDescription;
	}

	public void setFormatDescription(String formatDescription) {
		this.formatDescription = formatDescription;
	}

	@Override
	public String toString() {
		return "GradingReferences [formatId=" + this.formatId + ", formatType=" + this.formatType
				+ ", formatDescription=" + this.formatDescription + "]";
	}

}
