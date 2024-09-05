package haui.store.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class StatisticalTotalOrder {
	private long orderSuccess;
	private long orderCancel;
	private long orderWait;
	private long orderTransport;

	public StatisticalTotalOrder(long success, long cancel, long wait, long transport) {
		this.orderSuccess = orderSuccess;
		this.orderCancel = orderCancel;
		this.orderWait = orderWait;
		this.orderTransport = orderTransport;
	}

	public StatisticalTotalOrder() {

	}

//	public StatisticalTotalOrder() {
//	}
//
//	public StatisticalTotalOrder(long orderSuccess, long orderCancel, long orderWait, long orderTransport) {
//		this.orderSuccess = orderSuccess;
//		this.orderCancel = orderCancel;
//		this.orderWait = orderWait;
//		this.orderTransport = orderTransport;
//	}

	public long getOrderSuccess() {
		return orderSuccess;
	}

	public void setOrderSuccess(long orderSuccess) {
		this.orderSuccess = orderSuccess;
	}

	public long getOrderCancel() {
		return orderCancel;
	}

	public void setOrderCancel(long orderCancel) {
		this.orderCancel = orderCancel;
	}

	public long getOrderWait() {
		return orderWait;
	}

	public void setOrderWait(long orderWait) {
		this.orderWait = orderWait;
	}

	public long getOrderTransport() {
		return orderTransport;
	}

	public void setOrderTransport(long orderTransport) {
		this.orderTransport = orderTransport;
	}
}
