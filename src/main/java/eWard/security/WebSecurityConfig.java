package eWard.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {
	
	 	@Bean
	    public PasswordEncoder passwordEncoder() {
	        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	    }
	
		@Bean
		public UserDetailsService users() {
			
			UserDetails admin = User.withUsername("admin")
					.password(passwordEncoder().encode("admin"))
					.roles("Administrador", "Moderador", "Tutor", "Profesor", "Alumno").build();
			UserDetails moderator = User.withUsername("moderador")
					.password(passwordEncoder().encode("moderador"))
					.roles("Moderador", "Tutor", "Profesor", "Alumno").build();
			UserDetails tutor = User.withUsername("tutor")
					.password(passwordEncoder().encode("tutor"))
					.roles("Tutor", "Profesor").build();
			UserDetails profesor = User.withUsername("profesor")
					.password(passwordEncoder().encode("profesor"))
					.roles("Profesor").build();
			UserDetails alumno = User.withUsername("alumno")
					.password(passwordEncoder().encode("alumno"))
					.roles("Alumno").build();
			
			return new InMemoryUserDetailsManager(admin, moderator, tutor, profesor, alumno);
			
		}

	    @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    	
	        http
	        		.csrf(csrf -> csrf.disable())
	                .authorizeHttpRequests(auth ->
                    {
						try {
							auth
							        .requestMatchers("/", "/login")
							        .permitAll()
							        .and()
							        .formLogin(login -> login
							                .loginPage("/login")
							                .defaultSuccessUrl("/")
							                .permitAll())
							        .logout(logout -> logout
							                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
							                .logoutSuccessUrl("/")
							                .invalidateHttpSession(true)
							                .permitAll());
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					});

	        return http.build();
	    }

	    @Bean
	    public WebSecurityCustomizer webSecurityCustomizer() {
	        return (web) -> web.ignoring().requestMatchers("/register");
	    }

	

}
