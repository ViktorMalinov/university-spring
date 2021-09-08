package main.dataaccess.speciality.repo;

import org.springframework.data.repository.CrudRepository;

import main.dataaccess.speciality.dao.Speciality;

public interface SpecialityCrudRepository extends CrudRepository<Speciality, Long> {

}
