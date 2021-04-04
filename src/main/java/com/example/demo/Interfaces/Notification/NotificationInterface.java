package com.example.demo.Interfaces.Notification;

import com.example.demo.entity.Notifications.Notifications;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface NotificationInterface {

    List<Notifications> getSomeNotifications(String phone);


}
