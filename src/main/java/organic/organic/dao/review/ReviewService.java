package organic.organic.dao.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import organic.organic.model.review.Review;

@Service
public class ReviewService {
	@Autowired
	ReviewRepository reviewRepository;

	public List<Review> findAll() {
		return (List<Review>) reviewRepository.findAll();
	}

	public List<Review> findByIdProductReview(int id) {
		List<Review> review = reviewRepository.findByIdProductReview(id);
		return review;
	}

	public List<Review> findByIdUserReview(int id) {
		List<Review> review = reviewRepository.findByIdUsertReview(id);
		return review;
	}

	public String create(Review review) {
		String mess = "";
		try {
			reviewRepository.save(review);

			mess = "OK";
		} catch (Exception e) {
			mess = "FAIL";
		}
		return mess;
	}

	public String update(Review review) {
		String mess = "";
		try {
			reviewRepository.save(review);

			mess = "OK";
		} catch (Exception e) {
			mess = "FAIL";
		}
		return mess;

	}

	public String delete(int id) {
		String mess = "";
		try {
			reviewRepository.deleteById(id);
			mess = "OK";
		} catch (Exception e) {
			mess = "FAIL";
		}
		return mess;

	}
}
