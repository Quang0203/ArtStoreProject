/**
 * @(#)UserRoleServiceImpl.java 2021/09/07.
 * 
 * Copyright(C) 2021 by PHOENIX TEAM.
 * 
 * Last_Update 2021/09/07.
 * Version 1.00.
 */
package haui.store.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import haui.store.dao.EmployeeDao;
import haui.store.dao.UserDao;
import haui.store.dao.UserRoleDao;
import haui.store.entity.Employee;
import haui.store.entity.User;
import haui.store.entity.UserRole;
import haui.store.service.UserRoleService;

/**
 * Class trien khai theo interface UserRoleService, Thao tac voi Class
 * UserRoleDao de thuc hien cac tac vu tuong ung
 * 
 * @author KHOA-PH
 * @version 1.00
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {
	// Thong tin user role dao
	@Autowired
	UserRoleDao userRoleDao;

	@Autowired
	UserDao userDao;

	@Autowired
	EmployeeDao employeeDao;

	/**
	 * Luu user role vao database
	 * 
	 * @param thong tin user role
	 */
	@Override
	public void save(UserRole userRole) {
		userRoleDao.save(userRole);
	}

	/**
	 * Tim kiem tat ca entity trong user role
	 * 
	 * @param thong tin user role
	 */
	@Override
	public List<UserRole> findAll() {
		return userRoleDao.findAll();
	}

	/**
	 * Tim kiem tat cac entity trong user role co role la admin hoac director
	 */
	@Override
	public List<UserRole> findAllAdminOrDirector() {
		return userRoleDao.findAllAdminOrDirector();
	}

	@Override
	public void delete(Integer id) {
		// Xoa user
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = ((UserDetails)principal).getUsername();
		User temp = userDao.findUserByEmail(username);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		User user = userDao.findById(id).get();
		
		if(!temp.getEmail().equals(user.getEmail())) {
			user.setDeleteday(timestamp.toString());
			user.setPersondelete(temp.getId());
			userDao.save(user);
			
			// Xoa employee
			List<Employee> listEmployee = user.getListEmployee();
			for(Employee e: listEmployee) {
				e.setDeleteday(timestamp.toString());
				e.setPersondelete(temp.getId());
				employeeDao.save(e);
			}
		}	
		
		else {
			throw new RuntimeException();
		}
	}

}
