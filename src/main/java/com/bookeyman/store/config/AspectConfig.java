package com.bookeyman.store.config;

import com.bookeyman.store.aspect.AuditableAspect;
import com.bookeyman.store.clients.AuditRSocketClient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AspectConfig {

    @Bean
    public AuditableAspect auditableAspect(AuditRSocketClient auditRSocketClient) {
        return new AuditableAspect(auditRSocketClient);
    }

}
