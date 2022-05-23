package org.winterframework.dashboard.web.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Jackson {
    private static final ThreadLocal<ObjectMapper> om = ThreadLocal.withInitial(() -> {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper;
    });

    /**
     * Flyweight thread local objectMapper.  Users of this should not keep a reference to this.
     * @return an ObjectMapper
     */
    public static ObjectMapper get() {
        return om.get();
    }
}
