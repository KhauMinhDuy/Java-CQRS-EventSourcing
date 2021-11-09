package com.khauminhduy.cqrs.aggregates;

import com.khauminhduy.cqrs.command.CreateUserCommand;
import com.khauminhduy.cqrs.command.UpdateUserCommand;
import com.khauminhduy.cqrs.repository.UserWriteRepository;
import com.khauminhduy.domain.User;

public class UserAggregate {

	private UserWriteRepository writeRepository;
	
	public UserAggregate(UserWriteRepository userWriteRepository) {
		this.writeRepository = userWriteRepository;
	}
	
	public User handleCreateUserCommand(CreateUserCommand userCommand) {
		User user = new User();
		user.setUserId(userCommand.getUserId());
		user.setFirstName(userCommand.getFirstName());
		user.setLastName(userCommand.getLastName());
		
		writeRepository.addUser(user.getUserId(), user);
		return user;
	}
	
	public User handleUpdateUserCommand(UpdateUserCommand command) {
		User user = writeRepository.getUser(command.getUserId());
		user.setContacts(command.getContacts());
		user.setAddresses(command.getAddresses());
		
		writeRepository.addUser(user.getUserId(), user);
		return user;
	}
	
}
