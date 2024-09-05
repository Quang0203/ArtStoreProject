/**
 * @(#)UserRole.java 2021/08/19.
 * 
 * Copyright(C) 2021 by PHOENIX FIVE.
 * 
 * Last_Update 2021/08/19.
 * Version 1.00.
 */
package haui.store.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

/**
 * Class chua thong tin User Role
 * 
 * @author Admin
 * @version 1.00
 */
@Data
//@NoArgsConstructor
//@AllArgsConstructor
@SuppressWarnings("serial")
@Entity
@Table(name="User_Role")
public class UserRole implements Serializable{
	
	// Thong tin User Role Id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	//Thong tin User
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="User_Id")
	private User user;
	
	// Thong tin Role
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="Role_Id")
	private Role role;

	/**
	 * Ham khoi tao user role
	 *
	 * @param user tin user
	 * @param role tin role
	 */
	public UserRole(User user, Role role) {
		this.user = user;
		this.role = role;
	}

	public UserRole() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
