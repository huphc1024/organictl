package organic.organic.model.review;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import organic.organic.model.product.Product;
import organic.organic.model.user.User;

@Entity
@Table(name = "reviews")
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;
	@Column(name = "comment")
	private String comment;
	@Column(name = "rating")
	private int rating;
	@ManyToOne
	@JoinColumn(name = "tbl_product_id")
	private Product tbl_product_id;
	@ManyToOne
	@JoinColumn(name = "tbl_user_id")
	private User tbl_user_id;
	@Column(name = "created_at")
	private String created_at;

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Review(int id, String comment, int rating, Product tbl_product_id, User tbl_user_id, String created_at) {
		super();
		this.id = id;
		this.comment = comment;
		this.rating = rating;
		this.tbl_product_id = tbl_product_id;
		this.tbl_user_id = tbl_user_id;
		this.created_at = created_at;
	}

	public Product getTbl_product_id() {
		return tbl_product_id;
	}

	public void setTbl_product_id(Product tbl_product_id) {
		this.tbl_product_id = tbl_product_id;
	}

	public User getTbl_user_id() {
		return tbl_user_id;
	}

	public void setTbl_user_id(User tbl_user_id) {
		this.tbl_user_id = tbl_user_id;
	}

	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}

}
