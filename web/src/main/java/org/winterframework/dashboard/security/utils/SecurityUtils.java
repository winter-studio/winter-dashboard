package org.winterframework.dashboard.security.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.winterframework.dashboard.security.core.JwtUserDetails;

@Slf4j
public class SecurityUtils {

    public static final int JWT_TOKEN_EXPIRED = 1;
    public static final int JWT_TOKEN_INVALID = 2;
    private final static ThreadLocal<Integer> authenticationState = new ThreadLocal<>();

    public static void setAuthenticationState(int state) {
        authenticationState.set(state);
    }

    public static int getAuthenticationState() {
        return authenticationState.get() == null ? 0 : authenticationState.get();
    }

    public static void clearAuthenticationState() {
        authenticationState.remove();
    }

    public static Long getUserId() {
        final Authentication authentication = getAuthentication();

        Object principal = authentication.getPrincipal();

        Long userId = null;
        if (principal instanceof JwtUserDetails jwtUserDetails) {
            userId = jwtUserDetails.getUserId();
        } else if (principal instanceof String s) {
            userId = Long.valueOf(s);
        }

        return userId;
    }

    private static Authentication getAuthentication() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null) {
            log.debug("no authentication in security context found");
            throw new RuntimeException("no authentication in security context found");
        }
        return authentication;
    }

}
