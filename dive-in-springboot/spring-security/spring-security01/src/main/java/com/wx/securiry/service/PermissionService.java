package com.wx.securiry.service;

import com.wx.securiry.bean.Permission;
import java.util.List;

/**
 * @author Fox
 */
public interface PermissionService  {

    List<Permission> selectByUserId(Long userId);
}
