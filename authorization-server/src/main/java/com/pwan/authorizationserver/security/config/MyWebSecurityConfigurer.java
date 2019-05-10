package com.pwan.authorizationserver.security.config;


import com.pwan.authorizationserver.security.encoder.MyPasswordEncoder;
import com.pwan.authorizationserver.service.MyUserDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * For configuring the end users recognized by this Authorization Server
 */
@Configuration
@Slf4j
class MyWebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        if(log.isDebugEnabled()) {
            log.debug("configure(HttpSecurity http)");
        }
        http
                .authorizeRequests()
                .mvcMatchers("/.well-known/jwks.json").permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/favicon.ico", "/css/**", "/js/**", "/fonts/**", "/index").permitAll() // 都可以访问
                .antMatchers("/h2-console/**").permitAll() // 都可以访问
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .csrf().ignoringRequestMatchers(request -> "/introspect".equals(request.getRequestURI()))
                .and()
                .csrf().ignoringAntMatchers("/h2-console/**") // 禁用 H2 控制台的 CSRF 防护
                .and()
                .headers().frameOptions().sameOrigin(); // 允许来自同一来源的H2 控制台的请求，否则iframe 嵌入网页 报 x-frame-options deny错误
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        if(log.isDebugEnabled()) {
            log.debug("configure(AuthenticationManagerBuilder auth)");
        }
        auth.userDetailsService(myUserDetailsService).passwordEncoder(new MyPasswordEncoder());
    }
}
