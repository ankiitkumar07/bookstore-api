//package com.bookstore.webapp.api.bookstoreapi.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//import com.bookstore.webapp.api.bookstoreapi.service.BookstoreUserDetailsService;
//
//@Configuration
//@EnableWebSecurity
//public class BookstoreSecurityConfiguration extends WebSecurityConfigurerAdapter {
//	
//	@Autowired
//	BookstoreUserDetailsService userDetailsService;
//	
//	@Bean
//	public AuthenticationProvider suthProvider() {
//		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//		provider.setUserDetailsService(userDetailsService);
//		provider.setPasswordEncoder(new BCryptPasswordEncoder());
//		return provider;
//	}
//}
