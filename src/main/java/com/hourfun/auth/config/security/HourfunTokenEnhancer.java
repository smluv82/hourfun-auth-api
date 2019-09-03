package com.hourfun.auth.config.security;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.Map;

public class HourfunTokenEnhancer implements TokenEnhancer {
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
        ((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(Map.of("authorities", oAuth2Authentication.getUserAuthentication().getAuthorities()));
        return oAuth2AccessToken;
    }
}
