package com.proclinic.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Value("${spring.datasource.url}")
    String url;
    @Value("${spring.datasource.username}")
    String username;
    @Value("${spring.datasource.password}")
    String password;

    public DataSource getDataSource() {
	return DataSourceBuilder.create()
		.url(url)
		.username(username)
		.password(password)
		.build();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	auth.jdbcAuthentication()
		.passwordEncoder(new BCryptPasswordEncoder())
		.dataSource(getDataSource())
		.usersByUsernameQuery("select username,password,enabled from user where username = ?")
		.authoritiesByUsernameQuery(
			"select username,authority from user u,authorities a where a.user_id=u.id and username = ?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
	http
		.authorizeRequests()
		.antMatchers("/login", "/log.html", "/login.html", "/sign-up.html", "/charts/*", "/css/*",
			"/datatable/*",
			"/fonts/*",
			"/images/*", "/js/*")
		.permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login.html")
		.loginProcessingUrl("/login")
		.failureUrl("/login.html?error")
		.and()
		.rememberMe()
		.and()
		.logout()
		.and()
		.csrf().disable();
    }
}
