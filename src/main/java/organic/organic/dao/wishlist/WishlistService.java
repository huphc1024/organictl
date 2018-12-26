package organic.organic.dao.wishlist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import organic.organic.model.wishlist.Wishlist;

@Service
public class WishlistService {
	@Autowired
	WishlistRepository wishlistRepository;

	public List<Wishlist> findAll() {
		return (List<Wishlist>) wishlistRepository.findAll();
	}

	public List<Wishlist> findByIdUserWishlist(int id) {
		List<Wishlist> wishlist = wishlistRepository.findByIdUserWishlist(id);
		return wishlist;
	}

	public String create(Wishlist wishlist) {
		String mess = "";
		try {
			wishlistRepository.addWishProduct(wishlist);

			mess = "OK";
		} catch (Exception e) {
			mess = "FAIL";
		}
		return mess;
	}

	public String update(Wishlist wishlist) {
		String mess = "";
		try {
			wishlistRepository.save(wishlist);

			mess = "OK";
		} catch (Exception e) {
			mess = "FAIL";
		}
		return mess;

	}

	public String delete(int id) {
		String mess = "";
		try {
			wishlistRepository.deleteById(id);
			mess = "OK";
		} catch (Exception e) {
			mess = "FAIL";
		}
		return mess;

	}
}
