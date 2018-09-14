package com.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LongProcessController {
    @RequestMapping("/long-process")
    public String pause() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            log.warn("Process interrupted.");
            e.printStackTrace();
        }
        return "Process finished";
    }
}