package com.Assignment.NotificationService.dao;

import com.Assignment.NotificationService.entity.NotificationTempData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NotificationQueueRepository extends JpaRepository<NotificationTempData,Long> {



    @Query(value="select * from NotificationQueue where status =?1 and retryCount<=?2",nativeQuery = true)
    List<NotificationTempData> findAllNotificationsForReattempt(String Status, long retryCount);

    @Query(value="delete from NotificationQueue where status in ?1 and retryCount=?2",nativeQuery = true)
    void deleteSuccessFullNotifications(List successStatus,Long retryCount);
}
