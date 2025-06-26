package tn.esprit.spring.services;

import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.services.IUserService;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

	private final UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<User> retrieveAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User addUser(User u) {
		return userRepository.save(u);
	}

	@Override
	public void deleteUser(String id) {
		userRepository.deleteById(Long.parseLong(id));
	}

	@Override
	public User updateUser(User u) {
		return userRepository.save(u);
	}

	@Override
	public User retrieveUser(String id) {
		return userRepository.findById(Long.parseLong(id)).orElse(null);
	}
}
