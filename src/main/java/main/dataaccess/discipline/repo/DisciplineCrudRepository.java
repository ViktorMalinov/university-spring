package main.dataaccess.discipline.repo;

import org.springframework.data.repository.CrudRepository;

import main.dataaccess.discipline.dao.Discipline;

public interface DisciplineCrudRepository extends CrudRepository<Discipline, Long> {

}
