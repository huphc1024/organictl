package organic.organic.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
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
	@GetMapping("/products/{id}")
	public @ResponseBody Product findById(@PathVariable int id) {
		return productService.findById(id);
	}

	/* ---------------- CREATE NEW PRODUCT ------------------------ */
	@PostMapping("/products")
	public @ResponseBody String create(@RequestBody Product product) {

		return productService.create(product);
	}

	/* ---------------- UPDATE PRODUCT ------------------------ */
	@PutMapping("/products/{id}")
	public @ResponseBody String update(@RequestBody Product product, @PathVariable int id) {
		product.setId(id);
		return productService.update(product);
	}

	/* ---------------- UPDATE PRODUCT ------------------------ */
	@DeleteMapping("/products/{id}")
	public @ResponseBody String delete(@PathVariable int id) {
		return productService.delete(id);
	}

	@GetMapping("/categories/{id}")
	public @ResponseBody List<Product> fillAllProductByIdCat(@PathVariable int id) {
		List<Product> listProduct = new ArrayList<>();
		if (id == 1) {
			// gat all
			listProduct = productService.findAll();
		} else {
			listProduct = productService.fillAllProductByIdCat(id);
			List<Integer> listIdCat = productService.fillIdByParentID(id);		
			for (Integer i : listIdCat) {
				
				listProduct.addAll(productService.fillAllProductByIdCat(i));
				
			}
		}
		return listProduct;
	}
	/*
	 * @GetMapping("/categories/{id}") public @ResponseBody List<Product>
	 * fillCountProductByIdCat(@PathVariable int id) { if(id==0) {
	 * productService.findAll(); }else { int parent_id =[id]; if() } return
	 * productService.fillAllProductByIdCat(id); }
	 */

}
