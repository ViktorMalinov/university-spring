package main.dataaccess.apiuser.dao;

import org.springframework.stereotype.Component;

import main.dataaccess.apiuser.repo.ApiUserRepoManager;
import main.dataaccess.common.BaseDaoImpl;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class ApiUserDaoImpl extends BaseDaoImpl <Long, ApiUser, ApiUserRepoManager> implements ApiUserDao {

    @Transactional
    @Override
    public ApiUser getUser(String username) {
        List<ApiUser> user  = find("username",username);
        if (!user.isEmpty()) {
            return user.get(0);
        }
        else
            return null;
    }

}
