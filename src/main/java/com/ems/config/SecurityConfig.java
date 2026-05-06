package com.ems.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	private UserDetailsService userDetailsService;

	public SecurityConfig(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	@Bean
	AuthenticationProvider authProvider() {

		DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userDetailsService);
//		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		provider.setPasswordEncoder(new BCryptPasswordEncoder(12));

		return provider;
	}

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) {

//		--csrf disabled
		http.csrf(customizer -> customizer.disable())
				.authorizeHttpRequests(request -> request.anyRequest().authenticated())
				.httpBasic(Customizer.withDefaults())
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//		http.authorizeHttpRequests(request -> request.anyRequest().hasRole("ADMIN"));
		return http.build();
	}

	@Bean
	BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder(12);
	}

//	@Bean
//	public UserDetailsService userDetailsService() {
//
//		UserDetails user = User.withDefaultPasswordEncoder().username("admin").password("admin").roles("USER").build();
//
//		return new InMemoryUserDetailsManager(user);
//	}

}
