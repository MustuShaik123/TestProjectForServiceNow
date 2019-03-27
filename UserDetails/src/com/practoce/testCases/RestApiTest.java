package com.practoce.testCases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.jboss.weld.junit4.WeldInitiator;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.practice.users.UserDetailsList;
import com.practice.users.UsersDTO;
import com.practice.users.impl.UserDetailsApiImpl;

@RunWith(MockitoJUnitRunner.class)
public class RestApiTest {
	
	@Inject
	UserDetailsApiImpl userDetailsApiImpl;
	
	@Rule
	public WeldInitiator weld = WeldInitiator.from(
			
		UserDetailsApiImpl.class,
		UserDetailsList.class,
		UsersDTO.class
		//@formatter:on
	).inject(this).build();
	
	@Before
	public void initialize() {
	}

	@Before
	public void init() {
	}

	@Test
	public void TestSearchFunctionality() {
		List<UserDetailsList> users =new ArrayList<>();
		users.addAll(userDetailsApiImpl.getUsersBySearch("Dieter"));
		
		for(UserDetailsList user :users) {
			assertTrue(user.getName().equalsIgnoreCase("Dieter"));
		}
	}
	
	@Test
	public void TestPagination() {
		List<UserDetailsList> users =new ArrayList<>();
		UsersDTO dto=userDetailsApiImpl.getListOfUsersByPagination(2L);
		assertTrue(dto.getListOfUsers().size()<=10);
	}
}
