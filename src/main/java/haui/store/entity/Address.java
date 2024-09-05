package haui.store.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Address")
public class Address implements Serializable{
	// Thong tin address id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	// Thong tin ho va ten
	private String Fullname;
	
	// Thong tin so dien thoai
	private String phone;
	
	// Thong tin tinh
	private String province;
	
	// Thong tin huyen
	private String district;
	
	// Thong tin xa
	private String ward;
	
	// Thong tin dia chi chi tiet
	private String detail;
	
	// Thong tin nguoi dung
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "User_Id")
	User user;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "address")
	List<Order> listOrder;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullname() {
		return Fullname;
	}

	public void setFullname(String fullname) {
		Fullname = fullname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getWard() {
		return ward;
	}

	public void setWard(String ward) {
		this.ward = ward;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Order> getListOrder() {
		return listOrder;
	}

	public void setListOrder(List<Order> listOrder) {
		this.listOrder = listOrder;
	}
}
