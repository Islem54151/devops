package tn.esprit.spring.control;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.IUserService;

@RestController
@RequestMapping("/user")
public class UserRestControl {

	@Autowired
	private IUserService userService;   // <-- Injection ici

	@GetMapping("/retrieve-all-users")
	public List<User> retrieveAllUsers() {
		return userService.retrieveAllUsers();
	}

	@GetMapping("/retrieve-user/{user-id}")
	public User retrieveUser(@PathVariable("user-id") Long userId) {
		return userService.retrieveUser(String.valueOf(userId));
	}

	@PostMapping("/add-user")
	public User addUser(@RequestBody User u) {
		return userService.addUser(u);
	}

	@DeleteMapping("/remove-user/{user-id}")
	public void removeUser(@PathVariable("user-id") Long userId) {
		userService.deleteUser(String.valueOf(userId));
	}

	@PutMapping("/modify-user")
	public User updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}
}
