package com.example.demo.Implements.Notifications;

import com.example.demo.Interfaces.Notification.NotificationInterface;
import com.example.demo.entity.Notifications.Notifications;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationInterfaceImpl implements NotificationInterface {
    @Override
    public List<Notifications> getSomeNotifications(String phone) {
        return null;
    }
}
