package organic.organic.dao.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import organic.organic.dao.ServiceResult;
import organic.organic.model.product.Product;
import organic.organic.model.user.Role;

@Service
public class RoleService {
	@Autowired
	RoleRepository roleRepository;

	public List<Role> findAll() {

		return (List<Role>) roleRepository.findAll();
	}

	public Role findById(int id) {
		Role role = roleRepository.findById(id).orElse(null);
		return role;
	}

	public String create(Role role) {
		String mess = "";
		try {
			roleRepository.save(role);
			mess = "OK";
		} catch (Exception e) {
			mess = "FAIL";
		}
		return mess;
	}

	public String update(Role role) {
		String mess = "";
		try {
			roleRepository.save(role);

			mess = "OK";
		} catch (Exception e) {
			mess = "FAIL";
		}
		return mess;
	}

	public String delete(int id) {
		String mess = "";
		try {
			roleRepository.deleteById(id);
			mess = "OK";
		} catch (Exception e) {
			mess = "FAIL";
		}
		return mess;
	}
}
