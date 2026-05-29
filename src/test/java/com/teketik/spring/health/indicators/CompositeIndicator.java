package com.teketik.spring.health.indicators;

import com.teketik.spring.health.AsyncHealth;

import org.springframework.boot.health.contributor.CompositeHealthContributor;
import org.springframework.boot.health.contributor.Health;
import org.springframework.boot.health.contributor.HealthContributor;
import org.springframework.boot.health.contributor.HealthContributors;
import org.springframework.boot.health.contributor.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.stream.Stream;

@AsyncHealth
@Component
public class CompositeIndicator implements CompositeHealthContributor {

    private final HealthIndicator healthIndicator = new HealthIndicator() {
        @Override
        public Health health() {
            return Health.up().build();
        }
    };

    @Override
    public HealthContributor getContributor(String name) {
        throw new AssertionError();
    }

    @Override
    public Iterator<HealthContributors.Entry> iterator() {
        return stream().iterator();
    }

    @Override
    public Stream<Entry> stream() {
        return Stream.of(new HealthContributors.Entry("name", healthContributor));
    }

}
