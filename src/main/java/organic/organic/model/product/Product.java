package organic.organic.model.product;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import organic.organic.model.user.Role;

@Entity
@Table(name = "tbl_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", updatable = false, nullable = false)
    private int id;
    @Column(name = "name")
    private  String name;
    @Column(name = "price")
    private float price;
    @Column(name = "unit")
    private String unit;
    @Column(name = "stock")
    private int stock;
    @Column(name = "sku")
    private String sku;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	 @ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(name = "ref_shop_product", joinColumns = @JoinColumn(name = "tbl_product_id", referencedColumnName = "id"),
	            inverseJoinColumns = @JoinColumn(name = "tbl_shop_id", referencedColumnName = "id"))
	 
	private List<Shop> shops;
	  
	public List<Shop> getShops() {
		return shops;
	}
	public void setShops(List<Shop> shops) {
		this.shops = shops;
	}
	public int getId() {
		return id;
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
	
	public Product(int id, String name, float price, String unit, int stock, String sku) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.unit = unit;
		this.stock = stock;
		this.sku = sku;
		
	}
    
    
    
}