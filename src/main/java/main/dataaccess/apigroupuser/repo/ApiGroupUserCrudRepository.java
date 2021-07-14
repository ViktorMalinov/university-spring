package main.dataaccess.apigroupuser.repo;

import org.springframework.data.repository.CrudRepository;

import main.dataaccess.apigroupuser.dao.ApiGroupUser;

public interface ApiGroupUserCrudRepository extends CrudRepository<ApiGroupUser, Long> {

}
