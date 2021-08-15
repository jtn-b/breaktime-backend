package com.breaktime.backend.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="interests")
public class Interests {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private int categoryID;

    public Interests(String email,int categoryID)
    {
        this.email = email;
        this.categoryID = categoryID;
    }

}
