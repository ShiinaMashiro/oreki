package xin.oreki.orekiuser.security;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import xin.oreki.orekiuser.domain.User;
import xin.oreki.orekiuser.vo.LoginStatus;
import xin.oreki.orekiuser.vo.LoginVo;

import java.io.PrintWriter;

/**
 * @author oreki
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private CustomUserService customUserService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                    .loginPage("/login")
                    .loginProcessingUrl("/login_s").usernameParameter("username").passwordParameter("password")
                    .permitAll()
                    .failureHandler((request, response, e) -> {
                        response.setContentType("application/json;charset=utf-8");
                        PrintWriter out = response.getWriter();
                        out.write(JSON.toJSONString(LoginVo.fail(LoginStatus.OTHER_ERROR)));
                        out.flush();
                        out.close();
                    })
                    .successHandler((request, response, authentication) -> {
                        response.setContentType("application/json;charset=utf-8");
                        PrintWriter out = response.getWriter();
                        out.write(JSON.toJSONString(LoginVo.success((User) authentication.getPrincipal())));
                        out.flush();
                        out.close();
                    })
                .and()
                .logout().permitAll();
    }
}
