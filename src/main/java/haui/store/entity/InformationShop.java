/**
 * @(#)Category.java 2021/09/28.
 * 
 * Copyright(C) 2021 by PHOENIX TEAM.
 * 
 * Last_Update 2021/09/28.
 * Version 1.00.
 */
package haui.store.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class chua thong tin cua hang
 * 
 * @author tuan-pm
 * @version 1.00
 */
@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Informationshop")
public class InformationShop implements Serializable {
	// Thong tin category id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	// Thong tin ten shop
	private String name;
	
	// Thong tin trang thai kich hoat
	private boolean active;
	
	// Thong tin thoi gian mo cua
	private String Timeopen;

	// Thong tin logo
	private String logo;

	// Thong tin so dien thoai
	private String phone;

	// Thong tin tax
	private String fax;

	// Thong tin email
	private String email;

	// Thong tin logo footer
	private String Logofooter;

	// Thong tin dia chi shop
	private String address;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getTimeopen() {
		return Timeopen;
	}

	public void setTimeopen(String timeopen) {
		Timeopen = timeopen;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogofooter() {
		return Logofooter;
	}

	public void setLogofooter(String logofooter) {
		Logofooter = logofooter;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
}
