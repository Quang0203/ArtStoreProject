package haui.store.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import haui.store.entity.Product;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CartModel {
	private int id;
	private Product product;
//	private String name;
//	private String image;
	private int quality;
//	private int discount = 0;
//	private int price;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuality() {
		return quality;
	}

	public void setQuality(int quality) {
		this.quality = quality;
	}
}
