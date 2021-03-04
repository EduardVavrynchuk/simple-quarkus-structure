package com.evavrynchuk.converter.rest.api;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

@Path("info")
@Tag(name = "Info API")
public class InfoApi {

    static final String PROPERTY_VERSION = "version";
    static final String PROPERTY_BRANCH = "branch";
    static final String PROPERTY_TAG = "tag";
    static final String PROPERTY_COMMIT = "commit";
    static final String PROPERTY_BUILD_TIMESTAMP = "buildTimestamp";

    @ConfigProperty(name = "git.build.version")
    String version;

    @ConfigProperty(name = "git.branch")
    String branch;

    @ConfigProperty(name = "git.tags")
    Optional<String> tags;

    @ConfigProperty(name = "git.commit.id.abbrev")
    String abbrev;

    @ConfigProperty(name = "git.build.time")
    String time;

    public InfoApi() {
    }

    @GET
    @Operation(summary = "Retrieving information about Git and Build info of a running JAR")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> getInfo() {

        Map<String, Object> info = new TreeMap<>();

        info.put(PROPERTY_VERSION, version);
        info.put(PROPERTY_BRANCH, branch);
        info.put(PROPERTY_TAG, tags.orElse(""));
        info.put(PROPERTY_COMMIT, abbrev);
        info.put(PROPERTY_BUILD_TIMESTAMP, time);

        return info;

    }

}
