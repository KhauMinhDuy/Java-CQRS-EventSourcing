package com.khauminhduy.crud;

import static org.junit.Assert.assertEquals;

import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

import com.khauminhduy.crud.repository.UserRepository;
import com.khauminhduy.crud.service.UserService;
import com.khauminhduy.domain.Address;
import com.khauminhduy.domain.Contact;

public class ApplicationUnitTest {

	private UserRepository userRepository;

	private UserService userService;

	@Before
	public void init() {
		userRepository = new UserRepository();
		userService = new UserService(userRepository);
	}

	@Test
	public void givenCRUDApplication_whenDataCreated_thenDataCanBeFetched() throws Exception {
		String userId = UUID.randomUUID().toString();

		userService.createUser(userId, "Khau", "Duy");
		userService.updateUser(userId,
				Stream.of(new Contact("EMAIL", "tom.sawyer@gmail.com"), new Contact("EMAIL", "tom.sawyer@rediff.com"),
						new Contact("PHONE", "700-000-0001")).collect(Collectors.toSet()),
				Stream.of(new Address("New York", "NY", "10001"), new Address("Los Angeles", "CA", "90001"),
						new Address("Housten", "TX", "77001")).collect(Collectors.toSet()));

		userService.updateUser(userId,
				Stream.of(new Contact("EMAIL", "tom.sawyer@gmail.com"), new Contact("PHONE", "700-000-0001"))
						.collect(Collectors.toSet()),
				Stream.of(new Address("New York", "NY", "10001"), new Address("Housten", "TX", "77001"))
						.collect(Collectors.toSet()));

		assertEquals(Stream.of(new Contact("EMAIL", "tom.sawyer@gmail.com")).collect(Collectors.toSet()),
				userService.getContactByType(userId, "EMAIL"));
		assertEquals(Stream.of(new Address("New York", "NY", "10001")).collect(Collectors.toSet()),
				userService.getAddressByRegion(userId, "NY"));
	}

}
