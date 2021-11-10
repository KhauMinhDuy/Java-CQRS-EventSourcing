package com.khauminhduy.cqrs;

import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

import com.khauminhduy.cqrs.aggregates.UserAggregate;
import com.khauminhduy.cqrs.command.CreateUserCommand;
import com.khauminhduy.cqrs.command.UpdateUserCommand;
import com.khauminhduy.cqrs.projections.UserProjection;
import com.khauminhduy.cqrs.repository.UserReadRepository;
import com.khauminhduy.cqrs.repository.UserWriteRepository;
import com.khauminhduy.domain.Address;
import com.khauminhduy.domain.Contact;
import com.khauminhduy.domain.User;

public class ApplicationUnitTest {

	private UserWriteRepository writeRepository;
	private UserReadRepository readRepository;
	private UserAggregate userAggregate;
	private UserProjection userProjection;
	
	@Before
	public void init() {
		writeRepository = new UserWriteRepository();
		readRepository = new UserReadRepository();
		userAggregate = new UserAggregate(writeRepository);
		userProjection = new UserProjection(readRepository);
	}
	
	@Test
	public void givenCQRSApplication_whenCommandRun_thenQueryShouldReturnResult() {
		String userId = UUID.randomUUID().toString();
		
		CreateUserCommand createUserCommand = new CreateUserCommand();
		createUserCommand.setUserId(userId);
		createUserCommand.setFirstName("Khau");
		createUserCommand.setLastName("Duy");
		
		User user = userAggregate.handleCreateUserCommand(createUserCommand);
		
		UpdateUserCommand updateUserCommand = new UpdateUserCommand();
		updateUserCommand.setUserId(userId);
		updateUserCommand.setContacts(Stream.of(new Contact("EMAIL", "tom.sawyer@gmail.com"), new Contact("EMAIL", "tom.sawyer@rediff.com"))
                .collect(Collectors.toSet()));
		updateUserCommand.setAddresses(Stream.of(new Address("New York", "NY", "10001"), new Address("Los Angeles", "CA", "90001"))
            .collect(Collectors.toSet()));
		
		userAggregate.handleUpdateUserCommand(updateUserCommand);
		
		
		
	}
	
}
