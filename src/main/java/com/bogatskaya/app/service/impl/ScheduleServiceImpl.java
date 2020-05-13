package com.bogatskaya.app.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bogatskaya.app.domain.schedule.Schedule;
import com.bogatskaya.app.exception.AlreadyExistException;
import com.bogatskaya.app.exception.NotFoundException;
import com.bogatskaya.app.repository.ScheduleRepository;
import com.bogatskaya.app.service.ScheduleService;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleServiceImpl.class);


    private ScheduleRepository scheduleRepository;

    @Autowired
    public ScheduleServiceImpl(ScheduleRepository scheduleRepository){
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public List<Schedule> findAll() {
        return scheduleRepository.findAll();
    }

    @Override
    public Schedule findOne(Long id) {
        for(Schedule schedule : findAll()){
            if(schedule.getId().equals(id)){
                return schedule;
            }
        }

        LOGGER.error("No schedule with id: {}",id);
        throw new NotFoundException("Schedule does not exist");
    }

    @Override
    public Schedule findByDate(LocalDate date) {

        for(Schedule schedule : findAll()){
            if (schedule.getDate().equals(date)){
                return schedule;
            }
        }

        LOGGER.error("No schedule on this date: {}",date);
        throw new NotFoundException("Schedule does not exist");
    }

    @Override
    public Schedule findByDate(String date) {

        for(Schedule schedule : findAll()){
            if(schedule.getDate().equals(LocalDate.parse(date))){
                return schedule;
            }
        }

        LOGGER.error("No schedule on this date: {}",date);
        throw new NotFoundException("Schedule does not exist");
    }

    @Override
    public void createSchedule(Schedule schedule) {
        if(!isExist(schedule)){
            scheduleRepository.save(schedule);
        }
    }

    @Override
    public void updateSchedule(Long id,Schedule schedule) {

    }

    @Override
    public void removeSchedule(Long id) {
        if(findOne(id) != null){
            scheduleRepository.deleteById(id);
        }
        LOGGER.error("No schedule with id: {}",id);
        throw new NotFoundException("Schedule does not exist");
    }

    @Override
    public boolean isExist(Schedule schedule) {
        for(Schedule s : scheduleRepository.findAll()){
            if(s.getDate().equals(schedule.getDate())){
                LOGGER.error("Schedule already exist for this date");
                throw new AlreadyExistException("Schedule already exist");
            }
        }

        return false;
    }


}
