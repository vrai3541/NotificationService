package com.Assignment.NotificationService.dao;

import com.Assignment.NotificationService.entity.DailyCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

public interface DailyCountRepository extends JpaRepository<DailyCount,Long > {

    @Query(value="select * from DailyCount where userID =?1 and todayDate=?2",nativeQuery = true)

    DailyCount findOne(Long userId, Date todayDate);
}
