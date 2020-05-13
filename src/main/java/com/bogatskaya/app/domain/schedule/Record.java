package com.bogatskaya.app.domain.schedule;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.transaction.Transactional;

import com.bogatskaya.app.domain.SuperEntity;
import com.bogatskaya.app.domain.user.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Transactional
@Table(name="records")
public class Record extends SuperEntity {

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "time")
    private LocalTime time;

    @Column(name = "complaint")
    private String complaint;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(columnDefinition = "text", name = "fullname", referencedColumnName = "fullname")
    private User fullname;

    public Record(){

    }

    public Record(final String date, final String time){
        this.date = LocalDate.parse(date);
        this.time = LocalTime.parse(time);
    }


}
