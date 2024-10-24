package com.atul.videocall;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.atul.videocall.user.User;
import com.atul.videocall.user.UserService;

@SpringBootApplication
public class VideocallApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideocallApplication.class, args);
	}
		
	@Bean
	public CommandLineRunner commandLineRunner(UserService service) {
		User user1 = new User();
		user1.setUsername("Atul");
		user1.setEmail("atuls7718@gmail.com");
		user1.setPassword("atul12");
		User user2 = new User("Anup", "anups5531@gmail.com", "anup12");
		User user3 = new User("Ansh", "anshsingh@gmail.com", "ansh12");
		return args -> {
			service.register(user1);
			service.register(user2);
			service.register(user3);
		};
	}
}
