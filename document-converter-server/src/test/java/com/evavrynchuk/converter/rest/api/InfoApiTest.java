package com.evavrynchuk.converter.rest.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Optional;

public class InfoApiTest {

    private InfoApi infoApi;

    @BeforeEach
    public void before() {
        infoApi = new InfoApi();
    }

    @Test
    public void testGetInfo() {

        final String appVersion = "v1";
        final String tag = "t1";
        final String branch = "b1";
        final String commit = "c1";
        final String buildTimestamp = "2020-03-03";

        infoApi.version = appVersion;
        infoApi.tags = Optional.of(tag);
        infoApi.branch = branch;
        infoApi.abbrev = commit;
        infoApi.time = buildTimestamp;

        Map<String, Object> info = infoApi.getInfo();

        Assertions.assertNotNull(info);
        Assertions.assertEquals(5, info.size());
        Assertions.assertEquals(appVersion, info.get(InfoApi.PROPERTY_VERSION));
        Assertions.assertEquals(tag, info.get(InfoApi.PROPERTY_TAG));
        Assertions.assertEquals(branch, info.get(InfoApi.PROPERTY_BRANCH));
        Assertions.assertEquals(commit, info.get(InfoApi.PROPERTY_COMMIT));
        Assertions.assertEquals(buildTimestamp, info.get(InfoApi.PROPERTY_BUILD_TIMESTAMP));

    }

}