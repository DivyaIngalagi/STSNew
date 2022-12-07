package com.example.controller;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.model.Doctor;
import com.example.model.Login;
import com.example.service.AappointmentService;
import com.example.service.AdminService;
import com.example.service.DoctorService;
import com.example.service.HospitalService;
import com.example.service.PatientService;
import com.fasterxml.jackson.databind.ObjectMapper;



//@ComponentScan(basePackages = {"com.mypackage"})
//@SpringBootTest
//@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@WebMvcTest
public class MainControllerTest {

	@Autowired
	private MainController controller;

	
	@MockBean
	private AdminService aService;
	
	@MockBean
	private HospitalService hService;
	
	@MockBean
	private PatientService pService;
	
	@MockBean
	private AappointmentService appService;


	@MockBean
	private DoctorService dService;

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private WebApplicationContext context;

	@BeforeEach
	public void setUp() {

		mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void testCreateAdmin() throws Exception {

		Login log = new Login();

		log.setId(1);
		log.setLoginUserName("divya");
		log.setLoginPassword("7865");

		Mockito.when(aService.createAdmin(log)).thenReturn(log);

		mvc.perform(post("/addDoc").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(log)));

	}
	
	
	@Test
	public void testRegDoctor() throws Exception {

		Doctor doc = new Doctor();
		doc.setDocid(1);
		doc.setFirstName("divya");
		doc.setPassword("1234");
		doc.setEmail("divya@ingalagi786gmail.com");
		doc.setUsername("divya123");
		doc.setLastName("Ingalagi");
		doc.setMobileno("2211237821");
		doc.setAddress("123 ABC");
		doc.setCity("gokak");
		doc.setQualification("mbbs");
		doc.setSpecializaton("skin");
		
		Login log = new Login();
		log.setId(1);
		log.setLoginUserName("divya");
		log.setLoginPassword("1234");
		
		Mockito.when(hService.saveDoctor(doc)).thenReturn(doc);

		mvc.perform(post("/doctorreg").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(doc)));
		
		
	}

}
