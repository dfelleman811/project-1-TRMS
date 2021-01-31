package dev.felleman.models;

import java.sql.Date;

public class DevelopmentResource {

	private int resourceId;
	private Date startDate;
	private Date resourceTime;
	private String resourceLocation;
	private int resourceCost;
	private int gradingFormatId;
	private String resourceType;
	private String resourceDescription;
	private String resourceJustification;
	// not sure what to do about attachments

	public DevelopmentResource() {
		super();
	}

	public DevelopmentResource(Date startDate, Date resourceTime, String resourceLocation, int resourceCost,
			int gradingFormatId, String resourceType, String resourceDescription, String resourceJustification) {
		super();
		this.startDate = startDate;
		this.resourceTime = resourceTime;
		this.resourceLocation = resourceLocation;
		this.resourceCost = resourceCost;
		this.gradingFormatId = gradingFormatId;
		this.resourceType = resourceType;
		this.resourceDescription = resourceDescription;
		this.resourceJustification = resourceJustification;
	}

	public DevelopmentResource(int resourceId, Date startDate, Date resourceTime, String resourceLocation,
			int resourceCost, int gradingFormatId, String resourceType, String resourceDescription,
			String resourceJustification) {
		super();
		this.resourceId = resourceId;
		this.startDate = startDate;
		this.resourceTime = resourceTime;
		this.resourceLocation = resourceLocation;
		this.resourceCost = resourceCost;
		this.gradingFormatId = gradingFormatId;
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

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getResourceTime() {
		return this.resourceTime;
	}

	public void setResourceTime(Date resourceTime) {
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

	public int getGradingFormatId() {
		return this.gradingFormatId;
	}

	public void setGradingFormatId(int gradingFormatId) {
		this.gradingFormatId = gradingFormatId;
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

	@Override
	public String toString() {
		return "DevelopmentResources [resourceId=" + this.resourceId + ", startDate=" + this.startDate
				+ ", resourceTime=" + this.resourceTime + ", resourceLocation=" + this.resourceLocation
				+ ", resourceCost=" + this.resourceCost + ", gradingFormatId=" + this.gradingFormatId
				+ ", resourceType=" + this.resourceType + ", resourceDescription=" + this.resourceDescription
				+ ", resourceJustification=" + this.resourceJustification + "]";
	}

}
