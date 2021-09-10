package main.authentication;

import org.hibernate.annotations.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Filter(name = "authFilter")
public class CustomAuthenticationFilter extends OncePerRequestFilter {

    private static final String AUTHENTICATION_TOKEN = "authToken";

    private static final String AUTHENTICATION_BASIC = "Authorization";


    @Autowired
    private Credentials credetentials;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        Authentication auth = credetentials.getAuthentication();

        UsernamePasswordTokenAuthenticationToken authentication = (UsernamePasswordTokenAuthenticationToken) auth;

        final String tokenURLparam = request.getParameter("token");  // KamenTr
        final HttpServletRequest httpRequest = (HttpServletRequest) request; // KamenTr


        if (authentication == null) {
            //authentication = tokenAuthentication(request);
            authentication = TokenAuthentication(httpRequest, tokenURLparam);
        }

        if (authentication == null) {
            //authentication = basicAuthentication(request);
            authentication = BAAuthentication(httpRequest);
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);


        filterChain.doFilter(request,response);


    }

    private UsernamePasswordTokenAuthenticationToken tokenAuthentication(HttpServletRequest httpRequest) {
        if (!httpRequest.getHeader("Authorization").contains("Basic")) {
            return new UsernamePasswordTokenAuthenticationToken("","",
                    httpRequest.getHeader("Authorization").trim());
        }
        return null;
    }

    private UsernamePasswordTokenAuthenticationToken basicAuthentication(HttpServletRequest httpRequest) {


        if (httpRequest.getHeader("Authorization").contains("Basic")) {

            BasicAuthenticationEnt basicAuthHeader = new BasicAuthenticationEnt(
                    httpRequest.getHeader("Authorization"));
            if (basicAuthHeader != null) {
                String username = basicAuthHeader.getUsername();
                String password = basicAuthHeader.getPassword();

                return new UsernamePasswordTokenAuthenticationToken(username,
                        password);
            }
        }
        return null;
    }


    // From KamenTr
    @SuppressWarnings("unused")
    private UsernamePasswordTokenAuthenticationToken BAAuthentication(HttpServletRequest httpRequest) {

        BasicAuthenticationEnt basicAuthHeader = new BasicAuthenticationEnt(
                httpRequest.getHeader(AUTHENTICATION_BASIC));

        if (basicAuthHeader != null) {

            String username = basicAuthHeader.getUsername();
            String password = basicAuthHeader.getPassword();

            UsernamePasswordTokenAuthenticationToken authentication = new UsernamePasswordTokenAuthenticationToken(username,
                    password);
            return authentication;
        }

        return null;
    }

    private UsernamePasswordTokenAuthenticationToken TokenAuthentication(HttpServletRequest httpRequest,
                                                                     String tokenURLparam) {

        String token = tokenURLparam;
        if (token == null)
            token = httpRequest.getHeader(AUTHENTICATION_TOKEN);
        if (token != null) {
            UsernamePasswordTokenAuthenticationToken authentication = new UsernamePasswordTokenAuthenticationToken("", "",
                    token);

            return authentication;
        }

        return null;
    }

}
