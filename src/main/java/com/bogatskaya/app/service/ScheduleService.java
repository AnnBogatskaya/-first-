package com.bogatskaya.app.service;

import java.time.LocalDate;
import java.util.List;

import com.bogatskaya.app.domain.schedule.Schedule;


public interface ScheduleService {

    List<Schedule> findAll();

    Schedule findByDate(final String date);

    Schedule findOne(Long id);

    Schedule findByDate(LocalDate date);

    void createSchedule(Schedule schedule);

    void updateSchedule(Long id, Schedule schedule);

    void removeSchedule(Long id);

    boolean isExist(Schedule schedule);


}
