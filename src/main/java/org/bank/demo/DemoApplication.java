package org.bank.demo;

import org.bank.demo.entites.Account;
import org.bank.demo.entites.Card;
import org.bank.demo.entites.Currency;
import org.bank.demo.entites.Role;
import org.bank.demo.repositories.AccountRepository;
import org.bank.demo.repositories.CardRepository;
import org.bank.demo.repositories.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class DemoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner run(RoleRepository roleRepository, AccountRepository accountRepository,
								 CardRepository cardRepository, PasswordEncoder passwordEncode){
		return args -> {
			if(roleRepository.findByAuthority("ADMIN").isPresent()) return;
			Role adminRole = roleRepository.save(new Role("ADMIN"));
			roleRepository.save(new Role("USER"));

			Set<Role> roles = new HashSet<>();
			roles.add(adminRole);

			Account admin = new Account("admin", "admin", passwordEncode.encode("password"), roles);

/*			Account admin = new Account(
					"admin", passwordEncode.encode("password"),
					"admin", 800000000000L,
					roles, LocalDate.now()
			);*/
			accountRepository.save(admin);

			Card card = new Card(admin, Currency.RUB, Double.MAX_VALUE);

			cardRepository.save(card);
		};
	}
}
