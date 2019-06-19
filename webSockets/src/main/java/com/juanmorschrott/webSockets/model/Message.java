package com.juanmorschrott.webSockets.model;

import lombok.Data;

@Data
public class Message {
    private String text;
    private String from;
}
