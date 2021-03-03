package com.evavrynchuk.converter.health;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

abstract class DelegatingHealthCheck implements HealthCheck {

    @Inject
    Config config;

    private HealthCheck delegate;

    protected abstract HealthCheck createDelegate(Config config);

    @PostConstruct
    public final void init() {
        this.delegate = this.createDelegate(config);
    }

    @Override
    public final HealthCheckResponse call() {
        return delegate.call();
    }

    final HealthCheck getDelegate() {
        return delegate;
    }

    final void setDelegate(HealthCheck delegate) {
        this.delegate = delegate;
    }
}
