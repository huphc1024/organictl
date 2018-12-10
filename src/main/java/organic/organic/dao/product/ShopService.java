package organic.organic.dao.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import organic.organic.model.product.Shop;

@Service
public class ShopService {
	@Autowired
	ShopRepository shopRepository;

	public List<Shop> findAll() {
		return (List<Shop>) shopRepository.findAll();
	}

	public Shop findById(int id) {
		Shop shop = shopRepository.findById(id).orElse(null);
		return shop;
	}

	public String create(Shop shop) {
		String mess = "";
		try {
			shopRepository.save(shop);

			mess = "OK";
		} catch (Exception e) {
			mess = "FAIL";
		}
		return mess;
	}

	public String update(Shop shop) {
		String mess = "";
		try {
			shopRepository.save(shop);

			mess = "OK";
		} catch (Exception e) {
			mess = "FAIL";
		}
		return mess;

	}

	public String delete(int id) {
		String mess = "";
		try {
			shopRepository.deleteById(id);
			mess = "OK";
		} catch (Exception e) {
			mess = "FAIL";
		}
		return mess;

	}
}
