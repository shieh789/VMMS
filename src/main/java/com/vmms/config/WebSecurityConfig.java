package com.vmms.config;

import com.vmms.login.service.impl.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    protected Log log = LogFactory.getLog(this.getClass());


    /**
     * 配置角色关系
     * @return
     */
    @Bean
    RoleHierarchy roleHierarchy(){
        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
        String hierarchy = "ROLE_super > ROLE_test";
        roleHierarchy.setHierarchy(hierarchy);
        return roleHierarchy;
    }

    /**
     * 配置用户数据
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
    }

    //定义登陆成功返回信息
    private class AjaxAuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
        @Override
        public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {

            //User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            log.info("商户[" + SecurityContextHolder.getContext().getAuthentication().getPrincipal() +"]登陆成功！");
            //登陆成功后移除session中验证码信息
            request.getSession().removeAttribute("codeValue");
            request.getSession().removeAttribute("codeTime");

            response.setContentType("application/json;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.write("{\"status\":\"ok\",\"msg\":\"登录成功\"}");
            out.flush();
            out.close();
        }
    }

    //定义登陆失败返回信息
    private class AjaxAuthFailHandler extends SimpleUrlAuthenticationFailureHandler {
        @Override
        public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
            //登陆失败后移除session中验证码信息
            request.getSession().removeAttribute("codeValue");
            request.getSession().removeAttribute("codeTime");

            response.setContentType("application/json;charset=utf-8");
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            PrintWriter out = response.getWriter();
            out.write("{\"status\":\"error\",\"msg\":\"请检查用户名、密码或验证码是否正确\"}");
            out.flush();
            out.close();
        }
    }

    //定义异常返回信息
    public class UnauthorizedEntryPoint implements AuthenticationEntryPoint {
        @Override
        public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
            response.sendError(HttpStatus.UNAUTHORIZED.value(),authException.getMessage());
        }

    }

    //定义登出成功返回信息
    private class AjaxLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {

        public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
                                    Authentication authentication) throws IOException, ServletException {
            response.setContentType("application/json;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.write("{\"status\":\"ok\",\"msg\":\"登出成功\"}");
            out.flush();
            out.close();
        }
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.exceptionHandling().authenticationEntryPoint(new UnauthorizedEntryPoint())
                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/test/login").permitAll()
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/users/login_page")
                .successHandler(new AjaxAuthSuccessHandler())
                .failureHandler(new AjaxAuthFailHandler())
                .loginProcessingUrl("/login")
                .and()
                .logout().logoutSuccessHandler(new AjaxLogoutSuccessHandler())
                .logoutUrl("/logout");
    }
}