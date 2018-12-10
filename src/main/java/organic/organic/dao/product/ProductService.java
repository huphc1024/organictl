package organic.organic.dao.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import organic.organic.model.product.Product;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;

	public List<Product> findAll() {
		return (List<Product>) productRepository.findAll();
	}

	public Product findById(int id) {
		Product product = productRepository.findById(id).orElse(null);
		return product;
	}

	public String create(Product product) {
		String mess = "";
		try {
			productRepository.save(product);

			mess = "OK";
		} catch (Exception e) {
			mess = "FAIL";
		}
		return mess;
	}

	public String update(Product product) {
		String mess = "";
		try {
			productRepository.save(product);

			mess = "OK";
		} catch (Exception e) {
			mess = "FAIL";
		}
		return mess;
	}

	public String delete(int id) {
		String mess = "";
		try {
			productRepository.deleteById(id);
			mess = "OK";
		} catch (Exception e) {
			mess = "FAIL";
		}
		return mess;
	}
}
