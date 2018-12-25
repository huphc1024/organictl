package organic.organic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import organic.organic.dao.discount.DiscountService;
import organic.organic.model.discount.Discount;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@Controller
@RequestMapping("/api")
public class DiscountController {
	@Autowired
	private DiscountService discountService;

	/* ---------------- GET ALL ------------------------ */
	@GetMapping("/discounts")
	public @ResponseBody List<Discount> findAllDiscount() {
		return discountService.findAll();
	}

	/* ---------------- GET BY ID ------------------------ */
	@GetMapping("/discounts/{id}")
	public @ResponseBody Discount findById(@PathVariable int id) {
		return discountService.findById(id);
	}

	/* ---------------- CREATE NEW ------------------------ */
	@PostMapping("/discounts")
	public @ResponseBody String create(@RequestBody Discount discount) {
		return discountService.create(discount);
	}

	/* ---------------- UPDATE ------------------------ */
	@PutMapping("/discounts/{id}")
	public @ResponseBody String update(@RequestBody Discount discount, @PathVariable int id) {
		discount.setId(id);
		return discountService.update(discount);
	}

	@DeleteMapping("/discounts/{id}")
	public @ResponseBody String delete(@PathVariable int id) {
		return discountService.delete(id);
	}
}
