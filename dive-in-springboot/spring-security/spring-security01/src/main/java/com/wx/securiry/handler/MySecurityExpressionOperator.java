package com.wx.securiry.handler;

import javax.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;

/**
 * @program: deep-in-springboot
 * @description:
 * @author: Mr.Wang
 * @create: 2022-02-20 18:36
 **/
public interface MySecurityExpressionOperator {

    boolean hasPermission(HttpServletRequest request, Authentication authentication);

}
