package com.bogatskaya.app.domain.user;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.bogatskaya.app.domain.Role;
import com.bogatskaya.app.domain.SuperEntity;
import com.bogatskaya.app.domain.schedule.Record;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode
@Entity
@Table(name = "users")
public class User extends SuperEntity implements Serializable{

    @Column(name="fullname")
    private String fullname;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "role_id", foreignKey = @ForeignKey(name = "role_id_fk"))
    private Role role = new Role(1L);

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Record> recordList;

    public User(){

    }

    public User(final String login,final String password){
        this.login = login;
        this.password = password;
    }

    @Override
    public String toString(){
        return fullname;
    }

}
