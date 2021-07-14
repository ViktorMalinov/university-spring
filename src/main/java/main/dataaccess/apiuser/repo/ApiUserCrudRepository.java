package main.dataaccess.apiuser.repo;

import org.springframework.data.repository.CrudRepository;

import main.dataaccess.apiuser.dao.ApiUser;

public interface ApiUserCrudRepository extends CrudRepository<ApiUser, Long> {

}
