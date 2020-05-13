package com.bogatskaya.app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    private String fullname;

    private String login;

    private String password;

    private String email;

    public UserDTO(){

    }

}
