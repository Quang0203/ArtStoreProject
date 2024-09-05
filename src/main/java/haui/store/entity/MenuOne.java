/**
 * @(#)MenuOne.java 2021/09/22.
 * 
 * Copyright(C) 2021 by PHOENIX TEAM.
 * 
 * Last_Update 2021/09/22.
 * Version 1.00.
 */
package haui.store.entity;

import java.io.Serializable;
import java.util.List;

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
 * Class chua thong tin MenuOne
 * 
 * @author tuan-pm
 * @version 1.00
 */
@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Menuone")
public class MenuOne implements Serializable {
	// Thong tin menu id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	// Thong tin ten menu
	private String name;

	// Thong tin ten dung de tim kiem
	private String Namesearch;

	// Thong tin danh muc
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Cate_Id")
	private Category category;

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

	// Danh sach User Role
	@JsonIgnore
	@OneToMany(mappedBy = "menuOne")
	List<MenuTwo> listMenuTwo;

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

	public String getNamesearch() {
		return Namesearch;
	}

	public void setNamesearch(String namesearch) {
		Namesearch = namesearch;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
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

	public List<MenuTwo> getListMenuTwo() {
		return listMenuTwo;
	}

	public void setListMenuTwo(List<MenuTwo> listMenuTwo) {
		this.listMenuTwo = listMenuTwo;
	}
}
