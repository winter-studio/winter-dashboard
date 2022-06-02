package org.winterframework.dashboard.security.core;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.winterframework.dashboard.security.utils.SecurityUtils;
import org.winterframework.dashboard.web.model.ApiResCodes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        // This is invoked when user tries to access a secured REST resource without supplying any credentials
        // We should just send a 401 Unauthorized response because there is no 'login page' to redirect to
        // Here you can place any message you want
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        PrintWriter writer = response.getWriter();
        String msg;
        switch (SecurityUtils.getAuthenticationState()) {
            case SecurityUtils.JWT_TOKEN_EXPIRED -> msg = buildMessage(ApiResCodes.Failure.JWT_EXPIRED, "凭证过期");
            case SecurityUtils.JWT_TOKEN_INVALID -> msg = buildMessage(ApiResCodes.Failure.JWT_INVALID, "凭证无效");
            default -> msg = buildMessage(ApiResCodes.Failure.SECURITY, "Unauthorized");
        }

        writer.write(msg);
        writer.close();

    }

    private String buildMessage(int security, String Unauthorized) {
        return "{\"code\":" + security + ",\"message\":\"" + Unauthorized + "\"}";
    }
}
