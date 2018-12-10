package organic.organic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import organic.organic.dao.product.ShopService;

import organic.organic.model.product.Shop;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@Controller
@RequestMapping("/api")
public class ShopController {
	@Autowired
	private ShopService shopService;

	/* ---------------- GET ALL Shop ------------------------ */
	@GetMapping("/shops")
	public List<Shop> findAllShop() {
		return shopService.findAll();
	}

	/* ---------------- GET Shop BY ID ------------------------ */
	@GetMapping("/shop/{id}")
	public Shop findById(@PathVariable int id) {
		return shopService.findById(id);
	}

	/* ---------------- CREATE NEW Shop ------------------------ */
	@PostMapping("/shop")
	public String create(@RequestBody Shop shop) {
		return shopService.create(shop);
	}

	/* ---------------- UPDATE Shop ------------------------ */
	@PutMapping("/shop/{id}")
	public String update(@RequestBody Shop shop, @PathVariable int id) {
		shop.setId(id);
		return shopService.update(shop);
	}

	@DeleteMapping("/shop/{id}")
	public String delete(@PathVariable int id) {
		return shopService.delete(id);
	}
}
