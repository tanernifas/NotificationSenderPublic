package com.srm.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Демонстрационный контроллер для отправки уведомлений
 */
@Controller
public class DemoController {

    @GetMapping
    public String demo() {
        return "demo";
    }
}
