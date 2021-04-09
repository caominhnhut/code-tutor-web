package com.vn.green.rest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.vn.green.rest.factory.jwt.TokenHelper;
import com.vn.green.core.user.service.UserDetailService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}

	@Autowired
	private UserDetailService userDetailsService;

	@Autowired
	TokenHelper tokenHelper;

	@Autowired
	private RestAuthenticationEntryPoint authenticationEntryPoint;

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception
	{
		return super.authenticationManagerBean();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception
	{
		// configure AuthenticationManager so that it knows from where to load
		// user for matching credentials
		// Use BCryptPasswordEncoder
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		// make sure we use stateless session; session won't be used to store user's state.
		http
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint).and()
				.authorizeRequests()
				.antMatchers(
						HttpMethod.GET,
						"/",
						"/webjars/**",
						"/*.html",
						"/favicon.ico",
						"/**/*.html",
						"/**/*.css",
						"/**/*.js",
						"/assets/**",
						"/swagger-resources/**",
						"/swagger-ui.html",
						"/v2/api-docs",
						"/authenticate",
						"/no-auth/**").permitAll() // dont authenticate this particular request
				.anyRequest().authenticated().and() // all other requests need to be authenticated
				.addFilterBefore(new AuthenticationFilter(userDetailsService, tokenHelper), UsernamePasswordAuthenticationFilter.class); // Add a filter to validate the tokens with every request

		// We don't need CSRF for this example
		http.csrf().disable();
	}

	@Override
	public void configure(WebSecurity web) throws Exception
	{
		// TokenAuthenticationFilter will ignore the below paths
		web.ignoring().antMatchers(
				HttpMethod.POST,
				"/authenticate",
				"/no-auth/**"
		);
		web.ignoring().antMatchers(
				HttpMethod.GET,
				"/",
				"/webjars/**",
				"/*.html",
				"/favicon.ico",
				"/**/*.html",
				"/**/*.css",
				"/**/*.js",
				"/assets/**"
		);

	}
}
