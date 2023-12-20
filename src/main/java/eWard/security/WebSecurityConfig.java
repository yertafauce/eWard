package eWard.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.session.ConcurrentSessionControlAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.security.web.session.HttpSessionEventPublisher;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true,securedEnabled = true,jsr250Enabled = true)
public class WebSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    private static final String ZUL_FILES = "/zkau/web/**/**/*.zul";

    private static final String[] ZK_RESOURCES = {
            "/include/**",
            "/css/**",
            "/icons/**",
            "/img/**",
            "/js/**",
            "/zkau/web/**/js/**",
            "/zkau/web/**/css/**",
            "/zkau/web/**/font/**",
            "/zkau/web/**/img/**",
            "/zkau/web/**/zul/img/**"
    };
    
    
    
    
    @Bean
    public SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> securityConfigurerAdapter() {
        return new SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>() {
    
		    @Override
			public void configure(HttpSecurity http) throws Exception {

		    	http.csrf().disable();
		    	
		    	http.authorizeRequests()
		        .anyRequest().permitAll()
		       // .antMatchers(HttpMethod.GET, ZUL_FILES).denyAll()
		        
		        .requestMatchers("/","/login","/logout").permitAll()
		       
		       
		      .and()
		      //cuando logeamos si ha ido ok, pasamos el usuario a la session con customAuthenticationSuccessHandler
		        .formLogin().loginPage("/login").permitAll()
		        .defaultSuccessUrl("/menuzoomer")
		        .failureUrl("/login?error=true")
		        .usernameParameter("username")
		        .passwordParameter("password")
		        
		        .and()  
		        .logout().permitAll().logoutUrl("/logout").logoutSuccessUrl("/login");
		        
		        //control de sesiones y concurrencia de usuarios
		    	http
		        .sessionManagement()
		       // .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
		       .invalidSessionUrl("/errorSession");
		        //.invalidSessionUrl("/login")
		       // .sessionRegistry(sessionRegistry)
		        
		    	//System.out.println(configMag.getConfig().getInt("config.sesionesMaximas"));
		    }
        };
    }
    

    /*@Bean
    public HttpSessionEventPublisher httpSessionEventPublisher() {
        return new HttpSessionEventPublisher();
    }

    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }*/
    
}