package organic.organic.model.review;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	@Column(name = "rproduct")
	private int rproduct;
	@Column(name = "ruser")
	private int ruser;

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

	public int getRproduct() {
		return rproduct;
	}

	public void setRproduct(int rproduct) {
		this.rproduct = rproduct;
	}

	public int getRuser() {
		return ruser;
	}

	public void setRuser(int ruser) {
		this.ruser = ruser;
	}

	public Review(int id, String comment, int rating, int rproduct, int ruser) {
		super();
		this.id = id;
		this.comment = comment;
		this.rating = rating;
		this.rproduct = rproduct;
		this.ruser = ruser;
	}

	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}

}