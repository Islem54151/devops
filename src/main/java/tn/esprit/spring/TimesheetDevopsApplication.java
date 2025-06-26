package tn.esprit.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class TimesheetDevopsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimesheetDevopsApplication.class, args);
	}

    @Service
    public static class userServiceImpl {

        private final UserRepository userRepository;

        // Injection via constructeur
        public userServiceImpl(UserRepository userRepository) {
            this.userRepository = userRepository;
        }

        public User addUser(User user) {
            return userRepository.save(user);
        }

        public User updateUser(User user) {
            return userRepository.save(user);
        }

        public User retrieveUser(String userId) {
            Long id = Long.parseLong(userId);
            Optional<User> user = userRepository.findById(id);
            return user.orElse(null);
        }

        public List<User> retrieveAllUsers() {
            return userRepository.findAll();
        }

        public void deleteUser(String userId) {
            Long id = Long.parseLong(userId);
            userRepository.deleteById(id);
        }
    }
}
