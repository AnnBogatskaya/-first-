package com.bogatskaya.app.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bogatskaya.app.domain.schedule.Record;
import com.bogatskaya.app.exception.NotFoundException;
import com.bogatskaya.app.repository.RecordRepository;
import com.bogatskaya.app.service.RecordService;
import com.bogatskaya.app.service.ScheduleService;

@Service
public class RecordServiceImpl implements RecordService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RecordServiceImpl.class);
    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private RecordRepository recordRepository;

    @Override
    public List<Record> findAll() {
        return recordRepository.findAll();
    }

    @Override
    public List<Record> findAllByDate(final String date) {
        List<Record> resultList = new ArrayList<>();

        for(Record record : findAll()){
            if(record.getDate().equals(LocalDate.parse(date))){
                resultList.add(record);
            }
        }
        return resultList;
    }

    @Override
    public Record findOne(Long id) {
        for(Record record : findAll()){
            if(record.getId().equals(id)){
                return record;
            }
        }
        LOGGER.error("No record with id: {}",id);
        throw new NotFoundException("No such record");
    }

    @Override
    public void addRecord(Record record) {
//        Schedule schedule = scheduleService.findByDate(record.getDate());
//
//        if(schedule != null){
//            schedule.addRecord(record);
//        }
//        recordRepository.save(record);
    }

    @Override
    public void deleteRecord(Long id) {
        recordRepository.deleteById(id);
    }
}
