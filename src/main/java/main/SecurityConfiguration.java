package main;

import main.service.apigroup.ApiGroupResult;
import main.service.apigroup.ApiGroupService;
import main.service.apigroupuser.ApiGroupUserResult;
import main.service.apigroupuser.ApiGroupUserService;
import main.service.apiuser.ApiUserResult;
import main.service.apiuser.ApiUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private ApiUserService apiUser;
    @Autowired
    private ApiGroupService apiGroupService;
    @Autowired
    private ApiGroupUserService apiGroupUser;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        List<ApiUserResult> users = apiUser.getAll();

        users.stream().forEach(u ->
            {
                try {
                    auth
                            .inMemoryAuthentication()
                            //.withUser(u.getUsername()).password(passwordEncoder().encode(u.getPassword())).roles(getRolesForUser(u.getId()));
                            .withUser(u.getUsername()).password(passwordEncoder().encode(u.getPassword())).roles("ADMIN");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        );

        /*
        auth
                .inMemoryAuthentication()
                .withUser("admin").password(passwordEncoder().encode("admin111")).roles("ADMIN");


        auth
                .inMemoryAuthentication()
                .withUser("user").password(passwordEncoder().encode("user111")).roles("USER");

         */
    }

    private String getRolesForUser(Long id) throws Exception {
        AtomicReference<String> roles = new AtomicReference<>("");
        List<ApiGroupUserResult>  grpUser = apiGroupUser.getAll();
        List<ApiGroupResult>  groups = apiGroupService.getAll();

        Stream<ApiGroupUserResult> fltUserGroups = grpUser.stream().filter(gu -> gu.getApiUserId().equals(id));
        Stream<ApiGroupResult> fltGroups = groups.stream().filter(
                    g -> fltUserGroups.anyMatch(gu -> gu.getApiGroupId().equals(g.getId()))
                );

        fltGroups.forEach( g -> roles.set(roles.get() + g.getName()) );

        return roles.get();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest().authenticated()
                .and().httpBasic();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
