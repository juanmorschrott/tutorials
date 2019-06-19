package com.juanmorschrott.webSockets.controller;

import com.juanmorschrott.webSockets.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class ChatController {

    @MessageMapping("/broadcast")
    @SendTo("/topic/broadcast")
    public Message broadcast(Message message) {
        Message broadcast = new Message();
        broadcast.setText(HtmlUtils.htmlEscape(message.getText()));
        return broadcast;
    }

}
