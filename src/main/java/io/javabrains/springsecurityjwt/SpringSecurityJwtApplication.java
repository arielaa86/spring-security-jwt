package io.javabrains.springsecurityjwt;

import io.javabrains.springsecurityjwt.domain.Role;
import io.javabrains.springsecurityjwt.domain.User;
import io.javabrains.springsecurityjwt.filters.JwtRequestFilter;
import io.javabrains.springsecurityjwt.domain.AuthenticationRequest;
import io.javabrains.springsecurityjwt.domain.AuthenticationResponse;
import io.javabrains.springsecurityjwt.repository.UserRepository;
import io.javabrains.springsecurityjwt.service.RoleService;
import io.javabrains.springsecurityjwt.service.UserService;
import io.javabrains.springsecurityjwt.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@SpringBootApplication
public class SpringSecurityJwtApplication implements CommandLineRunner {


	@Autowired
	UserService userService;

	@Autowired
	RoleService roleService;
	@Autowired
	PasswordEncoder passwordEncoder;


	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJwtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		Role role = new Role();
		role.setAuthority("ROLE_ADMIN");

		Role role2 = new Role();
		role2.setAuthority("ROLE_USER");

		roleService.save(role);
		roleService.save(role2);


		User user = new User();
		user.setName("Pedro");
		user.setLastName("Ramos");
		user.setUsername("pedro");
		user.setPassword(passwordEncoder.encode("1234"));
		user.getRoles().addAll(Arrays.asList(role, role2));

		User user2 = new User();
		user2.setName("Aldo");
		user2.setLastName("Espinosa");
		user2.setUsername("aldo");
		user2.setPassword(passwordEncoder.encode("1234"));
		user2.getRoles().add(role2);


		userService.save(user);
		userService.save(user2);




	}
}

