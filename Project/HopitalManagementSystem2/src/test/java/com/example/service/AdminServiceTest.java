package com.example.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.dao.AdminRepository;
import com.example.dao.HospitalRepository;
import com.example.model.Doctor;
import com.example.model.Login;
@ExtendWith(MockitoExtension.class)
class AdminServiceTest {

	@Mock
	private AdminRepository adminrepo;
	
	@InjectMocks
    private AdminCredServiceImp adminCredServiceImpl;
	
	@Mock
	HospitalRepository hosprepo;
	
	@InjectMocks
	HospitalServiceImp hospservImpl;
	
	
	@Test
	void createtestAdmin() {
		
		Login log = new Login();
		log.setId(1);
		log.setLoginUserName("divya");
		log.setLoginPassword("1234");
		
		given(adminrepo.save(log)).willReturn(log);
		
			Login savedAdmin = adminCredServiceImpl.createAdmin(log);

      
        assertThat(savedAdmin).isNotNull();
	}

	@Test
	void checktestAdmin() {
		
		Login log = new Login();
		log.setId(1);
		log.setLoginUserName("divya");
		log.setLoginPassword("12345");
		
	
		 given(adminrepo.findById(log.getId())).willReturn(Optional.of(log));
		
		
		
			boolean checkAdmin = adminCredServiceImpl.checkAdminCred(log);

      
        assertEquals(true, checkAdmin);
	}
	
	@Test
	void testSaveDoctor() {
		
		Doctor d = new Doctor();
		d.setDocid(1);
		d.setCity("gokak");
		d.setAddress("somvar peth");
		d.setEmail("divya@gmail.com");
		d.setFirstName("divya");
		d.setPassword("1234");
		d.setGender("female");
		d.setMobileno("2134658795");
		d.setQualification("mbbs");
		d.setSpecializaton("skin");
	
		 given(hosprepo.save(d)).willReturn(d);
		
		
		
			Doctor doc = hospservImpl.saveDoctor(d);

      
        assertThat(doc).isNotNull();
	}

	@Test
	void testgetDoctorByID() {
		
		Doctor d = new Doctor();
		d.setDocid(1);
		d.setCity("gokak");
		d.setAddress("somvar peth");
		d.setEmail("divya@gmail.com");
		d.setFirstName("divya");
		d.setPassword("1234");
		d.setGender("female");
		d.setMobileno("2134658795");
		d.setQualification("mbbs");
		d.setSpecializaton("skin");
		
	
		given(hosprepo.findById(d.getDocid())).willReturn(Optional.of(d));
		
		
		
			Optional<Doctor> checkDoctor = hospservImpl.getDoctorById(d.getDocid());

      assertThat(checkDoctor).isNotNull();
       
	}
	
	@Test
	void testDeleteDoctor() {
		
		Doctor d = new Doctor();
		d.setDocid(1);
		d.setCity("gokak");
		d.setAddress("somvar peth");
		d.setEmail("divya@gmail.com");
		d.setFirstName("divya");
		d.setPassword("1234");
		d.setGender("female");
		d.setMobileno("2134658795");
		d.setQualification("mbbs");
		d.setSpecializaton("skin");
	
		 
		
		 hospservImpl.deletebyId(d.getDocid());
		 
		 verify(hosprepo, times(1)).deleteById(d.getDocid());
	}
	
	@Test
	void testUpdateDoctor() {
		
		


		
		Doctor d = new Doctor();
		d.setDocid(1);
		d.setCity("gokak");
		d.setAddress("somvar peth");
		d.setEmail("divya@gmail.com");
		d.setFirstName("divya");
		d.setPassword("1234");
		d.setGender("female");
		d.setMobileno("2134658795");
		d.setQualification("mbbs");
		d.setSpecializaton("skin");
	
		given(hosprepo.save(d)).willReturn(d);
		
		
	
		d.setFirstName("sunita");
		
	
		 
		
		
		 Doctor doc = hospservImpl.updateby(d);
		 
		 assertThat(doc.getFirstName()).isEqualTo("sunita");
	}
}
