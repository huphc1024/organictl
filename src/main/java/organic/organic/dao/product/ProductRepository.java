package organic.organic.dao.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import organic.organic.model.product.Product;


public interface ProductRepository  extends JpaRepository<Product, Integer> {

	
	@Query(value = "SELECT id,name,price,unit,stock,rating,buy,sku,tbl_category_id,sname,description FROM tbl_product", nativeQuery = true)
	List<Product> fillAllProduct ();
	
	@Query(value = "SELECT * FROM tbl_product WHERE tbl_category_id =?1", nativeQuery = true)
	List<Product> fillAllProductByIdCat (int id_cat);
	
	@Query(value = "SELECT c.parent_id FROM tbl_category c where c.id = ?1", nativeQuery = true)
	int fillIdParent (int id_cat);
	
	@Query(value = "SELECT c.id FROM tbl_category c where c.parent_id = ?1", nativeQuery = true)
	List<Integer> fillIdByParentID (int id_cat);
	
	@Query(value = "SELECT p.id, p.name , p.price, p.unit,p.buy, p.rating, p.tbl_category_id,p.stock, p.sku, s.name as sname , s.description as description FROM ref_shop_product r inner join tbl_product p on p.id = r.tbl_product_id inner join tbl_shop s on s.id = r.tbl_shop_id where p.id =?1", nativeQuery = true)
	Product findByIdProduct(int id);
	
	@Query(value = "SELECT * FROM tbl_product WHERE buy = (SELECT MAX(buy) FROM tbl_product) LIMIT 1", nativeQuery = true)
	Product findProductDeal();
	
}