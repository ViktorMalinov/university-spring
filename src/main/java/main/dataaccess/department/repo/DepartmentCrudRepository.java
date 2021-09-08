package main.dataaccess.department.repo;

import org.springframework.data.repository.CrudRepository;

import main.dataaccess.department.dao.Department;

public interface DepartmentCrudRepository extends CrudRepository<Department, Long> {

}
