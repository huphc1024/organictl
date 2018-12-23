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
		return (List<Product>) productRepository.fillAllProduct();
	}

	/*public Product findById(int id) {
		Product product = productRepository.findById(id).orElse(null);
		return product;
	}*/
	
	
	public Product findByIdProduct(int id) {
		Product product = productRepository.findByIdProduct(id);
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

	public List<Product> fillAllProductByIdCat(int id_cat) {

		return productRepository.fillAllProductByIdCat(id_cat);

	}

	public int fillIdParent(int id_cat) {

		return productRepository.fillIdParent(id_cat);

	}

	public List<Integer> fillIdByParentID(int id_cat) {

		return productRepository.fillIdByParentID(id_cat);

	}

}
