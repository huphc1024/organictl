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
	public @ResponseBody List<Shop> findAllShop() {
		return shopService.findAll();
	}

	/* ---------------- GET Shop BY ID ------------------------ */
	@GetMapping("/shops/{id}")
	public @ResponseBody Shop findById(@PathVariable int id) {
		return shopService.findById(id);
	}

	/* ---------------- CREATE NEW Shop ------------------------ */
	@PostMapping("/shops")
	public @ResponseBody String create(@RequestBody Shop shop) {
		return shopService.create(shop);
	}

	/* ---------------- UPDATE Shop ------------------------ */
	@PutMapping("/shops/{id}")
	public @ResponseBody String update(@RequestBody Shop shop, @PathVariable int id) {
		shop.setId(id);
		return shopService.update(shop);
	}

	@DeleteMapping("/shops/{id}")
	public @ResponseBody String delete(@PathVariable int id) {
		return shopService.delete(id);
	}
}
