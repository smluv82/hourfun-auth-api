package com.hourfun.auth.app.oauth;

import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {

    @GetMapping("/info")
    public Map<String, Object> userInfo(OAuth2Authentication user) throws Exception {
        log.info("1 : {}", user.getUserAuthentication().getPrincipal());
        log.info("2 : {}", user.getUserAuthentication().getAuthorities());


        return ImmutableMap.of("user", user.getUserAuthentication().getPrincipal()
        , "authorities", user.getUserAuthentication().getAuthorities()
        , "t2", user.getUserAuthentication().getDetails());
    }
}
