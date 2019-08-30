package com.hourfun.auth.app;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value="/test", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TestController {

    @GetMapping("/hello")
    public String hello() throws Exception {
        log.info("hello");

        return "hello world";
    }
}
