package com.latte.kafka.controller;


import com.latte.kafka.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController {

    private final KafkaProducerService kafkaProducerService;

    @Autowired
    public MyController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @GetMapping("/send-message")
    public String sendMessage(@RequestParam String message) {
        kafkaProducerService.sendMessage("my-topic", message);
        return "Message sent to Kafka: " + message;
    }
}
