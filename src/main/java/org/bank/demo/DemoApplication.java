package org.bank.demo;

import org.bank.demo.entites.Account;
import org.bank.demo.entites.Role;
import org.bank.demo.repositories.AccountRepository;
import org.bank.demo.repositories.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class DemoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
	CommandLineRunner run(RoleRepository roleRepository, AccountRepository accountRepository, PasswordEncoder passwordEncode){
		return args ->{
			if(roleRepository.findByAuthority("ADMIN").isPresent()) return;
			Role adminRole = roleRepository.save(new Role("ADMIN"));
			roleRepository.save(new Role("USER"));

			Set<Role> roles = new HashSet<>();
			roles.add(adminRole);

			Account admin = new Account(1L, "admin","admin", passwordEncode.encode("password"), roles);

			accountRepository.save(admin);
		};
	}
}
