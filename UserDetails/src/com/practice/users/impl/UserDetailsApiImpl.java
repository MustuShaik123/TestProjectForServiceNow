package com.practice.users.impl;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.practice.users.UserDetailsList;
import com.practice.users.UsersDTO;

public class UserDetailsApiImpl{
	
public List<UserDetailsList> showUsers() throws IOException, ParseException { 
	return getUsersList();		
}

public UsersDTO showLimitedUsers(Long paginatedCount){
	return getListOfUsersByLimit(paginatedCount);
}

public List<UserDetailsList> usersBySearch(String  userName){
	return getUsersBySearch(userName);
}


public UsersDTO getListOfUsersByLimit(Long paginatedCount){  		   
	return  getListOfUsersByPagination(paginatedCount);
}

/*
 * Below method is used for fetching the users for pagination
 * Ex:-
 * we have 100 users,each page we are showing 10 users
 * so total number of pages will be 10.
 * finally we are returning DTO consisting of users based on the page Number
 */
public UsersDTO getListOfUsersByPagination(long pageNumber) {
	UsersDTO  paginatedUserDTO =new UsersDTO();
	 List<UserDetailsList> users = new ArrayList<>();
	 try {
		users.addAll(getUsersList());
	} catch (IOException | ParseException e) {
		e.printStackTrace();
	} 
	 Long countLimit =10L;
	 Long startIndex=(pageNumber-1)*countLimit+1;
	 Long endIndex=pageNumber*countLimit;
	 List<UserDetailsList> paginatedUsrsList = new ArrayList<>(); 
	 Long numberOfPages = users.size()/countLimit;
	 if(users.size()>10) {
	  for(Long i=startIndex;i<endIndex;i++) {
		  paginatedUsrsList.add(users.get(i.intValue()));
		  }
	 }else {
		 for(int i=0;i<10;i++) {
			  paginatedUsrsList.add(users.get(i));
			  }
	 }
	 paginatedUserDTO.setListOfUsers(paginatedUsrsList);
	 paginatedUserDTO.setPaginationCount(numberOfPages);		 
	  return paginatedUserDTO;
	
}

public List<UserDetailsList> getUsersBySearch(String userName) {
	 List<UserDetailsList> users = new ArrayList<>();
   try {
	users.addAll(getUsersList());
} catch (IOException | ParseException e) {
	e.printStackTrace();
} 
	 List<UserDetailsList> searchResults = new ArrayList<>();
	
	 for(UserDetailsList user:users) {
		 if(user.getName().equalsIgnoreCase(userName)) {
			 searchResults.add(user);
		 }
	 }
	return searchResults;
}


private  List<UserDetailsList> getUsersList() throws IOException, ParseException {
	List<UserDetailsList> users = new ArrayList<>();
	 JSONParser parser = new JSONParser();
	 JSONArray jsonArray =  (JSONArray) parser.parse(new FileReader("C:\\workspace_7.0\\UserDetails\\src\\com\\practice\\users\\SampleData.json"));
	 for(Object element : jsonArray) {
		 UserDetailsList userDetail = new UserDetailsList();
		 JSONObject jsonObj = (JSONObject) element;
		 userDetail.setName(String.valueOf(jsonObj.get("name")));
		 userDetail.setAge(Integer.valueOf(String.valueOf(jsonObj.get("age"))));
		 userDetail.setCompany(String.valueOf(jsonObj.get("company")));
		 userDetail.setAddress(String.valueOf(jsonObj.get("address")));
		 users.add(userDetail);		 
	 }
	 return users;
}
}
