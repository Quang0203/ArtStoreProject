/**
 * @(#)RoleService.java 2021/09/10.
 * 
 * Copyright(C) 2021 by PHOENIX TEAM.
 * 
 * Last_Update 2021/09/10.
 * Version 1.00.
 */
package haui.store.service;

import java.util.List;

import haui.store.model.EmployeeModel;
import haui.store.entity.Employee;

/**
 * Class cung cap cac dich vu thao tac voi table Employee trong database
 * 
 * @author khoa-ph
 * @version 1.00
 */
public interface EmployeeService {

	List<EmployeeModel> getListEmployee();

	void save(Employee employee);
	
}
