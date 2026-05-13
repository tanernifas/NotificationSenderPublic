package com.srm.dto;

import lombok.Data;

/**
 * Сообщение с информацией кому и зачем его отправлять<br>
 * Класс обменный, должен находится у всех, кто общается с данным сервисом
 */
@Data
public class MailMessageDto implements MessageDto {
    private String to;
    private String message;
    private String subject;
    private boolean isHtml;
}
