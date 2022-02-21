package com.wx.securiry.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @program: deep-in-springboot
 * @description:
 * @author: Mr.Wang
 * @create: 2022-02-20 15:56
 **/
public class AuthenticationDemo {

    private static AuthenticationManager am = new SampleAuthenticationManager();

    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while (true) {

            try {
                System.out.println("please enter you username");
                String userName = in.readLine();
                System.out.println("please enter you password");
                String password = in.readLine();
                Authentication authentication = new UsernamePasswordAuthenticationToken(userName, password);
                final Authentication authenticate = am.authenticate(authentication);
                SecurityContextHolder.getContext().setAuthentication(authenticate);
                break;

            } catch (IOException e) {
                System.out.println("Authentication failed: " + e.getMessage());
            }
        }

        System.out.println("Successfully authenticated. Security context contains: " +
        SecurityContextHolder.getContext().getAuthentication());

    }

}


class SampleAuthenticationManager implements AuthenticationManager {

    public static List<GrantedAuthority> authorities = new ArrayList<>();

    static {
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        if (authentication.getName().equals(authentication.getCredentials())) {
            return new UsernamePasswordAuthenticationToken(
                    authentication.getName(), authentication.getCredentials(),authorities );
        }
        throw new BadCredentialsException("bad credentials");

    }
}
