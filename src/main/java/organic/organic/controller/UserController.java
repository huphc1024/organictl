package organic.organic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import organic.organic.dao.user.UserService;
import organic.organic.model.user.User;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@Controller
@RequestMapping("/api")
public class UserController {
	@Autowired
	private UserService userService;

	/* ---------------- GET ALL USER ------------------------ */
	@GetMapping("/users")
	public @ResponseBody List<User> findAllCustomer() {
		return userService.findAll();
	}

	/* ---------------- GET USER BY ID ------------------------ */
	@GetMapping("/user/{id}")
	public @ResponseBody User findById(@PathVariable int id) {
		return userService.findById(id);
	}

	/* ---------------- CREATE NEW USER ------------------------ */
	@PostMapping("/user")
	public @ResponseBody String create(@RequestBody User user) {
		return userService.create(user);
	}

	/* ---------------- UPDATE USER ------------------------ */
	@PutMapping("/user/{id}")
	public @ResponseBody String update(@RequestBody User user, @PathVariable int id) {
		user.setId(id);
		return userService.update(user);
	}

	@DeleteMapping("/user/{id}")
	public @ResponseBody String delete(@PathVariable int id) {
		return userService.delete(id);
	}
}
