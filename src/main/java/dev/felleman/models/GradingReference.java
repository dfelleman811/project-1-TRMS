package dev.felleman.models;

public class GradingReference {

	private int gradeId;
	private String grade;
	private int	passing;
	private String gradeFormat;
	
	public GradingReference() {
		super();
	}

	public GradingReference(String grade, int passing, String gradeFormat) {
		super();
		this.grade = grade;
		this.passing = passing;
		this.gradeFormat = gradeFormat;
	}

	public GradingReference(int gradeId, String grade, int passing, String gradeFormat) {
		super();
		this.gradeId = gradeId;
		this.grade = grade;
		this.passing = passing;
		this.gradeFormat = gradeFormat;
	}

	public int getGradeId() {
		return gradeId;
	}

	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getPassing() {
		return passing;
	}

	public void setPassing(int passing) {
		this.passing = passing;
	}

	public String getGradeFormat() {
		return gradeFormat;
	}

	public void setGradeFormat(String gradeFormat) {
		this.gradeFormat = gradeFormat;
	}

	@Override
	public String toString() {
		return "GradingReferences [gradeId=" + gradeId + ", grade=" + grade + ", passing=" + passing
				+ ", gradeFormat=" + gradeFormat + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GradingReference other = (GradingReference) obj;
		if (gradeId != other.gradeId)
			return false;
		if (grade == null) {
			if (other.grade != null)
				return false;
		} else if (!grade.equals(other.grade))
			return false;
		if (gradeFormat == null) {
			if (other.gradeFormat != null)
				return false;
		} else if (!gradeFormat.equals(other.gradeFormat))
			return false;
		if (passing != other.passing)
			return false;
		return true;
	}

	
	
	
}