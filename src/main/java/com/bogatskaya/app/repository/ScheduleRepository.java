package com.bogatskaya.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bogatskaya.app.domain.schedule.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule,Long>{
}
