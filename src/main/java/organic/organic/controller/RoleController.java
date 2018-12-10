package organic.organic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import organic.organic.dao.user.RoleService;
import organic.organic.model.user.Role;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@Controller
@RequestMapping("/api")
public class RoleController {
	@Autowired
	private  RoleService userService;

	/* ---------------- GET ALL ROLE ------------------------ */
	@GetMapping("/roles")
	public @ResponseBody List<Role> findAllRole() {
		return userService.findAll();
	}

	/* ---------------- GET ROLE BY ID ------------------------ */
	@GetMapping("/role/{id}")
	public @ResponseBody Role findById(@PathVariable int id) {
		return userService.findById(id);
	}

	/* ---------------- CREATE NEW ROLE ------------------------ */
	@PostMapping("/role")
	public @ResponseBody String create(@RequestBody Role userRole) {
		return userService.create(userRole);
	}

	/* ---------------- UPDATE ROLE ------------------------ */
	@PutMapping("/role/{id}")
	public @ResponseBody String update(@RequestBody Role userRole, @PathVariable int id) {
		userRole.setId(id);
		return userService.update(userRole);
	}

	@DeleteMapping("/role/{id}")
	public @ResponseBody String delete(@PathVariable int id) {
		return userService.delete(id);
	}
}
