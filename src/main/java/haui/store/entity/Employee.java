/**
 * @(#)Employee.java 2021/09/10.
 * 
 * Copyright(C) 2021 by PHOENIX TEAM.
 * 
 * Last_Update 2021/09/10.
 * Version 1.00.
 */
package haui.store.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class chua thong tin Employee
 * 
 * @author khoa-ph
 * @version 1.00
 */
@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Employees")
public class Employee implements Serializable{
	// Thong tin employee id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	// Thong tin phong ban
	private String department;
	
	// Thong tin vi tri
	private String position;

	// Thong tin so dien thoai
	private String phone;
	
	// Thong tin ngay bat dau lam viec
	private String Startday;
	
	// Thong tin luong
	private int salary;
	
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
	
	// Thong tin anh dai dien
	private String image;
	
	// Thong tin nguoi dung
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "User_Id")
	User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getStartday() {
		return Startday;
	}

	public void setStartday(String startday) {
		Startday = startday;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
