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
import java.util.stream.Collectors;
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
                            .withUser(u.getUsername()).password(passwordEncoder().encode(u.getPassword())).roles(getRolesForUser(u.getId()));
                            //.withUser(u.getUsername()).password(passwordEncoder().encode(u.getPassword())).roles("ADMIN");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        );

    }

    private String getRolesForUser(Long id) throws Exception {
        String roles = "";

        List<ApiGroupUserResult>  grpUser = apiGroupUser.getAll();
        List<ApiGroupResult>  groups = apiGroupService.getAll();

        Stream<ApiGroupUserResult> fltUserGroups = grpUser.stream().filter(gu -> gu.getApiUserId().equals(id));
        List<ApiGroupUserResult> fltUserGroupsList = fltUserGroups.collect(Collectors.toList());

        Stream<ApiGroupResult> fltGroups = groups.stream().filter(
                g -> fltUserGroupsList.stream().anyMatch(gu -> gu.getApiGroupId().equals(g.getId()))

                //g -> checkGroup(fltUserGroupsList,g.getId())
                //g -> g.getId() == 2 || g.getId() == 1
        );

        List<ApiGroupResult> fltGroupsList = fltGroups.collect(Collectors.toList());

        for (ApiGroupResult apiG : fltGroupsList)
        {
            if (roles.equals(""))
                roles = apiG.getName();
            else
                roles = roles + "," + apiG.getName();
        }

        return roles;
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
