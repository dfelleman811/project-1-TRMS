package dev.felleman.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dev.felleman.models.DevelopmentResource;
import dev.felleman.services.DevResServices;
import dev.felleman.services.DevResServicesImpl;

public class DevResControllerImpl implements DevResController {
	
	public DevResServices drs = new DevResServicesImpl();
	public Gson gson = new Gson();

	@Override
	public DevelopmentResource getResource(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		DevelopmentResource d = gson.fromJson(request.getReader(), DevelopmentResource.class);
		
		d = drs.getResource(d.getResourceId());
		
		response.getWriter().append((d != null) ? gson.toJson(d) : "{}");
		
		return d;
	}

	@Override
	public void getAllResources(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		List<DevelopmentResource> resList = drs.getAllResources();
		
		response.getWriter().append(gson.toJson(resList));

	}

	@Override
	public void getAllResourcesByType(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String input = request.getParameter("resourceType");
		
		String type;
		try {
			type = input.toString();
		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.sendError(400, "Resource Type parameter improperly formatted.");
			return;
		}
		
		List<DevelopmentResource> resList = drs.getAllResourcesByType(type);
		
		response.getWriter().append(gson.toJson(resList));
		

	}

	@Override
	public void addDevelopmentResource(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		DevelopmentResource dr = gson.fromJson(request.getReader(), DevelopmentResource.class);
		
		drs.addDevelopmentResource(dr);
		
		response.getWriter().append(gson.toJson(dr));

	}

	@Override
	public void updateDevelopmentResource(HttpServletRequest request, HttpServletResponse response) throws IOException {
		DevelopmentResource dr = gson.fromJson(request.getReader(), DevelopmentResource.class);
		
		drs.updateDevelopmentResource(dr);
		
		response.getWriter().append(gson.toJson(dr));

	}

	@Override
	public void deleteDevelopmentResource(HttpServletRequest request, HttpServletResponse response) throws IOException {
		DevelopmentResource dr = gson.fromJson(request.getReader(), DevelopmentResource.class);
		
		drs.deleteDevelopmentResource(dr);
		
		response.getWriter().append("Development Resource Deleted");
	}

}
