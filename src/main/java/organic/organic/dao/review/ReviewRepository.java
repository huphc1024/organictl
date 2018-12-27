package organic.organic.dao.review;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import organic.organic.model.review.Review;


public interface ReviewRepository  extends CrudRepository<Review, Integer> {
	
	
	@Query(value = "SELECT * FROM reviews r inner join tbl_product p on p.id = r.tbl_product_id inner join tbl_user u on u.id = r.tbl_user_id where r.tbl_product_id =?1", nativeQuery = true)
	List<Review> findByIdProductReview(int id);
	
	@Query(value = "SELECT * FROM reviews r inner join tbl_product p on p.id = r.tbl_product_id inner join tbl_user u on u.id = r.tbl_user_id where r.tbl_user_id =?1", nativeQuery = true)
	List<Review> findByIdUsertReview(int id);
	
	
}