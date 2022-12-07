package com.pms.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.pms.dto.SuccessResponse;
import com.pms.dto.UpdateUser;
import com.pms.dto.UserCountDto;
import com.pms.dto.UserRequestInfo;
import com.pms.dto.UserResponse;
import com.pms.model.Login;
import com.pms.model.Role;
import com.pms.model.User;
import com.pms.repository.RoleRepository;
import com.pms.repository.UserRepository;
import com.pms.service.EmailService;
import com.pms.service.impl.UserServiceImpl;
import com.pms.util.PasswordGeneratorUtil;
import com.pms.util.UserRequestInfoMapper;
import com.pms.util.UserResponseMapper;

@SpringBootTest
class UserControllerTest {

	Login login ,login2;	
	User user;	
	UserRequestInfo  requestInfo;
	List<Role> roleList;
	UpdateUser updateUser;

	List<UserResponse> userResponsesList;
	List<User> usersList;
	UserResponse userResponse;

	@Mock
	private EmailService emailService;

	@Mock
	private PasswordGeneratorUtil passwordGeneratorUtil;

	@Mock
	private UserRequestInfoMapper requestInfoMapper;

	@Mock
	private UserResponseMapper responseMapper;

	@Mock
	private UserRepository userRepository;

	@Mock
	private RoleRepository roleRepo;

	@Mock
	PasswordEncoder passwordEncoder;

	@Mock
	private UserServiceImpl  userServiceImpl;

	@InjectMocks
	private UserController  userController;

	@BeforeEach
	void setUp() {

		login = new Login(1L, "bihadep@gmail.com", "", "password@123", 1L, "");
		login2 = new Login(2L, "amitk@gmail.com", "", "amit@123", 1L, "");
		updateUser = new UpdateUser("DR001", false, "Password@123");
		user = new User(1L, "Mr", "Praful", "bihade", "bihadep@gmail.com", "06/05/1998", "06/03/2022", true,"Ortho", login, "DR001");
		requestInfo = new UserRequestInfo(1L, "Mr", "praful", "bihade", "bihadep@gmail.com", "06/05/1997", "06/03/2022", true, 1L, "DR001");
		userResponsesList = new ArrayList<>();
		userResponsesList.add(new UserResponse("DR001", "Praful", "Bihade", true, "05/02/2021", "Ortho"));
		userResponsesList.add(new UserResponse("DR002", "Amit", "kolhe", true, "07/06/2021", "Ortho"));

		usersList = new ArrayList<>();
		usersList.add(new User(1L, "Mr", "praful", "bihade", "bihadep@gmail.com", "06/05/1998", "06/03/2022", true,"Ortho", login, "DR001"));
		usersList.add(new User(2L, "Mr", "Amit", "kolhe", "amitk@gmail.com", "06/05/1995", "07/03/2022", true,"Ortho", login, "DR002"));

		userResponse = new UserResponse("DR001", "Praful", "Bihade", true, "05/02/2021", "Ortho");
		Role r1 = new Role(1L, "Admin");
		Role r2 = new Role(2L, "Physician");
		Role r3 = new Role(3L, "Nurse");
		Role r4 = new Role(4L, "Patient");

		roleList = new ArrayList<>();
		roleList.add(r1);
		roleList.add(r2);
		roleList.add(r3);
		roleList.add(r4);
	}

	@Test
	void testGetUsersByRoleIdAndSpecialization() {
		MockHttpServletRequest request = new  MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		when(userServiceImpl.getUsersByRoleIdAndSpecialization(1L, "Ortho")).thenReturn(usersList);
		List<User> actuallistUser =userController.getUsersByRoleIdAndSpecialization(1L, "Ortho");
		assertEquals(2, actuallistUser.size());

	}

	@Test
	void testSaveUser() {
		SuccessResponse sresp = new SuccessResponse(HttpStatus.OK, "User Registered Successfully");
		MockHttpServletRequest request = new  MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		when(userServiceImpl.saveUser(requestInfo)).thenReturn(user);
		SuccessResponse successResponse = userController.saveUser(requestInfo);

		assertEquals("User Registered Successfully", successResponse.getMessage());
		assertEquals(sresp, successResponse);

	}



	@Test
	void testUpdateUser() {
		//SuccessResponse sresp = new SuccessResponse(HttpStatus.OK, "User Registered Successfully");
		MockHttpServletRequest request = new  MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		when(userServiceImpl.updateUser(updateUser)).thenReturn(user);
		User actualUser= userController.updateUser(updateUser);

		assertEquals(user, actualUser);
	}



	@Test
	void testGetAllUser() {
		Mockito.when(userServiceImpl.getAllUsers()).thenReturn(userResponsesList);
		ResponseEntity<List<UserResponse>>  responseEntity = userController.getAllUser();

		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
		assertEquals(2, responseEntity.getBody().size());
	}

	@Test
	void testGetAllUserByRoleId() {
		Mockito.when(userServiceImpl.getAllUserByRoleId(1L)).thenReturn(userResponsesList);
		List<UserResponse>  actualUserResponses =  userController.getAllUserByRoleId(1L);
		
		assertEquals(2, actualUserResponses.size());
	}

	@Test
	void testGetAllRoles() {
		Mockito.when(userServiceImpl.getAllRoles()).thenReturn(roleList);
		assertEquals(4, userController.getAllRoles().size());
	}

	@Test
	void testGetUserByEmployeeId() {
		Mockito.when(userServiceImpl.getUserByID("DR001")).thenReturn(userResponse);
		UserResponse actualUserResponse = userController.getUserByEmployeeId("DR001");
		assertEquals(userResponse, actualUserResponse);
	}

	

	@Test
	void testGetAllUserCount() {
		UserCountDto countDto =  new UserCountDto(3L, 5L, 9L);
		Mockito.when(userServiceImpl.countUser()).thenReturn(countDto);
		
		UserCountDto actualCountDto = userController.getAllUserCount();
		assertEquals(countDto, actualCountDto);
	}


}









