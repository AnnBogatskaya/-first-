package com.bogatskaya.app.domain.user;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.bogatskaya.app.domain.SuperEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "profile")
public class UserProfile extends SuperEntity {

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id",foreignKey = @ForeignKey(name = "user_id_fk"))
    private User user;

    @Column(name="firstname")
    private String firstName;

    @Column(name="lastname")
    private String lastName;

    @Column(name = "age")
    private int age;

    @Column(name = "adress")
    private String adress;

    @Column(name = "phone")
    private String phone;

    public UserProfile(){

    }

    public UserProfile(User user){
        this.user = user;
    }


}
