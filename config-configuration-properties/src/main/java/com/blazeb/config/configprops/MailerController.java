package com.blazeb.config.configprops;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailerController {

    private final MailerProperties mailer;

    public MailerController(MailerProperties mailer) {
        this.mailer = mailer;
    }

    @GetMapping("/mailer")
    public Map<String, Object> mailer() {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("host", mailer.getHost());
        body.put("port", mailer.getPort());
        body.put("recipients", mailer.getRecipients());
        body.put("startTls", mailer.isStartTls());
        return body;
    }
}
