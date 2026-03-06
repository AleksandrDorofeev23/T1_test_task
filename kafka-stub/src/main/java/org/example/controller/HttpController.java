package org.example.controller;

import jakarta.validation.Valid;
import org.example.model.Payload;
import org.example.model.Message;
import org.example.service.KafkaConsumer;
import org.example.service.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpController {

    private final KafkaProducer producer;
    private final KafkaConsumer consumer;

    public HttpController(KafkaProducer producer, KafkaConsumer consumer) {
        this.producer = producer;
        this.consumer = consumer;
    }

    @PostMapping("/buy")
    public ResponseEntity<Message> sendMessage(@Valid @RequestBody Payload payload) {

        Message message = new Message(
                payload.getPrice(),
                "POST",
                "/buy"
        );

        producer.sendMessage(message);
        return ResponseEntity.ok(message);
    }

    @PostMapping("/get-last-message-data")
    public ResponseEntity<Message> getLastMessage() {

        Message message = consumer.getLastMessage();
        if (message == null) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(message);
    }
}
