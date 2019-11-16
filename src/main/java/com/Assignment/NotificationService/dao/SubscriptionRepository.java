package com.Assignment.NotificationService.dao;

import com.Assignment.NotificationService.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription,Long> {


}
