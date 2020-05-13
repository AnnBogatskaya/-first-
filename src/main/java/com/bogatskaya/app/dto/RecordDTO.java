package com.bogatskaya.app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecordDTO {

    private String date;

    private String time;

    private String complaint;

    private String fullname;

    public RecordDTO(){

    }

}
