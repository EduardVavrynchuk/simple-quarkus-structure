package com.evavrynchuk.converter.health;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class DelegatingHealthCheckTest {

    private class TestHealthCheck extends DelegatingHealthCheck {

        @Override
        protected HealthCheck createDelegate() {
            return delegate;
        }
    }

    private HealthCheck delegate;
    private DelegatingHealthCheck delegatingHealthCheck;
    private HealthCheckResponse response;

    @BeforeEach
    public void before() {
        delegate = Mockito.mock(HealthCheck.class);
        delegatingHealthCheck = new TestHealthCheck();
        response = Mockito.mock(HealthCheckResponse.class);
    }

    @Test
    public void testInit() {

        delegatingHealthCheck.init();

        Assertions.assertSame(delegate, delegatingHealthCheck.getDelegate());
    }

    @Test
    public void testCall() {

        delegatingHealthCheck.setDelegate(delegate);

        Mockito.when(delegate.call()).thenReturn(response);

        Assertions.assertSame(response, delegatingHealthCheck.call());
    }

}