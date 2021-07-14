package main.dataaccess.facultydiscipline.repo;

import org.springframework.data.repository.CrudRepository;

import main.dataaccess.facultydiscipline.dao.FacultyDiscipline;

public interface FacultyDisciplineCrudRepository extends CrudRepository<FacultyDiscipline, Long> {

}
