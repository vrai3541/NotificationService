package com.Assignment.NotificationService.dao;

import com.Assignment.NotificationService.entity.Recipients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipientRepository extends JpaRepository<Recipients,Long> {
}
