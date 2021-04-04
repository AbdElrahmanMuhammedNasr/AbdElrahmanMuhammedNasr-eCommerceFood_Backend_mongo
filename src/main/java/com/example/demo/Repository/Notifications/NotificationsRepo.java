package com.example.demo.Repository.Notifications;

import com.example.demo.entity.Notifications.Notifications;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationsRepo extends MongoRepository<Notifications, String> {
}
