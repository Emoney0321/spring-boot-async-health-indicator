package com.teketik.spring.health.indicators;

import com.teketik.spring.health.AsyncHealth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.health.contributor.Health;
import org.springframework.boot.health.contributor.HealthIndicator;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

@Profile("with-timing-out-web-indicator")
@Component
@AsyncHealth(refreshRate = 1, timeout = 1)
public class TimingOutWebIndicator implements HealthIndicator {

    @Autowired
    private Environment environment;

    @Override
    public Health health() {
        final String port = environment.getProperty("local.server.port");
        try(InputStream ignored = new URL("http://localhost:" + port + "/").openStream()) {
            // open and consume the response stream so the request fully executres
        } catch(IOException e) {
            throw new RuntimeException(e);
        }

        return Health.up().build();
    }

}
