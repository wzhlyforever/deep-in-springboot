package com.wx.securiry.service;

import com.wx.securiry.bean.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


@Service
public interface UserService extends UserDetailsService {

    public User getByUserName(String userName);

}
