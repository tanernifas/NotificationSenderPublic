package com.srm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Ядро
 */
@SpringBootApplication
@ComponentScan(basePackages = {
        "com.srm.config",
        "com.srm.consumer",
        "com.srm.controller",
        "com.srm.dto",
        "com.srm.service"
})
public class NotificationSender {

    public static void main(String[] args) {
        SpringApplication.run(NotificationSender.class, args);
    }
}
