package com.pca.security;

import com.pca.config.Constants;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

/**
 * Implementation of AuditorAware based on Spring Security.
 */
@Component
public class SpringSecurityAuditorAware implements AuditorAware<Long> {

    public Long getCurrentAuditor() {
        String userName = SecurityUtils.getCurrentLogin();
        //TODO: inject user service and get the use id
        return 1l;
    }
}
