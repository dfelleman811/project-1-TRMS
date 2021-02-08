package dev.felleman.services;

import java.util.List;

import dev.felleman.models.DevelopmentResource;
import dev.felleman.repositories.DevResRepo;
import dev.felleman.repositories.DevResRepoImpl;

/**
 * Implements DevResServices Interface.
 * 
 * This Service Implementation calls the Repository Layer in order to retrieve, add, update, or delete Development Resources in the Database.
 * @author DanielFelleman
 *
 */
public class DevResServicesImpl implements DevResServices {
	
	public DevResRepo drr = new DevResRepoImpl();

	@Override
	public DevelopmentResource getResource(int rId) {
		return drr.getResource(rId);
	}

	@Override
	public List<DevelopmentResource> getAllResources() {
		return drr.getAllResources();
	}

	@Override
	public List<DevelopmentResource> getAllResourcesByType(String type) {
		return drr.getAllResourcesByType(type);
	}

	@Override
	public boolean addDevelopmentResource(DevelopmentResource r) {
		return drr.addDevelopmentResource(r);
	}

	@Override
	public boolean updateDevelopmentResource(DevelopmentResource r) {
		return drr.updateDevelopmentResource(r);
	}
	@Override
	public boolean updateDevelopmentResourceGrade(DevelopmentResource r) {
		return drr.updateDevelopmentResourceGrade(r);
	}

	@Override
	public boolean deleteDevelopmentResource(DevelopmentResource r) {
		return drr.deleteDevelopmentResource(r);
	}

}
