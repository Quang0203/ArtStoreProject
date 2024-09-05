package haui.store.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import haui.store.entity.Product;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class BestSellerModel {
	@Id
	private Product product;
	private long sum;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public long getSum() {
		return sum;
	}

	public void setSum(long sum) {
		this.sum = sum;
	}
}
