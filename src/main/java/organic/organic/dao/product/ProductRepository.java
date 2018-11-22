package organic.organic.dao.product;

import org.springframework.data.repository.CrudRepository;

import organic.organic.model.product.Product;


public interface ProductRepository  extends CrudRepository<Product, Integer> {

	
	
}