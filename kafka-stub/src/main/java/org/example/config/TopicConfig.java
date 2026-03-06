package org.example.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicConfig {
    @Bean
    public NewTopic topic() {
        return new NewTopic("payments", 1, (short) 1);
    }
}
