package dev.felleman.models;

import java.sql.Date;

public class DevelopmentResource {

	private int resourceId;
	private String startDate;
	private String resourceTime;
	private String resourceLocation;
	private int resourceCost;
	private String gradingFormat;
	private String resourceType;
	private String resourceDescription;
	private String resourceJustification;
	private int finalGrade;
	// not sure what to do about attachments

	public DevelopmentResource() {
		super();
	}

	public DevelopmentResource(String startDate, String resourceTime, String resourceLocation, int resourceCost,
			String gradingFormat, String resourceType, String resourceDescription, String resourceJustification) {
		super();
		this.startDate = startDate;
		this.resourceTime = resourceTime;
		this.resourceLocation = resourceLocation;
		this.resourceCost = resourceCost;
		this.gradingFormat = gradingFormat;
		this.resourceType = resourceType;
		this.resourceDescription = resourceDescription;
		this.resourceJustification = resourceJustification;
	}

	public DevelopmentResource(int resourceId, String startDate, String resourceTime, String resourceLocation,
			int resourceCost, String gradingFormat, String resourceType, String resourceDescription,
			String resourceJustification) {
		super();
		this.resourceId = resourceId;
		this.startDate = startDate;
		this.resourceTime = resourceTime;
		this.resourceLocation = resourceLocation;
		this.resourceCost = resourceCost;
		this.gradingFormat = gradingFormat;
		this.resourceType = resourceType;
		this.resourceDescription = resourceDescription;
		this.resourceJustification = resourceJustification;
	}

	public int getResourceId() {
		return this.resourceId;
	}

	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}

	public String getStartDate() {
		return this.startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getResourceTime() {
		return this.resourceTime;
	}

	public void setResourceTime(String resourceTime) {
		this.resourceTime = resourceTime;
	}

	public String getResourceLocation() {
		return this.resourceLocation;
	}

	public void setResourceLocation(String resourceLocation) {
		this.resourceLocation = resourceLocation;
	}

	public int getResourceCost() {
		return this.resourceCost;
	}

	public void setResourceCost(int resourceCost) {
		this.resourceCost = resourceCost;
	}

	public String getGradingFormat() {
		return this.gradingFormat;
	}

	public void setGradingFormat(String gradingFormatId) {
		this.gradingFormat = gradingFormatId;
	}

	public String getResourceType() {
		return this.resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public String getResourceDescription() {
		return this.resourceDescription;
	}

	public void setResourceDescription(String resourceDescription) {
		this.resourceDescription = resourceDescription;
	}

	public String getResourceJustification() {
		return this.resourceJustification;
	}

	public void setResourceJustification(String resourceJustification) {
		this.resourceJustification = resourceJustification;
	}
	
	public int getFinalGrade() {
		return this.finalGrade;
	}
	
	public void setFinalGrade(int finalGrade) {
		this.finalGrade = finalGrade;
	}

	@Override
	public String toString() {
		return "DevelopmentResources [resourceId=" + this.resourceId + ", startDate=" + this.startDate
				+ ", resourceTime=" + this.resourceTime + ", resourceLocation=" + this.resourceLocation
				+ ", resourceCost=" + this.resourceCost + ", gradingFormatId=" + this.gradingFormat
				+ ", resourceType=" + this.resourceType + ", resourceDescription=" + this.resourceDescription
				+ ", resourceJustification=" + this.resourceJustification + ", finalGrade=" + this.finalGrade + "]";
	}

}
