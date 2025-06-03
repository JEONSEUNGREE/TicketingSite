package com.massive.ticketserver;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.massive.ticketserver.domain.entity.User;
import com.massive.ticketserver.domain.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@EnableJpaAuditing
@SpringBootApplication
@RequiredArgsConstructor
public class TicketServerApplication implements ApplicationRunner {

	private final UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(TicketServerApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		userRepository.save(User.builder().name("Test1").email("Test1@Email.com").build());
		userRepository.save(User.builder().name("Test2").email("Test2@Email.com").build());
		userRepository.save(User.builder().name("Test3").email("Test3@Email.com").build());
	}
}
