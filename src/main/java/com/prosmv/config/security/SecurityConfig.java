package com.prosmv.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.prosmv.constants.url.ApiUrl;
import com.prosmv.filter.TokenAuthenticationFilter;
import com.prosmv.repositories.AuthenticationTokenRepository;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private AuthenticationTokenRepository authenticationTokenRepository;

	@Override
	protected void configure(final HttpSecurity http) throws Exception {

		// Implementing Token based authentication in this filter
		http.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.authorizeRequests().antMatchers(HttpMethod.POST, ApiUrl.USER_LOGIN).permitAll()
				// .antMatchers(HttpMethod.GET,"/api/v1/user/getallUser/**").hasRole("ADMIN")
				.antMatchers(HttpMethod.GET, ApiUrl.COMPANY_LIST).hasRole("SUPERADMIN").anyRequest().authenticated()
				.antMatchers(ApiUrl.AUTO_COMPLETE_ROLE).authenticated()
				.antMatchers(HttpMethod.POST, ApiUrl.REGISTER_USER).hasRole("USER").anyRequest().authenticated()
				.antMatchers(HttpMethod.PUT, ApiUrl.UPDATE_USER).hasRole("USER").anyRequest().authenticated()
				.antMatchers(HttpMethod.POST, ApiUrl.REGISTER_COMPANY).hasRole("SUPERADMIN").anyRequest()
				.authenticated().antMatchers(HttpMethod.PUT, ApiUrl.UPDATE_COMPANY).hasRole("SUPERADMIN").anyRequest()
				.authenticated().antMatchers(HttpMethod.GET, ApiUrl.USER_LIST).hasRole("USER").anyRequest()
				.authenticated().antMatchers(HttpMethod.GET, ApiUrl.GET_ALL_USERS).hasRole("SUPERADMIN").anyRequest()
				.authenticated().antMatchers(HttpMethod.GET, ApiUrl.DELETE_COMPANY).hasRole("SUPERADMIN").anyRequest()
				.authenticated().antMatchers(HttpMethod.GET, ApiUrl.DEACTIVATE_COMPANY).hasRole("SUPERADMIN")
				.anyRequest().authenticated().antMatchers(HttpMethod.GET, ApiUrl.ACTIVATE_COMPANY).hasRole("SUPERADMIN")
				.anyRequest().authenticated().antMatchers(HttpMethod.POST, ApiUrl.REGISTER_FACTORY).hasRole("USER")
				.anyRequest().authenticated().antMatchers(HttpMethod.PUT, ApiUrl.UPDATE_FACTORY).hasRole("USER")
				.anyRequest().authenticated().antMatchers(HttpMethod.GET, ApiUrl.FACTORY_LIST).hasRole("USER")
				.anyRequest().authenticated().antMatchers(HttpMethod.GET, ApiUrl.DEACTIVATE_FACTORY).hasRole("USER")
				.anyRequest().authenticated().antMatchers(HttpMethod.GET, ApiUrl.ACTIVATE_FACTORY).hasRole("USER")
				.anyRequest().authenticated().antMatchers(HttpMethod.GET, ApiUrl.USER_LOGOUT).authenticated()
				.anyRequest().authenticated().antMatchers(ApiUrl.AUTO_COMPLETE_COMPANY).authenticated().anyRequest()
				.authenticated().antMatchers(ApiUrl.AUTO_COMPLETE_ROLE_BY_COMPANY).authenticated()
				.antMatchers(ApiUrl.UPLOAD_COMPANY_LOGO).authenticated();
		// Implementing Token based authentication in this filter
		final TokenAuthenticationFilter tokenFilter = new TokenAuthenticationFilter(authenticationTokenRepository);
		http.addFilterBefore(tokenFilter, BasicAuthenticationFilter.class);
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/v2/api-docs/**");
		web.ignoring().antMatchers("/swagger.json");
		web.ignoring().antMatchers("/swagger-ui.html");
		web.ignoring().antMatchers("/webjars/**");
		web.ignoring().antMatchers("/swagger-resources/**");
	}

}
