package com.practice.users;

import java.util.List;

public class UsersDTO {

	private List<UserDetailsList> listOfUsers;
    private Long totalNuberOfPages;
    
    
    
    
	public List<UserDetailsList> getListOfUsers() {
		return listOfUsers;
	}
	public void setListOfUsers(List<UserDetailsList> listOfUsers) {
		this.listOfUsers = listOfUsers;
	}
	public Long getPaginationCount() {
		return totalNuberOfPages;
	}
	public void setPaginationCount(Long totalNuberOfPages) {
		this.totalNuberOfPages = totalNuberOfPages;
	}
	
	
}
