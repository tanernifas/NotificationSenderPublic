package com.srm.dto;

/**
 * Сообщение<br>
 * Класс обменный, должен находится у всех, кто общается с данным сервисом
 */
public interface MessageDto {

    /**
     * Получить текст сообщения
     *
     * @return текст сообщения
     */
    String getMessage();
}
