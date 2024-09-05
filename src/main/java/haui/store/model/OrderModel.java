package haui.store.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import haui.store.entity.Discount;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class OrderModel {
	@Id
	private String Id;
	private String name;
	private Long quantity;
	private Long total;
	private String date;
	private String status;
	private Discount discount;
	
	public OrderModel(String id, String name, Long quantity, Long total, String date, String status) {
		super();
		this.Id = id;
		this.name = name;
		this.quantity = quantity;
		this.total = total;
		this.date = date;
		this.status = status;
	}

	public String getId() {
		return Id;
	}

	public void setId(String orderID) {
		this.Id = orderID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Discount getDiscount() {
		return discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}
}
