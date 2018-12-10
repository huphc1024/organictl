package organic.organic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import organic.organic.dao.product.ProductService;
import organic.organic.model.product.Product;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@Controller
@RequestMapping("/api")
public class ProductController {
	@Autowired
	private ProductService productService;

	/* ---------------- GET ALL PRODUCT ------------------------ */
	@GetMapping("/products")
	public @ResponseBody List<Product> findAllProduct() {
		return productService.findAll();
	}

	/* ---------------- GET PRODUCT BY ID ------------------------ */
	@GetMapping("/product/{id}")
	public @ResponseBody Product findById(@PathVariable int id) {
		return productService.findById(id);
	}

	/* ---------------- CREATE NEW PRODUCT ------------------------ */
	@PostMapping("/product")
	public @ResponseBody String create(@RequestBody Product product) {

		return productService.create(product);
	}

	/* ---------------- UPDATE PRODUCT ------------------------ */
	@PutMapping("/product/{id}")
	public @ResponseBody String update(@RequestBody Product product, @PathVariable int id) {
		product.setId(id);
		return productService.update(product);
	}

	/* ---------------- UPDATE PRODUCT ------------------------ */
	@DeleteMapping("/product/{id}")
	public @ResponseBody String delete(@PathVariable int id) {
		return productService.delete(id);
	}
}
