package org.example.service;

import org.example.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);
    private final KafkaTemplate<String, Message> kafkaTemplate;
    private final String topic = "payments";

    public KafkaProducer(KafkaTemplate<String, Message> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Message message) {
        kafkaTemplate.send(topic, message).whenComplete((request, e) -> {
            if (e != null)
                logger.error("Error sending to Kafka", e);
        });
    }

}
