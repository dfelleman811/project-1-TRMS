package dev.felleman.repositories;

import java.util.List;

import dev.felleman.models.GradingReference;

public interface GradingRefRepo {
	
	public GradingReference getGradingReference(int gradeId);
	
	public GradingReference getGradeRefByGrade(String grade);
	
	public List<GradingReference> getAllGradingReferences();
	
	public boolean addGradingReference(GradingReference r);
	
	public boolean updateGradingReference(GradingReference rChange);
	
	public boolean deleteGradingReference(GradingReference r);


}
