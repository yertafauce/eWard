package eWard.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static org.springframework.security.config.Customizer.withDefaults;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true,securedEnabled = true,jsr250Enabled = true)
public class WebSecurityConfigOri extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>{
	
	/*@Bean
    public SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> securityConfigurerAdapter() {
        return new SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>() {
            
			@Override
            public void configure(HttpSecurity http) throws Exception {

				//http.csrf(csrf -> csrf.disable());
				
                http
                        .authorizeHttpRequests(auth ->
                                auth
                                        .requestMatchers("/","/hello","/logout").permitAll()
                                        .requestMatchers("/admin/**").hasRole("ADMIN")
                                        .anyRequest().authenticated()
                        )
                        .formLogin(login -> login
                                .loginPage("/hello")  // Configura la página de inicio de sesión si es necesario
                                .permitAll())
                        
                        .logout(logout -> logout
                                .logoutSuccessUrl("/hello?logout")
                                .permitAll())
                        .httpBasic(withDefaults());
                        
            }
        };
    }*/
	
	

	    private final ShouldAuthenticateAgainstThirdPartySystem shouldAuth;

	    private final LoggingAccessDeniedHandler accessDeniedHandler;
	    public WebSecurityConfigOri(ShouldAuthenticateAgainstThirdPartySystem shouldAuth, LoggingAccessDeniedHandler accessDeniedHandler) {
	        this.shouldAuth = shouldAuth;
	        this.accessDeniedHandler = accessDeniedHandler;
	    }

	    @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

	        http
	                .authorizeHttpRequests((authz) -> {
	                            try {
	                                authz
	                                        .anyRequest().authenticated()
	                                        .and().formLogin().
	                                        loginPage("/login").
	                                        defaultSuccessUrl("/",true)
	                                        .permitAll()
	                                        .and()
	                                        .logout()
	                                        .invalidateHttpSession(true)
	                                        .clearAuthentication(true)
	                                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	                                        .logoutSuccessUrl("/login?logout")
	                                        .permitAll()
	                                        .and()
	                                        .exceptionHandling()
	                                        .accessDeniedHandler(accessDeniedHandler)
	                                        ;
	                            } catch (Exception e) {
	                                throw new RuntimeException(e);
	                            }
	                        }
	                );

	                //.authenticationManager(new CustomAuthenticationManager(shouldAuth));

	        return http.build();
	    }

	    @Bean
	    public WebSecurityCustomizer webSecurityCustomizer() {
	        return (web) -> web.ignoring().requestMatchers("/register");
	    }

	

}
