package organic.organic.dao.wishlist;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import organic.organic.model.review.Review;
import organic.organic.model.wishlist.Wishlist;


public interface WishlistRepository  extends CrudRepository<Wishlist, Integer> {
	
	
	
	@Query(value = "SELECT * FROM wishlists where user_id =?1", nativeQuery = true)
	List<Wishlist> findByIdUserWishlist(int id);
	
	
}