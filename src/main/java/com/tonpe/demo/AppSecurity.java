package com.tonpe.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class AppSecurity extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService;
	@Bean
	public AuthenticationProvider authenticationProcider() {
		DaoAuthenticationProvider pro = new DaoAuthenticationProvider();
		pro.setUserDetailsService(userDetailsService);
		pro.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		return pro;

	}
    //pre username and passwords
	/*
	 * @Bean
	 * 
	 * @Override protected UserDetailsService userDetailsService() {
	 * List<UserDetails> users = new ArrayList<>();
	 * users.add(User.withDefaultPasswordEncoder().username("tonpe narayana").
	 * password("12345aaa").roles("USER").build());
	 * 
	 * users.add(User.withDefaultPasswordEncoder().username("tonpe").password(
	 * "12345").roles("USER").build());
	 * 
	 * 
	 * 
	 * return new InMemoryUserDetailsManager(users);
	 * 
	 * 
	 * }
	 */

}
