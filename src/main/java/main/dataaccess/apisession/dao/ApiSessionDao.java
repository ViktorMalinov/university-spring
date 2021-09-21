package main.dataaccess.apisession.dao;


import main.dataaccess.common.BaseDao;

public interface ApiSessionDao extends BaseDao <Long, ApiSession> {

    ApiSession getSession(String authToken);
    ApiSession getSessionByUsername(String username);
}
