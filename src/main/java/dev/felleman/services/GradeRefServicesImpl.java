package dev.felleman.services;

import java.util.List;

import dev.felleman.models.GradingReference;
import dev.felleman.repositories.GradingRefRepo;
import dev.felleman.repositories.GradingRefRepoImpl;

/**
 * Implements GradeRefServices Interface.
 * 
 * This Service Implementation calls the Repository Layer in order to retrieve, add, update, or delete Grading References in the Database.
 * @author DanielFelleman
 *
 */
public class GradeRefServicesImpl implements GradeRefServices {
	
	public GradingRefRepo grr = new GradingRefRepoImpl();

	@Override
	public GradingReference getGradingReference(int gradeId) {
		return grr.getGradingReference(gradeId);
	}
	
	public GradingReference getGradeRefByGrade(String grade) {
		return grr.getGradeRefByGrade(grade);
	}

	@Override
	public List<GradingReference> getAllGradingReferences() {
		return grr.getAllGradingReferences();
	}

	@Override
	public boolean addGradingReference(GradingReference r) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateGradingReference(GradingReference rChange) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteGradingReference(GradingReference r) {
		// TODO Auto-generated method stub
		return false;
	}

}
