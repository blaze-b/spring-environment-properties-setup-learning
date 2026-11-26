package com.blazeb.config.awsparam;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParamController {

    private final ParamStoreDemoProperties demo;
    private final SsmPathProperties ssm;

    public ParamController(ParamStoreDemoProperties demo, SsmPathProperties ssm) {
        this.demo = demo;
        this.ssm = ssm;
    }

    @GetMapping("/params")
    public Map<String, Object> params() {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("greeting", demo.greeting());
        body.put("dbPasswordConfigured", demo.dbPassword() != null && !demo.dbPassword().isBlank());
        body.put("ssmPrefix", ssm.prefix());
        body.put("ssmApplicationName", ssm.applicationName());
        body.put("ssmRegion", ssm.region());
        body.put("expectedParameterPath", ssm.prefix() + "/" + ssm.applicationName());
        return body;
    }
}
