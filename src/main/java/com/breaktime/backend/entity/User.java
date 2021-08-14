package com.breaktime.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Entity
@Table(name = "user")
public class User {

    @Id
    private String email;
    private String endpoint;
    private String p256dh;
    private String auth;

}
