package organic.organic.model.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "price")
	private float price;
	@Column(name = "unit")
	private String unit;
	@Column(name = "stock")
	private int stock;
	@Column(name = "rating")
	private int rating;
	@Column(name = "buy")
	private int buy;
	@Column(name = "tbl_category_id")
	private int tbl_category_id;
	@Column(name = "sku")
	private String sku;

	@Column(name = "sname")
	private String sname;

	@Column(name = "description")
	private String description;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	/*
	 * @ManyToMany(fetch = FetchType.LAZY)
	 * 
	 * @JoinTable(name = "ref_shop_product", joinColumns = @JoinColumn(name =
	 * "tbl_product_id", referencedColumnName = "id"), inverseJoinColumns
	 * = @JoinColumn(name = "tbl_shop_id", referencedColumnName = "id"))
	 */

	/*
	 * private List<Shop> shops;
	 * 
	 * public List<Shop> getShops() { return shops; } public void
	 * setShops(List<Shop> shops) { this.shops = shops; }
	 */

	public int getTbl_category_id() {
		return tbl_category_id;
	}

	public void setTbl_category_id(int tbl_category_id) {
		this.tbl_category_id = tbl_category_id;
	}

	public int getId() {
		return id;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getBuy() {
		return buy;
	}

	public void setBuy(int buy) {
		this.buy = buy;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Product(int id, String name, float price, String unit, int stock, int rating, int buy, int tbl_category_id,
			String sku, String sname, String description) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.unit = unit;
		this.stock = stock;
		this.rating = rating;
		this.buy = buy;
		this.tbl_category_id = tbl_category_id;
		this.sku = sku;
		this.sname = sname;
		this.description = description;
	}

	public Product(int id, String name, float price, String unit, int stock, int rating, int buy, int tbl_category_id,
			String sku) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.unit = unit;
		this.stock = stock;
		this.rating = rating;
		this.buy = buy;
		this.tbl_category_id = tbl_category_id;
		this.sku = sku;

	}

}