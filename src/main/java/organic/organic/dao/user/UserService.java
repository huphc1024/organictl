package organic.organic.dao.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import organic.organic.model.user.User;

@Service
public class UserService {
	@Autowired
	UserRepository userReponsitory;

	public List<User> findAll() {
		return (List<User>) userReponsitory.findAll();
	}

	public User findById(int id) {
		User user = userReponsitory.findById(id).orElse(null);
		return user;
	}

	public String create(User user) {
		String mess = "";
		try {
			userReponsitory.save(user);

			mess = "OK";
		} catch (Exception e) {
			mess = "FAIL";
		}
		return mess;
	}

	public String update(User user) {

		String mess = "";
		try {
			userReponsitory.save(user);

			mess = "OK";
		} catch (Exception e) {
			mess = "FAIL";
		}
		return mess;
	}

	public String delete(int id) {
		String mess = "";
		try {
			userReponsitory.deleteById(id);
			mess = "OK";
		} catch (Exception e) {
			mess = "FAIL";
		}
		return mess;
	}
}
