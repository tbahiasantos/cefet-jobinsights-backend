package br.com.taugs.jobinsights.infra.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.com.taugs.jobinsights.infra.security.filter.SecurityFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http, SecurityFilter securityFilter) throws Exception {
		return http.csrf(csrf -> csrf.disable())//
		        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) //
		        .authorizeHttpRequests( //
		                authorize -> authorize //
		                        .requestMatchers(HttpMethod.POST, "/auth/logar").permitAll() //
		                        .requestMatchers(HttpMethod.POST, "/usuario/salvar/*").permitAll()//
		                        .requestMatchers(HttpMethod.GET, "/curso/listarTodos").permitAll() //
		                        .requestMatchers(HttpMethod.GET, "/cargo/listarTodos").permitAll() //
		                        .requestMatchers(HttpMethod.GET, "/confirmation/confirmar/*").permitAll() //
		                        .requestMatchers(HttpMethod.POST, "/curso/*").permitAll() //
		                        .requestMatchers(HttpMethod.POST, "/cargo/*").permitAll() //
		                        .anyRequest().authenticated() //
				) //
		        .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)//
		        .build();
	}

	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
