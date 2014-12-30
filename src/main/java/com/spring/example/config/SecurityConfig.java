package com.spring.example.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.spring.example.security.SimpleUrlAuthenticationSuccessHandler;

/**
 *
 * @author ajay
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired 
	private UserDetailsService userDetailsService;
    
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	DataSource dataSource;

	@Autowired
	SimpleUrlAuthenticationSuccessHandler successHandler;
	
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
	}

	
	@Override
    public void configure(AuthenticationManagerBuilder authentication) throws Exception {
        authentication
		.userDetailsService(userDetailsService)
		.passwordEncoder(passwordEncoder);
    }
	
	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
		db.setDataSource(dataSource);
		return db;
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
			.authorizeRequests()
				.antMatchers("/").permitAll() 
				.antMatchers("/login").permitAll()
				.antMatchers("/home").hasAnyRole("AGENT", "ADMIN")
				.antMatchers("/createUser").hasAnyRole("ADMIN")
				.antMatchers("/user/delete").hasAnyRole("ADMIN")
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .successHandler(successHandler)
                .loginProcessingUrl("/login")
                .and()
            .logout()
                .deleteCookies("remove")
                .invalidateHttpSession(false)
                .logoutUrl("/logout")
				.logoutSuccessUrl("/login")
				.permitAll()
				.and()
				.rememberMe()
				.tokenRepository(persistentTokenRepository())
				.and()
				.csrf(); // Cross Site Request Forgery (CSRF) attacks.
	}
}