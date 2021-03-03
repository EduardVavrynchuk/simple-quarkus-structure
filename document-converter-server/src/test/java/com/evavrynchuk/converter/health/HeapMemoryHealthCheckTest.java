package com.evavrynchuk.converter.health;

import org.eclipse.microprofile.health.HealthCheck;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HeapMemoryHealthCheckTest {

    private static final int MAX_PERCENT = 60;

    private HeapMemoryHealthCheck heapMemoryHealthCheck;

    @BeforeEach
    public void before() {
        heapMemoryHealthCheck = new HeapMemoryHealthCheck(MAX_PERCENT);
    }

    @Test
    public void testCreateDelegate() {
        HealthCheck delegate = heapMemoryHealthCheck.createDelegate();

        Assertions.assertNotNull(delegate);
        Assertions.assertSame(io.smallrye.health.checks.HeapMemoryHealthCheck.class, delegate.getClass());
    }


}