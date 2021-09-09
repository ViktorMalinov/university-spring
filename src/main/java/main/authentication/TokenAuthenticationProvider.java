package main.authentication;

import main.business.apiuser.processor.ApiUserProcessor;
import main.dataaccess.apisession.dao.ApiSession;
import main.dataaccess.apisession.dao.ApiSessionDao;
import main.service.apiuser.ApiUserResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class TokenAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private Credentials credentials;

    @Autowired
    private ApiSessionDao apiSessionDao;

    @Autowired
    private ApiUserProcessor userProcessor;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordTokenAuthenticationToken authenticationToken = (UsernamePasswordTokenAuthenticationToken) authentication ;

        if (authenticationToken != null) {

            if (null != authenticationToken.getAuthToken()) {

                String authToken = authenticationToken.getAuthToken();

                ApiSession apiSession = apiSessionDao.getSession(authToken);

                if (apiSession!=null) {
                    ApiUserResult userResult = userProcessor.getUser(apiSession.getName());
                    if (userResult != null)
                        authentication = new UsernamePasswordTokenAuthenticationToken(userResult.getUsername(), userResult.getPassword(),authToken);
                    return authentication;
                }
            }
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}