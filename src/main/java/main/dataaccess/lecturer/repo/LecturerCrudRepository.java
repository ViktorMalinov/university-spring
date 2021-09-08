package main.dataaccess.lecturer.repo;

import org.springframework.data.repository.CrudRepository;

import main.dataaccess.lecturer.dao.Lecturer;

public interface LecturerCrudRepository extends CrudRepository<Lecturer, Long> {

}
