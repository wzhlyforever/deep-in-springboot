package com.wx.oauth2demo.config;

import com.wx.oauth2demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * @program: deep-in-springboot
 * @description: 授权服务器和资源服务器的配置
 * @author: Mr.Wang
 * @create: 2022-02-21 16:16
 **/
@Configuration
public class OAuth2ServerConfig {




    //授权服务器配置
    @Configuration
    @EnableAuthorizationServer
    protected static class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

        // 配置AuthorizationServer安全认证的相关信息,创建ClientCredentialsTokenEndpointFilter核心过滤器

        @Autowired
        private PasswordEncoder passwordEncoder;

        @Autowired
        private AuthenticationManager authenticationManager;

        @Autowired
        private UserService userService;

        @Autowired
        private RedisTokenStore redisTokenStore;

        // 配置OAuth2的客户端相关信息
        @Override
        public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

            clients.inMemory()
                    .withClient("client")    // 配置client id
                    .secret(passwordEncoder.encode("123123"))
                    .accessTokenValiditySeconds(3600)   // 配置 accesstoken 的访问期限
                    .refreshTokenValiditySeconds(86400)  // 配置 refreshtoken 的期限
                    .redirectUris("http://www.baidu.com")
                    .scopes("all")
                    .authorizedGrantTypes("authorization_code","password","client_credentials","refresh_token");

        }
        // 配置AuthorizationServerEndpointsConfigurer众多相关类，
        // 包括配置身份认证器，配置认证方式，TokenStore，TokenGranter，OAuth2RequestFactory
        @Override
        public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
            endpoints.authenticationManager(authenticationManager)
                    .tokenStore(redisTokenStore) // 将指定token 存储到redis里
                    .reuseRefreshTokens(false)   // 是否重复使用refresh_token
                    .userDetailsService(userService)
                    .allowedTokenEndpointRequestMethods(HttpMethod.GET,HttpMethod.POST);
        }


        @Override
        public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
            security.allowFormAuthenticationForClients();   // 允许表单验证
        }
    }

    //配置资源服务器
    @Configuration
    @EnableResourceServer
    protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

        @Override
        public void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                    .anyRequest().authenticated()
                    .and().requestMatchers().antMatchers("/user/**");
        }
    }


}
