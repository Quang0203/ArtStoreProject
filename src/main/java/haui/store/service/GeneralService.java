package haui.store.service;

import haui.store.model.EmployeeForm;

public interface GeneralService {

	EmployeeForm createEmployee(EmployeeForm employee);

	EmployeeForm getOneUserById(Integer id);

	EmployeeForm updateEmployee(EmployeeForm employeeForm);

}
