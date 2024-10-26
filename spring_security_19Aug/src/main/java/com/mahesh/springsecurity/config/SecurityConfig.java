package com.mahesh.springsecurity.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@EnableWebSecurity
//@Configuration
//@EnableMethodSecurity
//public class SecurityConfig extends WebSecurityConfiguration {
//   protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//	   auth.inMemoryAuthentication()
//	   .passwordEncoder(passwordEncoder())
//	   .withUser("mahesh")
//	   .password(passwordEncoder().encode("mahesh"))
//	   .roles("Admin")
//	   .and()
//	   .withUser("user")
//	   .password(passwordEncoder().encode("user"))
//	   .roles("BASIC");
//   }
//   @Bean
//   private PasswordEncoder passwordEncoder() {
//	   return new BCryptPasswordEncoder();
//   }
//  
//protected void configure(HttpSecurity http) {
//	   http.authorizeHttpRequests()
//	   .requestMatchers("/basic")
//	   .hasAnyRole("BASIC","ADMIN")
//	   .requestMatchers("/admin")
//	   .hasRole("ADMIN")
//	   .requestMatchers("/")
//	   .permitAll()   
//	   .anyRequest()
//	   .authenticated()
//	   .and()
//	   .formLogin()
//	   .permitAll()
//	   .loginPage("/login")
//	   .usernameParameter("username")
//	   .and()
//	   .logout()
//	   .logoutRequestMatcher(new logoutRequestMatcher("/logout"))
//	   .permitAll();
//   }
//}

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
@EnableWebSecurity
@Configuration
public class SecurityConfig{
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
		.authorizeHttpRequests((authz)->authz
				.requestMatchers("/api/admin/**").hasRole("ADMIN")
				.requestMatchers("/api/users/**").hasRole("USER")
				.anyRequest().authenticated());
		return http.build();
	}
	
  protected void configure(AuthenticationManagerBuilder auth) throws Exception{
	   auth.inMemoryAuthentication()
	   .passwordEncoder(passwordEncoder())
	   .withUser("mahesh")
	   .password(passwordEncoder().encode("mahesh"))
	   .roles("Admin")
	   .and()
	   .withUser("user")
	   .password(passwordEncoder().encode("user"))
	   .roles("BASIC");
  }
  @Bean
public PasswordEncoder passwordEncoder() {
	   return new BCryptPasswordEncoder();
  }
}
