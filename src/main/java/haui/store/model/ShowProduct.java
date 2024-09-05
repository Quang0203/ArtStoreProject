package haui.store.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import haui.store.entity.Product;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShowProduct {
	private Product product;
	private int totalStar;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getTotalStar() {
		return totalStar;
	}

	public void setTotalStar(int totalStar) {
		this.totalStar = totalStar;
	}


}
