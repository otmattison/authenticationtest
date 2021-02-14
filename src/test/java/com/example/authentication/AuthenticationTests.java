package com.example.authentication;

import com.example.authentication.models.User;
import com.example.authentication.repositories.UserRepository;
import com.example.authentication.services.LoginService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest

public class AuthenticationTests {

	@Autowired
	private UserRepository userRepository;

	/*
	 * @Autowired private LoginService loginService;
	 */

	@Test
	public void whenFindByName_thenReturnUser() {
		// given

		User dummyUser = new User();
		dummyUser.setName("Dummy");
		dummyUser.setEmail("test@test.com");
		dummyUser.setPassword("password");
		userRepository.save(dummyUser);

		// when
		User found = userRepository.findByName(dummyUser.getName());

		// then

		assertEquals(found.getName(), dummyUser.getName());
	}

	
	  @Test public void AddAndCheckUser() {
	  
	  LoginService service = new LoginService();
	  
	  User dummyUser = new User(); dummyUser.setName("Dummy");
	  dummyUser.setEmail("test@test.com"); dummyUser.setPassword("password");
	  
	  userRepository.save(dummyUser);
	  
	  boolean authenticated = service.AuthenticateUser(dummyUser, "password");
	  assertEquals(authenticated, true);
	  
	  }
	 

}
