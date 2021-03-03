package com.evavrynchuk.converter.health;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.Liveness;

import javax.inject.Singleton;

@Singleton
@Liveness
public class SystemLoadHealthCheck extends DelegatingHealthCheck {

    @ConfigProperty(name = "health.cpu.max-percentage")
    Integer maxCPUPercentage;

    public SystemLoadHealthCheck() {
    }

    SystemLoadHealthCheck(Integer maxCPUPercentage) {
        this();
        this.maxCPUPercentage = maxCPUPercentage;
    }

    @Override
    protected HealthCheck createDelegate() {
        return new io.smallrye.health.checks.SystemLoadHealthCheck(maxCPUPercentage);
    }
}
