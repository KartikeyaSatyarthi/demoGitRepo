package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
@Configuration
@EnableWebSecurity
public class AccessConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		UserBuilder users= User.withDefaultPasswordEncoder();
		auth.inMemoryAuthentication()
		.withUser(users.username("User").password("User").roles("User"))
		.withUser(users.username("Admin").password("Admin").roles("User","Admin"));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.formLogin().and().authorizeRequests().anyRequest().authenticated()
		.antMatchers("/User/**").hasRole("User")
		.antMatchers("/Admin/**").hasRole("Admin")
		.and().csrf().disable();
	}

	
	
}
