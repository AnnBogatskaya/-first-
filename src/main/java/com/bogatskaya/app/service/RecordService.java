package com.bogatskaya.app.service;

import java.util.List;

import com.bogatskaya.app.domain.schedule.Record;


public interface RecordService {

    List<Record> findAll();

    List<Record> findAllByDate(String date);

    Record findOne(Long id);

    void addRecord(Record record);

    void deleteRecord(Long id);
}
