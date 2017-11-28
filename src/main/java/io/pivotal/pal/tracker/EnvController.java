package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {
    Map<String, String> envProps = new HashMap<>(4);

    public EnvController(@Value("${PORT:NOT SET}") String port, @Value("${MEMORY_LIMIT:NOT SET}") String memoryLimit,
                         @Value("${CF_INSTANCE_INDEX:NOT SET}") String cfIndex, @Value("${CF_INSTANCE_ADDR:NOT SET}") String cfInstanceAddr) {
        envProps.put("PORT",port);
        envProps.put("MEMORY_LIMIT",memoryLimit);
        envProps.put("CF_INSTANCE_INDEX",cfIndex);
        envProps.put("CF_INSTANCE_ADDR",cfInstanceAddr);

    }

    @GetMapping("/env")
    public Map<String, String> getEnv() {
    return envProps;
    }
}
