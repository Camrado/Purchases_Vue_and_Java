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

import com.javatpoint.rest.entity.Purchase;
import com.javatpoint.rest.repository.IPurchaseRepository;
import com.javatpoint.rest.repository.PurchaseRepository;


@Path("/purchases")
public class Purchases_API {
	
	private IPurchaseRepository _purchaseRepository;
	
	public Purchases_API() {
		_purchaseRepository = new PurchaseRepository();
	}
	
	@GET
	@Path("/get/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectRows() {
		
		try {
			List<Purchase> purshases = _purchaseRepository.getAll();
			
			return Response.ok(purshases, MediaType.APPLICATION_JSON).build();
			
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		
	}
	
	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectRow(@PathParam("id") int id) {
		
		try {
			Purchase purshase = _purchaseRepository.getById(id);
						
			return Response.ok(purshase, MediaType.APPLICATION_JSON).build();
			
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		
	}
	
	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response insertRow(Purchase purchase) {
		try {
			_purchaseRepository.insert(purchase);
			
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
	public Response updateRow(Purchase purchase) {
		try {
			_purchaseRepository.update(purchase);
			
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
			_purchaseRepository.deleteById(id);
			
			return Response.ok("Successfully deleted!", MediaType.TEXT_PLAIN).build();
		} catch (Exception e) {
			// return Response.status(Response.Status.BAD_REQUEST).entity(e.toString()) .build();
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		
	}
}