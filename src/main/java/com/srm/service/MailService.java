package com.srm.service;

import com.srm.dto.MailMessageDto;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

/**
 * Отправщик сообщений на почту
 */
@Service
public class MailService {

    private static final Logger logger = LoggerFactory.getLogger(MailService.class);

    @Autowired
    private JavaMailSender mailSender;

    @Value("${mail.from.address}")
    private String fromAddress;

    @Value("${mail.from.name}")
    private String fromName;

    /**
     * Отправка сообщения
     *
     * @param messageEvent сообщение
     */
    public void sendMail(@NotNull MailMessageDto messageEvent) {
        MimeMessage message = mailSender.createMimeMessage();

        try {
            try {
                MimeMessageHelper helper = new MimeMessageHelper(message, true);
                helper.setFrom(fromAddress, fromName);
                helper.setTo(messageEvent.getTo());
                helper.setSubject(messageEvent.getSubject());
                helper.setText(messageEvent.getMessage(), messageEvent.isHtml());
            } catch (MessagingException | UnsupportedEncodingException e) {
                logger.error("Ошибка формирования письма", e);
            }

            mailSender.send(message);
        } catch (MailException e) {
            logger.error("Ошибка отправки письма", e);
        }
    }
}
