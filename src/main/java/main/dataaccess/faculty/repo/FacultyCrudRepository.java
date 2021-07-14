package main.dataaccess.faculty.repo;

import org.springframework.data.repository.CrudRepository;

import main.dataaccess.faculty.dao.Faculty;

public interface FacultyCrudRepository extends CrudRepository<Faculty, Long> {

}
