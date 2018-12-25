package organic.organic.dao.discount;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import organic.organic.model.discount.Discount;

@Service
public class DiscountService {
	@Autowired
	DiscountRepository discountRepository;

	public List<Discount> findAll() {
		return (List<Discount>) discountRepository.findAll();
	}

	public Discount findById(int id) {
		Discount discount = discountRepository.findById(id).orElse(null);
		return discount;
	}

	public String create(Discount discount) {
		String mess = "";
		try {
			discountRepository.save(discount);

			mess = "OK";
		} catch (Exception e) {
			mess = "FAIL";
		}
		return mess;
	}

	public String update(Discount discount) {
		String mess = "";
		try {
			discountRepository.save(discount);

			mess = "OK";
		} catch (Exception e) {
			mess = "FAIL";
		}
		return mess;

	}

	public String delete(int id) {
		String mess = "";
		try {
			discountRepository.deleteById(id);
			mess = "OK";
		} catch (Exception e) {
			mess = "FAIL";
		}
		return mess;

	}
}
