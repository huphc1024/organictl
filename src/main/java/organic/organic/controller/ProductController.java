package organic.organic.controller;

import java.util.ArrayList;
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
	@GetMapping("/products/{id}")
	public @ResponseBody Product findById(@PathVariable int id) {
		return productService.findByIdProduct(id);
	}

	/* ---------------- CREATE NEW PRODUCT ------------------------ */
	@PostMapping("/products")
	public @ResponseBody String create(@RequestBody Product product) {

		return productService.create(product);
	}
	
	/*-------------------PRODUCT DEAL--------------*/
	@GetMapping("/productdeal")
	public @ResponseBody Product productDeal() {

		return productService.findProductDeal();
	}

	/* ---------------- UPDATE PRODUCT ------------------------ */
	@PutMapping(value="/products/{id}" , produces="application/x-www-form-urlencode;charset=UTF-8")
	public @ResponseBody String update(@RequestBody Product product, @PathVariable int id) {
		product.setId(id);
		String name = product.getName();
		System.out.println(name);
		float price = product.getPrice();
		String unit = product.getUnit();
		int stock = product.getStock();
		int rating = product.getRating();
		int buy = product.getBuy();
		int tbl_category_id = product.getTbl_category_id();
		String sku = product.getSku();
		Product products = new Product(id, name, price, unit, stock, rating, buy, tbl_category_id, sku);
		return productService.update(products);
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
