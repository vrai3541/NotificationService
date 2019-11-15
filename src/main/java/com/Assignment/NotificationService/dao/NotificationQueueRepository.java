package com.Assignment.NotificationService.dao;

import com.Assignment.NotificationService.entity.FailedNotificationQueue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NotificationQueueRepository extends JpaRepository<FailedNotificationQueue,Long> {



    @Query(value="select * from NotificationQueue where status =?1 and retryCount<=?2",nativeQuery = true)
    List<FailedNotificationQueue> findAllNotificationsForReattempt(String Status, long retryCount);

    @Query(value="delete from NotificationQueue where status in ?1 and retryCount=?2",nativeQuery = true)
    void deleteSuccessFullNotifications(List successStatus,Long retryCount);
}
