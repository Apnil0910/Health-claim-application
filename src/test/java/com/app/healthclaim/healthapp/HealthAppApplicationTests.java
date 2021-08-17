package com.app.healthclaim.healthapp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot. test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.app.healthclaim.healthapp.model.User;

@SpringBootTest
class HealthAppApplicationTests {

	@Test
	public void testInsertRegisterdUser() {
		
		RestTemplate rst = new RestTemplate();
		String url = "http://localhost:8090/registeruser" ;
		User request = new User();
		request.setEmailId("p.apnildave@gmail.com2");
		request.setPassword("Pass@word2");
		
		User usr = rst.postForObject(url, request, User.class);
		assertNotNull(usr);
		assertEquals("p.apnildave@gmail.com2", usr.getEmail());
		assertEquals("Pass@word2", usr.getPassword());
		
	}
	
	@Test
	void testfetchLoginUserDetailsCorrect() {
		
		RestTemplate rst = new RestTemplate();
		String url = "http://localhost:8090/loginuser" ;
		User request = new User();
		request.setEmailId("p.apnildave@gmail.com1");
		request.setPassword("Pass@word1");
		
		
		User usr = rst.postForObject(url, request , User.class);
		assertNotNull(usr);
		assertEquals("p.apnildave@gmail.com1", usr.getEmail());
		assertEquals("Pass@word1", usr.getPassword());
		
	}
	
	@Test
	void testfetchLoginUserDetailsWrongResponseBody() {
		
		RestTemplate rst = new RestTemplate();
		String url = "http://localhost:8090/loginuser" ;
		User request = new User();
		request.setEmailId("p.apnildave@gmail.com1");
		request.setPassword("Pass@word1");
		
		
		User usr = rst.postForObject(url, request , User.class);
		assertNotNull(usr);
		assertNotEquals("p.apnildave@gmail.com222", usr.getEmail());
		assertNotEquals("Pass@word22", usr.getPassword());
		
	}

}
