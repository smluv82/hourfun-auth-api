package com.hourfun.auth.common.listener.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RedisSubscribe {
    public void subMessage1(final Object message) {
        System.out.println("message1 : " + message.toString());
    }

    public void subMessage2(final Object message) {
        System.out.println("message2 : " + message.toString());
    }
}
