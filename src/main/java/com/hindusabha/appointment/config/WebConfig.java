package com.hindusabha.appointment.config;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;

import com.hindusabha.appointment.serviceimpl.UserDetailsServiceImpl;
import com.jolbox.bonecp.BoneCPConfig;
import com.jolbox.bonecp.BoneCPDataSource;

@Configuration
@EnableWebSecurity

//@PropertySource("file:D:/IT/Development/Properties/appointment/appointment_queries.properties")
//@PropertySource("file:D:/IT/Development/Properties/appointment/appointment_server.properties")
//@PropertySource("file:C:/Users/ganesh.chauhan.REINLABS/Properties/pexperience/appointment_queries.properties")
//@PropertySource("file:C:/Users/ganesh.chauhan.REINLABS/Properties/pexperience/appointment_server.properties")

@PropertySource("classpath:dbserver.properties")
@PropertySource("classpath:queries.properties")
public class WebConfig extends WebSecurityConfigurerAdapter {

	private static final Logger LOGGER = LoggerFactory.getLogger(WebConfig.class);

	@Resource
	private Environment environment;

	@Autowired
	UserDetailsServiceImpl userDetailsService;

	@Bean(name = "mappingDataSource")
	@Qualifier("mappingDataSource")
	public DataSource mappingDataSource() {
		String trimmedEachEnvironment = "map";
		LOGGER.debug("Setting up the datasource for {}", trimmedEachEnvironment);

		BoneCPConfig bonecpConfig = new BoneCPConfig();
		bonecpConfig.setJdbcUrl(environment.getRequiredProperty(trimmedEachEnvironment + ".dbUrl"));
		bonecpConfig.setUsername(environment.getRequiredProperty(trimmedEachEnvironment + ".dbUser"));
		bonecpConfig.setPassword(environment.getRequiredProperty(trimmedEachEnvironment + ".dbPassword"));
		BoneCPDataSource dataSource = new BoneCPDataSource(bonecpConfig);
		dataSource.setDriverClass(environment.getRequiredProperty(trimmedEachEnvironment + ".driverClassName"));

		return dataSource;
	}
	

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());

	}
	
	 @Bean
	    public RestTemplate restTemplate() {
	        RestTemplate restTemplate = new RestTemplate();
	        ((SimpleClientHttpRequestFactory) restTemplate.getRequestFactory()).setConnectTimeout(15000);
	        ((SimpleClientHttpRequestFactory) restTemplate.getRequestFactory()).setReadTimeout(15000);

	        return restTemplate;
	    }

	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Primary
	@Bean(name = "mappingNamedParameterJdbcTemplate")
	@Qualifier("mappingNamedParameterJdbcTemplate")
	public NamedParameterJdbcTemplate getMappingNamedParameterJdbcTemplate() {
		return new NamedParameterJdbcTemplate(mappingDataSource());
	}

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable();

		// The pages does not require login
		http.authorizeRequests().antMatchers("/", "/login", "/logout").permitAll();

		// http.authorizeRequests().antMatchers("/userInfo").access("hasAnyRole('ROLE_USER','ROLE_ADMIN')");
		// http.authorizeRequests().antMatchers("/uploadData","/errorColors","/errorDescription", "/seperateCategory").access("hasAuthority('Administrator')");
		http.authorizeRequests()
				.antMatchers("/appointment")
				.access("hasAnyRole('ROLE_EMPLOYEE','ROLE_MANAGER','ROLE_ADMIN')");
		
		http.authorizeRequests()
		.antMatchers("/vaccination-dashboard","/ipd-dashboard")
		.access("hasAnyRole('ROLE_ADMIN')");

		// For ADMIN only.
		//http.authorizeRequests().antMatchers("/all-batches","/stagewise-all-batches").access("hasRole('ROLE_MANAGER')");
		// http.authorizeRequests().antMatchers("/createCategory", "/bulkCategoryUpload", "/uploadNewMasterTemplate").access("hasAuthority('Administrator')");
		http.authorizeRequests().antMatchers("/doctor","/department")
				.access("hasAnyRole('ROLE_ADMIN','ROLE_MANAGER')");
		
		http.authorizeRequests().antMatchers("/index")
		.access("hasAnyRole('ROLE_EMPLOYEE','ROLE_MANAGER','ROLE_ADMIN','ROLE_ABCD')");

		// When the user has logged in as XX.
		// But access a page that requires role YY,
		// AccessDeniedException will be thrown.
		http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

		// Config for Login Form
		http.authorizeRequests().and().formLogin()//
				// Submit URL of login page.
				.loginProcessingUrl("/j_spring_security_check") // Submit URL
				.loginPage("/login")//
				.defaultSuccessUrl("/index")//
				.failureUrl("/login?error=true")//
				.usernameParameter("username")//
				.passwordParameter("password")
				// Config for Logout Page
				.and().logout().logoutUrl("/logout").logoutSuccessUrl("/logoutSuccessful").deleteCookies("USER_SESSION_DATA")
				.invalidateHttpSession(true) ;

	}
}
