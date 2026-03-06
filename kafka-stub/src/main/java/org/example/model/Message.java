package org.example.model;

import java.time.Instant;
import java.util.UUID;

public class Message {

    private String price;
    private String message_id;
    private String timestamp;
    private String method;
    private String uri;

    public Message() {
    }

    public Message(String price, String method, String uri) {
        this.price = price;
        this.message_id = UUID.randomUUID().toString();
        this.timestamp = Long.toString(Instant.now().toEpochMilli());
        this.method = method;
        this.uri = uri;
    }

    public String getPrice() {
        return price;
    }

    public String getMessage_id() {
        return message_id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getMethod() {
        return method;
    }

    public String getUri() {
        return uri;
    }
}
