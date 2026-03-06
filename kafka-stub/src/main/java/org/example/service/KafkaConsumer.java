package org.example.service;

import org.example.model.Message;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private volatile Message lastMessage;

    @KafkaListener(topics = "payments", groupId = "payments-group")
    public void listen(Message message) {
        this.lastMessage = message;
    }

    public Message getLastMessage() {
        return lastMessage;
    }
}
