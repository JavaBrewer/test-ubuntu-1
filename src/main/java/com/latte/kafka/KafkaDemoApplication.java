package com.latte.kafka;

import com.latte.kafka.service.KafkaProducerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KafkaDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(KafkaProducerService producerService) {
        return args -> {
            producerService.sendMessage("my-topic", "Hello, Kafka!");
        };
    }
}

