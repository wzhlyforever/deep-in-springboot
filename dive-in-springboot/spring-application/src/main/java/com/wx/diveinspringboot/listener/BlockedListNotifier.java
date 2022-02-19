package com.wx.diveinspringboot.listener;

import com.wx.diveinspringboot.Event.BlockedListEvent;
import org.springframework.context.ApplicationListener;

/**
 * @program: deep-in-springboot
 * @description:
 * @author: Mr.Wang
 * @create: 2021-08-23 10:06
 **/
public class BlockedListNotifier implements ApplicationListener<BlockedListEvent> {

    private String notificationAddress;

    public void setNotificationAddress (String notificationAddress) {
      this.notificationAddress = notificationAddress;
    }

    @Override
    public void onApplicationEvent(BlockedListEvent event) {
        System.out.println("email event");
    }
}
