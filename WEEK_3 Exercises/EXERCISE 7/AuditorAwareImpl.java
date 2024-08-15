package com.example.employeemanagementsystem.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        // Replace with logic to fetch the current user from the security context
        return Optional.of("system"); // Placeholder for the current user
    }
}
