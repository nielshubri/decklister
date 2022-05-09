package com.decklister.Decklister;

import com.decklister.Decklister.security.SecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication(exclude = {UserDetailsServiceAutoConfiguration.class })
public class DecklisterApplication {

	public static void main(String[] args) {
		SpringApplication.run(new Class[] {DecklisterApplication.class, SecurityConfig.class}, args);
	}
}
