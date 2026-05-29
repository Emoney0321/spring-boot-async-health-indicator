package com.teketik.spring.health.indicators;

import com.teketik.spring.health.AsyncHealth;

import org.springframework.boot.health.contributor.Health;
import org.springframework.boot.health.contributor.HealthIndicator;
import org.springframework.stereotype.Component;

@AsyncHealth
@Component
public class UpIndicator1 implements HealthIndicator {

    @Override
    public Health health() {
        return Health
            .up()
            .withDetail("detailKey", "detailValue")
            .build();
    }

}
