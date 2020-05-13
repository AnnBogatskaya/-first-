package com.bogatskaya.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bogatskaya.app.domain.schedule.Record;

public interface RecordRepository extends JpaRepository<Record,Long> {
}
