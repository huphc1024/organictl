package organic.organic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import organic.organic.dao.review.ReviewService;
import organic.organic.model.review.Review;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@Controller
@RequestMapping("/api")
public class ReviewController {
	@Autowired
	private ReviewService reviewService;

	/* ---------------- GET ALL PRODUCT ------------------------ */
	@GetMapping("/product-reviews")
	public @ResponseBody List<Review> findAllProduct() {
		return reviewService.findAll();
	}

	/* ---------------- GET PRODUCT BY ID ------------------------ */
	@GetMapping("/product-reviews-products/{id}")
	public @ResponseBody List<Review> findByIdProduct(@PathVariable int id) {
		return reviewService.findByIdProductReview(id);
	}

	@GetMapping("/product-reviews-users/{id}")
	public @ResponseBody List<Review> findByIdUser(@PathVariable int id) {
		return reviewService.findByIdUserReview(id);
	}

	/* ---------------- CREATE NEW PRODUCT ------------------------ */
	@PostMapping("/product-reviews")
	public @ResponseBody String create(@RequestBody Review review) {
		return reviewService.create(review);
	}

	/* ---------------- UPDATE PRODUCT ------------------------ */
	@PutMapping(value = "/product-reviews/{id}", produces = "application/x-www-form-urlencode;charset=UTF-8")
	public @ResponseBody String update(@RequestBody Review review, @PathVariable int id) {
		review.setId(id);
		return reviewService.update(review);
	}

	/* ---------------- UPDATE PRODUCT ------------------------ */
	@DeleteMapping("/product-reviews/{id}")
	public @ResponseBody String delete(@PathVariable int id) {
		return reviewService.delete(id);
	}

}
