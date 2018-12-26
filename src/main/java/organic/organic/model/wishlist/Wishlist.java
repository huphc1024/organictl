package organic.organic.model.wishlist;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "wishlists")
public class Wishlist {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;
	@Column(name = "user_id")
	private int user_id;
	@Column(name = "product_id")
	private int product_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public Wishlist() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Wishlist(int id, int user_id, int product_id) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.product_id = product_id;
	}
	

	
}
