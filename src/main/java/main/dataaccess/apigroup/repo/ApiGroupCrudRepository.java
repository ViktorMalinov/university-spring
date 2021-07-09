package main.dataaccess.apigroup.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import main.dataaccess.apigroup.dao.ApiGroup;

@Repository
public interface ApiGroupCrudRepository extends CrudRepository<ApiGroup, Long> {

}
