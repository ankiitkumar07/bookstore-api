package com.bookstore.webapp.api.bookstoreapi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class BookstoreSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Bean
	public AuthenticationProvider suthProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		
		return provider;
	}
}
