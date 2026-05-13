package com.srm.controller.api;

import com.srm.dto.MailMessageDto;
import com.srm.service.MailService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Демонстрационный API контроллер для отправки уведомлений
 */
@AllArgsConstructor
@RestController
@RequestMapping("/api/demo")
public class DemoApiController {

    private final MailService mailService;

    @PostMapping("/send")
    public ResponseEntity<MailMessageDto> send(@RequestBody MailMessageDto mailMessageDto) {
        mailService.sendMail(mailMessageDto);

        return ResponseEntity.ok(mailMessageDto);
    }
}
