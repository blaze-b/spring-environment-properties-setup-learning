package com.blazeb.config.configclient;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    private final RemoteMessageProperties props;

    public MessageController(RemoteMessageProperties props) {
        this.props = props;
    }

    @GetMapping("/message")
    public Map<String, Object> message() {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("message", props.message());
        body.put("widgetsEnabled", props.feature() != null && props.feature().widgetsEnabled());
        return body;
    }
}
