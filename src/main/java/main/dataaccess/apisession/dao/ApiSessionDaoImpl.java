package main.dataaccess.apisession.dao;

import main.dataaccess.apisession.repo.ApiSessionRepoManager;


import org.springframework.stereotype.Component;

import main.dataaccess.common.BaseDaoImpl;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class ApiSessionDaoImpl extends BaseDaoImpl <Long, ApiSession, ApiSessionRepoManager> implements ApiSessionDao {


    @Transactional
    @Override
    public ApiSession getSession(String authToken) {
        List<ApiSession> apiSessions  = find("authToken",authToken);
        return apiSessions.get(0);
    }

    @Transactional
    @Override
    public ApiSession getSessionByUsername(String username) {
        List<ApiSession> session  = find("name",username);
        return session.get(0);
    }

}
