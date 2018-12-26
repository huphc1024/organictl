package organic.organic.dao.wishlist;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import organic.organic.model.wishlist.Wishlist;


public interface WishlistRepository  extends CrudRepository<Wishlist, Integer> {
	
	
	
	@Query(value = "SELECT * FROM wishlists where user_id =?1", nativeQuery = true)
	List<Wishlist> findByIdUserWishlist(int id);
	
//	@Query(value = "INSERT INTO wishlists(product_id, user_id) VALUE(?1, ?2)", nativeQuery = true)
//	List<Wishlist> addWishProduct(Wishlist wishlist);
	/// ???
	
}