package organic.organic.dao.product;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import organic.organic.model.product.Product;


public interface ProductRepository  extends CrudRepository<Product, Integer> {

	
	@Query(value = "SELECT id,name,price,unit,stock,rating,buy,sku,tbl_category_id FROM tbl_product", nativeQuery = true)
	List<Product> fillAllProduct ();
	
	@Query(value = "SELECT * FROM tbl_product WHERE tbl_category_id =?1", nativeQuery = true)
	List<Product> fillAllProductByIdCat (int id_cat);
	
	@Query(value = "SELECT c.parent_id FROM tbl_category c where c.id = ?1", nativeQuery = true)
	int fillIdParent (int id_cat);
	
	@Query(value = "SELECT c.id FROM tbl_category c where c.parent_id = ?1", nativeQuery = true)
	List<Integer> fillIdByParentID (int id_cat);
}