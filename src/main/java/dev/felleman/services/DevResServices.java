package dev.felleman.services;

import java.util.List;

import dev.felleman.models.DevelopmentResource;

public interface DevResServices {
	
public DevelopmentResource getResource(int rId);
	
	public List<DevelopmentResource> getAllResources();
	
	public List<DevelopmentResource> getAllResourcesByType(String type);
	
	public boolean addDevelopmentResource(DevelopmentResource r);
	
	public boolean updateDevelopmentResource(DevelopmentResource r);
	
	public boolean updateDevelopmentResourceGrade(DevelopmentResource r);
	
	public boolean deleteDevelopmentResource(DevelopmentResource r);

}
