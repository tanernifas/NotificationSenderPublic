package com.srm.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.srm.dto.MailMessageDto;
import com.srm.service.MailService;
import lombok.AllArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.jetbrains.annotations.NotNull;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;

/**
 * Приемщик данных
 */
@Component
@AllArgsConstructor
public class NotificationConsumer {

    private final MailService mailService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Слушатель сообщений для отправки по почте
     *
     * @param consumerRecord сообщение с информацией кому и зачем его отправлять
     */
    @KafkaListener(topics = "mail-message-topic")
    public void handleMailMessage(@NotNull ConsumerRecord<String, LinkedHashMap<String, Object>> consumerRecord) {
        mailService.sendMail(objectMapper.convertValue(consumerRecord.value(), MailMessageDto.class));
    }

    /**
     * Слушатель сообщений
     *
     * @param consumerRecord сообщение
     */
    @KafkaListener(topics = "only-message-topic")
    public void handleOnlyMessage(@NotNull ConsumerRecord<String, String> consumerRecord) {
        System.out.println("Get message: " + consumerRecord.value());
    }
}
