package com.evavrynchuk.converter.health;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.Liveness;

import javax.inject.Singleton;

@Singleton
@Liveness
public class HeapMemoryHealthCheck extends DelegatingHealthCheck {

    @ConfigProperty(name = "health.memory.max-percentage")
    Integer memoryMaxPercentage;

    public HeapMemoryHealthCheck() {
    }

    HeapMemoryHealthCheck(Integer memoryMaxPercentage) {
        this();
        this.memoryMaxPercentage = memoryMaxPercentage;
    }

    @Override
    protected HealthCheck createDelegate() {
        return new io.smallrye.health.checks.HeapMemoryHealthCheck(memoryMaxPercentage);
    }
}
