package com.hourfun.auth.config.redis;

import com.hourfun.auth.common.listener.redis.RedisSubscribe;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

@RequiredArgsConstructor
@Configuration
public class RedisPubSubConfig {
    @Qualifier("redisConnectionFactory")
    private final LettuceConnectionFactory redisConnectionFactory;
//    @Qualifier("redisTemplate")
//    private final RedisTemplate<String, Object> redisTemplate;
    private final RedisSubscribe redisSubscribe;

    @Bean
    RedisMessageListenerContainer container(@Qualifier("testMessage1") MessageListenerAdapter testMessage1,
                                            @Qualifier("testMessage2") MessageListenerAdapter testMessage2) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(redisConnectionFactory);
        container.addMessageListener(testMessage1, new PatternTopic("test1"));
        container.addMessageListener(testMessage2, new PatternTopic("test2"));
        return container;
    }

    @Bean(name="testMessage1")
    MessageListenerAdapter testMessage1(RedisSubscribe redisSubscribe) {
        return new MessageListenerAdapter(redisSubscribe, "subMessage1");
    }

    @Bean(name="testMessage2")
    MessageListenerAdapter testMessage2(RedisSubscribe redisSubscribe) {
        return new MessageListenerAdapter(redisSubscribe, "subMessage2");
    }
}
