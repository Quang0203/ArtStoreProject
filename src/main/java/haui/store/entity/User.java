/**
 * @(#)User.java 2021/09/08.
 * 
 * Copyright(C) 2021 by PHOENIX TEAM.
 * 
 * Last_Update 2021/09/08.
 * Version 1.00.
 */
package haui.store.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
@Table(name = "Users")
@Getter
@Setter
public class User implements Serializable {
	// Thong tin user id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	// Thong tin email
	private String email;

	// Thong tin password
	private String password;

	// Thong tin fullname
	private String Fullname;

	// Thong tin gioi tinh
	private int sex;

	// Thong tin ngay sinh nhat
	private String birthday;

	// Thong tin dang ky nhan ban tin
	private int subscribe;

	// Thong tin ngay tao
	private String Createday;

	// Thong tin ngay xoa
	private String Deleteday;

	// Thong tin nguoi xoa
	private int Persondelete;

	// Danh sach User Role
	@JsonIgnore
	@OneToMany(mappedBy = "user")
	List<UserRole> listUserRole;

	// Danh sach Employee
	// @JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	List<Employee> listEmployee;
	
	// Danh sach dia chi
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	List<Address> listAddress;

	// Danh sach yeu thich
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	List<Favorite> listFavorite;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String fullname) {
        Fullname = fullname;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(int subscribe) {
        this.subscribe = subscribe;
    }

    public String getCreateday() {
        return Createday;
    }

    public void setCreateday(String createday) {
        Createday = createday;
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

    public List<UserRole> getListUserRole() {
        return listUserRole;
    }

    public void setListUserRole(List<UserRole> listUserRole) {
        this.listUserRole = listUserRole;
    }

    public List<Employee> getListEmployee() {
        return listEmployee;
    }

    public void setListEmployee(List<Employee> listEmployee) {
        this.listEmployee = listEmployee;
    }

    public List<Address> getListAddress() {
        return listAddress;
    }

    public void setListAddress(List<Address> listAddress) {
        this.listAddress = listAddress;
    }

    public List<Favorite> getListFavorite() {
        return listFavorite;
    }

    public void setListFavorite(List<Favorite> listFavorite) {
        this.listFavorite = listFavorite;
    }
}
