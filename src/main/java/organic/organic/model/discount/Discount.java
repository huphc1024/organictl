package organic.organic.model.discount;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_discount")
public class Discount {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;
	@Column(name = "quantity")
	private int quantity;
	@Column(name = "discount_number")
	private float discount_number;

	public Discount(int id, int quantity, float discount_number) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.discount_number = discount_number;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getDiscount_number() {
		return discount_number;
	}

	public void setDiscount_number(float discount_number) {
		this.discount_number = discount_number;
	}

	public Discount() {
		super();
		// TODO Auto-generated constructor stub
	}

}
