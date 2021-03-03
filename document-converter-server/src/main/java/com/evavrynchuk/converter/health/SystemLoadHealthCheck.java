package com.evavrynchuk.converter.health;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.Liveness;

import javax.inject.Singleton;

@Singleton
@Liveness
public class SystemLoadHealthCheck extends DelegatingHealthCheck {

    @ConfigProperty(name = "health.cpu.max-percentage")
    Integer maxCPUPercentage;

    @Override
    protected HealthCheck createDelegate(Config config) {
        return new io.smallrye.health.checks.SystemLoadHealthCheck(maxCPUPercentage);
    }
}
