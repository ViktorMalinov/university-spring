package main.dataaccess.apisession.repo;


import main.dataaccess.apisession.dao.ApiSession;
import org.springframework.data.repository.CrudRepository;


public interface ApiSessionCrudRepository extends CrudRepository<ApiSession, Long> {

}
