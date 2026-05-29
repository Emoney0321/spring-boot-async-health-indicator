package com.teketik.spring.noasync;

import org.springframework.boot.health.contributor.Health;
import org.springframework.boot.health.contributor.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class DefaultIndicator implements HealthIndicator {

    @Override
    public Health health() {
        return Health
            .up()
            .build();
    }

}
