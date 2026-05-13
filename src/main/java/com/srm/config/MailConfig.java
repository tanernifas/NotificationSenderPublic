package com.srm.config;

import jakarta.mail.internet.InternetAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.MimeMessagePreparator;

/**
 * Конфигурация отправки почты
 */
@Configuration
public class MailConfig {
    @Value("${mail.from.address}")
    private String fromAddress;

    @Value("${mail.from.name}")
    private String fromName;

    @Bean
    public MimeMessagePreparator mimeMessagePreparator() {
        return mimeMessage -> {
            mimeMessage.setFrom(new InternetAddress(fromAddress, fromName));
        };
    }
}
