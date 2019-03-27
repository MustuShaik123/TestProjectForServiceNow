package com.practice.users;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/Users")
public interface UsersApi {

	@GET
	@Path("/showUsers")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UserDetailsList> showUsers();
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/showUsers/limit")
	 public UsersDTO showLimitedUsers(@PathParam("limit") Long limit);
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/showUsers/SearchUser")
	public List<UserDetailsList> getUsersBySearch(@PathParam("searchUser") String userName);

}
