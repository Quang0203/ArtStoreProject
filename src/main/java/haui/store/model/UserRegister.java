/**
 * @(#)UserRegister.java 2021/09/08.
 * 
 * Copyright(C) 2021 by PHOENIX TEAM.
 * 
 * Last_Update 2021/09/08.
 * Version 1.00.
 */
package haui.store.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class lam viec voi form register.html
 * 
 * @author khoa-ph
 * @version 1.00
 * 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegister {
	// Thong tin email
	private String email;

	// Thong tin ho va ten
	private String fullName;

	// Thong tin mat khau
	private String password;

	// Thong tin xac nhan mat khau
	private String confirmPassword;

	// Thong tin ma xac nhan
	private int code;

	// Thong tin xac nhan ma
	private String confirmCode;
	
	// Thong tin nhan thong bao
	private int subscribe;
	
	// Thong tin xac nhan dieu khoan
	private boolean confirmTerm;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getConfirmCode() {
		return confirmCode;
	}

	public void setConfirmCode(String confirmCode) {
		this.confirmCode = confirmCode;
	}

	public int getSubscribe() {
		return subscribe;
	}

	public void setSubscribe(int subscribe) {
		this.subscribe = subscribe;
	}

	public boolean isConfirmTerm() {
		return confirmTerm;
	}

	public void setConfirmTerm(boolean confirmTerm) {
		this.confirmTerm = confirmTerm;
	}
}
