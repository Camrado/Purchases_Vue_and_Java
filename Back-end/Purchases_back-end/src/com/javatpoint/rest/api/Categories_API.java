package com.javatpoint.rest.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.javatpoint.rest.entity.Category;
import com.javatpoint.rest.repository.CategoryRepository;
import com.javatpoint.rest.repository.ICategoryRepository;


@Path("/categories")
public class Categories_API {
	
	private ICategoryRepository _categoryRepository;
	
	public Categories_API() {
		_categoryRepository = new CategoryRepository();
	}
	
	@GET
	@Path("/get/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectRows() {
		
		try {
			List<Category> categories = _categoryRepository.getAll();
			
			return Response.ok(categories, MediaType.APPLICATION_JSON).build();
			
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		
	}
	
	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectRow(@PathParam("id") int id) {
		
		try {
			Category category = _categoryRepository.getById(id);
						
			return Response.ok(category, MediaType.APPLICATION_JSON).build();
			
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		
	}
	
	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response insertRow(Category category) {
		try {
			_categoryRepository.insert(category);
			
			return Response.ok("Successfully added!", MediaType.TEXT_PLAIN).build();
		} catch (Exception e) {
			// return Response.status(Response.Status.BAD_REQUEST).entity(e.toString()) .build();
			return Response.status(Response.Status.BAD_REQUEST).build();
		}

	}
	
	@PUT
	@Path("/put")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response updateRow(Category category) {
		try {
			_categoryRepository.update(category);
			
			return Response.ok("Successfully updated!", MediaType.TEXT_PLAIN).build();
		} catch (Exception e) {
			// return Response.status(Response.Status.BAD_REQUEST).entity(e.toString()) .build();
			return Response.status(Response.Status.BAD_REQUEST).build();
		}

	}
	
	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response deleteRow(@PathParam("id") int id) {
		try {
			_categoryRepository.deleteById(id);
			
			return Response.ok("Successfully deleted!", MediaType.TEXT_PLAIN).build();
		} catch (Exception e) {
			// return Response.status(Response.Status.BAD_REQUEST).entity(e.toString()) .build();
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		
	}
}