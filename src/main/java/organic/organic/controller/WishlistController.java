package organic.organic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import organic.organic.dao.wishlist.WishlistService;
import organic.organic.model.wishlist.Wishlist;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@Controller
@RequestMapping("/api")
public class WishlistController {
	@Autowired
	private WishlistService wishlistService ;

	/* ---------------- GET ALL ------------------------ */
	@GetMapping("/wishlists")
	public @ResponseBody List<Wishlist> findAllDiscount() {
		return wishlistService.findAll();
	}

	/* ---------------- GET BY ID USER ------------------------ */
	@GetMapping("/wishlists-users/{id}")
	public @ResponseBody List<Wishlist> findById(@PathVariable int id) {
		return wishlistService.findByIdUserWishlist(id);
	}

	/* ---------------- CREATE NEW ------------------------ */
	@PostMapping("/wishlists")
	public @ResponseBody String create(@RequestBody int id) {
		return wishlistService.create(id);
	}

	/* ---------------- DELETE ------------------------ */


	@DeleteMapping("/wishlists/{id}")
	public @ResponseBody String delete(@PathVariable int id) {
		return wishlistService.delete(id);
	}
}
