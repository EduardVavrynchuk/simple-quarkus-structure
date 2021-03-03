package com.evavrynchuk.converter.health;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.Liveness;

import javax.inject.Singleton;

@Singleton
@Liveness
public class HeapMemoryHealthCheck extends DelegatingHealthCheck {

    @ConfigProperty(name = "health.memory.max-percentage")
    Integer memoryMaxPercentage;

    @Override
    protected HealthCheck createDelegate(Config config) {
        return new io.smallrye.health.checks.HeapMemoryHealthCheck(memoryMaxPercentage);
    }
}
