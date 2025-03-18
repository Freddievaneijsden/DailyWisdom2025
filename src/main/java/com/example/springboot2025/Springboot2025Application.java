package com.example.springboot2025;

import com.example.springboot2025.domain.entity.DailyWisdom;
import com.example.springboot2025.infrastructure.persistence.DailyWisdomRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Springboot2025Application {

    public static void main(String[] args) {
        SpringApplication.run(Springboot2025Application.class, args);
    }

    @Bean
    CommandLineRunner runner (DailyWisdomRepository dailyWisdomRepository) {
        return args -> {
            if (dailyWisdomRepository.count() == 0) {
                DailyWisdom dailyWisdom = new DailyWisdom();
                dailyWisdom.setMessage("Du är bög");
                dailyWisdomRepository.save(dailyWisdom);
            }
        };
    }

}
