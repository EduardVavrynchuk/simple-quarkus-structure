package com.evavrynchuk.converter.health;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;

import javax.annotation.PostConstruct;

public abstract class DelegatingHealthCheck implements HealthCheck {

    private HealthCheck delegate;

    protected abstract HealthCheck createDelegate();

    @PostConstruct
    public final void init() {
        this.delegate = this.createDelegate();
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
