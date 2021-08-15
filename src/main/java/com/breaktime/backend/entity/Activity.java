package com.breaktime.backend.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="activities")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int categoryID;
    private String task;
    @Column(nullable = true)
    private String redirectLink;

    public Activity(int categoryID, String task) {
        this.categoryID = categoryID;
        this.task = task;
    }

    public Activity(int categoryID, String task, String redirectLink) {
        this.categoryID = categoryID;
        this.task = task;
        this.redirectLink = redirectLink;
    }
}
