package com.wx.oauth2demo.enhancer;

import java.util.HashMap;
import java.util.Map;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

/**
 * @program: deep-in-springboot
 * @description:
 * @author: Mr.Wang
 * @create: 2022-02-22 14:50
 **/
public class JwtTokenEnhancer implements TokenEnhancer {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        Map<String, Object> info = new HashMap<>();

        info.put("info", "info" );
        ((DefaultOAuth2AccessToken)accessToken).setAdditionalInformation(info);
        return accessToken;

    }
}
