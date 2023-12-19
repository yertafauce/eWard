package eWard.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true,securedEnabled = true,jsr250Enabled = true)
public class WebSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>{
	
	@Bean
    public SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> securityConfigurerAdapter() {
        return new SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>() {
            
			@Override
            public void configure(HttpSecurity http) throws Exception {

                http
                        .authorizeHttpRequests(auth ->
                                auth
                                        .requestMatchers("/","/login","/logout").permitAll()
                                        .requestMatchers("/admin/**").hasRole("ADMIN")
                                        .anyRequest().authenticated()
                        )
                        .formLogin(login -> login
                                .loginPage("/login")  // Configura la página de inicio de sesión si es necesario
                                .permitAll())
                        .logout(logout -> logout
                                .logoutSuccessUrl("/login?logout")
                                .permitAll())
                        .httpBasic(withDefaults())
                        .csrf(csrf -> csrf.disable());
            }
        };
    }

}
