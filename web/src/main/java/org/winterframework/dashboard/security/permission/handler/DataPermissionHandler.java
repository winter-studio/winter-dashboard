package org.winterframework.dashboard.security.permission.handler;

import org.winterframework.dashboard.security.core.JwtAuthenticationToken;

public interface DataPermissionHandler {
    String getSupportPermission();

    boolean hasPermission(JwtAuthenticationToken authentication, Object targetDomainObject);
}
