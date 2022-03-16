package com.kelvin.dbapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/register", 
				"/resources/**", 
				"/css/**", 
				"/fonts/**", 
				"/img/**", 
				"/js/**",
				"/vendor/**").permitAll()
		.antMatchers("/user/addNew").permitAll()
		.anyRequest().authenticated()
		//.antMatchers("/", "/about").anonymous()
		.and()
		.formLogin()
		//return login page
		.loginPage("/login").permitAll()
		.and()
		.logout().invalidateHttpSession(true)
		.clearAuthentication(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/login").permitAll();
		
		
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
		
	}
	
//	@Bean
//	public PasswordEncoder bCryptpPsswordEncoder() {
//		return new BCryptPasswordEncoder();
//		
//	}
	
	//get user
	@Autowired
	private UserDetailsService userDetailsService;
	
	//provide 
	@Bean
	public AuthenticationProvider authenticationProvider() {
		
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		
		provider.setUserDetailsService(userDetailsService);
		//provide the site password encoder
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		//bCryptpPsswordEncoder()
		return provider;
		
	}
	
}
