package com.evavrynchuk.converter.health;

import org.eclipse.microprofile.health.HealthCheck;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SystemLoadHealthCheckTest {

    private static final int MAX_PERCENT = 60;

    private SystemLoadHealthCheck systemLoadHealthCheck;

    @BeforeEach
    public void before() {
        systemLoadHealthCheck = new SystemLoadHealthCheck(MAX_PERCENT);
    }

    @Test
    public void testCreateDelegate() {
        HealthCheck delegate = systemLoadHealthCheck.createDelegate();

        Assertions.assertNotNull(delegate);
        Assertions.assertSame(io.smallrye.health.checks.SystemLoadHealthCheck.class, delegate.getClass());
    }

}