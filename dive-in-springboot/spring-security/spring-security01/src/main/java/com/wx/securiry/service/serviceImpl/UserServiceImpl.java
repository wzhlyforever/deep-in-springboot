package com.wx.securiry.service.serviceImpl;

import com.wx.securiry.bean.Permission;
import com.wx.securiry.bean.User;
import com.wx.securiry.mapper.PermissionMapper;
import com.wx.securiry.mapper.UserMapper;
import com.wx.securiry.service.UserService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @program: deep-in-springboot
 * @description:
 * @author: Mr.Wang
 * @create: 2022-02-19 19:18
 **/

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PermissionMapper permissionMapper;


    @Override
    public User getByUserName(String userName) {
        return userMapper.getByUsername(userName);
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        // 从mysql 获取
        User user = getByUserName(userName);

        // 该用户的所有权限
        List<GrantedAuthority> authorities = new ArrayList<>();

        if (user != null) {
            // 获取该用户的所有权限
            List<Permission> permissions = permissionMapper.selectByUserId(user.getId());

            permissions.forEach(
                    permission -> {
                        if (permission != null && !StringUtils.isEmpty(permission.getEnname())) {
                            GrantedAuthority authority = new SimpleGrantedAuthority(permission.getEnname());
                            authorities.add(authority);
                        }
                    }
            );
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                    authorities);

        } else {
            throw new UsernameNotFoundException("用户名不存在");

        }


    }
}
