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

/**
 * Class chua thong tin User
 * 
 * @author khoa-ph
 * @version 1.00
 */
@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Products")
public class Product implements Serializable{
	// Thong tin id san pham
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	// Thong tin ma san pham
	private String code;

	// Thong tin ten san pham
	private String name;

	// Thong tin gia san pham
	private int price;

	// Thong tin so luong san pham
	private int quantity;

	// Thong tin so luot xem
	private int views;

	// Mo ta san pham
	private String description;

	// Thong tin cac thong so
	private String specification;

	// Thong tin hinh anh 1
	private String image1;

	// Thong tin hinh anh 2
	private String image2;

	// Thong tin hinh anh 3
	private String image3;

	// Thong tin hinh anh 4
	private String image4;

	// Thong tin hinh anh 5
	private String image5;

	// Hien thi san pham hay khong
	private boolean active;

	private Integer Menu1_Id;

	private Integer Menu2_Id;
	
	// Thong tin gia khuyen mai
	private int sales;
	
	// Hien thi ten dung de tim kiem
	private String Namesearch;
	
	// Thong tin ngay tao
	private String Createday;

	// Thong tin ma nguoi tao
	private int Personcreate;

	// Thong tin ngay xoa
	private String Deleteday;

	// Thong tin nguoi xoa
	private int Persondelete;

	// Thong tin ngay cap nhat
	private String Updateday;

	// Thong tin ma nguoi cap nhat
	private int Personupdate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public String getImage1() {
		return image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	public String getImage2() {
		return image2;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}

	public String getImage3() {
		return image3;
	}

	public void setImage3(String image3) {
		this.image3 = image3;
	}

	public String getImage4() {
		return image4;
	}

	public void setImage4(String image4) {
		this.image4 = image4;
	}

	public String getImage5() {
		return image5;
	}

	public void setImage5(String image5) {
		this.image5 = image5;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Integer getMenu1_Id() {
		return Menu1_Id;
	}

	public void setMenu1_Id(Integer menu1_Id) {
		Menu1_Id = menu1_Id;
	}

	public Integer getMenu2_Id() {
		return Menu2_Id;
	}

	public void setMenu2_Id(Integer menu2_Id) {
		Menu2_Id = menu2_Id;
	}

	public int getSales() {
		return sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}

	public String getNamesearch() {
		return Namesearch;
	}

	public void setNamesearch(String namesearch) {
		Namesearch = namesearch;
	}

	public String getCreateday() {
		return Createday;
	}

	public void setCreateday(String createday) {
		Createday = createday;
	}

	public int getPersoncreate() {
		return Personcreate;
	}

	public void setPersoncreate(int personcreate) {
		Personcreate = personcreate;
	}

	public String getDeleteday() {
		return Deleteday;
	}

	public void setDeleteday(String deleteday) {
		Deleteday = deleteday;
	}

	public int getPersondelete() {
		return Persondelete;
	}

	public void setPersondelete(int persondelete) {
		Persondelete = persondelete;
	}

	public String getUpdateday() {
		return Updateday;
	}

	public void setUpdateday(String updateday) {
		Updateday = updateday;
	}

	public int getPersonupdate() {
		return Personupdate;
	}

	public void setPersonupdate(int personupdate) {
		Personupdate = personupdate;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Order> getListOrder() {
		return listOrder;
	}

	public void setListOrder(List<Order> listOrder) {
		this.listOrder = listOrder;
	}

	public List<Favorite> getListFavorite() {
		return listFavorite;
	}

	public void setListFavorite(List<Favorite> listFavorite) {
		this.listFavorite = listFavorite;
	}

	public List<Comment> getListComment() {
		return listComment;
	}

	public void setListComment(List<Comment> listComment) {
		this.listComment = listComment;
	}

	// Thong tin nha san xuat
	@ManyToOne
	@JoinColumn(name = "Manu_Id")
	Manufacturer manufacturer;

	// Thong tin danh muc
	@ManyToOne
	@JoinColumn(name = "Cate_Id")
	Category category;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
	List<Order> listOrder;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
	List<Favorite> listFavorite;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
	List<Comment> listComment;


}
